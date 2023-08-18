package com.ebookfrenzy.assignment5.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ebookfrenzy.assignment5.R
import com.ebookfrenzy.assignment5.databinding.FragmentMainBinding
import com.ebookfrenzy.assignment5.BR.myViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentMainBinding

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_main, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.setVariable(myViewModel, viewModel)

    }
}