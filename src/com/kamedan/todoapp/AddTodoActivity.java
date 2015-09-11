package com.kamedan.todoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class AddTodoActivity extends Activity {
	
	public static final String TODO = "todo";
	public static final String DONE = "done";
	public static final String CONTENT = "content";
	
	private EditText contextEditText;
	private CheckBox doneCheck;
	private Button saveBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_todo);
		
		 contextEditText = (EditText)findViewById(R.id.content_et);
		 doneCheck = (CheckBox)findViewById(R.id.done_cb);
		 saveBtn = (Button)findViewById(R.id.save_btn);
		 
		 saveBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String content = contextEditText.getText().toString();
				boolean isDone = doneCheck.isChecked();
				
				Todo todo = new Todo();
				todo.content = content;
				todo.done = isDone;
				 
				Intent intent = new Intent();
				intent.putExtra(TODO, todo);
				
				setResult(RESULT_OK, intent);
				finish();
			
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_todo, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
