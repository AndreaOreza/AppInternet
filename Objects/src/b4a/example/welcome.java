package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class welcome extends Activity implements B4AActivity{
	public static welcome mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.welcome");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (welcome).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.welcome");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.welcome", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (welcome) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (welcome) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return welcome.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (welcome) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (welcome) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            welcome mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (welcome) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static int _iduser = 0;
public static String _correow = "";
public static String _selectedimageuri = "";
public static String _url = "";
public anywheresoftware.b4a.objects.LabelWrapper _lblcorreo = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbluser = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel3 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnmenu = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imguser = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnimagen = null;
public anywheresoftware.b4a.phone.Phone.ContentChooser _imagechooser = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _selectedimage = null;
public static byte[] _selectedimagebytes = null;
public b4a.example.main _main = null;
public b4a.example.registro _registro = null;
public b4a.example.updatepass _updatepass = null;
public b4a.example.actualizar _actualizar = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="welcome";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Activity.LoadLayout(\"welcome\")";
mostCurrent._activity.LoadLayout("welcome",mostCurrent.activityBA);
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="Panel2.Left = -250dip";
mostCurrent._panel2.setLeft((int) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250))));
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="Panel3.Color = Colors.Transparent";
mostCurrent._panel3.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="ImageChooser.Initialize(\"ImageChooser\")";
mostCurrent._imagechooser.Initialize("ImageChooser");
RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="Dim job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="URL = \"http://192.168.1.69/PHP/login.php\"";
mostCurrent._url = "http://192.168.1.69/PHP/login.php";
RDebugUtils.currentLine=851976;
 //BA.debugLineNum = 851976;BA.debugLine="job.Initialize(\"\", Me)";
_job._initialize /*String*/ (null,processBA,"",welcome.getObject());
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="job.PostString(URL, \"buscar&Correo=\" & CorreoW)";
_job._poststring /*String*/ (null,mostCurrent._url,"buscar&Correo="+_correow);
RDebugUtils.currentLine=851978;
 //BA.debugLineNum = 851978;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="welcome";
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="welcome";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="End Sub";
return "";
}
public static byte[]  _bitmaptobytes(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap) throws Exception{
RDebugUtils.currentModule="welcome";
if (Debug.shouldDelegate(mostCurrent.activityBA, "bitmaptobytes", false))
	 {return ((byte[]) Debug.delegate(mostCurrent.activityBA, "bitmaptobytes", new Object[] {_bitmap}));}
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _stream = null;
byte[] _bytearray = null;
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub BitmapToBytes(Bitmap As Bitmap) As Byte()";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="Dim stream As OutputStream";
_stream = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="stream.InitializeToBytesArray(0)";
_stream.InitializeToBytesArray((int) (0));
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="Bitmap.WriteToStream(stream, 100, \"PNG\")";
_bitmap.WriteToStream((java.io.OutputStream)(_stream.getObject()),(int) (100),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"PNG"));
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="Dim ByteArray() As Byte";
_bytearray = new byte[(int) (0)];
;
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="ByteArray = stream.ToBytesArray";
_bytearray = _stream.ToBytesArray();
RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="stream.Close";
_stream.Close();
RDebugUtils.currentLine=1048583;
 //BA.debugLineNum = 1048583;BA.debugLine="Return ByteArray";
if (true) return _bytearray;
RDebugUtils.currentLine=1048584;
 //BA.debugLineNum = 1048584;BA.debugLine="End Sub";
return null;
}
public static String  _btnimagen_click() throws Exception{
RDebugUtils.currentModule="welcome";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnimagen_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnimagen_click", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub btnimagen_Click";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="If idUser = 0 Then";
if (_iduser==0) { 
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="ToastMessageShow(\"Debes iniciar sesión antes de";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Debes iniciar sesión antes de cargar una imagen de perfil."),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="ImageChooser.Show(\"image/*\", \"Seleccionar imagen";
mostCurrent._imagechooser.Show(processBA,"image/*","Seleccionar imagen de perfil");
 };
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="End Sub";
return "";
}
public static String  _btnmenu_click() throws Exception{
RDebugUtils.currentModule="welcome";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmenu_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmenu_click", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Private Sub btnMenu_Click";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="If Panel2.Left = -250dip Then";
if (mostCurrent._panel2.getLeft()==-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250))) { 
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="Panel2.Left = 0";
mostCurrent._panel2.setLeft((int) (0));
 }else {
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="Panel2.Left = -250dip";
mostCurrent._panel2.setLeft((int) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250))));
 };
RDebugUtils.currentLine=1441798;
 //BA.debugLineNum = 1441798;BA.debugLine="End Sub";
