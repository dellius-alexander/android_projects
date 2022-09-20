package com.skillsoft.currencyconverter

// allows us to test the UI of our app
import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.Window
import android.widget.AdapterView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
// allows us to test view elements using ViewActions functions
// i.e. a button is clickable, a checkbox is selected
import androidx.test.espresso.action.ViewActions.*
// allows to perform assertions on view elements
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.matcher.RootMatchers.withDecorView
// included function to be performed on view elements,
// i.e. a button is clickable, a checkbox is selected
import androidx.test.espresso.matcher.ViewMatchers.*
// allows us to perform functional testing on a single activity
// also makes sure that all corresponding activities are launched
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.*
import org.junit.*
import org.junit.Assert.*
// rules are applied before any functions are invoked
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class HomePageTest{
    /**
     * Execute our Activities:
     * Using ActivityScenario we can manually control when out app closes in the cleanUP step
     */
    @get:Rule
    private lateinit var activityScenario: ActivityScenario<LoginPage>

    @Before
    @Throws(Exception::class)
    fun setup()
    {

        // @JvmField: Instructs the Kotlin compiler not to generate
        //      getters/setters for this property and expose it as a field.
        @JvmField
        activityScenario = launch(LoginPage::class.java)
        // creates a view interaction for the given view userID using the withId() function
        // also enables us to interact with the view, like entering a value to be typed
        val viewUserId = onView(withId(R.id.userID)).perform(typeText("bob.baker@loonycorn.com"))
        assertNotNull(viewUserId)
        // creates a view interaction for the given view password using the withId() function
        // also enables us to interact with the view, like entering a value to be typed
        // we also closed the keyboard after entering password
        val viewPwd = onView(withId(R.id.password)).perform(typeText("bobbaker"), closeSoftKeyboard())
        assertNotNull(viewPwd)
        // creates a view interaction for the given view login_button using the withId() function
        // here we check if the button is clickable and we click the login button
        onView(withId(R.id.login_button)).check(matches(isClickable())).perform(click())

    }

    @After
    fun tearDown() {
        activityScenario.close()
    }

    @Test
    @Throws(Exception::class)
    fun drawerTest()
    {
        Thread.sleep(5000L)
        onView(withId(R.id.drawer_layout))
            .perform(DrawerActions.open())
        Thread.sleep(2000L)
        onView(withText(R.string.market_status))
            .check(matches(isDisplayed()))
            .perform(click())
        val baseCurrField = onView(withId(R.id.base_currency))
        assertNotNull(baseCurrField)

        onView(withId(R.id.drawer_layout))
            .perform(DrawerActions.open())
        Thread.sleep(2000L)
        onView(withText(R.string.help))
            .check(matches(isDisplayed()))
            .perform(click())
        val baseCurr = onData(withText(R.id.help_page_ans_basecurr))
        assertNotNull(baseCurr)

        val totalCurr = onView(withId(R.id.help_page_ans_numcurr))
        assertNotNull(totalCurr)

        onView(withId(R.id.drawer_layout))
            .perform(DrawerActions.open())
        Thread.sleep(2000L)
        onView(withText(R.string.contact_us))
            .check(matches(isDisplayed()))
            .perform(click())
//        onView(withText("Visit: www.loonycorn.com"))
//            .inRoot(withDecorView(not()))
//            .check(matches(isDisplayed()))

    }

    @Test
    fun homePageTest(){
        Thread.sleep(5000L)
        onView(withId(R.id.fromCurr))
            .check(matches(isClickable()))
            .perform(click())
        Thread.sleep(2000L)
        onData(allOf(`is`(instanceOf(String::class.java)), `is`("USD")))
            .inAdapterView(allOf(isAssignableFrom(AdapterView::class.java)))
            .perform(click())
        Thread.sleep(2000L)
        onView(withId(R.id.toCurr))
            .check(matches(isClickable()))
            .perform(click())
        Thread.sleep(2000L)
        onData(allOf(`is`(instanceOf(String::class.java)), `is`("INR")))
            .inAdapterView(allOf(isAssignableFrom(AdapterView::class.java)))
            .perform(click())
        Thread.sleep(2000L)
        val editAmt = onView(withId(R.id.enterAmt))
            .perform(typeText("50"), closeSoftKeyboard())
        assertNotNull(editAmt)
        Thread.sleep(2000L)
        onView(withId(R.id.convertBtn))
            .check(matches(isClickable()))
            .perform(click())
        Thread.sleep(2000L)
        onView(withId(R.id.result_page))
            .check(matches(isDisplayed()))
    }
}