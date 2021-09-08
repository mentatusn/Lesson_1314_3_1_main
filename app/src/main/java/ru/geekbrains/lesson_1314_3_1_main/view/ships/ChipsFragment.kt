package ru.geekbrains.lesson_1314_3_1_main.view.ships

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.geekbrains.lesson_1314_3_1_main.databinding.FragmentChipsBinding
import ru.geekbrains.lesson_1314_3_1_main.view.picture.PODFragment

class ChipsFragment:Fragment() {
    var _bindong: FragmentChipsBinding? = null
    val binding: FragmentChipsBinding
        get() {
            return _bindong!!
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindong =  FragmentChipsBinding.inflate(inflater)
        return  binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _bindong = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.chipGroup.setOnCheckedChangeListener{childGroup,position->
            Toast.makeText(context,"Click $position",Toast.LENGTH_SHORT).show()
        }
        binding.chipWithClose.setOnCloseIconClickListener {
            Toast.makeText(context,"Click on chipWithClose",Toast.LENGTH_SHORT).show()
        }
    }
    companion object {
        fun newInstance() = ChipsFragment()
    }


}