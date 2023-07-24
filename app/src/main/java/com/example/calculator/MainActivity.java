package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {
    Button btn0,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn1,btnXoa,btnCham,btnResult,
    btnSubtract,btnPMultiply,btnSum,btnDevide;
    TextView result;
    String input = "";
    String output = "";
    String newOutPut = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        btn0.setOnClickListener(calClick);
        btn1.setOnClickListener(calClick);
        btn2.setOnClickListener(calClick);
        btn3.setOnClickListener(calClick);
        btn4.setOnClickListener(calClick);
        btn5.setOnClickListener(calClick);
        btn6.setOnClickListener(calClick);
        btn7.setOnClickListener(calClick);
        btn8.setOnClickListener(calClick);
        btn9.setOnClickListener(calClick);
        btnXoa.setOnClickListener(calClick);
        btnCham.setOnClickListener(calClick);
        btnResult.setOnClickListener(calClick);
        btnSubtract.setOnClickListener(calClick);
        btnPMultiply.setOnClickListener(calClick);
        btnSum.setOnClickListener(calClick);
        btnDevide.setOnClickListener(calClick);
    }
    public View.OnClickListener calClick = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button0:
                    input += 0;
                    result.setText(input);
                    break;
                case R.id.button1:
                    input += 1;
                    result.setText(input);
                    break;
                case R.id.button2:
                    input += 2;
                    result.setText(input);
                    break;
                case R.id.button3:
                    input += 3;
                    result.setText(input);
                    break;
                case R.id.button4:
                    input += 4;
                    result.setText(input);
                    break;
                case R.id.button5:
                    input += 5;
                    result.setText(input);
                    break;
                case R.id.button6:
                    input += 6;
                    result.setText(input);
                    break;
                case R.id.button7:
                    input += 7;
                    result.setText(input);
                    break;
                case R.id.button8:
                    input += 8;
                    result.setText(input);
                    break;
                case R.id.button9:
                    input += 9;
                    result.setText(input);
                    break;
                case R.id.buttonSum:
                    solve();
                    input += "+";
                    result.setText(input);
                    break;
                case R.id.buttonSubtract:
                    solve();
                    input += "-";
                    result.setText(input);
                    break;
                case R.id.buttonMultiply:
                    solve();
                    input += "*";
                    result.setText(input);
                    break;
                case R.id.buttonDevide:
                    solve();
                    input += "/";
                    result.setText(input);
                    break;
                case R.id.buttonCham:
                    input += ".";
                    result.setText(input);
                    break;
                case R.id.buttonXoa:
                    input = "";
                    output = "";
                    result.setText(output);
                    break;
                case R.id.buttonResult:
                    Log.i("TAG", cutDecimal("2.0"));
                    solve();
                    result.setText(input);
                    break;
            }
        }
        public void solve(){
            //plus
            if(input.split("\\+").length==2){
                String numbers[] = input.split("\\+");
                Double d = Double.parseDouble(numbers[0])+Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutPut = cutDecimal(output);
                result.setText(newOutPut);
                input = d+"";
            }
            //subtract
            if(input.split("\\-").length==2){
                String numbers[] = input.split("\\-");
                if(Double.parseDouble(numbers[0])<Double.parseDouble(numbers[1])){
                    //Tinh toan
                    BigDecimal number1 = new BigDecimal(numbers[0]);
                    BigDecimal number2 = new BigDecimal(numbers[1]);
                    BigDecimal resultOfSubtract = number2.subtract(number1);
                    String d = resultOfSubtract.toString();
                    output = d;
                    //Xu ly so thap phan
                    newOutPut = cutDecimal(output);
                    result.setText(newOutPut);
                    input = d+"";
                }else{
                    BigDecimal number1 = new BigDecimal(numbers[0]);
                    BigDecimal number2 = new BigDecimal(numbers[1]);
                    BigDecimal resultOfSubtract = number1.subtract(number2);
                    String d = resultOfSubtract.toString();
                    output = d;
                    newOutPut = cutDecimal(output);
                    result.setText(newOutPut);
                    input = d+"";
                }
            }
            //multiply
            if(input.split("\\*").length==2){
                String numbers[] = input.split("\\*");
                BigDecimal number1 = new BigDecimal(numbers[0]);
                BigDecimal number2 = new BigDecimal(numbers[1]);
                BigDecimal resultOfMultiply = number1.multiply(number2);
                String d = resultOfMultiply.toString();
                newOutPut = cutDecimal(output);
                result.setText(newOutPut);
                input = d+"";
            }
            //Devide
            if(input.split("\\/").length==2){
                String numbers[] = input.split("\\/");
                Double d = Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutPut = cutDecimal(output);
                result.setText(newOutPut);
                input = d+"";
            }
        }
        //Cắt số 0 (vd: 2.0 -> 2)
        private String cutDecimal(String number){
            String n [] = number.split("\\.");
            if (n.length >1){
                if (n[1].equals("0")){
                    number = n[0];
                }
            }
            return number;
        }

    };
    public void anhXa(){
        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btnXoa = findViewById(R.id.buttonXoa);
        btnCham = findViewById(R.id.buttonCham);
        btnResult = findViewById(R.id.buttonResult);
        btnSubtract = findViewById(R.id.buttonSubtract);
        btnPMultiply = findViewById(R.id.buttonMultiply);
        btnSum = findViewById(R.id.buttonSum);
        btnDevide = findViewById(R.id.buttonDevide);
        result = findViewById(R.id.Result);
    }
}
