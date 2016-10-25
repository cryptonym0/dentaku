package cryptonym0.calculateme;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

import static android.R.id.input;
import static cryptonym0.calculateme.R.id.btn1;
import static cryptonym0.calculateme.R.id.history;

public class MainActivity extends AppCompatActivity {

    //Globals
    TextView tv, history;
    Double answer, mem, operator, total;
    Boolean add, sub, div, divR, mult, clear, delete;
    String zero = "0";
    private Toast g;
    DecimalFormat p4 = new DecimalFormat("0.0000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Globals, again
        //Everything that needs to persist
        answer          = 0.0;
        mem             = 0.0;
        operator        = 0.0;
        total           = 0.0;

        //Bools
        add             = false;
        sub             = false;
        div             = false;
        divR            = false;
        mult            = false;
        clear           = false;
        delete          = false;

        //Initialize everything again
        //Textviews
        tv = (TextView) findViewById(R.id.textInput);
        history = (TextView) findViewById(R.id.history);

        //Buttons
        //Numbers 0-9, 00
        findViewById(R.id.btn00).setOnClickListener(clickMe);
        findViewById(R.id.btn0).setOnClickListener(clickMe);
        findViewById(R.id.btn1).setOnClickListener(clickMe);
        findViewById(R.id.btn2).setOnClickListener(clickMe);
        findViewById(R.id.btn3).setOnClickListener(clickMe);
        findViewById(R.id.btn4).setOnClickListener(clickMe);
        findViewById(R.id.btn5).setOnClickListener(clickMe);
        findViewById(R.id.btn6).setOnClickListener(clickMe);
        findViewById(R.id.btn7).setOnClickListener(clickMe);
        findViewById(R.id.btn8).setOnClickListener(clickMe);
        findViewById(R.id.btn9).setOnClickListener(clickMe);

        //Operators
        findViewById(R.id.btnPlus).setOnClickListener(clickMe);
        findViewById(R.id.btnMinus).setOnClickListener(clickMe);
        findViewById(R.id.btnDivide).setOnClickListener(clickMe);
        findViewById(R.id.btnDivRem).setOnClickListener(clickMe);
        findViewById(R.id.btnMultiply).setOnClickListener(clickMe);
        findViewById(R.id.btnEquals).setOnClickListener(clickMe);

        //Modifiers
        findViewById(R.id.btnClear).setOnClickListener(clickMe);
        findViewById(R.id.btnDelete).setOnClickListener(clickMe);
        findViewById(R.id.btnDecimal).setOnClickListener(clickMe);
        findViewById(R.id.btnPlusMinus).setOnClickListener(clickMe);

        //Memory
        findViewById(R.id.btnMemClear).setOnClickListener(clickMe);
        findViewById(R.id.btnMemPlus).setOnClickListener(clickMe);
        findViewById(R.id.btnMemMin).setOnClickListener(clickMe);
        findViewById(R.id.btnMemReg).setOnClickListener(clickMe);

        //Toast
        g = Toast.makeText(getApplicationContext(), "Invalid Value", Toast.LENGTH_SHORT);
    }//End on Create

    //My One beautiful Listener
    private View.OnClickListener clickMe = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Initialize Things
            Button btn          = (Button)view;
            String current      = btn.getText().toString();
            String calc         = tv.getText().toString();
            view.setSelected(true);

