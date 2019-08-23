package com.arturkida.eurorates.robots

class CurrencyRobot : BaseRobot() {
    fun checkUsdCurrencyTitle(resId: Int) {
        isDisplayed(resId)
        matchText(resId, "USD")
    }

    fun checkPlnCurrencyTitle(resId: Int) {
        isDisplayed(resId)
        matchText(resId, "PLN")
    }

    fun checkUsdCurrencyValue(resId: Int) {
        isDisplayed(resId)
    }

    fun checkPlnCurrencyValue(resId: Int) {
        isDisplayed(resId)
    }
}