package com.example.numberstofigure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number;
    Button submit;
    TextView result;

    public static String convert_to_words(final int n){

        final String tens_number[]={
                "",
                "",
                "twenty",
                "thirty",
                "forty",
                "fifty",
                "sixty",
                "seventy",
                "eighty",
                "ninety"
        };

        final String units_number[]={
                "",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "eleven",
                "twelve",
                "thirteen",
                "fourteen",
                "fifteen",
                "sixteen",
                "seventeen",
                "eighteen",
                "nineteen"
        };


        if(n<0){
            return "Minus" + convert_to_words(-n);
        }

        if(n<20){
           return units_number[n];
        }

        if(n<100){
            return tens_number[n/10] +" "+ units_number[n%10];
        }

        if(n<1000){
            return units_number[n / 100] + " hundred" + " " + convert_to_words(n % 100);
        }

        return  " ";
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number= findViewById(R.id.txt_input);
        result= findViewById(R.id.txt_result);
        submit= findViewById(R.id.btn_submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int number_input= Integer.parseInt(number.getText().toString());

                if(number.getText().toString().equals(null)){
                    number.setError("Enter a number");
                }

                else if(number_input>999){
                    number.setError("Enter number only up to 3 digit");
                }

                else{
                    String words= convert_to_words(number_input);
                    result.setText(number_input+" to words is "+" ' "+words+" ' ");
                }


            }
        });


    }



}
