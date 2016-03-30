package com.example.wordtoau;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ReadActivity extends Activity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read);
		// 文件选择按钮
		Button fileOpenBtn = (Button)findViewById(R.id.openFIleBtn);
        fileOpenBtn.setOnClickListener(new OpenFileAction());
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
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = this.getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		menu.removeItem(R.id.gb2312);
		menu.removeItem(R.id.utf8);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.about:
			doAbout();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	//【关于】对话
	private void doAbout() {
		Dialog dialog = new AlertDialog.Builder(ReadActivity.this).setTitle(
				R.string.aboutTitle).setMessage(R.string.aboutInfo)
				.setPositiveButton(R.string.aboutOK,
						new DialogInterface.OnClickListener() {
							public void onClick(
									DialogInterface dialoginterface, int i) {
								// ��ť�¼�
							}
						}).create();
		dialog.show();
	}
	class OpenFileAction implements OnClickListener
    {
		public void onClick(View v) {
			Intent in = new Intent(ReadActivity.this, ListAllFileActivity.class);
        	startActivityForResult(in, 0);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}
}
