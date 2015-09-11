package com.kamedan.todoapp;

import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity implements OnClickListener {
	
	private Button button;
	private EditText usernameEdit;
	private EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        button = (Button)findViewById(R.id.login_btn);
        button.setOnClickListener(this);
        usernameEdit = (EditText)findViewById(R.id.username_et);
        passwordEdit = (EditText)findViewById(R.id.password_et);
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
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

	@Override
	public void onClick(View arg0) {
		String username = usernameEdit.getText().toString();
		String password = passwordEdit.getText().toString();
		boolean isError = false;
		
		if(TextUtils.isEmpty(username)){
			usernameEdit.setError(getString(R.string.this_is_an_empty_field));
			isError = true;
		}
		
		if(TextUtils.isEmpty(password)){
			passwordEdit.setError(getString(R.string.this_is_an_empty_field));
			isError = true;
		}
		if(!isError){
			login(username, password);
		}
		
	}

	private void login(String username, String password) {
		if( username.equals("test") && password.equals("test")){
		Toast.makeText(getApplicationContext(), "login ok", Toast.LENGTH_SHORT).show();
		
		Intent intent = new Intent(getApplicationContext(), TodoListActivity.class);
		startActivity(intent);
		finish();
		}
	}
}
