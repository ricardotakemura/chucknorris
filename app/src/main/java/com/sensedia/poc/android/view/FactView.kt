package com.sensedia.poc.android.view

import com.sensedia.poc.android.model.bean.Fact
import com.sensedia.poc.android.model.bean.Facts

interface FactView {

    fun onReceived(facts: Facts?)

}