package com.example.user.shoppingmate;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import Security.LoginTrack;

public class MainMenu extends AppCompatActivity{

    Button btnBuyMore, btnPurchaseHistory, btnMyAccount, btnTest, btnExit;
    Animation animTranslate;

    public void exit(){
        View view = (LayoutInflater.from(ContextObject.GetContext())).inflate(R.layout.exit_confirm, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainMenu.this);
        builder.setTitle("Confirm");
        builder.setView(view);
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainMenu.this.finish();
                System.exit(1);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        Dialog dialog = builder.create();
        dialog.show();
    }

    public void showBuyMoreForm(View v){
        v.startAnimation(animTranslate);

        if(LoginTrack.isValid()){
            Intent intent = new Intent(ContextObject.GetContext() , PurchaseForm.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(ContextObject.GetContext() , Login.class);
            startActivity(intent);
        }
    }

    public void showPurchaseHistoryForm(View v){
        v.startAnimation(animTranslate);
        if(LoginTrack.isValid()){
            Intent intent = new Intent(ContextObject.GetContext() , PurchaseHistoryPlot.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(ContextObject.GetContext() , Login.class);
            startActivity(intent);
        }
    }

    public void showMyAccountForm(View v){
        v.startAnimation(animTranslate);
        if(LoginTrack.isValid()){
            Intent intent = new Intent(ContextObject.GetContext() , MyAccount.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(ContextObject.GetContext() , Login.class);
            startActivity(intent);
        }
    }

    public void showTestForm(View v){
        v.startAnimation(animTranslate);
        if(LoginTrack.isValid()){
            Intent intent = new Intent(ContextObject.GetContext() , Test.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(ContextObject.GetContext() , Login.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Buttons
        btnBuyMore = (Button) findViewById(R.id.btnMainMenuBuyMore);
        btnPurchaseHistory = (Button) findViewById(R.id.btnMainMenuPurchaseHistory);
        btnMyAccount = (Button) findViewById(R.id.btnMainMenuMyAccount);
        btnTest = (Button) findViewById(R.id.btnMainMenuTest);
        btnExit = (Button) findViewById(R.id.btnMainMenuExit);

        if(Test.DEBUG == true){
            btnTest.setVisibility(View.VISIBLE);
        }

        //Button animation
        animTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);

        btnBuyMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBuyMoreForm(v);
            }
        });

        btnPurchaseHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPurchaseHistoryForm(v);
            }
        });

        btnMyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyAccountForm(v);
            }
        });

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTestForm(v);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animTranslate);
                exit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(MainMenu.this, "Long press to exit", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
        }
        return true;
    }
}
