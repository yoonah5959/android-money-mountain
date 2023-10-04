package com.heenu.moneymountain.ui.expenditurewriting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.heenu.design.ui.theme.DColor
import com.heenu.design.ui.theme.HeenuTheme

@Composable
fun ExpenditureWritingScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = DColor.Gray5)) {

    }
}

@Preview("expenditure writing screen")
@Composable
fun PreviewExpenditureWritingScreen() {
    HeenuTheme {
        ExpenditureWritingScreen()
    }
}