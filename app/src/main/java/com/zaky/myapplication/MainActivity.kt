package com.zaky.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCALABLE = "OBJECT_INTENT"
    }

    private lateinit var rvKue: RecyclerView
//    ambil data mtable
    private var data: MutableList<Kue> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvKue = findViewById(R.id.rv_kue)
        rvKue.setHasFixedSize(true)

//        data.getdata
        data.addAll(KueData.getData)
        showRecyclerList()
    }

    private fun showSelectedKue(kue: Kue) {
//        Toast.makeText(this, "Kamu memilih " + kue.name, Toast.LENGTH_SHORT).show()
        val moveWithDataIntent = Intent(this@MainActivity, Details::class.java)
        val nama = kue.name
        val detail = kue.detail
        val photo = kue.photo

        moveWithDataIntent.putExtra(Details.EXTRA_NAME, "$nama")
        moveWithDataIntent.putExtra(Details.EXTRA_DETAIL,"$detail")
        moveWithDataIntent.putExtra(INTENT_PARCALABLE, kue.photo)
        startActivity(moveWithDataIntent)
    }

    private fun showRecyclerList() {
        rvKue.layoutManager = LinearLayoutManager(this)
        val listKueAdapter = ListKueAdapter(data as ArrayList<Kue>)
        rvKue.adapter = listKueAdapter

        listKueAdapter.setOnItemClickCallback(object : ListKueAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Kue) {
                showSelectedKue(data)
            }
        })


    }


}
