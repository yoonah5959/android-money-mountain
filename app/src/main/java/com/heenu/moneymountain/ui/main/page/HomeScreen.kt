package com.heenu.moneymountain.ui.main.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.heenu.design.ui.theme.HeenuTheme
import com.heenu.moneymountain.R


@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        RestPrice(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(24.dp))
        TodayTotalExpenditure(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun RestPrice(modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = stringResource(id = R.string.restPrice))
        Spacer(modifier = modifier.height(12.dp))
        Text(text = "10,000원")
    }
}

@Composable
fun TodayTotalExpenditure(modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = stringResource(id = R.string.todayTotalExpenditure))
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "22,0000원"
            )
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Rounded.KeyboardArrowRight, contentDescription = stringResource(
                    id = R.string.seeDetail
                )
            )
        }
    }
}

@Preview("home screen", showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HeenuTheme {
        HomeScreen()
    }
}

@Preview("rest price", showBackground = true)
@Composable
fun PreviewRestPrice() {
    HeenuTheme {
        RestPrice(modifier = Modifier.fillMaxWidth())
    }
}

@Preview("today total expenditure", showBackground = true)
@Composable
fun PreviewTodayTotalExpenditure() {
    HeenuTheme {
        TodayTotalExpenditure(modifier = Modifier.fillMaxWidth())
    }
}