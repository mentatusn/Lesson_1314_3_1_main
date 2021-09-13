package ru.geekbrains.lesson_1314_3_1_main.api

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.TextViewCompat
import com.google.android.material.badge.BadgeDrawable
import ru.geekbrains.lesson_1314_3_1_main.R
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityApiBinding
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityApiBottomBinding
import ru.geekbrains.lesson_1314_3_1_main.view.picture.PODFragment

class ApiBottomActivity : AppCompatActivity() {

    lateinit var binding: ActivityApiBottomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiBottomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.action_mars->{
                    supportFragmentManager.beginTransaction().replace(R.id.container, MarsFragment()).commit()
                    true
                }
                R.id.action_earth->{
                    supportFragmentManager.beginTransaction().replace(R.id.container, EarthFragment()).commit()
                    true
                }
                R.id.action_system->{
                    supportFragmentManager.beginTransaction().replace(R.id.container, SystemFragment()).commit()
                    true
                }
                else ->false
            }
        }
        binding.bottomNavigationView.selectedItemId = R.id.action_system
        binding.bottomNavigationView.getOrCreateBadge(R.id.action_earth).apply {
            number = 100;
            badgeGravity = BadgeDrawable.TOP_END
            maxCharacterCount = 3
        }
        binding.bottomNavigationView.menu.getItem(1).apply{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                tooltipText = "Это марс"
            }
        }
    }

}