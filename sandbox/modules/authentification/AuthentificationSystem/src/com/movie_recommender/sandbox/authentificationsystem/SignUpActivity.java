package com.movie_recommender.sandbox.authentificationsystem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// TODO: subclass of Activity or SingleFragmentActivity?
public class SignUpActivity extends Activity {
	// TODO: why private?
	private EditText mUserNameEditText, mPasswordEditText, 
		mConfirmPasswordEditText;
    private Button mCreateAccountButton;
    
    // Reference to the SQLite Database API
 	private LoginManager mLoginManager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        
        // Create an instance of SQLite Database
        mLoginManager =new LoginManager(this);
        
        // Get references to EditText views
        mUserNameEditText = (EditText)findViewById(R.id.editTextUserName);
        mPasswordEditText = (EditText)findViewById(R.id.editTextPassword);
        mConfirmPasswordEditText = (EditText)findViewById(R.id.editTextConfirmPassword);
 
        // Get references to buttons
        mCreateAccountButton = (Button)findViewById(R.id.buttonCreateAccount);
        mCreateAccountButton.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		// Get the user's text input
        		String userName = mUserNameEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();
                String confirmPassword = mConfirmPasswordEditText.getText().toString();
        		
                
                // Check if any of the fields is empty
                if(userName.equals("") || password.equals("") || confirmPassword.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Empty Field", Toast.LENGTH_LONG).show();
                    return;
                }
                
                // Check if both passwords match
                if(!password.equals(confirmPassword))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    // Save the user data in database
                    loginDataBaseAdapter.insertEntry(userName, password);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                }
        	}
        });
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // TODO: writeme
        loginDataBaseAdapter.close();
    }

}
