package com.bodnar.lab6

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import com.bodnar.lab6.ui.theme.AppTheme
import lab6.shared.generated.resources.Res
import lab6.shared.generated.resources.compose_multiplatform
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.compose.KoinContext
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App() {
    remember { Napier.base(DebugAntilog()) }

    KoinContext {
        val aboutViewModel: AboutViewModel = koinInject()
        val state by aboutViewModel.uiState.collectAsState()
        AppTheme {
            var showContent by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .safeContentPadding()
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Platform: ${state.platformName} | OS: ${state.osVersion}",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    showContent = !showContent
                    if (showContent) {
                        aboutViewModel.incrementCounterInUi()
                    }
                    Napier.i("Кнопку натиснуто. Стан: $showContent", tag = "LAB9_LOG")
                }) {
                    Text("Click me!")
                }

                AnimatedVisibility(showContent) {
                    val greeting = remember { Greeting().greet() }
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        androidx.compose.foundation.Image(painterResource(Res.drawable.compose_multiplatform), null)
                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Кількість відкриттів екрана: ${state.openCount}",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.secondary
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Востаннє відкрито: ${state.lastOpenTime}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                }
            }
        }
    }
}
