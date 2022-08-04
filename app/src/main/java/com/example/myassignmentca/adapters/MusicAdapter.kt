package com.example.myassignmentca.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginBottom
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myassignmentca.R
import com.example.myassignmentca.databinding.FragmentClassicBinding
import com.example.myassignmentca.databinding.ItemMusicBinding
import com.example.myassignmentca.model.ResultModel

class MusicAdapter(
    val context: Context,
    val musicList: List<ResultModel>
    ) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

//    private lateinit var binding:ItemMusicBinding
    class MusicViewHolder(musicItem: View): RecyclerView.ViewHolder(musicItem) {
        val binding:ItemMusicBinding = ItemMusicBinding.bind(musicItem)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MusicViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_music,parent,false)
    )

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        //using library to load image using glide
        Glide.with(context).load(musicList[position].artworkUrl60).into(holder.binding.ivMusicItem)
        holder.binding.tvMusicArtist.text = musicList[position].artistName
        holder.binding.tvMusicTitle.text = "${position+1}. ${musicList[position].collectionName}"
        holder.binding.tvMusicPrice.text = "${musicList[position].trackPrice} USD"
//        if(position==49){
////            holder.binding.tvMusicTitle.text = "End of the list"
////            holder.binding.cvMusic.setPaddingRelative(100,100,100,100)
//        }
    }

    override fun getItemCount(): Int = musicList.size

}
