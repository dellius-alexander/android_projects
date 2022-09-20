package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.helloworld.databinding.ActivityHelloBinding
//import com.example.helloworld.databinding.ActivityHelloBinding
import com.example.helloworld.databinding.ActivityResultBinding

//import kotlinx.android.synthetic.main.activity_hello.*
//import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    private lateinit var resultBinding: ActivityResultBinding

    /**
     * we override the default implementation, and call super.onCreate to initialize an
     * activity using a previous savedInstanceState and following that we map the activity
     * to a view.
     * @param savedInstanceState a previous savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        // create instance of the ActivityMainBinding,
        // as we have only one layout activity_hello.xml
        resultBinding = ActivityResultBinding.inflate(layoutInflater)

        // resultBinding.root returns the root layout,
        // which is activity_hello.xml file itself
        setContentView(resultBinding.root)

        // create an intent to pass the text from activity_hello.xml
        // to activity_result.xml TextView
        val text_to_be_displayed = intent.getStringExtra("text")

        // pass to both TextView in activity_result.xml
        resultBinding.resultText.text = text_to_be_displayed
        resultBinding.displayText.text = text_to_be_displayed
        println(text_to_be_displayed)

    }
}