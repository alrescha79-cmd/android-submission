package com.example.angguncaksono

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListCharAdapter(private val listChar: ArrayList<Character>): RecyclerView.Adapter<ListCharAdapter.ListViewHolder>() {

    // Membuat onClick
    interface OnItemClickCallback{
        fun onItemClicked(data: Character)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvMatch: TextView = itemView.findViewById(R.id.tv_item_description)
        val tvPoints: TextView = itemView.findViewById(R.id.tv_item_points)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_char, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listChar.size



 override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
    val character = listChar[position]
    holder.imgPhoto.setImageResource(character.photo)
    holder.tvName.text = character.name
    holder.tvMatch.text = character.rarity
    holder.tvPoints.text = character.path.toString()
    holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listChar[holder.adapterPosition]) }
}


}