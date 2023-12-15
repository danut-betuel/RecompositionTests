package com.mytests.dev.presentation.pages

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    fun onEvent(event: HomeEvent) {
        if (event is HomeEvent.OnButtonClick1) {
            state = state.copy(toBeChanged = !state.toBeChanged)
        }
        else if (event is HomeEvent.OnButtonClick2) {
            state = state.copy(isLoading = !state.isLoading)
        }
    }

    init {
        state = state.copy(isLoading = true)

        viewModelScope.launch {
            delay(1000)

            state = state.copy(
                isLoading = false,
                list = listOf(
                    "#life", "#motivation", "#nature", "#health", "#technology",
                    "#inspiration", "#wellness", "#adventure", "#creativity",
                    "#happiness", "#knowledge", "#peace", "#success", "#mindfulness",
                    "#balance", "#positivity", "#growth", "#challenge", "#spirituality",
                    "#gratitude", "#connection", "#mindset", "#perseverance", "#tranquility",
                    "#curiosity", "#kindness", "#achievement", "#resilience", "#imagination",
                ).toImmutableList()
            )
        }
    }
}