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
        val data:MutableList<Data> = ArrayList()
        repeat(10){
            if(it%2==0){
                data.add(Data("Earth"))
            }else{
                data.add(Data("Mars",""))
            }
        }
        data.add(0,Data("Header"))
        binding.recyclerView.adapter = RecyclerActivityAdapter(
            object : OnListItemClickListener {
                override fun onItemClick(data: Data) {
                    Toast.makeText(this@RecyclerActivity,data.someText,Toast.LENGTH_SHORT).show()
                }
            }, data)
    }
}