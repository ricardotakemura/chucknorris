package com.sensedia.poc.android.model.bean

import kotlin.collections.ArrayList

data class Fact(var categories: List<String> = ArrayList(),
                var created_at: String = "",
                var icon_url: String = "",
                var id: String = "",
                var updated_at: String = "",
                var url: String = "",
                var value: String = "")
