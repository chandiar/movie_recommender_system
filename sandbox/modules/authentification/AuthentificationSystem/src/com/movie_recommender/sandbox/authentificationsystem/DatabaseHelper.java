package com.movie_recommender.sandbox.authentificationsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// API for inserting, querying, and otherwise managing the data in the database
// However, ONLY the LoginManager will be able to use it
// TODO: what is SQLiteDatabase ?
public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DB_NAME = "login.sqlite";
	private static final int VERSION = 1;

	// user table fields
	// TODO: private, static, final ?
	private static final String TABLE_USER = "user";
    private static final String COLUMN_USER_ID = "uid";
    private static final String COLUMN_CREATION_DATE = "creation_date";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_EMAIL = "email";
	
	// TODO: context ?
	public DatabaseHelper(Context context) {
		// null value for the optional CursorFactory
        super(context, DB_NAME, null, VERSION);
    }
	
	// Implementing a subclass of SQLiteOpenHelper requires to override two
	// abstract methods: onCreate and onUpgrade 

	@Override
	// Establishes the schema for a NEWLY created database
	// It is called for the first time when the app is being installed
	public void onCreate(SQLiteDatabase db) {
		// create the "user" table
		// TODO: data type?
		// TODO: use placeholders when building the sql query
        db.execSQL("create table run (uid integer primary key autoincrement," +
        		" creation_date integer, username text, password text, email text)");
	}

	@Override
	// Executes MIGRATION code to move from one version of the database schema
	// to another. Version number must an increasing integer value starting at
	// one.
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// implement schema and data changes here when upgrading
	}
	
	// Inserts a new row in the "user" table and returns its ID.
	public long insertUser(User user) {
		// ContentValues object represent the mapping of columns names to values
        ContentValues cv = new ContentValues();
        
        // Assign values for each row
		// TODO: user input sanity check (e.g. guard against code injection)
        cv.put(COLUMN_CREATION_DATE, user.getmCreationDate().getTime()); 
        cv.put(COLUMN_USERNAME, user.getmUsername());
        cv.put(COLUMN_PASSWORD, user.getmPassword());
        cv.put(COLUMN_EMAIL, user.getmEmail());

        // getWritableDatabase is used when a WRITABLE database is needed
        // It returns an instance of SQLiteDatabase for a given instance of
        // SQLiteOpenHelper
        return getWritableDatabase().insert(TABLE_USER, null, cv);
    }

}
