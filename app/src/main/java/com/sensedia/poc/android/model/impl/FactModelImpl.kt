package com.sensedia.poc.android.model.impl

import com.sensedia.poc.android.model.FactModel
import com.sensedia.poc.android.model.bean.Facts
import com.sensedia.poc.android.model.service.FactService
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class FactModelImpl: FactModel {

    private val factService = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()
        .create(FactService::class.java)

    override fun getFacts(): Facts? {
        val call = factService.getFacts("dev")
        return call.execute().body()
    }

}