package ru.geekbrains.lesson_1314_3_1_main.view.picture

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.*
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.provider.FontRequest
import androidx.core.provider.FontsContractCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import ru.geekbrains.lesson_1314_3_1_main.R
import ru.geekbrains.lesson_1314_3_1_main.api.ApiActivity
import ru.geekbrains.lesson_1314_3_1_main.api.ApiBottomActivity
import ru.geekbrains.lesson_1314_3_1_main.databinding.FragmentMainBinding
import ru.geekbrains.lesson_1314_3_1_main.view.MainActivity
import ru.geekbrains.lesson_1314_3_1_main.view.ViewBindingFragment
import ru.geekbrains.lesson_1314_3_1_main.view.settings.SettingsFragment
import ru.geekbrains.lesson_1314_3_1_main.viewmodel.PODData
import ru.geekbrains.lesson_1314_3_1_main.viewmodel.PODViewModel


class PODFragment : ViewBindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>


    private val viewModel: PODViewModel by lazy {
        ViewModelProvider(this).get(PODViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // что-то свое
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private var isMain = true
    private fun setActionBar() {
        (context as MainActivity).setSupportActionBar(binding.bottomAppBar)
        setHasOptionsMenu(true)
        binding.fab.setOnClickListener {
            if (isMain) {
                isMain = false
                binding.bottomAppBar.navigationIcon = null // лучше придумать замену бургеру
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                binding.fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_back_fab
                    )
                )
                binding.bottomAppBar.replaceMenu(R.menu.menu_bottom_bar_other_screen)
            } else {
                isMain = true
                binding.bottomAppBar.navigationIcon =
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_hamburger_menu_bottom_bar
                    )
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                binding.fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_plus_fab
                    )
                )
                binding.bottomAppBar.replaceMenu(R.menu.menu_bottom_bar)
            }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.sendServerRequest()

        binding.inputLayout.setEndIconOnClickListener {
            val i = Intent(Intent.ACTION_VIEW).apply {
                data =
                    Uri.parse("https://en.wikipedia.org/wiki/${binding.inputEditText.text.toString()}")
            }
            startActivity(i)
        }
        bottomSheetBehavior = BottomSheetBehavior.from(binding.includeLayout.bottomSheetContainer)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        /*binding.testYoutube.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=MRLyREkZles")))
        }*/

    }

    private fun renderData(data: PODData) {
        when (data) {
            is PODData.Error -> {//TODO HW
                Toast.makeText(context, "PODData.Error", Toast.LENGTH_LONG).show()
            }
            is PODData.Loading -> {
                //Toast.makeText(context, "PODData.Loading", Toast.LENGTH_LONG).show()
                binding.imageView.load(R.drawable.progress_image_animation){

                }
            }
            is PODData.Success -> {
                binding.imageView.load(data.serverResponseData.url) { // квадратное становится прямоугольным
                    error(R.drawable.ic_load_error_vector)
                    placeholder(R.drawable.progress_image_animation)
                }
                data.serverResponseData.explanation?.let{
                    //binding.includeLayoutTv.textView.text = it
                    /*binding.includeLayoutTv.textView.typeface =
                        Typeface.createFromAsset(requireActivity().assets,"font/Robus-BWqOd.otf")

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        binding.includeLayoutTv.textView.typeface = resources.getFont(R.font.azeret)
                    }*/


                    //маркировка через HTML
                    /*val text = "My text <ul><li>bullet one</li><li>bullet two</li></ul>"
                    binding.includeLayoutTv.textView.text = Html.fromHtml(text,Html.FROM_HTML_MODE_COMPACT)*/

                    //маркировка через Spannable
                   /* val spannable = SpannableStringBuilder("My text \nbullet one \nbullet two")
                    spannable.setSpan(BulletSpan(20,resources.getColor(R.color.colorAccent)),
                        9,18,Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                    spannable.setSpan(BulletSpan(20,resources.getColor(R.color.colorAccent)),
                        21,spannable.length,Spannable.SPAN_INCLUSIVE_INCLUSIVE)*/
                    val spannableStart = SpannableStringBuilder(it)

                    binding.includeLayoutTv.textView.setText(spannableStart,TextView.BufferType.EDITABLE)
                    val spannable = binding.includeLayoutTv.textView.text as SpannableStringBuilder


                    val start = 1
                    val end  = 3



                    spannable.setSpan(ForegroundColorSpan(resources.getColor(R.color.colorAccent)),start,
                    end,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    spannable.insert(end,"x")
                    spannable.insert(start,"x")

                    spannable.setSpan(ForegroundColorSpan(resources.getColor(R.color.colorPrimary)),5,
                    20,Spannable.SPAN_INCLUSIVE_INCLUSIVE)

                    spannable.setSpan(ForegroundColorSpan(resources.getColor(R.color.colorAccent)),20,
                        35,Spannable.SPAN_INCLUSIVE_INCLUSIVE)

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        spannable.setSpan(TypefaceSpan(resources.getFont(R.font.azeret)),20,
                            25,Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                    }

                    spannable.setSpan(ForegroundColorSpan(resources.getColor(R.color.colorPrimary)),0,
                        spannable.length,Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                    spannable.setSpan(QuoteSpan(resources.getColor(R.color.colorAccent)),0,
                        5,Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                    spannable.setSpan(BackgroundColorSpan(resources.getColor(R.color.colorAccent)),1,
                        5,Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                    spannable.setSpan(QuoteSpan(resources.getColor(R.color.colorAccent)),14,
                        25,Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                    spannable.setSpan(QuoteSpan(resources.getColor(R.color.colorAccent)),27,
                        29,Spannable.SPAN_INCLUSIVE_INCLUSIVE)


                    val request = FontRequest("com.google.android.gms.fonts",
                    "com.google.android.gms","Aguafina Script",R.array.com_google_android_gms_fonts_certs)
                    val fontCallback = object : FontsContractCompat.FontRequestCallback(){
                        override fun onTypefaceRetrieved(typeface: Typeface?) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                                typeface?.let {
                                    spannable.setSpan(TypefaceSpan(it),0,
                                        spannable.length,Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                                }
                            }
                        }
                    }
                    FontsContractCompat.requestFont(requireContext(),request,fontCallback,
                        Handler(Looper.getMainLooper())
                    )

                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        fun newInstance() = PODFragment()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_api_activity -> {
                Toast.makeText(context, "Favorite", Toast.LENGTH_SHORT).show()
                startActivity(Intent(context,ApiActivity::class.java))
            }

            R.id.action_api_bottom_activity -> {
                Toast.makeText(context, "Favorite", Toast.LENGTH_SHORT).show()
                startActivity(Intent(context, ApiBottomActivity::class.java))
            }
            R.id.app_bar_settings -> {
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container,SettingsFragment.newInstance()).addToBackStack("").commit()
            }
            // у нашего бургера такой вот id внутри android
            android.R.id.home -> {
                BottomNavigationDrawerFragment.newInstance()
                    .show(requireActivity().supportFragmentManager, "")
            }
        }
        return super.onOptionsItemSelected(item)
    }
}