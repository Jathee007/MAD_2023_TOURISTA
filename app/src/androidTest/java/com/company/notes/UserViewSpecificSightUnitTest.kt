package com.company.notes

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.company.notes.sightseeing.UserViewSpecificSight
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class UserViewSpecificSightUnitTest {




        @get:Rule
        val activityRule = ActivityScenarioRule(UserViewSpecificSight::class.java)

        @Test
        fun cancelButton_navigatesToUserViewSightsActivity() {
            // Click on the cancel button
            onView(withId(R.id.btncancelsight)).perform(click())


        }


}