package catos.dataaccess.controllers;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import catos.obd2.dataaccess.data.Code;
import catos.obd2.dataaccess.data.DBConnect;

public class CodesController 
{
	
	private DBConnect _dbConnect = null;
	
	public CodesController(DBConnect dbConnect)
	{
		
		this._dbConnect = dbConnect;
		
	}
	
	public List<Code> GetCodes()
	{
		
		Cursor cursor = this._dbConnect.GetRecords("SELECT * FROM Codes;");
		List<Code> codes = new ArrayList<Code>();
		
		if(!cursor.moveToFirst())
			return null;
		
		do 
		{
			Code code = new Code();
			code.SetCode(cursor.getString(cursor.getColumnIndex("Code")));
			code.SetDescription(cursor.getString(cursor.getColumnIndex("Description")));
			codes.add(code);
			
		}
		while(!cursor.moveToNext());
		
		return codes;
		
	}
	
}
