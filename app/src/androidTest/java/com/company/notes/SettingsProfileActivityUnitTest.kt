package com.company.notes

import android.app.Activity
import android.app.Instrumentation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches

@RunWith(AndroidJUnit4::class)
class SettingsProfileActivityUnitTest {
    @get:Rule
    var activityRule: ActivityTestRule<SettingsProfileActivity> = ActivityTestRule(SettingsProfileActivity::class.java)

    @Test
    fun testLogoutButton() {
     /*   onView(withId(R.id.btn_logout)).perform(click())
        onView(withId(androidx.appcompat.R.id.action_bar_activity_content)).check(matches(isDisplayed()))
*/
    }
}
