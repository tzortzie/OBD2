package catos.sqlite;

import java.util.ArrayList;
import java.util.List;

public class DB {
	protected List<DBTable> _dbTables = new ArrayList<DBTable>();
	public List<DBTable> GetDBTables() { return this._dbTables;}
	public void SetDBTables( List<DBTable> dbTables) { this._dbTables = dbTables;}
	
	protected String _name = "";
	public String GetName() { return this._name;}
	public void SetName(String value) { this._name = value;}
	
	protected int _version = 1;
	public int GetVersion() { return this._version;}
	public void SetVersion(int value) { this._version = value;}
	
}