return "";
}
public static String  _btnregresar_click() throws Exception{
RDebugUtils.currentModule="welcome";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnregresar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnregresar_click", null));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Private Sub btnRegresar_Click";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="End Sub";
return "";
}
public static String  _btnupdate_click() throws Exception{
RDebugUtils.currentModule="welcome";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnupdate_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnupdate_click", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Private Sub btnUpdate_Click";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="StartActivity(Actualizar)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._actualizar.getObject()));
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="End Sub";
return "";
}
public static String  _btnuppass_click() throws Exception{
RDebugUtils.currentModule="welcome";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnuppass_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnuppass_click", null));}
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Private Sub btnUppass_Click";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="StartActivity(UpdatePass)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._updatepass.getObject()));
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="End Sub";
return "";
}
public static String  _imagechooser_result(boolean _success,String _dir,String _filename) throws Exception{
RDebugUtils.currentModule="welcome";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imagechooser_result", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "imagechooser_result", new Object[] {_success,_dir,_filename}));}
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _inputstream1 = null;
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub ImageChooser_Result(Success As Boolean, Dir As";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="Dim InputStream1 As InputStream";
_inputstream1 = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="InputStream1 = File.OpenInput(Dir, FileName)";
_inputstream1 = anywheresoftware.b4a.keywords.Common.File.OpenInput(_dir,_filename);
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="SelectedImage.Initialize2(InputStream1)";
mostCurrent._selectedimage.Initialize2((java.io.InputStream)(_inputstream1.getObject()));
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="imgUser.Bitmap = SelectedImage";
mostCurrent._imguser.setBitmap((android.graphics.Bitmap)(mostCurrent._selectedimage.getObject()));
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="Dim SelectedImageBytes() As Byte";
_selectedimagebytes = new byte[(int) (0)];
;
RDebugUtils.currentLine=983050;
 //BA.debugLineNum = 983050;BA.debugLine="SelectedImageBytes = BitmapToBytes(SelectedImage";
_selectedimagebytes = _bitmaptobytes(mostCurrent._selectedimage);
 };
RDebugUtils.currentLine=983053;
 //BA.debugLineNum = 983053;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="welcome";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
String _jsonresponse = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="If job.Success Then";
if (_job._success /*boolean*/ ) { 
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="Dim jsonResponse As String";
_jsonresponse = "";
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="jsonResponse = job.GetString ' Obtiene la respue";
_jsonresponse = _job._getstring /*String*/ (null);
RDebugUtils.currentLine=1114119;
 //BA.debugLineNum = 1114119;BA.debugLine="If jsonResponse = \"No existen Registros\" Then";
if ((_jsonresponse).equals("No existen Registros")) { 
RDebugUtils.currentLine=1114121;
 //BA.debugLineNum = 1114121;BA.debugLine="ToastMessageShow(\"No existen registros\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No existen registros"),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=1114124;
 //BA.debugLineNum = 1114124;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=1114125;
 //BA.debugLineNum = 1114125;BA.debugLine="parser.Initialize(jsonResponse)";
_parser.Initialize(_jsonresponse);
RDebugUtils.currentLine=1114126;
 //BA.debugLineNum = 1114126;BA.debugLine="Dim root As Map";
_root = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1114127;
 //BA.debugLineNum = 1114127;BA.debugLine="root = parser.NextObject";
_root = _parser.NextObject();
RDebugUtils.currentLine=1114130;
 //BA.debugLineNum = 1114130;BA.debugLine="lblUser.Text = root.Get(\"Cuenta\")";
mostCurrent._lbluser.setText(BA.ObjectToCharSequence(_root.Get((Object)("Cuenta"))));
RDebugUtils.currentLine=1114131;
 //BA.debugLineNum = 1114131;BA.debugLine="lblCorreo.Text = root.Get(\"Correo\")";
mostCurrent._lblcorreo.setText(BA.ObjectToCharSequence(_root.Get((Object)("Correo"))));
RDebugUtils.currentLine=1114132;
 //BA.debugLineNum = 1114132;BA.debugLine="CorreoW = root.Get(\"Correo\")";
_correow = BA.ObjectToString(_root.Get((Object)("Correo")));
RDebugUtils.currentLine=1114133;
 //BA.debugLineNum = 1114133;BA.debugLine="idUser = root.Get(\"UsuarioID\") 'guarda en la va";
_iduser = (int)(BA.ObjectToNumber(_root.Get((Object)("UsuarioID"))));
 };
 }else {
RDebugUtils.currentLine=1114137;
 //BA.debugLineNum = 1114137;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=1114140;
 //BA.debugLineNum = 1114140;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=1114141;
 //BA.debugLineNum = 1114141;BA.debugLine="End Sub";
return "";
}
public static String  _panel3_click() throws Exception{
RDebugUtils.currentModule="welcome";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panel3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panel3_click", null));}
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Private Sub Panel3_Click";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="Panel2.Left = -250dip";
mostCurrent._panel2.setLeft((int) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250))));
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="End Sub";
return "";
}
}