package com.example.myassignmentca.repository

import com.example.myassignmentca.data.ApiDetails
import com.example.myassignmentca.model.MusicModel
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiDetails: ApiDetails) : Repository {
    override suspend fun getMusic(
        musicGenre: String,
        musicMedia: String,
        musicEntity: String,
        musicCount: Int
    ): Response<MusicModel> = apiDetails.getMusic(musicGenre, musicMedia, musicEntity, musicCount)
}