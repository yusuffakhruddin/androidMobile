package fki.mobile.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.*;

public class SQLiteHandler extends SQLiteOpenHelper{
	// sebagai label untuk membuat log
	private static final String TAG = SQLiteHandler.class.getSimpleName();
	
	//variable untuk nama Database dan table
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "android_api";
	private static final String TABLE_LOGIN = "login";
	
	//variable untuk nama kolom dan table login
	private static final String KEY_ID="id";
	private static final String KEY_NAME = "name";
	private static final String KEY_PASSWORD = "password";
	private static final String KEY_EMAIL = "email";
	private static final String KEY_UID = "uid";
	private static final String KEY_CREATED_AT = "created_at";
	
	public SQLiteHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	
	//membuat table
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_LOGIN_TABLE = "CREATE TABLE" + TABLE_LOGIN + "(" +
				KEY_ID + "INTEGER PRIMARY KEY," + KEY_NAME + "TEXT," +
				KEY_PASSWORD + "TEXT," + KEY_EMAIL + "TEXT_UNIQUE," +
				KEY_UID + "TEXT," + KEY_CREATED_AT + "TEXT," + ")";
		db.execSQL(CREATE_LOGIN_TABLE);
			
		Log.d(TAG, "Database tables created");
	}
	
	// UPGRADING DATABASE
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// hapus tabel lama jika ada
		db.execSQL("DROP TABLE EXISTS " + TABLE_LOGIN);
		
		// Buat table baru lagi
		onCreate(db);
		
	}

	public void addUser (String name, String email, String password, String uid, String created_at){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, name);//name
		values.put(KEY_EMAIL, email);//email
		values.put(KEY_PASSWORD, password);//password
		values.put(KEY_UID, uid);//uid
		values.put(KEY_CREATED_AT, created_at);//Created at
		
		//memasukkan baris data baru
		long id = db.insert(TABLE_LOGIN, null, values);
		db.close();
		
		Log.d(TAG, "New user inserted into SQlite :" +id);
	}
	
	public int UserLogin (String email, String password){
		String countQuery = "SELECT * FROM " + TABLE_LOGIN + "WHERE" +
				KEY_EMAIL + "='" + email + "' AND" + KEY_PASSWORD + "='"
				+ password + "'";
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		int rowCount = cursor.getCount();
		db.close();
		cursor.close();
		
		//return row count
		return rowCount;
		
	}
}
