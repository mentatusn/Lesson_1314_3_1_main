package ru.geekbrains.lesson_1314_3_1_main.view.picture

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.geekbrains.lesson_1314_3_1_main.R
import ru.geekbrains.lesson_1314_3_1_main.databinding.BottomNavigationLayoutBinding
import ru.geekbrains.lesson_1314_3_1_main.view.animations.AnimationsActivity

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {


    private var _binding: BottomNavigationLayoutBinding? = null
    val binding: BottomNavigationLayoutBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BottomNavigationLayoutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.navigationView.setNavigationItemSelectedListener { it->
            when(it.itemId){
                R.id.navigation_one ->{
                    activity?.let {
                        startActivity(Intent(it,AnimationsActivity::class.java))
                    }
                }
                R.id.navigation_two ->{
                    activity?.let {
                        //startActivity(Intent(it,AnimationsActivity::class.java))
                    }
                }
            }
            true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
    companion object {
        fun newInstance() = BottomNavigationDrawerFragment()
    }
}