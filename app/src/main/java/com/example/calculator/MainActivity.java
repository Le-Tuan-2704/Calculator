package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textPlay;
    private TextView textOperator;
    private EditText textEdit;
    private Button n1, n2, n3, n4, n5, n6, n7, n8, n9, n0, nBang, nCong, nTru, nNhan, nChia,nPhay, nBS, nC, nCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setOnClickButon();
    }

    public void init(){
           textPlay = (TextView) findViewById(R.id.textPlay);
           textEdit = (EditText) findViewById(R.id.textEdit);
           textOperator = (TextView) findViewById(R.id.textOperator);

            n1 = findViewById(R.id.n1);
            n2 = findViewById(R.id.n2);
            n3 = findViewById(R.id.n3);
            n4 = findViewById(R.id.n4);
            n5 = findViewById(R.id.n5);
            n6 = findViewById(R.id.n6);
            n7 = findViewById(R.id.n7);
            n8 = findViewById(R.id.n8);
            n9 = findViewById(R.id.n9);
            n0 = findViewById(R.id.n0);

            nPhay = findViewById(R.id.nPhay);
            nBang = findViewById(R.id.nBang);

            nNhan = findViewById(R.id.nNhan);
            nChia = findViewById(R.id.nChia);
            nCong = findViewById(R.id.nCong);
            nTru = findViewById(R.id.nTru);

            nBS = findViewById(R.id.nBS);
            nC = findViewById(R.id.nC);
            nCE = findViewById(R.id.nCE);
    }

    public void setOnClickButon(){
        n1.setOnClickListener(this);
        n2.setOnClickListener(this);
        n3.setOnClickListener(this);
        n4.setOnClickListener(this);
        n5.setOnClickListener(this);
        n6.setOnClickListener(this);
        n7.setOnClickListener(this);
        n8.setOnClickListener(this);
        n9.setOnClickListener(this);
        n0.setOnClickListener(this);

        nBang.setOnClickListener(this);
        nPhay.setOnClickListener(this);

        nCong.setOnClickListener(this);
        nTru.setOnClickListener(this);
        nNhan.setOnClickListener(this);
        nChia.setOnClickListener(this);

        nBS.setOnClickListener(this);
        nC.setOnClickListener(this);
        nCE.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.n0:
                textEdit.append("0");
                break;
            case R.id.n1:
                textEdit.append("1");
                break;
            case R.id.n2:
                textEdit.append("2");
                break;
            case R.id.n3:
                textEdit.append("3");
                break;
            case R.id.n4:
                textEdit.append("4");
                break;
            case R.id.n5:
                textEdit.append("5");
                break;
            case R.id.n6:
                textEdit.append("6");
                break;
            case R.id.n7:
                textEdit.append("7");
                break;
            case R.id.n8:
                textEdit.append("8");
                break;
            case R.id.n9:
                textEdit.append("9");
                break;
            case R.id.nPhay:
                textEdit.append(".");
                break;

            case R.id.nBang:
                layout("=");
                break;

            case R.id.nCong:
                layout("+");
                break;
            case R.id.nTru:
                layout("-");
                break;
            case R.id.nNhan:
                layout("*");
                break;
            case R.id.nChia:
                layout("/");
                break;

            case R.id.nC:
                //xoa 1 chu so toan hang hien tai
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(textEdit, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.nCE:
                textEdit.setText("");
                break;
            case R.id.nBS:
                //xoa phep tinh hien tai
                textOperator.setText("");
                textEdit.setText("");
                break;

        }

    }

    public void layout(String Operator){

        if (textPlay.getText()=="" && textEdit.getText().toString()=="" && (Operator=="+" ||Operator=="-")){
            textEdit.setText(Operator);
            }
        if (textPlay.getText()=="" && textEdit.getText().toString()!="" ) {
            textPlay.setText(textEdit.getText());
            textOperator.setText(Operator);
            textEdit.setText("");
        }
        if (textPlay.getText()!="" && textEdit.getText().toString()=="" ){
            if(textOperator.getText()==""){
                textOperator.setText(Operator);
            } else {
                textEdit.append("");
                return;
            }
        }
        if(textPlay.getText()!="" && textEdit.getText().toString()!="" )   {
            double cout1 = Double.parseDouble(textPlay.getText().toString());
            double cout2 = Double.parseDouble(textEdit.getText().toString());
            if(textOperator.getText()=="+"){
                textPlay.setText((int) (cout1+cout2));
            }
            if(textOperator.getText()=="-"){
                textPlay.setText((int) (cout1-cout2));
            }
            if(textOperator.getText()=="*"){
                textPlay.setText((int) (cout1*cout2));
            }
            if(textOperator.getText()=="/"){
                textPlay.setText((int) (cout1/cout2));
            }

            if(Operator!="=") {
                textOperator.setText(Operator);
            }
        }

//            textOperator.setText(Operator);
//            textPlay.setText(textEdit.getText());



    }
}
