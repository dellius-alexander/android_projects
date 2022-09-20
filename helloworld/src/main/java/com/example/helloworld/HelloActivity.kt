package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
//import androidx.core.widget.Text
import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.constraintlayout.widget.ConstraintLayout
import com.example.helloworld.databinding.ActivityHelloBinding
import com.example.helloworld.databinding.ActivityResultBinding

//import android.content.Intent
//import android.widget.TextView
//import kotlinx.android.synthetic.main.activity_hello.*
//import kotlinx.android.synthetic.main.activity_result.*

class HelloActivity : AppCompatActivity() {

    private lateinit var resultBinding: ActivityResultBinding
    private lateinit var helloBinding: ActivityHelloBinding
    /**
     * we override the default implementation, and call super.onCreate to initialize an
     * activity using a previous savedInstanceState and following that we map the activity
     * to a view.
     * @param savedInstanceState a previous savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_hello)

        // create instance of the ActivityMainBinding,
        // as we have only one layout activity_main.xml
        helloBinding = ActivityHelloBinding.inflate(layoutInflater)
        resultBinding = ActivityResultBinding.inflate(layoutInflater)

        // binding.root returns the root layout,
        // which is activity_main.xml file itself
        setContentView(helloBinding.root)

//        // using the binding variable we can access the layout
//        // properties and perform the operations on them as usual
//        helloBinding.submitButton.setOnClickListener {
//            val str: String = helloBinding.getEmailAddress.text.toString()
//            if (str.isNotEmpty()) {
//                resultBinding.resultText.text = str
//
//            } else {
//                error("Something went wrong with key binding...")
//            }
//        }

//        resultBinding = ActivityResultBinding.inflate(layoutInflater)
//        helloBinding = ActivityHelloBinding.inflate(layoutInflater)
        var submit_button = helloBinding.submitButton

        var result_intent = Intent(this, Result::class.java)

        submit_button.setOnClickListener {
            var email_text = helloBinding.getEmailAddress
            if (email_text.text.isNotEmpty()){
                val display_text = email_text.text
                result_intent.putExtra("text", display_text.toString())
                startActivity(result_intent)
                println(display_text)
            }
        }

    }


}