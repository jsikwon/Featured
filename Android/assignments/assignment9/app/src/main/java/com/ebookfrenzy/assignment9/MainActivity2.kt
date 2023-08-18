package com.ebookfrenzy.assignment9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.assignment9.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val extras = intent.extras ?: return

        val detail = extras.getString(R.id.itemDetail.toString())

        binding.detailText.text = detail

    }
}