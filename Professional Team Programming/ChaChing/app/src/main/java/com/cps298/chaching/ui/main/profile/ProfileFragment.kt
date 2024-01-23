package com.cps298.chaching.ui.main.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cps298.chaching.Contact
import com.cps298.chaching.R
import com.cps298.chaching.databinding.FragmentProfileBinding
import com.cps298.chaching.ui.main.ContactListAdapter

class ProfileFragment : Fragment() {

    private var adapter: ContactListAdapter? = null

    companion object {
        fun newInstance() = ProfileFragment()
    }

    val viewModel: ProfileViewModel by viewModels()
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        val spinner : Spinner = binding.root.findViewById<Spinner?>(R.id.useCategory_spinner)

       //option.adapter = ArrayAdapter<String>(this, R.layout.custom_spinner_item, options)

        ArrayAdapter.createFromResource (requireContext(), R.array.useCategory_array, R.layout.custom_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            spinner.adapter = adapter
        }

/*        val useCategorySpinner: Spinner = binding.useCategorySpinner

        useCategorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Retrieve the selected item as a string
                val selectedCategory: String = parent?.getItemAtPosition(position).toString()

                // Now you can use 'selectedCategory' as needed
                // For example, you can log it or use it in your logic
                Log.d("ProfileFragment", "Selected category: $selectedCategory")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case where nothing is selected if needed
            }
        }*/

        listenerSetup()
        observerSetup()
        recyclerSetup()

        return binding.root
    }




    private fun listenerSetup() {
        binding.profileDisplayButton.setOnClickListener{
            viewModel.getAllContacts()
            Log.d(tag, "Profile Display button clicked")
        }

        binding.addButton.setOnClickListener {
            val expiration = binding.expiration.text.toString()
            val cardName = binding.cardName.text.toString()
            val cardBrand = binding.cardBrand.text.toString()
            val fee = binding.fee.text.toString()
            val perk = binding.perk.text.toString()
            //val useCategory = binding.useCategorySpinner.toString()

            val useCategorySpinner: Spinner = binding.useCategorySpinner
            val selectedCategory = useCategorySpinner.selectedItem.toString()

            if (cardName != "" && cardBrand != "" && fee != "" && perk != "" && selectedCategory != "") {
                val contact = Contact(cardName,expiration , cardBrand, perk, selectedCategory, fee )
                viewModel.insertContact(contact)
                clearFields()
            // Update the RecyclerView after inserting the card
                //adapter?.setContactList(viewModel.getAllContacts()?)
                viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer { contacts ->
                    contacts?.let  {
                        adapter?.setContactList(it)
                        Log.d("Card Added", "getAllContacts observer activated after adding card")
                    }
                })
            } else {
                val toast = Toast.makeText(context, "You must enter values for all boxes", Toast.LENGTH_SHORT)
                toast.show()
                //binding.contactID.text = "Incomplete information"
            }
        }

        binding.descButton.setOnClickListener {
            viewModel.getAllContactsDesc()
            Log.d(tag, "DESC button clicked") }

        binding.ascButton.setOnClickListener {
            viewModel.getAllContactsAsc()
            Log.d(tag, "ASC button clicked") }

        binding.findButton.setOnClickListener { viewModel.findContact(binding.cardName.text.toString()) }

        binding.deleteButton.setOnClickListener {
            //val userInput = Integer.parseInt(binding.contactName.text.toString())
            //viewModel.deleteContact(userInput)//checks if user has entered the right name before deleting, i'll have to
            //repurpose this for use with the trashcan probably, I can compare it to a hidden value stored in the recyclerview
            clearFields()
        }

        val useCategorySpinner: Spinner = binding.useCategorySpinner

        useCategorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Retrieve the selected item as a string
                val selectedCategory: String = parent?.getItemAtPosition(position).toString()

                // Now you can use 'selectedCategory' as needed
                // For example, you can log it or use it in your logic
                Log.d("ProfileFragment", "Selected category: $selectedCategory")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case where nothing is selected if needed
            }
        }
    }

    private fun observerSetup() {

        viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let  {
                adapter?.setContactList(it)
                Log.d(tag, "getAllContacts observer activated")
            }
        })

        //ANDROID WANTED TO SPECIFY VIEWLIFECYCLEOWNER INSTEAD OF "THIS"
        //viewModel.getSearchResults().observe(this, Observer { products ->

        viewModel.getSearchResults().observe(viewLifecycleOwner, Observer { contacts ->

            contacts?.let {
                if(it.isNotEmpty()){
                    adapter?.setContactList(it)
                }
                /* else if (binding.cardName.text.isNotEmpty()) { //if nothing comes up in the recyclerview but there is text in the textbox
                     val toast = Toast.makeText(context, "There are no cards that match your search", Toast.LENGTH_SHORT)
                     toast.show()

                 }*/
                else {
                    val toast = Toast.makeText(context, "You must enter a search criteria in the name field", Toast.LENGTH_SHORT)
                    toast.show()
                    //show your toast here
                    //when there is nothing in the array
                }

                /*if (it.isNotEmpty()) {
                    //recyclerSetup()
                    Log.d(tag, "getSearchResults observer activated")
                    binding.contactID.text = String.format(Locale.US, "%d", it[0].id)
                    binding.contactName.setText(it[0].contactName)
                    binding.contactQuantity.setText(it[0].quantity)
                } else {
                    binding.contactID.text = "No Match"
                }*/
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.contact_list_item, false)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter

        adapter!!.settingListener(object: ContactListAdapter.onItemClickListener{
            //...code here to send the id to the deleteContact method of the mainviewmodel
            override fun onClick(id: String) {
                //return ()
                var contactId: Int = Integer.parseInt(id)
                viewModel.deleteContact(contactId)
                Log.d("ProfileFragment", "deleteButton Detected, ID: " + id)
            }

        })
    }

    private fun clearFields() { //clear contacts on ui to prevent repetition
        binding.contactID.text = ""
        binding.cardName.setText("")
        binding.cardBrand.setText("")
        binding.fee.setText("")
//        binding.ownership.setText("")
        binding.expiration.setText("")
        //binding.useCategory.setText("")
        binding.perk.setText("")
    }

}

//}