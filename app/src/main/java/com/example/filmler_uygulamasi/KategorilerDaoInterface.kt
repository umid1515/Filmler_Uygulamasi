package com.example.filmler_uygulamasi

import retrofit2.Call
import retrofit2.http.GET

interface KategorilerDaoInterface {
    @GET("filmler/tum_kategoriler.php")
    fun tumKategoriler() : Call<KategoriCevap>
}