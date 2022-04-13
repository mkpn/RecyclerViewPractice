package com.recyclerviewpractice

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = manager

        val myAdapter = MyAdapter()
        recyclerView.adapter = myAdapter
        var list = listOf(
            "a",
            "b",
            "c",
            "d",
            "a",
            "b",
            "c",
            "d",
            "a",
            "b",
            "c",
            "d",
        )
        myAdapter.submitList(list)

        val reverseButton = findViewById<TextView>(R.id.reverse)
        reverseButton.setOnClickListener {
            val newList = list.reversed()
            myAdapter.submitList(newList) {
                // これないと位置バグる　ふざけてる
                recyclerView.scrollToPosition(0)
            }
            list = newList
        }
    }
}