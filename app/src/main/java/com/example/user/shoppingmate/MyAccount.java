package com.example.user.shoppingmate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import DTO.UserDTO;
import Security.LoginTrack;

public class MyAccount extends AppCompatActivity {
    TextView txtUserName, txtEmail, txtMobileNumber, txtAccountBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        txtAccountBalance = (TextView) findViewById(R.id.txtMyAccountBalance);
        txtUserName = (TextView) findViewById(R.id.txtMyAccountUserName);
        txtEmail = (TextView) findViewById(R.id.txtMyAccountEmail);
        txtMobileNumber = (TextView) findViewById(R.id.txtMyAccountMobileNumber);

        UserDTO userDTO = LoginTrack.getCurrentUser();

        txtUserName.setText("User Name : " + userDTO.getUserName());
        txtMobileNumber.setText("Mobile Number : " + userDTO.getMobileNumber());
        txtEmail.setText("Email : " + userDTO.getEmail());
        txtAccountBalance.setText("Account Balance : " + String.valueOf(userDTO.getBalance()));

    }
}
