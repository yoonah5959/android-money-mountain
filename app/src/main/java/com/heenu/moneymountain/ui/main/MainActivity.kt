package com.heenu.moneymountain.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.heenu.design.ui.theme.DColor
import com.heenu.design.ui.theme.HeenuTheme

class MainActivity : ComponentActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeenuTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(DColor.DarkGrey)
                )

            }
        }
    }
}