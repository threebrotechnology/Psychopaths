package com.lifeindarkness.psychopaths

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.include_arrow_back.*
import kotlinx.android.synthetic.main.item_row.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        initUI()

        arrowBack.setOnClickListener {
            finish()
        }
    }

    private fun getInfo(index: Int): Array<String> {
        return when (index) {
            0 -> resources.getStringArray(R.array.type_0)
            1 -> resources.getStringArray(R.array.type_1)
            2 -> resources.getStringArray(R.array.type_2)
            3 -> resources.getStringArray(R.array.type_3)
            4 -> resources.getStringArray(R.array.type_4)
            5 -> resources.getStringArray(R.array.type_5)
            6 -> resources.getStringArray(R.array.type_6)
            7 -> resources.getStringArray(R.array.type_7)
            8 -> resources.getStringArray(R.array.type_8)
            9 -> resources.getStringArray(R.array.type_9)
            10 -> resources.getStringArray(R.array.type_10)
            11 -> resources.getStringArray(R.array.type_11)
            else -> arrayOf()
        }
    }

    private fun initUI() = GlobalScope.launch {

        val subItem = intent.getStringExtra("sub")
        val title: String = intent.getStringExtra("title") ?: getString(R.string.app_name)

        tvTitle.post {
            tvTitle.text = title
        }
        tvSub.post {
            tvSub.text = subItem
        }

        val drawableRes = intent.getIntExtra("draw", 0)
        if (drawableRes != 0) {
            ivTop.post {
                ivTop.setImageResource(drawableRes)
            }
        }

        val mainItems = resources.getStringArray(R.array.main_items)
        val items = mutableListOf<String>()
        for (item in mainItems) {
            if (item != title) {
                items.add(item)
            }
        }

        val subItems = getInfo(mainItems.indexOf(title))

        val inflater = LayoutInflater.from(this@InfoActivity)
        for (item in items) {
            val index = items.indexOf(item)
            val view = inflater.inflate(R.layout.item_row, null)
            view.post {
                view.cardView.setOnClickListener {
                    val intent = Intent(applicationContext, SplitActivity::class.java).apply {
                        putExtra("title", "$title и $item")
                        putExtra("sub", subItems[index])
                    }
                    startActivity(intent)
                }
                view.tvItem.text = item
            }
            llContent.post {
                llContent.addView(view)
            }
        }
    }
}