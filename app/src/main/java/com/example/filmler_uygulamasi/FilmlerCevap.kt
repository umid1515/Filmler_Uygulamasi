package com.example.filmler_uygulamasi


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FilmlerCevap(
    @SerializedName("filmler")
    val filmler: List<Filmler>?,
    @SerializedName("success")
    val success: Int?
) : Serializable{}