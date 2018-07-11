package com.allen.rxjavaretrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.allen.rxjavaretrofit.model.HttpResult
import com.allen.rxjavaretrofit.model.Movie
import com.allen.rxjavaretrofit.model.Result
import com.allen.rxjavaretrofit.net.MovieServiceInterface
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private var mBtnStartNet: Button? = null
    private var mTxtResult: TextView? = null
    private val baseUrl = "https://api.douban.com/v2/movie/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initListener()
    }

    private fun initListener() {
        mBtnStartNet?.setOnClickListener {
            getTopMovie(baseUrl, 0, 20)
        }
    }

    /**
     * 获取
     */
    private fun getTopMovie(baseUrl: String, startIndex: Int, count: Int) {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        val movieService = retrofit.create(MovieServiceInterface::class.java)
        movieService.getTopMovies(startIndex,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<HttpResult<List<Movie>>>() {
                    override fun onNext(result: HttpResult<List<Movie>>?) {
                        val subjects = result?.subjects
                        val sb = StringBuffer()
                        subjects?.forEach {
                            sb.append("$it  \n")
                        }
                        mTxtResult?.text = sb.toString()
                    }

                    override fun onCompleted() {
                        Log.e("tog","onCompleted")

                    }

                    override fun onError(e: Throwable?) {
                        Log.e("tog","onError ${e?.message}")
                    }

                })


    }

    private fun initView() {
        mBtnStartNet = findViewById(R.id.btn)
        mTxtResult = findViewById(R.id.txt_result)
    }
}
