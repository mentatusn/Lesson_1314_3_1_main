package ru.geekbrains.lesson_1314_3_1_main.view.animations

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*

import ru.geekbrains.lesson_1314_3_1_main.R
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityAnimationsExplodeBinding

class AnimationsActivity : AppCompatActivity() {

    lateinit var binding: ActivityAnimationsExplodeBinding

    var textIsVisible = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsExplodeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = Adapter()
    }

    fun explode(clickedView:View){
        val viewRect = Rect()
        clickedView.getGlobalVisibleRect(viewRect)
        val explode = Explode()
        explode.epicenterCallback = object : Transition.EpicenterCallback(){
            override fun onGetEpicenter(transition: Transition): Rect {
                return viewRect
            }
        }
        explode.excludeTarget(clickedView,true)
        explode.duration = 5000


        val fade = Fade().addTarget(clickedView)
        fade.duration = 5000
        val setTransition = TransitionSet()
            .addTransition(explode)
            .addTransition(fade)

        TransitionManager.beginDelayedTransition(binding.recyclerView,setTransition)
        binding.recyclerView.adapter = null
    }

    inner class Adapter : RecyclerView.Adapter<Adapter.MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_animations_explode_list_item,
                    parent,
                    false
                ) as View
            )
        }
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.itemView.setOnClickListener {
                explode(it)
            }
        }
        override fun getItemCount(): Int {
            return 32
        }
        inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) // FIXME
    }


}