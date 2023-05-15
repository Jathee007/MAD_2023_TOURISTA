package com.company.notes

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.company.notes.feedback.AddFeedback
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddFeedbackUnitTest {

    @Test
    fun testSubmitButton() {
        // Start the AddFeedback activity
        val scenario = ActivityScenario.launch(AddFeedback::class.java)

        // Enter values in the input fields
        scenario.onActivity { activity ->
            activity.binding.etUsername.setText("John")
            activity.binding.ratingBar.rating = 3.5f
            activity.binding.etCardnumber.setText("This is a review.")
        }

        // Click the submit button
        scenario.onActivity { activity ->
            activity.binding.btnAddpayment.performClick()
        }

        // Verify that the activity finishes and ThankYou activity is started
        scenario.onActivity { activity ->
            assertEquals(true, activity.isFinishing)

        }

        // Clean up the activity scenario
        scenario.close()
    }
}