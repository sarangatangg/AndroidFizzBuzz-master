package com.thinkful.fizzbuzzunit1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.util.Log;


public class MainActivity extends Activity {

    TextView textView;
    String fizzString = "Fizz";
    String buzzString = "Buzz";
    String fizzBuzzString = "Fizz Buzz";
    String valueString;
    EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    int [] fizzArray = new int [10];
    int fizzIndex = 0;
    int [] buzzArray = new int [10];
    int buzzIndex = 0;

    public void doButton(View view){
        // Implement the function of the button here
        // Use numberOfValues, and create a string array of both the numbers and words,
        // replacing the appropriate numbers with the words fizz or buzz

        editText = (EditText) findViewById(R.id.editText); // user input
        textView = (TextView) findViewById(R.id.fizzText); // where the text will display
        textView.setText("" + "\n");

        int numberOfValues = Integer.parseInt(editText.getText().toString());


        for (int i =1; i <= numberOfValues; i++){
            checkValue(i);
            textView.append(valueString + "\n"); // display in the textView
        }

        for (int i=0; i < fizzArray.length; i++) {
             Log.i("MyData", "fizzArray[" + i + "] = " + fizzArray[i]);
        }

        for (int i=0; i < buzzArray.length; i++) {
            Log.i("MyData", "buzzArray[" + i + "] = " + buzzArray[i]);
        }

    }




    public String checkValue(int value) {
        if (value % 3 == 0 && value % 5 == 0) {
            valueString = fizzBuzzString;
        } else if (value % 3 == 0) {
            valueString = fizzString;
            fizzArray[fizzIndex] = value;
            fizzIndex++;
        } else if (value % 5 == 0) {
            valueString = buzzString;
            buzzArray[buzzIndex] = value;
            buzzIndex++;
        } else {
            valueString = String.valueOf(value);
        }
        return valueString;
    }
}

