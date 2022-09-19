package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_hello.*
import kotlinx.android.synthetic.main.activity_result.*

class HelloActivity : AppCompatActivity() {
    /**
     * we override the default implementation, and call super.onCreate to initialize an
     * activity using a previous savedInstanceState and following that we map the activity
     * to a view.
     * @param savedInstanceState a previous savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  // load from previously saved state
        setContentView(R.layout.activity_hello)

        /**
         * we extract the activity from the submit button activity.
         * We initialize an Intent object that points to the component to handle the
         * intent, which in out case is the Results class. We then capture the input field
         * get_email_address and assign the input to the intent which points to the
         * Results activity.
         */
        submit_button.setOnClickListener {
            val result_intent = Intent(this, Result::class.java)
            if (get_email_address.text != null){
                val display_text = get_email_address.text
                result_intent.putExtra("text", display_text.toString())
                startActivity(result_intent)
                println(display_text)
            }

        }

    }


}