package com.demo.android.bmi;

import java.text.DecimalFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMIActivity<Bmi> extends Activity {
	/* ------------------- var ----------------- */
	protected static final int MENU_ABOUT = Menu.FIRST;
	protected static final int MENU_QUIT = Menu.FIRST + 1;

	private Button buttoncalc;
    private EditText fieldheight;
    private EditText fieldweight;
    private TextView result;
    private TextView suggest;
    
    /* ------------------- Override methods ----------------- */
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, MENU_ABOUT, 0, R.string.label_menu_about).setIcon(android.R.drawable.ic_menu_help);
		menu.add(0, MENU_QUIT, 0, R.string.label_menu_quit).setIcon(android.R.drawable.ic_menu_close_clear_cancel);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case MENU_ABOUT:
			openOptionDailog();
			break;
		case MENU_QUIT:
			finish();
			break;
		};
		return super.onOptionsItemSelected(item);
	}

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        findViews();
        setListeners();
    }
    
    /* ------------------- private methods ----------------- */
    
    private void setListeners() {
        buttoncalc.setOnClickListener(calcBMI);
	}

    private void findViews() {
        buttoncalc = (Button)findViewById(R.id.submit);
		fieldheight = (EditText)findViewById(R.id.height);
		fieldweight = (EditText)findViewById(R.id.weight);
		result = (TextView)findViewById(R.id.result);
		suggest = (TextView)findViewById(R.id.suggest);
    };

	private void openOptionDailog() {
		/*
		Toast.makeText(BMIActivity.this, R.string.toast_msg, Toast.LENGTH_SHORT).show();
		*/
		/* Open dialog */
		new AlertDialog.Builder(BMIActivity.this)
		.setTitle(R.string.about_title)
		.setMessage(R.string.about_msg)
		.setNegativeButton(R.string.label_homepage, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Uri uri = Uri.parse(getString(R.string.homepage_uri));
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);
			}
		})
		.setPositiveButton(R.string.label_ok,new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {}
		})
		.show();			
	};
	
    private OnClickListener calcBMI = new OnClickListener() {
		public void onClick(View v) {
			/*
			DecimalFormat nf = new DecimalFormat("0.00");
			try {
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
				// openOptionDailog();
			} catch(Exception obj) {
				Toast.makeText(BMIActivity.this, "打错了吗？只能输入数字喔", Toast.LENGTH_SHORT).show();
			}
			*/
			Intent intent = new Intent();
			intent.setClass(BMIActivity.this, Report.class);
			startActivity(intent);
		}
    };
}