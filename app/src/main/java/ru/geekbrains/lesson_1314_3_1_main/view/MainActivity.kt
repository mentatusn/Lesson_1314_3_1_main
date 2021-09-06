package ru.geekbrains.lesson_1314_3_1_main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.geekbrains.lesson_1314_3_1_main.R
import ru.geekbrains.lesson_1314_3_1_main.utils.CustomImageView
import ru.geekbrains.lesson_1314_3_1_main.view.picture.PODFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.container,PODFragment.newInstance()).commit()
        }
    }
}