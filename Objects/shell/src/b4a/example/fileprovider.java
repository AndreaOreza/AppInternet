
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class fileprovider {
    public static RemoteObject myClass;
	public fileprovider() {
	}
    public static PCBA staticBA = new PCBA(null, fileprovider.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _sharedfolder = RemoteObject.createImmutable("");
public static RemoteObject _usefileprovider = RemoteObject.createImmutable(false);
public static RemoteObject _rp = RemoteObject.declareNull("anywheresoftware.b4a.objects.RuntimePermissions");
public static b4a.example.main _main = null;
public static b4a.example.welcome _welcome = null;
public static b4a.example.registro _registro = null;
public static b4a.example.updatepass _updatepass = null;
public static b4a.example.actualizar _actualizar = null;
public static b4a.example.starter _starter = null;
public static b4a.example.httputils2service _httputils2service = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"rp",_ref.getField(false, "_rp"),"SharedFolder",_ref.getField(false, "_sharedfolder"),"UseFileProvider",_ref.getField(false, "_usefileprovider")};
}
}