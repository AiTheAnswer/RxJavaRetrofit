package com.allen.rxjavaretrofit.net

import com.allen.rxjavaretrofit.model.HttpResult
import com.allen.rxjavaretrofit.model.Movie
import com.allen.rxjavaretrofit.model.Result
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface MovieServiceInterface {
    @GET("top250")
    fun getTopMovies(@Query("start") start:Int,@Query("count") count:Int): Observable<HttpResult<List<Movie>>>

}