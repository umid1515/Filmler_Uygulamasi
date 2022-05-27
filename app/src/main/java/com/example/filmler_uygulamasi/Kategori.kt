package com.example.filmler_uygulamasi


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Kategori(
    @SerializedName("kategori_ad")
    val kategoriAd: String?,
    @SerializedName("kategori_id")
    val kategoriİd: String?
)  : Serializable