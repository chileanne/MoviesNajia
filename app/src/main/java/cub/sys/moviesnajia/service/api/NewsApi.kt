package cub.sys.moviesnajia.service.api
import cub.sys.moviesnajia.service.model.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query




interface NewsApi {

     @GET("top-headlines")
     suspend fun topHeadlines(
          @Query("category") category: String,
          @Query("country") country: String,
          @Query("apiKey") apiKey: String = ApiKey,
     ): NewsModel


     companion object{
          const val  ApiKey ="f81d874b58a445d1a8f8ca420050c8e6"
          const val BaseUrl="https://newsapi.org/v2/"
     }
}