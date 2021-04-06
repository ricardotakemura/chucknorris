package com.sensedia.poc.android.view.impl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sensedia.poc.android.R
import com.sensedia.poc.android.presenter.FactPresenter

class MainActivity : AppCompatActivity() {

    val factPresenter = object : FactPresenter {
        override fun obtainFacts() {
            TODO("MOCK")
        }
    }

    //@TODO MOCK
    var factsRecyclerView = RecyclerView(applicationContext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        factPresenter.obtainFacts()
        factsRecyclerView.layoutManager = LinearLayoutManager(this)
    }

}