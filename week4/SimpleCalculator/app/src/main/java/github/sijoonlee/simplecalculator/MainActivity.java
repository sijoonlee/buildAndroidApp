package github.sijoonlee.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Calculator simpleCalc;
    EditText multilineText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleCalc = new Calculator();
        multilineText = (EditText) findViewById(R.id.multilineText);
        multilineText.setKeyListener(null);
        multilineText.setText("");

    }

    private String printBuffer(){
        String accumulation = "";
        for(String a : simpleCalc.getBuffer())
        {
            accumulation = accumulation + " " + a;
        }
        return accumulation;
    }

    public void push1(View v) {
        boolean success = simpleCalc.addToBuffer("1");
        if(success){
            multilineText.setText(printBuffer());
        }

    }
    public void push2(View v) {
        boolean success = simpleCalc.addToBuffer("2");
        if(success){
            multilineText.setText(printBuffer());
        }
    }
    public void push3(View v) {
        boolean success = simpleCalc.addToBuffer("3");
        if(success){
            multilineText.setText(printBuffer());
        }
    }
    public void push4(View v) {
        boolean success = simpleCalc.addToBuffer("4");
        if(success){
            multilineText.setText(printBuffer());
        }
    }
    public void push5(View v) {
        boolean success = simpleCalc.addToBuffer("5");
        if(success){
            multilineText.setText(printBuffer());
        }
    }
    public void push6(View v) {
        boolean success = simpleCalc.addToBuffer("6");
        if(success){
            multilineText.setText(printBuffer());
        }
    }
    public void push7(View v) {
        boolean success = simpleCalc.addToBuffer("7");
        if(success){
            multilineText.setText(printBuffer());
        }
    }
    public void push8(View v) {
        boolean success = simpleCalc.addToBuffer("8");
        if(success){
            multilineText.setText(printBuffer());
        }
    }
    public void push9(View v) {
        boolean success = simpleCalc.addToBuffer("9");
        if(success){
            multilineText.setText(printBuffer());
        }
    }
    public void push0(View v) {
        boolean success = simpleCalc.addToBuffer("0");
        if(success){
            multilineText.setText(printBuffer());
        }
    }
    public void pushPlus(View v) {
        boolean success = simpleCalc.addToBuffer("+");
        if(success){
            multilineText.setText(printBuffer());
        }
    }
    public void pushMinus(View v) {
        boolean success = simpleCalc.addToBuffer("-");
        if(success){
            multilineText.setText(printBuffer());
        }
    }
    public void pushMultiply(View v) {
        boolean success = simpleCalc.addToBuffer("*");
        if(success){
            multilineText.setText(printBuffer());
        }
    }
    public void pushDivide(View v) {
        boolean success = simpleCalc.addToBuffer("/");
        if(success){
            multilineText.setText(printBuffer());
        }
    }
    public void pushDot(View v) {
        boolean success = simpleCalc.addToBuffer(".");
        if(success){
            multilineText.setText(printBuffer());
        }
    }
    public void pushBack(View v) {
        boolean success = simpleCalc.deleteLastOne();
        if (success){
            multilineText.setText(printBuffer());
        }
    }
    public void pushClear(View v) {
        simpleCalc.clearBuffer();
        multilineText.setText("");
    }
    public void pushEqual(View v) {
        double result;
        if(simpleCalc.sizeOfBuffer()%2==1){
            result = simpleCalc.cal();
            multilineText.setText(printBuffer());
        }


    }

}
