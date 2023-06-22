package cub.sys.moviesnajia.service.di

import cub.sys.moviesnajia.service.api.NewsApi
import cub.sys.moviesnajia.service.api.NewsApi.Companion.Base_Url
import cub.sys.moviesnajia.service.utils.NewRepository
import cub.sys.moviesnajia.service.utils.NewRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi): NewRepository {
        return NewRepositoryImp(newsApi = newsApi)
    }
}