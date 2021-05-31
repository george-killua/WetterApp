package com.hisoka.wetterapp.data


import com.google.gson.annotations.SerializedName
import com.hisoka.wetterapp.data.one_call_req.Coord

data class Cities(
    val coord: Coord,
    val country: String, // IR
    val id: Int, // 833
    val name: String, // Ḩeşār-e Sefīd
    val state: String
)