package com.example.submisiandroidpemula

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvVegetables: RecyclerView
    private val list = ArrayList<Vegetables>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Sayuran Sehat"

        rvVegetables = findViewById(R.id.rv_vegetables)
        rvVegetables.setHasFixedSize(true)
        list.addAll(getListVegetables())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        rvVegetables.layoutManager = LinearLayoutManager(this)
        val listVegetablesAdapter = ListVegetablesAdapter(list)
        rvVegetables.adapter = listVegetablesAdapter
    }

    private fun getListVegetables(): ArrayList<Vegetables> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listVegetables = ArrayList<Vegetables>()
        for (i in dataName.indices) {
            val vegetable = Vegetables(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listVegetables.add(vegetable)
        }
        return listVegetables
    }
}