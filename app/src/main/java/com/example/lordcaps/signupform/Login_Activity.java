package com.example.lordcaps.signupform;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Login_Activity extends Activity {

    private static final String TAG = "Login_Activity";

    Button mSubmitButton;
    EditText mUserNameInput;
    EditText mPasswordInput;
    EditText mConfirmInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mPasswordInput = (EditText) findViewById(R.id.password_input);
        mUserNameInput = (EditText) findViewById(R.id.username_input);
        mConfirmInput = (EditText) findViewById(R.id.confirm_input);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUserNameInput.getText().toString();
                String password = mPasswordInput.getText().toString();
                String confirmation = mConfirmInput.getText().toString();

                if(password.equals(confirmation)) {
                    User newUser = new User(username,password);


                    Intent i = new Intent(Login_Activity.this , HomeActivity.class);
                    i.putExtra(HomeActivity.EXTRA,"Hello Android Course");
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
