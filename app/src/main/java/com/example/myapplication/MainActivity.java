package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormatSymbols;

public class MainActivity extends AppCompatActivity {
    Button button;
    Context context;
    float WindowS;
    float WindowD;
    float DoorS;
    float DoorD;
    float WallD;
    float WallS;
    float CeilingS;
    float WallpaperS;
    float WallpaperD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        context = getApplicationContext();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameText = findViewById(R.id.WallD);
                EditText nameText2 = findViewById(R.id.WallS);
                EditText nameText3 = findViewById(R.id.CeilingS);
                EditText nameText4 = findViewById(R.id.WindowS);
                EditText nameText5 = findViewById(R.id.WindowD);
                EditText nameText6 = findViewById(R.id.DoorS);
                EditText nameText7 = findViewById(R.id.DoorD);
                EditText nameText8 = findViewById(R.id.WallpaperS);
                EditText nameText9 = findViewById(R.id.WallpaperD);
                String WallDD = nameText.getText().toString();
                WallDD = WallDD.replaceAll(",",".");
                if(TextUtils.isEmpty(WallDD)) {
                    nameText.setError("Это значение обязательно для получения результата");
                    return;
                }
                else {
                    WallD = Float.parseFloat(WallDD);
                }
                String WallSS = nameText2.getText().toString();
                WallSS = WallSS.replaceAll(",",".");
                if(TextUtils.isEmpty(WallSS)) {
                    nameText2.setError("Это значение обязательно для получения результата");
                    return;
                }
                else {
                    WallS = Float.parseFloat(WallSS);
                }
                String CeilingSS = nameText3.getText().toString();
                if(TextUtils.isEmpty(CeilingSS)) {
                    nameText3.setError("Это значение обязательно для получения результата");
                    return;
                }
                else {
                    CeilingS = Float.parseFloat(nameText3.getText().toString().trim());
                }
                String WindowSS = nameText4.getText().toString();
                String WindowDD = nameText5.getText().toString();
                WindowSS = WindowSS.replaceAll(",",".");
                WindowDD = WindowDD.replaceAll(",",".");
                if(TextUtils.isEmpty(WindowSS)) {
                    if (TextUtils.isEmpty(WindowDD)){
                        WindowS = 0;
                        WindowD = 0;
                    }
                    else
                    {
                        nameText5.setError("");
                        nameText4.setError("Ширина и длина окна должны быть обе либо введены, либо не введены");
                    return;
                    }
                }
                else{
                    if (TextUtils.isEmpty(WindowDD)){
                        nameText5.setError("");
                        nameText4.setError("Ширина и длина окна должны быть обе либо введены, либо не введены");
                        return;
                    }
                    else{
                        WindowS = Float.parseFloat(WindowSS);
                        WindowD = Float.parseFloat(WindowDD);
                    }

                }
                String DoorSS = nameText6.getText().toString();
                String DoorDD = nameText7.getText().toString();
                DoorSS = DoorSS.replaceAll(",",".");
                DoorDD = DoorDD.replaceAll(",",".");
                if(TextUtils.isEmpty(DoorSS)) {
                    if (TextUtils.isEmpty(DoorDD)){
                        DoorS = 0;
                        DoorD = 0;
                    }
                    else
                    {
                        nameText7.setError("");
                        nameText6.setError("Ширина и длина двери должны быть обе либо введены, либо не введены");
                        return;
                    }
                }
                else{
                    if(TextUtils.isEmpty(DoorDD)) {
                        nameText7.setError("");
                        nameText6.setError("Ширина и длина двери должны быть обе либо введены, либо не введены");
                        return;
                    }
                    else{
                        DoorS = Float.parseFloat(DoorSS);
                        DoorD = Float.parseFloat(DoorDD);
                    }
                }
                String WallPaperDD = nameText8.getText().toString();
                WallPaperDD = WallPaperDD.replaceAll(",",".");
                if(TextUtils.isEmpty(WallPaperDD)) {
                    nameText8.setError("Это значение обязательно для получения результата");
                    return;
                }
                else {
                    WallpaperD = Float.parseFloat(WallPaperDD);
                }
                String WallPaperSS = nameText9.getText().toString();
                WallPaperSS = WallPaperSS.replaceAll(",",".");
                if(TextUtils.isEmpty(WallPaperSS)) {
                    nameText9.setError("Это значение обязательно для получения результата");
                    return;
                }
                else {
                    WallpaperS = Float.parseFloat(WallPaperSS);
                }
                Intent intent = new Intent(context,SecondActivity.class);
                intent.putExtra("WallLength", WallD);
                intent.putExtra("WallHeight", WallS);
                intent.putExtra("Ceiling", CeilingS);
                intent.putExtra("WindowHeight", WindowS);
                intent.putExtra("WindowLength", WindowD);
                intent.putExtra("DoorHeight", DoorS);
                intent.putExtra("DoorLength", DoorD);
                intent.putExtra("WallPaperHeight", WallpaperS);
                intent.putExtra("WallPaperLength", WallpaperD);
                startActivity(intent);
            }
        });
    }


}