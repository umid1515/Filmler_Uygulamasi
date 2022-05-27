package com.example.filmler_uygulamasi

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmler_uygulamasi.databinding.FilmCardTasarimBinding
import com.squareup.picasso.Picasso

class FilmlerAdapter : RecyclerView.Adapter<FilmlerAdapter.FilmlerHolder>() {

    private val filmlerListe = ArrayList<Filmler>()


    class FilmlerHolder(
        private val cardTasarimBinding: FilmCardTasarimBinding
    ) : RecyclerView.ViewHolder(cardTasarimBinding.root) {
        fun find(film: Filmler) {
            with(cardTasarimBinding) {

                textViewFilmAd.text = film.filmAd


                //binding ile imageview cagırmaq ucun
                /*  imageViewFilmResim.setImageResource(
                      root.context.resources.getIdentifier(
                          film.filmResim,
                          "drawable",
                          root.context.packageName
                      )
                  )*/
                val url = "http://kasimadalan.pe.hu/filmler/resimler/${film.filmResim}"
                Picasso.get().load(url).into(cardTasarimBinding.imageViewFilmResim

                    )


                filmCard.setOnClickListener {
                    val intent = Intent(cardTasarimBinding.root.context, DetayActivity::class.java)
                    intent.putExtra("filmNesne", film)
                    cardTasarimBinding.root.context.startActivity(intent)
                }


            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmlerHolder {
        val layout =
            FilmCardTasarimBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return FilmlerHolder(layout)
    }

    override fun onBindViewHolder(holder: FilmlerHolder, position: Int) {

        val filmler = filmlerListe[position]
        holder.find(filmler)
    }

    override fun getItemCount(): Int {
        return filmlerListe.size
    }


    fun updateList(list: List<Filmler>?) {
        filmlerListe.clear()
        if (list != null) {
            filmlerListe.addAll(list)
        }
        notifyDataSetChanged()
    }

}