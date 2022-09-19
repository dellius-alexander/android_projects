package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HelloActivity : AppCompatActivity() {
    /**
     * we override the default implementation, and call super.onCreate to initialize an
     * activity using a previous savedInstanceState and following that we map the activity
     * to a view.
     * @param savedInstanceState a previous savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
    }

}