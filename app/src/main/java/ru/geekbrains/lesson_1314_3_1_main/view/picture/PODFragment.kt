package ru.geekbrains.lesson_1314_3_1_main.view.picture

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import ru.geekbrains.lesson_1314_3_1_main.R
import ru.geekbrains.lesson_1314_3_1_main.databinding.FragmentMainBinding
import ru.geekbrains.lesson_1314_3_1_main.viewmodel.PODData
import ru.geekbrains.lesson_1314_3_1_main.viewmodel.PODViewModel


class PODFragment: Fragment() {

    private var _binding: FragmentMainBinding? = null
    val binding:FragmentMainBinding
    get(){
        return _binding!!
    }

    private val viewModel: PODViewModel by lazy {
        ViewModelProvider(this).get(PODViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)

        _binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.sendServerRequest()
        binding.inputLayout.setEndIconOnClickListener {
            val i = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://en.wikipedia.org/wiki/${binding.inputEditText.text.toString()}")
            }
            startActivity( i)
        }
    }

    private fun renderData(data: PODData){
        when(data){
            is PODData.Error -> {//TODO HW
                Toast.makeText(context,"PODData.Error",Toast.LENGTH_LONG).show()
                }
            is PODData.Loading -> {
                Toast.makeText(context,"PODData.Loading",Toast.LENGTH_LONG).show()
            }
            is PODData.Success -> {
                binding.imageView.load(data.serverResponseData.url){ // квадратное становится прямоугольным
                    error(R.drawable.ic_load_error_vector)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        fun newInstance()= PODFragment()
    }
}