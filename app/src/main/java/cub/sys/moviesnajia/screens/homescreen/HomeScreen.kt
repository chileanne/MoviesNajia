package cub.sys.moviesnajia.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cub.sys.moviesnajia.R

@Composable
fun HomeScreen(){
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
       
   }
}