package com.example.wordtoau;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ReadActivity extends Activity implements OnClickListener {
	//修改
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read);
	      TextView text = (TextView)findViewById(R.id.contentText);  
	      try {  
	          File urlFile = new File("/sdcard/a.txt");  
	          InputStreamReader isr = new InputStreamReader(new FileInputStream(urlFile), "UTF-8");  
	          BufferedReader br = new BufferedReader(isr);    
	          String str = "";     
	          String mimeTypeLine = null ;  
	          while ((mimeTypeLine = br.readLine()) != null) {  
	            str = str+mimeTypeLine;  
	        }   
	          text.setText(str);  
	} catch (Exception e) {  
	    e.printStackTrace();  
	}  
	}
	@Override
	public void onClick(View view) {
		
	}
}
