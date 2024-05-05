package com.calberto_barbosa_jr.retrofit_example

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users/1") // Exemplo de endpoint, substitua pelo seu
    fun getUser(): Call<User>
}