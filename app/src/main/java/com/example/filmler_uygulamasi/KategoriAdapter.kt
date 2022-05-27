package com.example.filmler_uygulamasi

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmler_uygulamasi.databinding.KategoriCardTasarimBinding


class KategoriAdapter : RecyclerView.Adapter<KategoriAdapter.KategoriHolder>() {


    private val kategoriList = ArrayList<Kategori>()

    class KategoriHolder(
        private val cardTasarimBinding: KategoriCardTasarimBinding
    ) : RecyclerView.ViewHolder(cardTasarimBinding.root) {
        fun find(not: Kategori) {
            with(cardTasarimBinding) {
                textViewKategoriAd.text = not.kategoriAd
                kategoriCard.setOnClickListener {

                    val intent = Intent(cardTasarimBinding.root.context,FilmlerActivity::class.java)
                    intent.putExtra("nesne", not)
                    cardTasarimBinding.root.context.startActivity(intent)



                }

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriHolder {
        val layout =
            KategoriCardTasarimBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return KategoriHolder(layout)
    }

    override fun onBindViewHolder(holder: KategoriHolder, position: Int) {
        val kategori = kategoriList[position]
        holder.find(kategori)
    }

    override fun getItemCount(): Int {
        return kategoriList.size
    }




    fun updateList(list: List<Kategori>?) {
        kategoriList.clear()

        if (list != null) {
            kategoriList.addAll(list)
        }
        notifyDataSetChanged()
    }
}


