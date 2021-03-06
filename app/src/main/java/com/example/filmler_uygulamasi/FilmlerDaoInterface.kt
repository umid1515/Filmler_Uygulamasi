package com.example.filmler_uygulamasi

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface FilmlerDaoInterface {

    @POST("filmler/filmler_by_kategori_id.php")
    @FormUrlEncoded
    fun tumFilmlerByKategoriId(@Field("kategori_id") kategori_id: String?) : Call<FilmlerCevap>
    abstract fun tumFilmlerByKategoriId(): Call<FilmlerCevap>
}