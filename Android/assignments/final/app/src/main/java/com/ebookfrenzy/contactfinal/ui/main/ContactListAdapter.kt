package com.ebookfrenzy.final.ui.main
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.contactfinal.Contact
import com.ebookfrenzy.contactfinal.R


class ContactListAdapter(private val contactListLayout: Int) :
    RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {


        val contactName = holder.contactName
        val contactPhone = holder.contactPhone
        val delete = holder.deleteImage

        contactList.let {

            contactName.text = it!![listPosition].contactName
            contactPhone.text = it!![listPosition].contactPhone
            delete.id = it!![listPosition].id

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(contactListLayout, parent, false)
        return ViewHolder(view)
    }


        fun setContactList(contacts: List<Contact>) {
            contactList = contacts
            notifyDataSetChanged()
        }

        override fun getItemCount(): Int {
            return if (contactList == null) 0 else contactList!!.size
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var contactName: TextView = itemView.findViewById(R.id.contact_name)
            var contactPhone: TextView = itemView.findViewById(R.id.contact_phone)
            var deleteImage: ImageView = itemView.findViewById(R.id.deleteImage)

        }


    }
