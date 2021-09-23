package ru.geekbrains.lesson_1314_3_1_main.view.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityRecyclerBinding


class RecyclerActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data:MutableList<Pair<Data,Boolean>> = ArrayList()
        repeat(10){
            if(it%2==0){
                //data.add(Data("Earth"))
            }else{
                data.add(Pair(Data("Mars",""),false))
            }
        }
        val lat = 50
        val lon = 30
        val coordinate = lat to lon
        val coordinate3d = Triple(1,2,3)
        coordinate.first
        coordinate.second
        coordinate3d.first
        coordinate3d.second
        coordinate3d.third

        data.add(0,Pair(Data("Header"),false))
        val adapter= RecyclerActivityAdapter(
            object : OnListItemClickListener {
                override fun onItemClick(data: Data) {
                    Toast.makeText(this@RecyclerActivity,data.someText,Toast.LENGTH_SHORT).show()
                }
            }, data)
        binding.recyclerView.adapter = adapter
        binding.recyclerActivityFAB.setOnClickListener { adapter.appendItem()}
    }
}