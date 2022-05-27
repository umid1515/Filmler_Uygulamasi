package com.example.filmler_uygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmler_uygulamasi.databinding.ActivityFilmlerBinding
import com.example.notlaruygulamasi.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmlerActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityFilmlerBinding
    private val binding get() = _binding!!
   // private lateinit var filmListe: ArrayList<Filmler>
    private var adapter: FilmlerAdapter = FilmlerAdapter()
    private lateinit var fdi: FilmlerDaoInterface


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFilmlerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // geçiş yapmak için
        val kategori =intent.getSerializableExtra("nesne") as Kategori



        binding.toolbarFilmler.title = "Filmler:${kategori.kategoriAd}"
        binding.filmlerRV.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)


        fdi=ApiUtils.getFilmerDoaInterface()
        tumFilmlerByKategorID(kategori.kategoriİd)
       /* filmListe= ArrayList()

        val k = Kategori("Gerilim","1")
        val y1 = Yonetmen("Brian Helgeland","1")
        val y2 =Yonetmen("Brian De Palma","2")


        val f1=Filmler("The Legend","legend_film","2015","1",k,y1)
        val f2=Filmler("Scarface","scarface_film","1985","2",k,y2)
        filmListe.add(f1)
        filmListe.add(f2)

        binding.filmlerRV.adapter=adapter
        adapter.updateList(filmListe)

*/



    }

fun tumFilmlerByKategorID(kategori_id: String?) {
   /* fdi.tumFilmlerByKategoriId(kategori_id = taskId).enqueue(object :Callback<FilmlerCevap>{
        override fun onFailure(call: Call<FilmlerCevap>, t: Throwable) {
        }

        override fun onResponse(call: Call<FilmlerCevap>, response: Response<FilmlerCevap>) {
           binding.filmlerRV.adapter=adapter
            val filmListe = null
            filmListe?.let { adapter.updateList(it) }*/
            fdi.tumFilmlerByKategoriId(kategori_id).enqueue(object : Callback<FilmlerCevap> {
                override fun onResponse(
                    call: Call<FilmlerCevap>,
                    response: Response<FilmlerCevap>
                ) {
                    val liste = response.body()?.filmler
                    if (liste != null) {

                        with(adapter) { updateList(liste) }
                    }
                    //  adapter = NotlarAdapter(this@MainActivity,liste)
                    binding.filmlerRV.adapter = adapter
        }



                override fun onFailure(call: Call<FilmlerCevap>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
}



}