package com.enpassio.kotlincustomcallback

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText

class OtherActivityKotlin : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        passMessageButton = findViewById(R.id.passMessageButton)
        messageEditText = findViewById(R.id.messageEditText)

        passMessageButton.setOnClickListener {
            val message: String = messageEditText.text.toString()
            Log.d(MainActivity.TAG, "message from editText is: " + message)
            SomeActionPerformed(message)
        }
    }

    private fun SomeActionPerformed(message: String) {
        Log.d(MainActivity.TAG, "some action performed")
        //when some action is performed, call the interface method **messagePassedIs** and pass te message


        /*
        Issue below
        */
        ((AppConstant.context as PassedMessage).messagePassedIs(message))

    }

    interface PassedMessage {
        fun messagePassedIs(messagePassed: String)
    }


    companion object {
        //  val TAG:String = OtherActivityJava::class.java.simpleName
        val TAG: String = "my_tag"
    }

    lateinit var passMessageButton: Button
    lateinit var messageEditText: EditText
}
