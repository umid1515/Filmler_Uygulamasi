package com.example.filmler_uygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filmler_uygulamasi.databinding.ActivityDetayBinding
import com.squareup.picasso.Picasso

class DetayActivity : AppCompatActivity() {
    private var _binding: ActivityDetayBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        _binding = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val film = intent.getSerializableExtra("filmNesne") as Filmler
        binding.textViewDetayFilmAd.text = film.filmAd.toString()
        binding.textViewDetayFilmYil.text = film.filmYil.toString()
        binding.textViewDetayYonetmen.text= film.yonetmen?.yonetmenAd.toString()


        val url = "http://kasimadalan.pe.hu/filmler/resimler/${film.filmResim}"
        Picasso.get().load(url).into(binding.imageViewDetayResim

        )
      /*  binding.imageViewDetayResim.setImageResource(
            resources.getIdentifier(
                film.filmResim,
                "drawable",
                packageName
            )
        )
  */  }
}