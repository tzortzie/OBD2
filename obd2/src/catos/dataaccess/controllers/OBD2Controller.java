package catos.dataaccess.controllers;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import catos.obd2.dataaccess.data.Code;
import catos.obd2.dataaccess.data.DBConnect;
import catos.obd2.dataaccess.data.OBD2;

public class OBD2Controller 
{
    private DBConnect _dbConnect = null;
	
	public OBD2Controller(DBConnect dbConnect)
	{
		
		this._dbConnect = dbConnect;
		
	} 
	
	public List<OBD2> GetAvailableOBD2Codes()
	{
		
		Cursor cursor = this._dbConnect.GetRecords("SELECT Codes.* FROM Codes JOIN AvailableCodes on Codes.Code = AvailableCodes.Code;");
		List<OBD2> obd2s = new ArrayList<OBD2>();
		
		if( !cursor.moveToFirst())
			return null;
		
		do
		{
			
			OBD2 obd2 = new OBD2();
			Code code = new Code();
			code.SetCode(cursor.getString(cursor.getColumnIndex("Code")));
			code.SetDescription(cursor.getString(cursor.getColumnIndex("Description")));
			
			obd2.SetCode(code);
			
			obd2s.add(obd2);
			
		}
		while(cursor.moveToNext());
		
		return obd2s;
		
	}
	
}
