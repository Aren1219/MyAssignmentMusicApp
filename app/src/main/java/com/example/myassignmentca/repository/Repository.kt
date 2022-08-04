package com.example.myassignmentca.repository

import com.example.myassignmentca.model.MusicModel
import retrofit2.Response

interface Repository {
    suspend fun getMusic(
        musicGenre: String,
        musicMedia: String,
        musicEntity: String,
        musicCount: Int
    ) : Response<MusicModel>
}