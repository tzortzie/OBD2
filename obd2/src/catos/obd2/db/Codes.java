package catos.obd2.db;

import catos.sqlite.DBColumn;
import catos.sqlite.DBTable;

public class Codes extends DBTable 
{
	
	public Codes()
	{
		
		DBColumn code = new DBColumn();
		
		code.SetName("Code");
		code.SetType(String.class);
		code.SetIsPrimaryKey(true);
		code.SetIsAutoIncrement(false);
		code.SetAllowsNull(false);
		
		DBColumn description = new DBColumn();
		
		description.SetName("Description");
		description.SetType(String.class);
		description.SetAllowsNull(false);
		description.SetIsAutoIncrement(false);
		description.SetIsPrimaryKey(false);
		
		this._dbColumns.add(code);
		this._dbColumns.add(description);
		
	}
	
}