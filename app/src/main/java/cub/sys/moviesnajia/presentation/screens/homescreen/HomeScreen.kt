package cub.sys.moviesnajia.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cub.sys.moviesnajia.presentation.widgets.CardItem
import cub.sys.moviesnajia.presentation.widgets.CategoryTabBar
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import cub.sys.moviesnajia.presentation.screens.homescreen.HomeScreenEvents

import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cub.sys.moviesnajia.presentation.screens.homescreen.HomeScreenState
import cub.sys.moviesnajia.presentation.widgets.BottomSheetContent
import kotlinx.coroutines.CoroutineScope

import kotlinx.coroutines.launch
import kotlin.math.log


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
//    viewModel: homeScreenViewModel = hiltViewModel()

    onEvent: (HomeScreenEvents) -> Unit,
    state: HomeScreenState,

    ){

    val pagerState = rememberPagerState()
    val courtineScope = rememberCoroutineScope()
    val Categories = listOf<String>(
        "General", "Business","entertainment", "Sports","technology"
    )


    val sheetstate = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var shouldBottomSheetShow by remember { mutableStateOf(false) }


    if (shouldBottomSheetShow) {
        Log.d("Show Bottom Sheet", "value : $shouldBottomSheetShow")
        ModalBottomSheet(
            onDismissRequest = { shouldBottomSheetShow = false },
            sheetState = sheetstate,
            content = {
                state.selectedArticle?.let {
                    BottomSheetContent(
                        article = it,
                        onReadFullStoryButtonClicked = {
                           // onReadFullStoryButtonClick(it.url)
                            courtineScope.launch { sheetstate.hide() }.invokeOnCompletion {
                                if (!sheetstate.isVisible) shouldBottomSheetShow = false
                            }
                        }
                    )
                }
            }
        )
    }




    LaunchedEffect(key1 = pagerState){
       Log.d("Pager State Change", "Pager : $pagerState")
       Log.d("Pager State Changeccvc", "Pager : ${pagerState.currentPage}")


       snapshotFlow { pagerState.currentPage }.collect{ page->
           Log.d("Pagerccc", "Pager : $page")
           onEvent(HomeScreenEvents.onCategroyChanged(category = Categories[page] ))

     }
   }





    Column() {

       Spacer(modifier = Modifier.height(20.dp))

       /**top app bar **/

//       Row(
//           modifier= Modifier
//             //  .background(color = Color.Red)
//               .fillMaxWidth(),
//           verticalAlignment = Alignment.CenterVertically,
//           horizontalArrangement = Arrangement.SpaceAround
//       ){
//           Column() {
//              Text(
//                  text = "Hello Chile",
//                  style = MaterialTheme.typography.bodyMedium,
//                  color = MaterialTheme.colorScheme.onPrimary
//
//                   )
//
//               Text(
//                   text = "Book your Favorite Movie",
//                   style = MaterialTheme.typography.bodySmall,
//                   color = MaterialTheme.colorScheme.secondary
//
//                   )
//           }
//           Image(
//               painter = painterResource(id = R.drawable.avatar),
//               contentDescription ="Rounded",
//               modifier = Modifier
//                   .clip(RoundedCornerShape(40.dp))
//                   .size(34.dp),
//
//
//           )
//       }



        /** Category tab **/

       CategoryTabBar(
           pagerState = pagerState ,
           categories =Categories,
           onTabSelected = { index ->
               courtineScope.launch { pagerState.animateScrollToPage(index) }

           }
       )



       /**Horizontal Pager **/
       HorizontalPager(
           pageCount = Categories.size,
           state = pagerState
       ) {
           /** lazy row to show new item**/

           LazyColumn(
               contentPadding = PaddingValues(12.dp),
           ){
               items(state.article ){ Article ->

                   CardItem(
                       data = Article,
                       onClickAble = {
                           shouldBottomSheetShow=true
                           Log.d("Tap Show Bottom Sheet", "value : $shouldBottomSheetShow")
                           onEvent(HomeScreenEvents.onNewsCardClicked(SelectedArticle = it))
                       }

                   )

               }
           }

           Box (
               modifier = Modifier.fillMaxSize(),
               contentAlignment = Alignment.Center

                   ){
               if(state.isLoading){
                   CircularProgressIndicator()
               }
           }
       }


       
   }
}