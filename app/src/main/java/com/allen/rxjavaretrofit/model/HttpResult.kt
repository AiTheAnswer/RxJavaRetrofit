package com.allen.rxjavaretrofit.model

class HttpResult<T> {
     var count: Int? = 0
     var start: Int? = 0
     var total: Int? = 0
     var title: String? = null
     var subjects: T? = null


}