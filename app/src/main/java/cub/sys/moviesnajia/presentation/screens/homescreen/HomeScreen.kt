package cub.sys.moviesnajia.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import cub.sys.moviesnajia.R
import cub.sys.moviesnajia.presentation.screens.homescreen.homeScreenViewModel
import cub.sys.moviesnajia.presentation.widgets.ImageHolder


@Composable
fun HomeScreen(
    viewModel: homeScreenViewModel = hiltViewModel()
){

   Column() {

       Spacer(modifier = Modifier.height(20.dp))

       /**top app bar **/

       Row(
           modifier= Modifier
             //  .background(color = Color.Red)
               .fillMaxWidth(),
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.SpaceAround
       ){
           Column() {
              Text(
                  text = "Hello Chile",
                  style = MaterialTheme.typography.bodyMedium,
                  color = MaterialTheme.colorScheme.onPrimary

                   )

               Text(
                   text = "Book your Favorite Movie",
                   style = MaterialTheme.typography.bodySmall,
                   color = MaterialTheme.colorScheme.secondary

                   )
           }
           Image(
               painter = painterResource(id = R.drawable.avatar),
               contentDescription ="Rounded",
               modifier = Modifier
                   .clip(RoundedCornerShape(40.dp))
                   .size(34.dp),


           )
       }




       /** lazy row to show new item**/

       LazyColumn(
          contentPadding = PaddingValues(12.dp),
       ){
           items(viewModel.article ){ Article ->

               Card(
                   shape = MaterialTheme.shapes.extraSmall,
                   modifier = Modifier
                      // .fillMaxWidth()
                      // .height(90.dp)
                       .padding(10.dp)
               ) {
                  Column {
                      Text(
                          text = Article.title,
                          style = MaterialTheme.typography.bodyMedium,
                          color = MaterialTheme.colorScheme.onPrimary,
                           maxLines = 1,
                          overflow = TextOverflow.Ellipsis
                      )
                      
                      Spacer(modifier = Modifier.height(10.dp))

                      ImageHolder(imageUrl = Article.urlToImage)
                  }
               }


           }
       }
       
   }
}