package com.example.hwfour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etProgramming;
    private EditText etDataStructure;
    private EditText etAlgorithm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preload();
    }

    private void preload(){
        etProgramming = (EditText) findViewById(R.id.editText1);
        etDataStructure = (EditText) findViewById(R.id.editText2);
        etAlgorithm = (EditText) findViewById(R.id.editText3);

    }

    private boolean isValid(EditText editText){
        String pattern = "1[0]{2}|[0-9]{1,2}";
        String text = editText.getText().toString();

        if(!text.matches(pattern)){
            editText.setError("0 ~ 100");
            return false;
        }else{
            return true;
        }

    }

    private String getText(EditText editText){
        String result = editText.getText().toString();
        return result;
    }

    public void onSubmitClick(View view){
        boolean isValid = isValid(etProgramming) & isValid(etDataStructure) & isValid(etAlgorithm);

        if(!isValid){
            return;
        }

        int programmoing = Integer.parseInt(etProgramming.getText().toString());
        int dataStructure = Integer.parseInt(etDataStructure.getText().toString());
        int algorithm = Integer.parseInt(etAlgorithm.getText().toString());

        Intent intent= new Intent(this,ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("programming" , programmoing);
        bundle.putInt("dataStructure" , dataStructure);
        bundle.putInt("algorithm" , algorithm);

        intent.putExtras(bundle);
        startActivity(intent);
    }
}
