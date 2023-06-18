package cub.sys.moviesnajia.screens.homescreen


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cub.sys.moviesnajia.service.model.Article
import cub.sys.moviesnajia.service.utils.NewRepository
import cub.sys.moviesnajia.service.utils.Resources
import kotlinx.coroutines.launch

class homeScreenViewModel(
    private val newRepository: NewRepository
):ViewModel() {
    var article by mutableStateOf<List<Article>>(emptyList())

    private fun getNewArticle(category : String){
        viewModelScope.launch {
            val result = newRepository.getTopHeadLine(category = category)
            when (result) {
                is Resources.Success -> {
                     article = result.data?: emptyList()
                }

                is Resources.Error -> TODO()

            }
        }
    }
}