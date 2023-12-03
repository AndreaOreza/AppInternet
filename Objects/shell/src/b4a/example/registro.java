
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class registro implements IRemote{
	public static registro mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public registro() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("registro"), "b4a.example.registro");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, registro.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _deletedata = RemoteObject.declareNull("b4a.example.httpjob");
public static RemoteObject _updatedata = RemoteObject.declareNull("b4a.example.httpjob");
public static RemoteObject _readdata = RemoteObject.declareNull("b4a.example.httpjob");
public static RemoteObject _savedata = RemoteObject.declareNull("b4a.example.httpjob");
public static RemoteObject _txtusuario = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtcorreo = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtcontraseña = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtconfirmar = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _imageview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _imageview2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _url = RemoteObject.createImmutable("");
public static b4a.example.main _main = null;
public static b4a.example.welcome _welcome = null;
public static b4a.example.updatepass _updatepass = null;
public static b4a.example.actualizar _actualizar = null;
public static b4a.example.starter _starter = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",registro.mostCurrent._activity,"Actualizar",Debug.moduleToString(b4a.example.actualizar.class),"deletedata",registro.mostCurrent._deletedata,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"ImageView1",registro.mostCurrent._imageview1,"ImageView2",registro.mostCurrent._imageview2,"Main",Debug.moduleToString(b4a.example.main.class),"readdata",registro.mostCurrent._readdata,"savedata",registro.mostCurrent._savedata,"Starter",Debug.moduleToString(b4a.example.starter.class),"txtConfirmar",registro.mostCurrent._txtconfirmar,"txtContraseña",registro.mostCurrent._txtcontraseña,"txtCorreo",registro.mostCurrent._txtcorreo,"txtUsuario",registro.mostCurrent._txtusuario,"updatedata",registro.mostCurrent._updatedata,"UpdatePass",Debug.moduleToString(b4a.example.updatepass.class),"URL",registro.mostCurrent._url,"Welcome",Debug.moduleToString(b4a.example.welcome.class)};
}
}