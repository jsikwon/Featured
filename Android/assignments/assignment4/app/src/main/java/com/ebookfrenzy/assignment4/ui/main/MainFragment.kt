package com.ebookfrenzy.assignment4.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.assignment4.R
import com.ebookfrenzy.assignment4.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        if(viewModel.getName().isEmpty()) {
            binding.display.text = getString(R.string.emptyText)
        } else {
            binding.display.text = viewModel.getName().joinToString(
                prefix = "",
                separator = "\n",
                postfix = ""
            )
        }

        binding.button.setOnClickListener {
            if (binding.editTextPersonName.text.isNotEmpty()) {
                viewModel.addName(binding.editTextPersonName.text.toString())
                binding.display.text = viewModel.getName().joinToString(prefix = "",
                    separator = "\n",
                    postfix = "")
            } else {
                binding.display.text = getString(R.string.emptyText)
            }
        }
    }
}