package ru.geekbrains.lesson_1314_3_1_main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.LinearInterpolator
import ru.geekbrains.lesson_1314_3_1_main.R
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivitySplashBinding
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivityTestBinding
import ru.geekbrains.lesson_1314_3_1_main.databinding.FragmentMainBinding
import ru.geekbrains.lesson_1314_3_1_main.view.picture.PODFragment
import ru.geekbrains.lesson_1314_3_1_main.view.settings.SettingsFragment

class TestActivity : AppCompatActivity() {
    lateinit var handler: Handler
    lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*val themeID = getMyTheme();
        setTheme(themeID)*/
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}