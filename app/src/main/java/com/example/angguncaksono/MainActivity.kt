package com.example.angguncaksono

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private val rvChar: RecyclerView by lazy { findViewById(R.id.rv_char) }
    private val list: ArrayList<Character> by lazy { getListChar() }

    companion object {
        const val INTENT_SEND = "OBJECT_SENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvChar.setHasFixedSize(true)


        list.addAll(getListChar())
        showRecyclerList()
    }

    private fun getListChar(): ArrayList<Character> {
        val dataName = resources.getStringArray(R.array.data_char)
        val dataDescription = resources.getStringArray(R.array.data_char_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataRarity = resources.getStringArray(R.array.data_rarity)
        val dataPathChar = resources.getStringArray(R.array.data_path)
        val dataFaction = resources.getStringArray(R.array.data_faction)
        val dataDetail = resources.getStringArray(R.array.data_detail_char)
        val listChar = ArrayList<Character>()

        for (i in dataName.indices){
            val char = Character(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataRarity[i],dataPathChar[i], dataFaction[i], dataDetail[i])
            listChar.add(char)
        }
        dataPhoto.recycle()
        return listChar
    }

    private fun showRecyclerList(){
        rvChar.layoutManager = LinearLayoutManager(this)
        val listCharAdapter = ListCharAdapter(list)
        rvChar.adapter = listCharAdapter

        listCharAdapter.setOnItemClickCallback(object : ListCharAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Character) {
                val intoToDetail = Intent(this@MainActivity, DetailCharActivity::class.java)
                intoToDetail.putExtra(INTENT_SEND, data)
                startActivity(intoToDetail)
            }
        })
    }

    // Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about_page -> {
                val intoDetail = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intoDetail)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}