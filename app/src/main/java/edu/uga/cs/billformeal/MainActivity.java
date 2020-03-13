package edu.uga.cs.billformeal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double amount = 0.0, tip=0.0, amountPrPrsn = 0.0;
    private int participants = 1;
    private EditText editText, editText2;
    private TextView textView;
    private Button button10, button15, button18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView = (TextView) findViewById(R.id.textView);
        button10 = (Button) findViewById(R.id.button);
        button15 = (Button) findViewById(R.id.button2);
        button18 = (Button) findViewById(R.id.button3);
        button10.setOnClickListener(new ButtonClickListener());
        button15.setOnClickListener(new ButtonClickListener());
        button18.setOnClickListener(new ButtonClickListener());
    }

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v.getId() == button10.getId())
                tip = 1.1;
            else if (v.getId() == button15.getId())
                tip = 1.15;
            else if (v.getId() == button18.getId())
                tip = 1.18;

            editText = (EditText) findViewById(R.id.editText);
            editText2 = (EditText) findViewById(R.id.editText2);

            String textAmount = editText.getText().toString();
            String textPar = editText2.getText().toString();

            if (textPar.equals(""))
                participants = 1;
            else
                participants = Integer.parseInt(textPar);

            if (textAmount.equals("")){
                textView.setText("Total per Person");
            } else {
                amount = Double.parseDouble(textAmount);
                amountPrPrsn = (tip * amount)/participants;
                String numberAsString = String.format ("%.2f", amountPrPrsn);
                textView.setText(numberAsString);
            }
        }
    }
}
