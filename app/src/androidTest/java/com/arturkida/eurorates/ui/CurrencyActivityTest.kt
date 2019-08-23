package com.arturkida.eurorates.ui

import android.support.test.espresso.IdlingRegistry
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.arturkida.eurorates.R
import com.arturkida.eurorates.idlingresource.EspressoIdlingResource
import com.arturkida.eurorates.robots.CurrencyRobot
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CurrencyActivityTest {

    @get:Rule
    val rule = ActivityTestRule<CurrencyActivity>(CurrencyActivity::class.java)

    fun robot(func: CurrencyRobot.() -> Unit) =
        CurrencyRobot().apply {
            func()
        }

    @Before
    fun setup() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @After
    fun unregister() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }

    @Test
    fun onHomeScren_CheckUsdCurrencyTitleIsDisplayed() {
        robot {
            checkUsdCurrencyTitle(R.id.tv_usd_title)
        }
    }

    @Test
    fun onHomeScren_CheckPlnCurrencyTitleIsDisplayed() {
        robot {
            checkPlnCurrencyTitle(R.id.tv_pln_title)
        }
    }

    @Test
    fun onHomeScren_CheckUsdCurrencyValueIsDisplayed() {
        robot {
            checkUsdCurrencyValue(R.id.tv_usd_value)
        }
    }

    @Test
    fun onHomeScren_CheckPlnCurrencyValueIsDisplayed() {
        robot {
            checkPlnCurrencyValue(R.id.tv_pln_value)
        }
    }
}