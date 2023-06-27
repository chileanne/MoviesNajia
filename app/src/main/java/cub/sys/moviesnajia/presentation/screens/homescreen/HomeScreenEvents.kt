package cub.sys.moviesnajia.presentation.screens.homescreen

import cub.sys.moviesnajia.service.model.Article

sealed class HomeScreenEvents(){
    data class onNewsCardClicked(val article: Article):HomeScreenEvents()
    data class onCategroyChanged(val category: String):HomeScreenEvents()
    data class onSearchQueryChanged(val searchQuery : String) :HomeScreenEvents()
    object onSearchIconClicked: HomeScreenEvents()
    object onCloseIconClicked : HomeScreenEvents()
}
