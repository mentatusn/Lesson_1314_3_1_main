package ru.geekbrains.lesson_1314_3_1_main.api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityApiBinding

class ApiActivity : AppCompatActivity() {

    lateinit var binding: ActivityApiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

}