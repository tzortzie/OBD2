package catos.sqlite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBTable {
	
	protected String _name = "";
	public String GetName(){ return this._name;}
	public void SetName(String value) { this._name = value;}
	
	protected List<DBColumn> _dbColumns = new ArrayList<DBColumn>();
	public List<DBColumn> GetDBColumns(){ return this._dbColumns;}
	public void SetDBColumns(List<DBColumn> dbColumns) { this._dbColumns = dbColumns;}
	
	public String GetCreateTable()
	{
		
		String createDB = "create table " + this._name +"(";
		
		for(Iterator<DBColumn> dbColumn = this._dbColumns.iterator(); dbColumn.hasNext(); )
			createDB += dbColumn.next().GetColumnCreate() + ",";
		
		createDB = createDB.substring(0, createDB.length()-2) + ");";
		
		return createDB;
		
	}
	
}