package com.ebookfrenzy.final.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebookfrenzy.final.Contact
import com.ebookfrenzy.contactfinal.R
import com.ebookfrenzy.contactfinal.databinding.FragmentMainBinding
import java.util.*

class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        listenerSetup()
        observerSetup()
        recyclerSetup()

        return binding.root
    }

    private fun listenerSetup() {

        binding.addButton.setOnClickListener {

            val name = binding.contactName.text.toString()
            val phone = binding.contactPhone.text.toString()

            if (name != "" && phone != "") {
                val contact = Contact(name, phone)
                viewModel.insertContact(contact)
                clearFields()
            } else {
                Toast.makeText(context, "Incomplete information", Toast.LENGTH_SHORT).show()

            }
        }

        binding.findButton.setOnClickListener {

            val name = binding.contactName.text.toString()

            if (name != "") {
                viewModel.findContact(name)
            } else {
                Toast.makeText(context, "No Match", Toast.LENGTH_SHORT).show()
            }

        }

        binding.ascButton.setOnClickListener {
            viewModel.getAllContactsASC()?.observe(viewLifecycleOwner, Observer { contacts -> contacts?.let {
             adapter?.setContactList(it)
             }
         })
        }

        binding.descButton.setOnClickListener {
            viewModel.getAllContactsDESC()?.observe(viewLifecycleOwner, Observer { contacts -> contacts?.let {
                adapter?.setContactList(it)
            }
            })
        }
    }
    private fun observerSetup() {

        viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        })

        viewModel.getSearchResults().observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {

                    adapter?.setContactList(it)
                } else {
                    Toast.makeText(context, "No Match", Toast.LENGTH_SHORT).show()
                }
            }
        })

    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.card_layout)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter
    }

    private fun clearFields() {

        binding.contactName.setText("")
        binding.contactPhone.setText("")
    }

}