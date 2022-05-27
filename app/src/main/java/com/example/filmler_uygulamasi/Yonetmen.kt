package com.example.filmler_uygulamasi


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Yonetmen(
    @SerializedName("yonetmen_ad")
    val yonetmenAd: String?,
    @SerializedName("yonetmen_id")
    val yonetmenİd: String?
) :Serializable