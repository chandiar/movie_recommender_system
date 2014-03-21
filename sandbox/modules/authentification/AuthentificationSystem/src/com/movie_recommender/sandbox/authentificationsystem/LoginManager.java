package com.movie_recommender.sandbox.authentificationsystem;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.SQLException;

// This the APi that the rest of the application
public class LoginManager {
	
	private static final String PREFS_FILE = "users";
    private static final String PREF_CURRENT_USER_ID = "RunManager.currentUserId";

    // TODO: Context necessary ?
    private Context mAppContext;
    private DatabaseHelper mHelper;
    private SharedPreferences mPrefs;
    private long mCurrentUserId;
    
    // TODO: should it be private?
    public LoginManager(Context appContext) {
        mAppContext = appContext;
        mHelper = new DatabaseHelper(mAppContext);
        
        // TODO: keep it?
        //mPrefs = mAppContext.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        //mCurrentUserId = mPrefs.getLong(PREF_CURRENT_USER_ID, -1);
    }
    
    // TODO: keep it?
    // Creates and inserts a new User into the database and returns it to the
    // caller
    public User addNewUser() {
        // insert a user into the db
        User user = insertUser();
        return user;
    }
    
    private User insertUser() {
        User user = new User();
        user.setmId(mHelper.insertUser(user));
        return user;
    }
}
