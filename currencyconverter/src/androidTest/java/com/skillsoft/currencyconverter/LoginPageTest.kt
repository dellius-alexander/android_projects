package com.skillsoft.currencyconverter


// allows us to test the UI of our app
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
// allows us to test view elements using ViewActions functions
// i.e. a button is clickable, a checkbox is selected
import androidx.test.espresso.action.ViewActions.*
// allows to perform assertions on view elements
import androidx.test.espresso.assertion.ViewAssertions.matches
// included function to be performed on view elements,
// i.e. a button is clickable, a checkbox is selected
import androidx.test.espresso.matcher.ViewMatchers.*
// allows us to perform functional testing on a single activity
// also makes sure that all corresponding activities are launched
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.*
import org.junit.Assert.*
// rules are applied before any functions are invoked
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginPageTest {


    /**
     * ActivityScenarioRule: is great because it handles the setup and teardown of our
     * activity automatically.  ActivityScenarioRule launches a given activity before the
     * test starts and closes after the test.
     * Note: you must initialize the androidx.test.core.app.ActivityScenario.launch
     * function before running tests.
     */
    @get:Rule
    private lateinit var mActivityTestRule: ActivityScenarioRule<LoginPage>

    @Before
    @Throws(Exception::class)
    fun setup()
    {
        // @JvmField: Instructs the Kotlin compiler not to generate
        //      getters/setters for this property and expose it as a field.
        @JvmField
        mActivityTestRule = ActivityScenarioRule(LoginPage::class.java)
    }

    @Test
    @Throws(Exception::class)
    fun loginTest()
    {
        launch(LoginPage::class.java)
        // initializes the LoginPage activity
        // creates a view interaction for the given view userID using the withId() function
        // also enables us to interact with the view, like entering a value to be typed
        val viewUserId = onView(withId(R.id.userID))
            .perform(typeText("bob.baker@loonycorn.com"))
        assertNotNull(viewUserId)
        // creates a view interaction for the given view password using the withId() function
        // also enables us to interact with the view, like entering a value to be typed
        // we also closed the keyboard after entering password
        val viewPwd = onView(withId(R.id.password))
            .perform(typeText("bobbaker"), closeSoftKeyboard())
        assertNotNull(viewPwd)
        // creates a view interaction for the given view login_button using the withId() function
        // here we check if the button is clickable and we click the login button
        onView(withId(R.id.login_button))
            .check(matches(isClickable()))
            .perform(click())
        Thread.sleep(2000L)
    }

}