package com.khuongt.hangman;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends Activity {
	private EditText mInput; 
	
	private TextView mWord, mGuessLeft, mGuessMade, mStatus;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mInput = (EditText) findViewById(R.id.input);
		
		mWord = (TextView) findViewById(R.id.word);
		mGuessLeft = (TextView) findViewById(R.id.countValue);
		mGuessMade = (TextView) findViewById(R.id.guessedValues);
		mStatus = (TextView) findViewById(R.id.status);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
