package com.example.filmler_uygulamasi


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Filmler(
    @SerializedName("film_ad")
    val filmAd: String?,
    @SerializedName("film_resim")
    val filmResim: String?,
    @SerializedName("film_yil")
    val filmYil: String?,
    @SerializedName("film_id")
    val filmİd: String?,
    @SerializedName("kategori")
    val kategori: Kategori?,
    @SerializedName("yonetmen")
    val yonetmen: Yonetmen?
) :Serializable{}