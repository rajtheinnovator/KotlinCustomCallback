package com.enpassio.kotlincustomcallback

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), OtherActivity.PassedMessage {

    lateinit var button: Button
    lateinit var receivedMessageTextView: TextView

    companion object {
        //  val TAG:String = MainActivity::class.java.simpleName
        val TAG: String = "my_tag"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        receivedMessageTextView = findViewById(R.id.received_message_text_view)
        button.setOnClickListener { startActivity(Intent(this@MainActivity, OtherActivity::class.java)) }
    }

    override fun messagePassedIs(messageReceived: String) {
        //on receiving the message, set it on receivedMessageTextView
        Log.d(TAG, "message received is: " + messageReceived)
        receivedMessageTextView.text = messageReceived
    }
}
