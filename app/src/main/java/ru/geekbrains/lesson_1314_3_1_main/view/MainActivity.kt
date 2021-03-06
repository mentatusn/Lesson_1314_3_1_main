package ru.geekbrains.lesson_1314_3_1_main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.geekbrains.lesson_1314_3_1_main.R
import ru.geekbrains.lesson_1314_3_1_main.view.picture.PODFragment
import ru.geekbrains.lesson_1314_3_1_main.view.settings.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*val themeID = getMyTheme();
        setTheme(themeID)*/
        setTheme(R.style.Theme_Lesson_1314_3_1_main)
        setContentView(R.layout.activity_main)



        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.container,PODFragment.newInstance()).commit()
        }
    }
}