package cub.sys.moviesnajia.service.utils

import cub.sys.moviesnajia.service.model.Article

interface NewRepository {

    suspend fun getTopHeadLine(
        category:String
    ):Resources<List<Article>>


}