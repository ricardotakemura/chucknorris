package com.sensedia.poc.android.view.impl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sensedia.poc.android.R
import com.sensedia.poc.android.model.bean.Facts
import com.sensedia.poc.android.model.impl.FactModelImpl
import com.sensedia.poc.android.presenter.FactPresenter
import com.sensedia.poc.android.presenter.impl.FactPresenterImpl
import com.sensedia.poc.android.view.FactView
import com.sensedia.poc.android.view.impl.recycler.FactRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), FactView {

    val factPresenter: FactPresenter = FactPresenterImpl(this, FactModelImpl())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        factPresenter.obtainFacts()
        factsRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onReceived(facts: Facts?) {
        if (facts != null) {
           factsRecyclerView.adapter = FactRecyclerViewAdapter(facts.result)
        }
    }
}