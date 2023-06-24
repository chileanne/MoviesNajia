package cub.sys.moviesnajia.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import cub.sys.moviesnajia.presentation.screens.homescreen.homeScreenViewModel
import cub.sys.moviesnajia.presentation.widgets.CardItem
import cub.sys.moviesnajia.presentation.widgets.CategoryTabBar
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: homeScreenViewModel = hiltViewModel()
){

    val pagerState = rememberPagerState()
    val courtineScope = rememberCoroutineScope()
    val Categories = listOf<String>(
        "General", "Business","entertainment", "Sports","technology"
    )


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
               items(viewModel.article ){ Article ->

                   CardItem(
                       data = Article,
                       onClickAble = {}

                   )

               }
           }
       }


       
   }
}