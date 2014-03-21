package com.movie_recommender.sandbox.authentificationsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// TODO: writeme
public class HomeActivity extends Activity {
	// Constant for debugging
	private static final String TAG = "HomeActivity";
	
	// Reference to the SQLite Database API
	private LoginManager mLoginManager;
	
	// On-click Buttons
	private Button mSignInButton, mSignUpButton;
	
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
		super.onCreate(savedInstanceState);
		// TODO: ?
		setContentView(R.layout.home);
		
		// Create an instance of SQLite Database
        mLoginManager =new LoginManager(this);
        
        // Get references to buttons
        // TODO: should it be in onCreateView ?
        mSignInButton = (Button)findViewById(R.id.buttonSignIN);
        mSignUpButton = (Button)findViewById(R.id.buttonSignUP);
        
        // Set OnClick listener on SignUp button
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
        	// TODO: override necessary ?
        	@Override
	        public void onClick(View v) {
	        	// TODO: what is an intent? 
	            /// Create intent for SignUpActivity and start the activity
	            Intent intentSignUp = new Intent(getApplicationContext(), SignUpActivity.class);
	            startActivity(intentSignUp);
	        }
        });
		
    }

}
