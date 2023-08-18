package com.ebookfrenzy.assignment7.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ebookfrenzy.assignment7.R.drawable.*
import com.ebookfrenzy.assignment7.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.button1.setOnClickListener {
            val action : MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()

            action.setTitle("Image 1")
            action.setImage(android_image_1)
            Navigation.findNavController(it).navigate(action)
        }

        binding.button2.setOnClickListener {
            val action : MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()

            action.setTitle("Image 2")
            action.setImage(android_image_2)
            Navigation.findNavController(it).navigate(action)
        }

        binding.button3.setOnClickListener {
            val action : MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()

            action.setTitle("Image 3")
            action.setImage(android_image_3)
            Navigation.findNavController(it).navigate(action)
        }
    }
}