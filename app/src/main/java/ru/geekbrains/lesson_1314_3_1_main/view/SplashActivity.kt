package ru.geekbrains.lesson_1314_3_1_main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.LinearInterpolator
import ru.geekbrains.lesson_1314_3_1_main.R
import ru.geekbrains.lesson_1314_3_1_main.databinding.ActivitySplashBinding
import ru.geekbrains.lesson_1314_3_1_main.databinding.FragmentMainBinding
import ru.geekbrains.lesson_1314_3_1_main.view.picture.PODFragment
import ru.geekbrains.lesson_1314_3_1_main.view.settings.SettingsFragment

class SplashActivity : AppCompatActivity() {
    lateinit var handler: Handler
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*val themeID = getMyTheme();
        setTheme(themeID)*/
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.animate().rotationBy(1000f).setInterpolator(LinearInterpolator()).duration = 3000
        handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}