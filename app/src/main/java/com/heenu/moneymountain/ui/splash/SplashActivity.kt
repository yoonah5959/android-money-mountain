package com.heenu.moneymountain.ui.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.heenu.design.ui.theme.DColor
import com.heenu.moneymountain.ui.main.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = DColor.Pink40)
            ) {

                val scope = rememberCoroutineScope()
                val context = LocalContext.current
                LaunchedEffect(true) {
                    delay(1000)
                    scope.launch {
                        startActivity(MainActivity.newIntent(context = context))
                        finish()
                    }
                }
            }
        }
    }
}


