package com.example.filmler_uygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmler_uygulamasi.databinding.ActivityMainBinding
import com.example.notlaruygulamasi.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
   // private lateinit var kategoriList: ArrayList<Kategori>
     private lateinit var kdi: KategorilerDaoInterface
    private var adapter: KategoriAdapter = KategoriAdapter()
    private var _binding:ActivityMainBinding?= null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

     binding.toolbarKategori.title="Kategoriler"
     setSupportActionBar(binding.toolbarKategori)
        binding.kategoriRV.setHasFixedSize(true)
        binding.kategoriRV.layoutManager=LinearLayoutManager(this)



        kdi=ApiUtils.getKategorilerDoaInterface()

        tumKategoriler()

      /*  kategoriList= ArrayList()

        val k1=Kategori("Komedi","1")
        val k2=Kategori("Korku","2")

        kategoriList.add(k1)
        kategoriList.add(k2)


        adapter.updateList(kategoriList)
        binding.kategoriRV.adapter=adapter

*/

    }











    private fun tumKategoriler() {
        kdi.tumKategoriler().enqueue(object : Callback<KategoriCevap> {
            override fun onResponse(
                call: Call<KategoriCevap>, response: Response<KategoriCevap>
            ) {
                val liste = response.body()?.kategoriler
                if (liste != null) {

                    with(adapter) { updateList(liste) }
                }
                //  adapter = NotlarAdapter(this@MainActivity,liste)
                binding.kategoriRV.adapter = adapter

            }

            override fun onFailure(call: Call<KategoriCevap>, t: Throwable) {
                TODO("Not yet implemented")
            }

    })
}

            override fun onDestroy() {
                super.onDestroy()
                _binding=null
            }

        }