package com.example.myassignmentca.util

import com.example.myassignmentca.model.MusicModel

sealed class UiState {
    object Loading: UiState()
    data class Success(val musicResponse: MusicModel): UiState()
    data class Error(val error: Throwable): UiState()
}
