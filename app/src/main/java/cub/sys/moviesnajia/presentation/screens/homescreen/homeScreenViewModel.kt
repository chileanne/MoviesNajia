package cub.sys.moviesnajia.presentation.screens.homescreen


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cub.sys.moviesnajia.service.model.Article
import cub.sys.moviesnajia.service.utils.NewRepository
import cub.sys.moviesnajia.service.utils.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class homeScreenViewModel @Inject constructor(
    private val newRepository: NewRepository
):ViewModel() {
    var article by mutableStateOf<List<Article>>(emptyList())

    var state by mutableStateOf(HomeScreenState())

    fun onEvent(events: HomeScreenEvents){
        when(events){
            is HomeScreenEvents.onCategroyChanged -> {
                state = state.copy(category = events.category)
                getNewArticle(category = state.category)
            }
            HomeScreenEvents.onCloseIconClicked -> TODO()
            is HomeScreenEvents.onNewsCardClicked -> TODO()
            HomeScreenEvents.onSearchIconClicked -> TODO()
            is HomeScreenEvents.onSearchQueryChanged -> TODO()
        }

    }

    init {
        print("==========Fucked========")
        getNewArticle(category = "general")
        print("==========Fucked========")
    }

    private fun getNewArticle(category : String){
        viewModelScope.launch {
            val result = newRepository.getTopHeadLine(category = category)
            when (result) {
                is Resources.Success -> {
                    state= state.copy(
                        article = result.data?: emptyList()
                    )

                }



                is Resources.Error -> TODO()

            }
        }
    }
}