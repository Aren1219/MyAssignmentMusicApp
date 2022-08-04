package com.example.myassignmentca.model


import com.google.gson.annotations.SerializedName

data class MusicModel(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val results: List<ResultModel>
)