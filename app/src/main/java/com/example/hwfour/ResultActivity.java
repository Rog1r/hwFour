package com.example.hwfour;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class ResultActivity extends AppCompatActivity {
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rusult);

        tvResult = (TextView) findViewById(R.id.textView);
        showResults();
    }

    private void showResults(){
        NumberFormat numberFormat= NumberFormat.getInstance();
        Bundle bundle = getIntent().getExtras();

        int programming = bundle.getInt("programming");
        int dataStructure = bundle.getInt("dataStructure");
        int algorithm = bundle.getInt("algorithm");

        int sum = programming + dataStructure + algorithm;

        double average = sum/3.0;

        String text = "programming = " + programming +
                        "\ndataStructure = " + dataStructure +
                          "\nalgorithm = " + algorithm +
                            "\nsum = " + sum +
                              "\naverage = " + numberFormat.format(average);

        tvResult.setText(text);
        alert(average);
    }

    public void onBacKClick(View view){
        finish();
    }

    private void alert(double average){
        String message = new String();
        String title = new String();

        int pic = 0;

        if(average == 100){
            message = "100";
            title = "PASS";
            pic = R.drawable.pass;
        }else if(average >= 60){
            message = "Congratulations!";
            title = "PASS";
            pic = R.drawable.pass;
        }else{
            message = "Sorry mate!";
            title = "FAIL";
            pic = R.drawable.cross;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setIcon(pic);
        builder.setPositiveButton("OK",null);
        builder.setNegativeButton("Cancel",null);
        builder.setNeutralButton("Nothing",null);
        builder.show();
    }
}
