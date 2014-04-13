package catos.obd2.db;

public class DB extends catos.sqlite.DB 
{
	
	public DB()
	{	
		
		this._dbTables.add(new Codes());
		this._dbTables.add(new AvailableCodes());
		
	}
	
}