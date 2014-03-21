package com.movie_recommender.sandbox.authentificationsystem;

import java.util.Date;

public class User {
	// Identify users between them when querying the database
	private long mId;
    private Date mCreationDate;
    private String mUsername;
    private String mPassword;
    private String mEmail;
    
	public User(long mId, Date mCreationDate, String mUsername, String mPassword,
			String mEmail) {
		// TODO: is it necessary to call superclass constructor?
		super();
		this.mId = mId;
		this.mCreationDate = mCreationDate;
		this.mUsername = mUsername;
		this.mPassword = mPassword;
		this.mEmail = mEmail;
	}

	public long getmId() {
		return mId;
	}

	public void setmId(long mId) {
		this.mId = mId;
	}

	public Date getmCreationDate() {
		return mCreationDate;
	}

	public void setmCreationDate(Date mCreationDate) {
		this.mCreationDate = mCreationDate;
	}

	public String getmUsername() {
		return mUsername;
	}

	public void setmUsername(String mUsername) {
		this.mUsername = mUsername;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

}
