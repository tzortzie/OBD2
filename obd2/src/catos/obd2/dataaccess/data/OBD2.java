package catos.obd2.dataaccess.data;

public class OBD2 {
	private Code _code = null;
	public Code GetCode(){ return this._code; }
	public void SetCode(Code value) { this._code = value; }
	
	private String _response = "";
	public String GetResponse() { return this._response; }
	public void SetResponse(String value){ this._response = value;}
}
