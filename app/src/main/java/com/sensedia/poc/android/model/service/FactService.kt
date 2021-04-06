package com.sensedia.poc.android.model.service

import com.sensedia.poc.android.model.bean.Fact
import com.sensedia.poc.android.model.bean.Facts

interface FactService {

    //@TODO MOCK
    interface Call<T>

    fun getFacts(query: String): Call<Facts>
}