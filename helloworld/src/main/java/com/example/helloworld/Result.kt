package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hello.*
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {
    /**
     * we override the default implementation, and call super.onCreate to initialize an
     * activity using a previous savedInstanceState and following that we map the activity
     * to a view.
     * @param savedInstanceState a previous savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // retrieve the value from a map
        val text_to_be_displayed  = intent.getStringExtra("text")
        // set the input message as the display text
        display_text.text = text_to_be_displayed
    }
}