package com.kamedan.todoapp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.IntentCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class TodoListActivity extends ListActivity {

	public static final int REQUEST_CODE = 123;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_todo_list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.todo_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_logout) {
			finish();
			Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
			startActivity(intent);
			return true;
		}
		else if (id == R.id.action_add)
		{
			Intent intent = new Intent(getApplicationContext(), AddTodoActivity.class);
			startActivityForResult(intent, REQUEST_CODE);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == REQUEST_CODE)
		{
			if(resultCode == RESULT_OK){
				Todo todo = (Todo)data.getSerializableExtra(AddTodoActivity.TODO);
				Toast.makeText(getApplicationContext(), "Result ok content: "+todo.content, Toast.LENGTH_SHORT).show();
			}else if(resultCode == RESULT_CANCELED){
				Toast.makeText(getApplicationContext(), "Result canceled", Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	
}
