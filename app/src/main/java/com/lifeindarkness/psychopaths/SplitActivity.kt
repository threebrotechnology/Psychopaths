package com.lifeindarkness.psychopaths

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_split.*
import kotlinx.android.synthetic.main.include_arrow_back.*

class SplitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_split)

        arrowBack.setOnClickListener {
            finish()
        }

        tvTitle.text = intent.getStringExtra("title")

        tvSub.text = intent.getStringExtra("sub")
    }
}