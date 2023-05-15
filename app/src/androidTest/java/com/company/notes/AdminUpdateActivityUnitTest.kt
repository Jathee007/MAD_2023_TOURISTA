package com.company.notes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.company.notes.databinding.ActivityAdminUpdateBinding
import com.company.notes.hotel.AdminUpdateActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AdminUpdateActivityUnitTest {
    @get:Rule
    var activityRule: ActivityTestRule<AdminUpdateActivity>
            = ActivityTestRule(AdminUpdateActivity::class.java)

    private lateinit var binding: ActivityAdminUpdateBinding

    @Before
    fun setUp() {
        binding = activityRule.activity.binding
    }

    @Test
    fun testCancelButton() {
        onView(withText("Cancel")).check(matches(isDisplayed()))
        onView(withText("Cancel")).perform(click())
    }
}
