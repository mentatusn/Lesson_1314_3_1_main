package ru.geekbrains.lesson_1314_3_1_main.view.recycler

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.http.Header
import ru.geekbrains.lesson_1314_3_1_main.R
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityRecyclerItemEarthBinding
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityRecyclerItemHeaderBinding
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityRecyclerItemMarsBinding

class RecyclerActivityAdapter(
    private var onListItemClickListener: OnListItemClickListener,
    private var data: List<Data>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TYPE_EARTH->{
                val binding: ActivityRecyclerItemEarthBinding =
                    ActivityRecyclerItemEarthBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                EarthViewHolder(binding.root)
            }
            TYPE_MARS->{
                val binding: ActivityRecyclerItemMarsBinding =
                    ActivityRecyclerItemMarsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                MarsViewHolder(binding.root)
            }
            else -> {
                val binding: ActivityRecyclerItemHeaderBinding =
                    ActivityRecyclerItemHeaderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                HeaderViewHolder(binding.root)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(position==0) return TYPE_HEADER
        return if(data[position].someDescription.isNullOrBlank()) TYPE_MARS else TYPE_EARTH
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            TYPE_EARTH->{
                (holder as EarthViewHolder).bind(data[position])
            }
            TYPE_MARS->{
                (holder as MarsViewHolder).bind(data[position])
            }
            TYPE_HEADER->{
                (holder as HeaderViewHolder).bind(data[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class EarthViewHolder(view: View):RecyclerView.ViewHolder(view){
        fun bind(data: Data){
            ActivityRecyclerItemEarthBinding.bind(itemView).apply {
                descriptionTextView.text = data.someDescription
                wikiImageView.setOnClickListener {
                    onListItemClickListener.onItemClick(data)
                }
            }
        }
    }

    inner class MarsViewHolder(view: View):RecyclerView.ViewHolder(view){
        fun bind(data: Data){
            // было itemView.findViewById<ImageView>(R.id.marsImageView).setOnClickListener {  }
            ActivityRecyclerItemMarsBinding.bind(itemView).apply {
                marsImageView.setOnClickListener {
                    onListItemClickListener.onItemClick(data)
                }
            }
        }
    }

    inner class HeaderViewHolder(view: View):RecyclerView.ViewHolder(view){
        fun bind(data: Data){
            // было itemView.findViewById<ImageView>(R.id.marsImageView).setOnClickListener {  }
            ActivityRecyclerItemHeaderBinding.bind(itemView).apply {
                root.setOnClickListener {
                    onListItemClickListener.onItemClick(data)
                }
            }
        }
    }

    companion object{
        private const val TYPE_EARTH=0
        private const val TYPE_MARS=1
        private const val TYPE_HEADER=2
    }





}