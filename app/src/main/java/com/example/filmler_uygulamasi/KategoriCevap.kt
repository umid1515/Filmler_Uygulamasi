package com.example.filmler_uygulamasi


import com.google.gson.annotations.SerializedName

data class KategoriCevap(
    @SerializedName("kategoriler")
    val kategoriler: List<Kategori>?,
    @SerializedName("success")
    val success: Int?
)