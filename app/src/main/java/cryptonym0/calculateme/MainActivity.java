package cryptonym0.calculateme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.id.input;
import static cryptonym0.calculateme.R.id.history;

public class MainActivity extends AppCompatActivity {

    //Globals
    //Textviews
    TextView tv, history;
    Double answer, mem, operator, total;
    Boolean add, sub, div, divR, mult, clear, delete;

    //Number Buttons
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btn00;
    //Operators
    Button btnPlus, btnMin, btnDiv, btnDivR, btnmulti, btnEqu;
    //Modifiers
    Button btnClear, btnDel, btnDec, btnNeg;
    //Memory
    Button btnMemClr, btnMemPlus, btnMemMinus, btnMemRem;


    //Boolean Flags
    //Number Flags
    boolean isNumber = false;
    //Mod Flage
    boolean isClear = false;
    boolean isDecimalOn = false;
    boolean isNegative = false;
    //Operator Flags
    boolean isOperatorOn = true;
    boolean OperLast = false;
    boolean equalOn = false;
    //Store Memory
    double memory = 0.0;

    //double for initial accumulator, and the number in textview
    double accum = 0.0, temp = 0.0;
    //flag for equals to know what was the last operation
    char operEqualFlag = ' ';


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
    }//End on Create


    //My One beautiful Listener
    private View.OnClickListener clickMe = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Initialize Things
            Button btn          = (Button)view;
            String current      = btn.getText().toString();
            String calc         = tv.getText().toString();

            //Clunky Switch
            switch(btn.getId()){
                //Buttons 0-9, 00
                case R.id.btn00:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "00");
                    break;
                case R.id.btn0:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "0");
                    break;
                case R.id.btn1:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "1");
                    break;
                case R.id.btn2:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "2");
                    break;
                case R.id.btn3:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "3");
                    break;
                case R.id.btn4:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "4");
                    break;
                case R.id.btn5:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "5");
                    break;
                case R.id.btn6:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "6");
                    break;
                case R.id.btn7:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "7");
                    break;
                case R.id.btn8:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "8");
                    break;
                case R.id.btn9:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "9");
                    break;

                //Operators
                case R.id.btnPlus:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "+");
                    break;
                case R.id.btnMinus:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "-");
                    break;
                case R.id.btnDivide:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "/");
                    break;
                case R.id.btnDivRem:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "%");
                    break;
                case R.id.btnMultiply:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "*");
                    break;
                case R.id.btnEquals:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "=");
                    break;

                //Modifiers
                case R.id.btnClear:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "C");
                    break;
                case R.id.btnDelete:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "DEL");
                    break;
                case R.id.btnDecimal:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", ".");
                    break;
                case R.id.btnPlusMinus:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "+/-");
                    break;

                //Memory
                case R.id.btnMemClear:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "MC");
                    break;
                case R.id.btnMemPlus:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "M+");
                    break;
                case R.id.btnMemMin:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "M-");
                    break;
                case R.id.btnMemReg:
                    //Do Stuff
                    Log.d("BUTTON PRESSED: ", "MR");
                    break;

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
    public void inputHandleMe(){
        //Do Stuff
    }

    //History Handler
    public void historyHandleMe(){
        //Do Stuff
    }

    //Check previous Calculation
    public boolean autoUpdateMe(){
        //Do Stuff
        return true;//Change this
    }

    //Clear Function
    public void clearMe(){
        answer          = 0.0;
        operator        = 0.0;
        total           = 0.0;
    }

    //Update History
    public void historyMe(){
        //Do Stuff
    }

    //Set Textview
    public void showMe(){
        //Do Stuff
    }

}
