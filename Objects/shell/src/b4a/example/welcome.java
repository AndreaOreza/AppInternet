
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

public class welcome implements IRemote{
	public static welcome mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public welcome() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("welcome"), "b4a.example.welcome");
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
		pcBA = new PCBA(this, welcome.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _iduser = RemoteObject.createImmutable(0);
public static RemoteObject _correow = RemoteObject.createImmutable("");
public static RemoteObject _selectedimageuri = RemoteObject.createImmutable("");
public static RemoteObject _url = RemoteObject.createImmutable("");
public static RemoteObject _lblcorreo = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbluser = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panel2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panel3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _btnmenu = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _imguser = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _btnimagen = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _imagechooser = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.ContentChooser");
public static RemoteObject _selectedimage = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
public static RemoteObject _selectedimagebytes = null;
public static b4a.example.main _main = null;
public static b4a.example.registro _registro = null;
public static b4a.example.updatepass _updatepass = null;
public static b4a.example.actualizar _actualizar = null;
public static b4a.example.starter _starter = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",welcome.mostCurrent._activity,"Actualizar",Debug.moduleToString(b4a.example.actualizar.class),"btnimagen",welcome.mostCurrent._btnimagen,"btnMenu",welcome.mostCurrent._btnmenu,"CorreoW",welcome._correow,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"idUser",welcome._iduser,"ImageChooser",welcome.mostCurrent._imagechooser,"imgUser",welcome.mostCurrent._imguser,"lblCorreo",welcome.mostCurrent._lblcorreo,"lblUser",welcome.mostCurrent._lbluser,"Main",Debug.moduleToString(b4a.example.main.class),"Panel1",welcome.mostCurrent._panel1,"Panel2",welcome.mostCurrent._panel2,"Panel3",welcome.mostCurrent._panel3,"Registro",Debug.moduleToString(b4a.example.registro.class),"SelectedImage",welcome.mostCurrent._selectedimage,"SelectedImageBytes",welcome._selectedimagebytes,"SelectedImageUri",welcome._selectedimageuri,"Starter",Debug.moduleToString(b4a.example.starter.class),"UpdatePass",Debug.moduleToString(b4a.example.updatepass.class),"URL",welcome.mostCurrent._url};
}
}