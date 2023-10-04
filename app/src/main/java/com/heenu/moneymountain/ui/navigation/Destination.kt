package com.heenu.moneymountain.ui.navigation

sealed class Destination(val route: String) {
    object ExpenditureWriting : Destination(route = "expenditureWriting")

}