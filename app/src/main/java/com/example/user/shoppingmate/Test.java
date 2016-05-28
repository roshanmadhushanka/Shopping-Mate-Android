package com.example.user.shoppingmate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import TestZelda.EchoTest;

public class Test extends AppCompatActivity {
    public static boolean DEBUG = true;
    Button btnEchoTest, btnEncryptionTest;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //Buttons
        btnEchoTest = (Button) findViewById(R.id.btnTestEchoTest);

        //TextViews
        txtResult = (TextView) findViewById(R.id.txtTestResult);

        btnEchoTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EchoTest echoTest = new EchoTest();
                txtResult.setText(echoTest.doTest());
            }
        });
    }
}
