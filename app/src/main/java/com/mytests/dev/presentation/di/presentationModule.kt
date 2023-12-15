package com.mytests.dev.presentation.di

import com.mytests.dev.presentation.pages.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeViewModel() }
}