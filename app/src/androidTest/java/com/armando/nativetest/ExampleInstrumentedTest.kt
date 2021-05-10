package com.armando.nativetest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    //activity where you want the test to be executed against to must be specified
    @Rule
    @JvmField
    val rule : ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.armando.nativetest", appContext.packageName)
    }

    @Test
    fun userCanEnterFirstName(){
        onView(withId(R.id.et_firstName)).perform(typeText("Armando"))
    }


    @Test
    fun userCanEnterLastName(){
        onView(withId(R.id.et_lastName)).perform(typeText("Bibay"))
    }

    @Test
    fun when_user_enters_firstname_and_lastname_check_to_confirm_that_the_message_is_correct(){
        onView(withId(R.id.et_firstName)).perform(typeText("Armando"))
        onView(withId(R.id.et_lastName)).perform(typeText("Bibay"))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.messages)).check(matches(withText("Welcome, Armando Bibay")))
    }


}