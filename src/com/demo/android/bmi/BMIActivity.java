package com.demo.android.bmi;

import java.text.DecimalFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMIActivity<Bmi> extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        findViews();
        setListeners();
    }
    
    private void setListeners() {
        buttoncalc.setOnClickListener(calcBMI);
	}

	private Button buttoncalc;
    private EditText fieldheight;
    private EditText fieldweight;
    private TextView result;
    private TextView suggest;
    
    private void findViews() {
        buttoncalc = (Button)findViewById(R.id.submit);
		fieldheight = (EditText)findViewById(R.id.height);
		fieldweight = (EditText)findViewById(R.id.weight);
		result = (TextView)findViewById(R.id.result);
		suggest = (TextView)findViewById(R.id.suggest);
    };
    
    private OnClickListener calcBMI = new OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			DecimalFormat nf = new DecimalFormat("0.00");
			double height = Double.parseDouble(fieldheight.getText().toString())/100;
			double weight = Double.parseDouble(fieldweight.getText().toString());
			double BMI = weight / (height * height);
			
			result.setText("Your result" + nf.format(BMI));
			
			if(BMI > 25) {
				suggest.setText(R.string.advice_heavy);
			} else if (BMI < 20) {
				suggest.setText(R.string.advice_light);
			} else {
				suggest.setText(R.string.advice_average);
			}
			openOptionDailog();
		}

		private void openOptionDailog() {
			new AlertDialog.Builder(BMIActivity.this)
			.setTitle(R.string.about_title)
			.setMessage(R.string.about_msg)
			.setPositiveButton(R.string.label_ok,new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			})
			.show();
		}
    	
    };
}