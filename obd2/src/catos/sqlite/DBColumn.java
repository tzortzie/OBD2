package catos.sqlite;

public class DBColumn {
	private String _name = "";
	public String GetName() { return this._name;}
	public void SetName(String value) { this._name = value;}
	
	private DBTypes _type;
	public DBTypes GetType() { return this._type; }
	public void SetType(Class<?> value) { this._type = GetColumnDBType(value);}
	
	private boolean _allowsNull = false;
	public boolean GetAllowsNull() { return this._allowsNull;}
	public void SetAllowsNull(boolean value){ this._allowsNull = value;}
	
	private boolean _isPrimaryKey = false;
	public boolean GetIsPrimaryKey() { return this._isPrimaryKey;}
	public void SetIsPrimaryKey(boolean value){ this._isPrimaryKey = value;}
	
	private boolean _isAutoIncrement = false;
	public boolean GetIsAutoIncrement() {
		if( this._type == DBTypes.INTEGER)
			return this._isAutoIncrement;
		else
			return false;
	}
	public void SetIsAutoIncrement(boolean value) {
		if( this._type == DBTypes.INTEGER)
			this._isAutoIncrement = value;
		else
			this._isAutoIncrement = false;
	}
	
	public String GetColumnCreate(){
		return 
			this._name + " " + 
			this._type.GetType() + " " + 
			(this._isPrimaryKey ? "primary key" : "") + " " +
			(this._allowsNull ? "" : "not null") + " " +  
			(this._isAutoIncrement ? "autoincrement" : "");
	}
	
	private static DBTypes GetColumnDBType(Class<?> type){
		
		if( type == int.class || type == long.class || type == short.class || type == byte.class  )
			return DBTypes.INTEGER;
		else if ( type == boolean.class)
			return DBTypes.NUMERIC;
		else if( type == float.class || type == double.class )
			return DBTypes.REAL;
		else if( type == String.class || type == char.class)
			return DBTypes.TEXT;
		else
			return DBTypes.NONE;
	}
	
	public enum DBTypes {
		TEXT(1, "TEXT"), NUMERIC(2, "NUM"), INTEGER(3, "INT"), REAL(4, "REAL"), NONE(5, ""), BOOL(6, "INT");
		
		private int _id;
		private String _type;
		
		private DBTypes(int id, String type){
			this._id = id;
			this._type = type;
		}
		
		public int GetCode(){
			return this._id;
		}
		
		public String GetType(){
			return this._type;
		}
	}
	
}
