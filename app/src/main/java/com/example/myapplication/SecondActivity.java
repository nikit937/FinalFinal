package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView = new TextView(this);
        Bundle arguments = getIntent().getExtras();

        if(arguments!=null){
            float WallL = arguments.getFloat("WallLength");
            float WallH = arguments.getFloat("WallHeight");
            float CeilingH = arguments.getFloat("Ceiling");
            float WindowH = arguments.getFloat("WindowLength");
            float WindowL = arguments.getFloat("WindowHeight");
            float DoorL = arguments.getFloat("DoorLength");
            float DoorH = arguments.getFloat("DoorHeight");
            float WallPaperH = arguments.getFloat("WallPaperHeight");
            float WallPaperL = arguments.getFloat("WallPaperLength");
            float Sum = (WallH + WallL)*2;
            float WindowSum = WindowH*WindowL;
            float DoorSum = DoorH*DoorL;
            float Other = DoorSum+WindowSum;
            float Area = Sum*CeilingH;
            float FinalArea = Area - Other;
            float WallpaperArea = WallPaperH*WallPaperL;
            float Result = FinalArea/WallpaperArea;
            Result = (int)Math.ceil(Result);
            int Res = (int) (Result);
            String formattedDouble = new DecimalFormat("#0.0").format(FinalArea);
            String formattedDouble2 = new DecimalFormat("#0.0").format(WallpaperArea);
            textView.setText("Площадь стен  " + formattedDouble + "\n"+ "Площадь рулона обоев  " + formattedDouble2 + "\n" + "Нужное количество рулонов  " + Res + "\n" + "\n" + "Рекомендуется взять один рулон в запас");
        }
        setContentView(textView);
    }
}