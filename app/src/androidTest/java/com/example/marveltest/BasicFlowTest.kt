package com.example.marveltest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.marveltest.ui.list.adapter.ComicsViewHolder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BasicFlowTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    private val ITEM_BELOW_THE_FOLD = 11

    @Test
    fun scrollToItemBelowFold_checkItsText() {
        val title = "Ant-Man (2003) #2"

        // First scroll to the position that needs to be matched and click on it.
        onView(ViewMatchers.withId(R.id.comic_recycler))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<ComicsViewHolder>(
                    ITEM_BELOW_THE_FOLD,
                    click()
                )
            )

        // Match the text in an item below the fold and check that it's displayed.
        onView(withText(title)).check(matches(ViewMatchers.isDisplayed()))
    }
}
