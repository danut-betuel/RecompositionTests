package com.mytests.dev.presentation.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import kotlinx.collections.immutable.ImmutableList

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = getViewModel()
) {
    val state = homeViewModel.state

    LaunchedEffect(key1 = state.toBeChanged) {
    }

    val buttonClick1 = remember {
        {
            homeViewModel.onEvent(HomeEvent.OnButtonClick1)
        }
    }

    val buttonClick2 = remember {
        {
            homeViewModel.onEvent(HomeEvent.OnButtonClick2)
        }
    }

    HomeScreenContent(
        isLoading = state.isLoading,
        myList = state.list,
        buttonClick1,
        buttonClick2
    )
}

@Composable
fun HomeScreenContent(
    isLoading: Boolean,
    myList: ImmutableList<String>,
    button1Click: () -> Unit,
    button2Click: () -> Unit,
) {
    println("Composing HomeScreenContent")

    Column {

        Button(onClick = button1Click) {
            Text(text = "Click me1")
        }

        Button(onClick = button2Click) {
            Text(text = "Click me2")
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = myList,
            ) {
                Text(
                    text = it,
                    modifier = Modifier.padding(20.dp)
                )
            }
            if (isLoading) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}