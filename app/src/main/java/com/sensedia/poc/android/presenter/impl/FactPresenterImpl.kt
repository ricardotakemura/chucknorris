package com.sensedia.poc.android.presenter.impl

import android.os.Handler
import android.os.Looper
import com.sensedia.poc.android.model.FactModel
import com.sensedia.poc.android.model.bean.Facts
import com.sensedia.poc.android.presenter.FactPresenter
import com.sensedia.poc.android.view.FactView
import java.util.concurrent.Executors

class FactPresenterImpl(val view: FactView, val model: FactModel): FactPresenter {

    private val handler = Handler(Looper.getMainLooper());
    private val executor = Executors.newCachedThreadPool();

    override fun getFacts() {
        executor.execute {
            val facts = model.getFacts()
            handler.post {
                view.onReceived(facts)
            }
        }
    }

}