            if (tv.getText().equals("Undefined")) {
                g = Toast.makeText(getApplicationContext(), "Clearing Undefined Values.", Toast.LENGTH_SHORT);
                g.show();
                tv.setText(zero);
                history.setText(zero);
                clearMe();

            } else {
                //Clunky Switch
                switch (btn.getId()) {
                    //Buttons 0-9, 00
                    case R.id.btn00:
                        inputHandleMe(calc, current);
                        Log.d("BUTTON PRESSED: ", "00");
                        break;
                    case R.id.btn0:
                        inputHandleMe(calc, current);
                        Log.d("BUTTON PRESSED: ", "0");
                        break;
                    case R.id.btn1:
                        inputHandleMe(calc, current);
                        Log.d("BUTTON PRESSED: ", "1");
                        break;
                    case R.id.btn2:
                        inputHandleMe(calc, current);
                        Log.d("BUTTON PRESSED: ", "2");
                        break;
                    case R.id.btn3:
                        inputHandleMe(calc, current);
                        Log.d("BUTTON PRESSED: ", "3");
                        break;
                    case R.id.btn4:
                        inputHandleMe(calc, current);
                        Log.d("BUTTON PRESSED: ", "4");
                        break;
                    case R.id.btn5:
                        inputHandleMe(calc, current);
                        Log.d("BUTTON PRESSED: ", "5");
                        break;
                    case R.id.btn6:
                        inputHandleMe(calc, current);
                        Log.d("BUTTON PRESSED: ", "6");
                        break;
                    case R.id.btn7:
                        inputHandleMe(calc, current);
                        Log.d("BUTTON PRESSED: ", "7");
                        break;
                    case R.id.btn8:
                        inputHandleMe(calc, current);
                        Log.d("BUTTON PRESSED: ", "8");
                        break;
                    case R.id.btn9:
                        inputHandleMe(calc, current);
                        Log.d("BUTTON PRESSED: ", "9");
                        break;

                    //Operators
                    //Always Do a calc check fam
                    case R.id.btnPlus:
                        Log.d("BUTTON PRESSED: ", "+");
                        if (!autoUpdateMe()) {
                            try {
                                operator = Double.parseDouble(calc);
                                historyHandleMe(calc, '+');
                                answer += operator;
                                tv.setText(zero);
                                boolHandleMe(0);
                            }catch(NumberFormatException e) {
                                g.show();
                            }
                        } else {
                            boolHandleMe(0);
                            historyHandleMe(calc, '+');
                            showMe();
                        }
                        break;
                    case R.id.btnMinus:
                        Log.d("BUTTON PRESSED: ", "-");
                        if (!autoUpdateMe()) {
                            try {
                                operator = Double.parseDouble(calc);
                                historyHandleMe(calc, '-');
                                answer = operator - answer;
                                tv.setText(zero);
                                boolHandleMe(1);
                            }catch(NumberFormatException e) {
                                g.show();
                            }
                        } else {
                            boolHandleMe(1);
                            historyHandleMe(calc, '-');
                            showMe();
                        }
                        break;
                    case R.id.btnDivide:
                        Log.d("BUTTON PRESSED: ", "/");
                        if (!autoUpdateMe()) {
                            try{

                                historyHandleMe(calc, '/');
                                operator = Double.parseDouble(calc);
                                //Check the 0
                                if (total == 0.0) {
                                    answer = operator;
                                    total = answer;
                                    tv.setText(zero);
                                    boolHandleMe(2);
                                } else if (operator == 0.0) {
                                    tv.setText("Undefined");
                                    clearMe();
                                    boolHandleMe(-1);
                                } else {
                                    total = operator;
                                    answer = answer / total;
                                    tv.setText(zero);
                                    boolHandleMe(2);
                                }
                            }catch(NumberFormatException e) {
                                g.show();
                            }
                        } else {
                            boolHandleMe(2);
                            historyHandleMe(calc, '/');
                            showMe();
                        }
                        break;
//                    case R.id.btnDivRem:
//                        Log.d("BUTTON PRESSED: ", "%");
//                    if(!autoUpdateMe()) {
//                        historyHandleMe(calc, '%');
//                        operator = Double.parseDouble(calc);
//                        //Check the 0
//                        if (total == 0.0 || operator == 0) {
//                            answer = operator;
//                            total = answer;
//                            tv.setText(zero);
//                            boolHandleMe(3);
//                        } else {
//                            total = operator/100;
//                            answer = answer * total;
//                            tv.setText(zero);
//                            boolHandleMe(3);
//                        }
//                    }
//                    else{
//                        boolHandleMe(3);
//                        historyHandleMe(calc, '%');
//                        showMe();
//                    }
//                        break;
                    case R.id.btnMultiply:
                        Log.d("BUTTON PRESSED: ", "*");
                        if (!autoUpdateMe()) {
                            try {
                                operator = Double.parseDouble(calc);
                                historyHandleMe(calc, '*');
                                //Check the 0
                                if (total == 0.0) {
                                    answer = operator;
                                    total = operator;
                                    tv.setText(zero);
                                    boolHandleMe(4);
                                } else if (operator == 0.0) {
                                    clearMe();
                                    tv.setText("What Are You Doing.");
                                    boolHandleMe(-1);
                                } else {
                                    total = operator;
                                    answer *= operator;
                                    tv.setText(zero);
                                    boolHandleMe(4);
                                }
                            }catch(NumberFormatException e) {
                                g.show();
                            }
                        } else {
                            boolHandleMe(4);
                            historyHandleMe(calc, '*');
                            showMe();
                        }
                        break;
                    case R.id.btnEquals:
                        Log.d("BUTTON PRESSED: ", "=");

                        //Do a ton of checks
                        operator = Double.parseDouble(calc);//Breaks on this
                        double zeroMe = Double.parseDouble(calc);
                        try {
                            if (add) {
                                answer += operator;
                                showMe();
                            } else if (sub) {
                                answer = answer - operator;
                                showMe();
                            } else if (div) {
                                if (zeroMe == 0.0) {
                                    tv.setText("Undefined");
                                    clearMe();
                                } else {
                                    answer /= zeroMe;
                                    showMe();
                                }
                            } else if (divR) {
                                //Currently broken
//                                  showMe();
                            } else if (mult) {
                                answer *= operator;
                                showMe();
                            } else {
                                tv.setText(zero);
                                history.setText(zero);
                                clearMe();
                            }
                        }catch(NumberFormatException e) {
                            g.show();
                        }
                            clearMe();
                            historyMe();
                            boolHandleMe(-1);

                        break;

                    //Modifiers
                    case R.id.btnClear:
                        Log.d("BUTTON PRESSED: ", "C");
                        tv.setText(zero);
                        history.setText(zero);
                        clearMe();
                        break;
                    case R.id.btnDelete:
                        Log.d("BUTTON PRESSED: ", "DEL");
                        if ((calc.indexOf('-') >= 0) || (calc.length() == 1)) {
                            tv.setText(zero);
                        } else {
                            calc = calc.substring(0, calc.length() - 1);
                            tv.setText(calc);
                        }
                        break;
                    case R.id.btnDecimal:
                        Log.d("BUTTON PRESSED: ", ".");
                        if (calc.indexOf('.') >= 0) {
                            break;
                        }
                        //Check length eventually
                        else {
                            tv.setText(calc + current);
                        }
                        break;
                    case R.id.btnPlusMinus:
                        Log.d("BUTTON PRESSED: ", "+/-");
                        if (calc.indexOf('-') >= 0) {
                            tv.setText(calc.substring(1));
                        } else if (calc.equals(zero)) {
                            break;
                        } else {
                            tv.setText('-' + calc); // append - to front of input
                        }
                        break;
                    //Memory
                    case R.id.btnMemClear:
                        Log.d("BUTTON PRESSED: ", "MC");
                        try {
                            mem = 0.0;
                        }
                        catch(NumberFormatException e) {
                            g.show();
                        }
                        break;
                    case R.id.btnMemPlus:
                        Log.d("BUTTON PRESSED: ", "M+");
                        try{
                            double d = Double.parseDouble(calc);
                            mem += d;
                        }
                        catch(NumberFormatException e){
                            g.show();
                        }
                        break;
                    case R.id.btnMemMin:
                        Log.d("BUTTON PRESSED: ", "M-");
                        try{
                            double d = Double.parseDouble(calc);
                            mem -= d;
                        }
                        catch(NumberFormatException e){
                            g = Toast.makeText(getApplicationContext(), "Invalid Value", Toast.LENGTH_SHORT);
                            g.show();
                        }
                        break;
                    case R.id.btnMemReg:
                        Log.d("BUTTON PRESSED: ", "MR");
                        try {
                            tv.setText(mem.toString());
                        }
                        catch(NumberFormatException e) {
                            g.show();
                        }
                        break;

                }
            }
        }

    };//End on click listener

    //Handlers
    //Bools
    public void boolHandleMe(int i){
        switch(i){
            //Add
            case 0:
                add     = true;
                sub     = false;
                div     = false;
                divR    = false;
                mult    = false;
                break;
            //Subtract
            case 1:
                add     = false;
                sub     = true;
                div     = false;
                divR    = false;
                mult    = false;
                break;
            //Divide
            case 2:
                add     = false;
                sub     = false;
                div     = true;
                divR    = false;
                mult    = false;
                break;
            //Divide Rem
            case 3:
                add     = false;
                sub     = false;
                div     = false;
                divR    = true;
                mult    = false;
                break;
            //Multiply
            case 4:
                add     = false;
                sub     = false;
                div     = false;
                divR    = false;
                mult    = true;
                break;
            //None
            case -1:
                add     = false;
                sub     = false;
                div     = false;
                divR    = false;
                mult    = false;
                break;
        }
    }//End Bool Handler

    //User input Handler
    public void inputHandleMe(String cur, String userInput){
        //Check edge case 0
        if(cur.equals(zero) || clear){
            tv.setText(userInput);
            clear = false;
        }
        //Overflow
        else if((userInput+cur).length() > 15){
            //Do something here later
            Log.d("INPUT HANDLER: ", "Too Many Values");
        }
        //Add those babies
        else{
            tv.setText(cur + userInput);
            clear = false;
        }
    }

    //History Handler
    public void historyHandleMe(String userInput, Character operator){
        String historyOutput = "";
        String currentHistory = history.getText().toString();
        //Length Check
        if(currentHistory.length() > 60){
            historyOutput += currentHistory.substring(userInput.length() + 4);
        }
        else{
            historyOutput += currentHistory;
        }
        historyOutput += userInput;
        historyOutput += operator;
        history.setText(historyOutput);
    }

    //Check previous Calculation
    public boolean autoUpdateMe(){
        String output = tv.getText().toString();
        try {
            double n = Double.parseDouble(output);
            //If statements
            //Boolean add, sub, div, divR, mult, clear, delete;
            if (add) {
                answer += n;
                boolHandleMe(-1);
                return true;
            } else if (sub) {
                answer = answer - n;
                boolHandleMe(-1);
                return true;
            } else if (mult) {
                answer = answer * n;
                boolHandleMe(-1);
                return true;
            } else if (div) {
                if (n == 0.0) {
                    tv.setText("You Can't Divide By Zero Fam.");
                    boolHandleMe(-1);
                    clearMe();
                } else {
                    answer /= n;
                    boolHandleMe(-1);
                    return true;
                }
            } else if (divR) {
                if (n == 0.0) {
                    tv.setText("You Can't Divide By Zero Fam.");
                    boolHandleMe(-1);
                    clearMe();
                } else {
                    answer %= n;
                    boolHandleMe(-1);
                    return true;
                }
            } else {
                history.setText("");
                return false;
            }
        }
        catch(NumberFormatException e) {
            g.show();
        }
        return false;
    }//Auto Update me end

    //Clear Function
    public void clearMe(){
        answer          = 0.0;
        operator        = 0.0;
        total           = 0.0;
    }

    //Update History ONLY FOR "="
    public void historyMe(){
        history.setText(tv.getText().toString());
//        history.append(tv.getText());
    }

    //Set Textview
    public void showMe() {
        double zeroMe = Double.parseDouble(tv.getText().toString());
//        if (zeroMe == 0.0) {
//            tv.setText("Undefined");
//
//        } else {

        String output = p4.format(answer).toString();
            //Add  some checks here later


        tv.setText(output);
        clear = true;
//        }
    }


}
