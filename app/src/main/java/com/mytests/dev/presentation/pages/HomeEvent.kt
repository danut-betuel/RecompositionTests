package com.mytests.dev.presentation.pages

sealed class HomeEvent {
    object OnButtonClick1 : HomeEvent()
    object OnButtonClick2 : HomeEvent()
}