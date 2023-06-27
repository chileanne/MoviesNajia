package cub.sys.moviesnajia.presentation.screens.homescreen

import cub.sys.moviesnajia.service.model.Article

data class HomeScreenState(
    val isLoading : Boolean =false,
    val article: List<Article> = emptyList(),
    val error : String? =null,
    val isSearchBarVisible : Boolean =false,
    val selectedArticle : Article? = null,
    val category: String ="General",
    val searchQuery : String = ""
)
