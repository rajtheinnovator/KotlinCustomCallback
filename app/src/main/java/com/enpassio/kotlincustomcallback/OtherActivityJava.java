package com.enpassio.kotlincustomcallback;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OtherActivityJava extends AppCompatActivity {

    PassedMessage passedMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        //initialize the callback

        final EditText messageEditText = findViewById(R.id.messageEditText);
        Button passMessageButton = findViewById(R.id.passMessageButton);
        passMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passedMessage != null) {
                    passedMessage.messagePassedIs(messageEditText.getText().toString());
                }
            }
        });

    }
}
