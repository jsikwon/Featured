package com.ebookfrenzy.assignment9

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.assignment9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager(this)
        binding.contentMain.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        binding.contentMain.recyclerView.adapter = adapter
    }

//    override fun onCardClick(item: CardView) {
//        val intent = Intent(this, MainActivity2::class.java)
//        //intent.putExtra("title", itemTitle)
//        //intent.putExtra("detail", itemDetail)
//        //intent.putExtra("image", itemImage)
//        ContextCompat.startActivity(view.context, i, null)
//    }

//    adapter.setOnItemClickListener(object : RecyclerAdapter.onItemClickListener{
//        override fun onItemClick(position: Int){
//
//        }
//    })

//    fun sendText(view: View) {
//
//        val i = Intent(this, MainActivity2::class.java)
//
//        val myString = binding.contentMain.recyclerView.context
//
//        //i.putExtra("qString", myString)
//
//        ContextCompat.startActivity(view.context, i, null)
//        //I ADDED THIS ONE
//        //i.putExtra("myname", "scott")
//
//        //startActivity IS A ONE WAY STREET AND DOES NOT NEED THE
//        //REQUEST_CODE
//        //startActivityForResult(i, request_code)
//        startForResult.launch(i)
//    }
//
//    val startForResult = registerForActivityResult(
//        ActivityResultContracts.StartActivityForResult()
//    ) { result: ActivityResult ->
//        if (result.resultCode == Activity.RESULT_OK) {
//            val data = result.data
//            data?.let {
//                if (it.hasExtra("returnData")) {
//                    val returnString = it.extras?.getString("returnData")
//                    //binding.itemDetail.text = returnString
//                }
//            }
//        }
//    }
}