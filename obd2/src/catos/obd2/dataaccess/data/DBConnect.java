package catos.obd2.dataaccess.data;

import java.util.Iterator;
import java.util.List;

import catos.obd2.db.DB;
import catos.sqlite.DBTable;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnect extends SQLiteOpenHelper {
	
	private DB _db = null;
	
	public DBConnect(Context context, DB db) {
		super(context, db.GetName(), null, db.GetVersion());
		this._db = db;
	}
	
	@Override
	public void onCreate(SQLiteDatabase database) {
		for( Iterator<DBTable> dbTable = this._db.GetDBTables().iterator(); dbTable.hasNext();  )
			 database.execSQL(dbTable.next().GetCreateTable());
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
	
	public Cursor GetRecords(String sql)
	{
		
		return GetRecords(sql, null);
		
	}
	
	public Cursor GetRecords(String sql, String[] args)
	{
		
		try
		{
			
			return this.getWritableDatabase().rawQuery(sql, args);
			
		}
		catch( Exception eX)
		{
			
			return null;
			
		}
		
	}
	
	public boolean NoReturnSQL(String sql)
	{
		
		try
		{
			
			this.getWritableDatabase().execSQL(sql);
			
		}
		catch(Exception eX)
		{
			
			return false;
			
		}
		
		return true;
		
	}
	
}