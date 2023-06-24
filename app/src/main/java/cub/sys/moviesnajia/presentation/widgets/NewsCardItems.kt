package cub.sys.moviesnajia.presentation.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import cub.sys.moviesnajia.service.model.Article


@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    data: Article,
    onClickAble : (Article) -> Unit

    ){
    Card(
        shape = MaterialTheme.shapes.extraSmall,
        modifier = Modifier
            // .fillMaxWidth()
            // .height(90.dp)
            .padding(10.dp)
    ) {
        Column {
            Text(
                text = data.title,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(10.dp))

            ImageHolder(imageUrl = data.urlToImage)
        }
    }

}
