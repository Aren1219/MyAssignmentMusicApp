package com.example.myassignmentca.ui

import androidx.lifecycle.ViewModel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myassignmentca.model.MusicModel
import com.example.myassignmentca.repository.Repository
import com.example.myassignmentca.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopViewModel @Inject constructor(var repository: Repository): ViewModel() {

    private val _musicDetails: MutableLiveData<UiState> = MutableLiveData(UiState.Loading)
    val musicDetails: LiveData<UiState> get() = _musicDetails

    fun getPopMusic() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getMusic(
                musicGenre = "pop",
                musicMedia = "music",
                musicEntity = "song",
                musicCount = 50
            )

            Log.i("res", response.body().toString())

            if (response.isSuccessful) {
                _musicDetails.postValue(
                    response.body()?.let { success ->
                        UiState.Success(
                            MusicModel(
                                success.resultCount,
                                success.results
                            )
                        )
                    }
                )
            } else {
                _musicDetails.postValue(
                    UiState.Error(
                        Throwable(
                            response.message()
                        )
                    )
                )
            }
        }
    }
}