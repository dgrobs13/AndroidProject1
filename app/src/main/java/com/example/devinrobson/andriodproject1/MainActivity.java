package com.example.devinrobson.andriodproject1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText enterInteger;
    EditText enterBase;
    EditText enterOutputbase;
    TextView answer;
    Button convertButton;

    String displayedAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterInteger = (EditText) findViewById(R.id.Integer_Input);
        enterBase = (EditText) findViewById(R.id.Base_Input);
        enterOutputbase = (EditText) findViewById(R.id.Output_Base);
        answer = (TextView) findViewById(R.id.Answer);
        convertButton = (Button) findViewById(R.id.convertButton);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    displayedAnswer = Integer.toString(Integer.parseInt(Integer.toString(Integer.parseInt(enterInteger.getText().toString(),
                            Integer.parseInt(enterBase.getText().toString())),
                            Integer.parseInt(enterOutputbase.getText().toString()))));
                    answer.setText("The answer is: " + displayedAnswer);
                } catch (NumberFormatException e){
                    e.printStackTrace();
                    Toast errorToast = Toast.makeText(getApplicationContext(), "Not a Valid Conversion, Try Again", Toast.LENGTH_LONG);
                    errorToast.setGravity(Gravity.CENTER,0,0);
                    errorToast.show();

                    //set stuff red
                    enterInteger.setBackgroundColor(Color.RED);
                    enterBase.setBackgroundColor(Color.RED);
                    enterOutputbase.setBackgroundColor(Color.RED);
                    answer.setTextColor(Color.RED);


                }


            }
        });


    }
}
