package com.mytests.dev.presentation.pages

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

data class HomeState(
    val toBeChanged: Boolean = false,
    val isLoading: Boolean  = false,
    val list: ImmutableList<String> = emptyList<String>().toImmutableList()
)