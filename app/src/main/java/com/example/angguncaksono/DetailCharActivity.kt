package com.example.angguncaksono

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.angguncaksono.databinding.DetailLayoutBinding


class DetailCharActivity: AppCompatActivity() {

    private lateinit var binding: DetailLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DetailLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title = getString(R.string.detail_char)
        }

        val detailChar = intent.getParcelableExtra<Character>(MainActivity.INTENT_SEND)

        if (detailChar == null) {
            Toast.makeText(this, "Character data is unavailable", Toast.LENGTH_SHORT).show()
            return
        }

        with(detailChar) {
            binding.photoImg.setImageResource(photo)
            binding.charName.text = name
            findViewById<TextView>(R.id.description_char).text = detail
            binding.rarityChar.text = rarity
            binding.pathChar.text = path
            binding.factionChar.text = faction


        }

    }
}