package com.example.notlaruygulamasi

import com.example.filmler_uygulamasi.FilmlerDaoInterface
import com.example.filmler_uygulamasi.KategorilerDaoInterface

class ApiUtils {
    companion object{
        val BASE_URL="http://kasimadalan.pe.hu/"
        fun getKategorilerDoaInterface():KategorilerDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(KategorilerDaoInterface::class.java)
        }

        fun getFilmerDoaInterface():FilmlerDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(FilmlerDaoInterface::class.java)
        }
    }
}