package catos.obd2.db;

import catos.sqlite.DBColumn;
import catos.sqlite.DBTable;

public class AvailableCodes extends DBTable 
{
	
	public AvailableCodes()
	{
		
		DBColumn code = new DBColumn();
		
		code.SetName("Code");
		code.SetType(String.class);
		code.SetAllowsNull(false);
		code.SetIsPrimaryKey(true);
		code.SetIsAutoIncrement(false);
		
		this._dbColumns.add(code);
		
	}
	
}