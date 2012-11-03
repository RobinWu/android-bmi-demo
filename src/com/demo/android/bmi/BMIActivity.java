package com.demo.android.bmi;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMIActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button button = (Button)findViewById(R.id.submit);
        button.setOnClickListener(calcBMI);
    }
    
    private EditText fieldheight;
    private EditText fieldweight;
    private TextView result;
    private TextView suggest;
    
    private OnClickListener calcBMI = new OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			DecimalFormat nf = new DecimalFormat("0.00");
			fieldheight = (EditText)findViewById(R.id.height);
			fieldweight = (EditText)findViewById(R.id.weight);
			double height = Double.parseDouble(fieldheight.getText().toString())/100;
			double weight = Double.parseDouble(fieldweight.getText().toString());
			double BMI = weight / (height * height);
			
			result = (TextView)findViewById(R.id.result);
			result.setText("Your result" + nf.format(BMI));
			
			suggest = (TextView)findViewById(R.id.suggest);
			if(BMI > 25) {
				suggest.setText(R.string.advice_heavy);
			} else if (BMI < 20) {
				suggest.setText(R.string.advice_light);
			} else {
				suggest.setText(R.string.advice_average);
			}
		}
    	
    };
}