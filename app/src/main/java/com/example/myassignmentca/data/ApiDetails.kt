package com.example.myassignmentca.data

import com.example.myassignmentca.model.MusicModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.Part
import retrofit2.http.Query

interface ApiDetails {
    @GET("search")
    suspend fun getMusic(
        @Query("term") musicGenre: String,
        @Query("&media") musicMedia: String,
        @Query("&entity") musicEntity: String,
        @Query("&limit") musicCount: Int
    ) : Response<MusicModel>



// bundles, individual, properties
}