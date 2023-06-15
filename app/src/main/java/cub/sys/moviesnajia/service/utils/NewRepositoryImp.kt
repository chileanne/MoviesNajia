package cub.sys.moviesnajia.service.utils

import cub.sys.moviesnajia.service.api.NewsApi
import cub.sys.moviesnajia.service.model.Article

class NewRepositoryImp(
    private val newsApi: NewsApi
) : NewRepository{
    override suspend fun getTopHeadLine(category: String): Resources<List<Article>> {
        TODO("Not yet implemented")

        return  try {
            val response = newsApi.topHeadlines(category = category)
            Resources.Success(response.articles)

        }catch (e: Exception) {
            Resources.Error(message = "Failed to fetch news ${e.message}")
        }

    }

}