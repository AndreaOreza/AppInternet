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

public class registro extends Activity implements B4AActivity{
	public static registro mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.registro");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (registro).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.registro");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.registro", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (registro) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (registro) Resume **");
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
		return registro.class;
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
            BA.LogInfo("** Activity (registro) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (registro) Pause event (activity is not paused). **");
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
            registro mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (registro) Resume **");
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
public b4a.example.httpjob _deletedata = null;
public b4a.example.httpjob _updatedata = null;
public b4a.example.httpjob _readdata = null;
public b4a.example.httpjob _savedata = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtusuario = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtcorreo = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtcontraseña = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtconfirmar = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview2 = null;
public static String _url = "";
public b4a.example.main _main = null;
public b4a.example.welcome _welcome = null;
public b4a.example.updatepass _updatepass = null;
public b4a.example.actualizar _actualizar = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="registro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="Activity.LoadLayout(\"Registro\")";
mostCurrent._activity.LoadLayout("Registro",mostCurrent.activityBA);
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="URL=\"http://192.168.1.69/PHP/Registro.php\"";
mostCurrent._url = "http://192.168.1.69/PHP/Registro.php";
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="txtContraseña.PasswordMode = True";
mostCurrent._txtcontraseña.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="ImageView1.SetBackgroundImage(LoadBitmap(File.Dir";
mostCurrent._imageview1.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"password_hidden.png").getObject()));
RDebugUtils.currentLine=1769480;
 //BA.debugLineNum = 1769480;BA.debugLine="txtConfirmar.PasswordMode= True";
mostCurrent._txtconfirmar.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1769481;
 //BA.debugLineNum = 1769481;BA.debugLine="ImageView2.SetBackgroundImage(LoadBitmap(File.Dir";
mostCurrent._imageview2.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"password_hidden.png").getObject()));
RDebugUtils.currentLine=1769483;
 //BA.debugLineNum = 1769483;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="registro";
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="registro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="End Sub";
return "";
}
public static String  _btniniciar_click() throws Exception{
RDebugUtils.currentModule="registro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btniniciar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btniniciar_click", null));}
String _consulta = "";
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Private Sub btnIniciar_Click";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="savedata.Initialize(\"savedata\", Me)";
mostCurrent._savedata._initialize /*String*/ (null,processBA,"savedata",registro.getObject());
RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="If(txtContraseña.Text == txtConfirmar.Text) Then";
if (((mostCurrent._txtcontraseña.getText()).equals(mostCurrent._txtconfirmar.getText()))) { 
RDebugUtils.currentLine=2097158;
 //BA.debugLineNum = 2097158;BA.debugLine="If txtContraseña.Text.Length >= 8 Then";
if (mostCurrent._txtcontraseña.getText().length()>=8) { 
RDebugUtils.currentLine=2097160;
 //BA.debugLineNum = 2097160;BA.debugLine="If validarcorreo(txtCorreo.Text) Then";
if (_validarcorreo(mostCurrent._txtcorreo.getText())) { 
RDebugUtils.currentLine=2097162;
 //BA.debugLineNum = 2097162;BA.debugLine="Dim consulta As String";
_consulta = "";
RDebugUtils.currentLine=2097163;
 //BA.debugLineNum = 2097163;BA.debugLine="consulta = \"check&Usuario=\" & txtUsuario.Text";
_consulta = "check&Usuario="+mostCurrent._txtusuario.getText()+"&Correo="+mostCurrent._txtcorreo.getText();
RDebugUtils.currentLine=2097164;
 //BA.debugLineNum = 2097164;BA.debugLine="savedata.PostString(URL, consulta)";
mostCurrent._savedata._poststring /*String*/ (null,mostCurrent._url,_consulta);
 }else {
RDebugUtils.currentLine=2097166;
 //BA.debugLineNum = 2097166;BA.debugLine="ToastMessageShow(\"Correo electrónico no válido";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Correo electrónico no válido"),anywheresoftware.b4a.keywords.Common.False);
 };
 }else {
RDebugUtils.currentLine=2097169;
 //BA.debugLineNum = 2097169;BA.debugLine="ToastMessageShow(\"La contraseña debe tener al m";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("La contraseña debe tener al menos 8 caracteres"),anywheresoftware.b4a.keywords.Common.False);
 };
 }else {
RDebugUtils.currentLine=2097172;
 //BA.debugLineNum = 2097172;BA.debugLine="ToastMessageShow(\"Las contraseñas no coinciden\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Las contraseñas no coinciden"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=2097176;
 //BA.debugLineNum = 2097176;BA.debugLine="End Sub";
return "";
}
public static boolean  _validarcorreo(String _email) throws Exception{
RDebugUtils.currentModule="registro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "validarcorreo", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "validarcorreo", new Object[] {_email}));}
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub validarcorreo(email As String) As Boolean";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="If email.Contains(\"@\") And email.Contains(\".co";
if (_email.contains("@") && _email.contains(".com")) { 
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="End Sub";
return false;
}
public static String  _imageview1_click() throws Exception{
RDebugUtils.currentModule="registro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imageview1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "imageview1_click", null));}
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub ImageView1_Click";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="If ImageView1.Tag = \"oculto\" Then";
if ((mostCurrent._imageview1.getTag()).equals((Object)("oculto"))) { 
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="txtContraseña.PasswordMode = False";
mostCurrent._txtcontraseña.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="ImageView1.Tag = \"visible\"";
mostCurrent._imageview1.setTag((Object)("visible"));
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="ImageView1.SetBackgroundImage(LoadBitmap(File.Di";
mostCurrent._imageview1.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"password_visible.png").getObject()));
 }else {
RDebugUtils.currentLine=1966086;
 //BA.debugLineNum = 1966086;BA.debugLine="txtContraseña.PasswordMode = True";
mostCurrent._txtcontraseña.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1966087;
 //BA.debugLineNum = 1966087;BA.debugLine="ImageView1.Tag = \"oculto\"";
mostCurrent._imageview1.setTag((Object)("oculto"));
RDebugUtils.currentLine=1966088;
 //BA.debugLineNum = 1966088;BA.debugLine="ImageView1.SetBackgroundImage(LoadBitmap(File.Di";
mostCurrent._imageview1.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"password_hidden.png").getObject()));
 };
RDebugUtils.currentLine=1966090;
 //BA.debugLineNum = 1966090;BA.debugLine="End Sub";
return "";
}
public static String  _imageview2_click() throws Exception{
RDebugUtils.currentModule="registro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imageview2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "imageview2_click", null));}
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub ImageView2_Click";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="If ImageView2.Tag = \"oculto\" Then";
if ((mostCurrent._imageview2.getTag()).equals((Object)("oculto"))) { 
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="txtConfirmar.PasswordMode = False";
mostCurrent._txtconfirmar.setPasswordMode(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="ImageView2.Tag = \"visible\"";
mostCurrent._imageview2.setTag((Object)("visible"));
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="ImageView2.SetBackgroundImage(LoadBitmap(File.Di";
mostCurrent._imageview2.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"password_visible.png").getObject()));
 }else {
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="txtConfirmar.PasswordMode = True";
mostCurrent._txtconfirmar.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="ImageView2.Tag = \"oculto\"";
mostCurrent._imageview2.setTag((Object)("oculto"));
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="ImageView2.SetBackgroundImage(LoadBitmap(File.Di";
mostCurrent._imageview2.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"password_hidden.png").getObject()));
 };
RDebugUtils.currentLine=2031626;
 //BA.debugLineNum = 2031626;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="registro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
String _respuesta = "";
String _consultaguardar = "";
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub JobDone (job As HttpJob)";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="Select job";
switch (BA.switchObjectToInt(_job,mostCurrent._savedata,mostCurrent._readdata,mostCurrent._updatedata,mostCurrent._deletedata)) {
case 0: {
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="If job.Success Then";
if (_job._success /*boolean*/ ) { 
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="Dim respuesta As String";
_respuesta = "";
RDebugUtils.currentLine=2293766;
 //BA.debugLineNum = 2293766;BA.debugLine="respuesta = job.GetString";
_respuesta = _job._getstring /*String*/ (null);
RDebugUtils.currentLine=2293768;
 //BA.debugLineNum = 2293768;BA.debugLine="If respuesta = \"EXISTE\" Then";
if ((_respuesta).equals("EXISTE")) { 
RDebugUtils.currentLine=2293769;
 //BA.debugLineNum = 2293769;BA.debugLine="ToastMessageShow(\"El usuario o correo ya exis";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("El usuario o correo ya existen"),anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=2293770;
 //BA.debugLineNum = 2293770;BA.debugLine="Else If respuesta = \"NO_EXISTE\" Then";
if ((_respuesta).equals("NO_EXISTE")) { 
RDebugUtils.currentLine=2293771;
 //BA.debugLineNum = 2293771;BA.debugLine="Dim consultaGuardar As String";
_consultaguardar = "";
RDebugUtils.currentLine=2293772;
 //BA.debugLineNum = 2293772;BA.debugLine="consultaGuardar = \"save&Cuenta=\" & txtUsuario";
_consultaguardar = "save&Cuenta="+mostCurrent._txtusuario.getText()+"&Contrasena="+mostCurrent._txtcontraseña.getText()+"&Correo="+mostCurrent._txtcorreo.getText();
RDebugUtils.currentLine=2293773;
 //BA.debugLineNum = 2293773;BA.debugLine="ToastMessageShow(\"Registro Guardado\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Registro Guardado"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2293775;
 //BA.debugLineNum = 2293775;BA.debugLine="txtUsuario.Text=\"\"";
mostCurrent._txtusuario.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=2293776;
 //BA.debugLineNum = 2293776;BA.debugLine="txtContraseña.Text = \"\"";
mostCurrent._txtcontraseña.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=2293777;
 //BA.debugLineNum = 2293777;BA.debugLine="txtCorreo.Text = \"\"";
mostCurrent._txtcorreo.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=2293778;
 //BA.debugLineNum = 2293778;BA.debugLine="txtConfirmar.Text = \"\"";
mostCurrent._txtconfirmar.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=2293779;
 //BA.debugLineNum = 2293779;BA.debugLine="savedata.PostString(URL, consultaGuardar)";
mostCurrent._savedata._poststring /*String*/ (null,mostCurrent._url,_consultaguardar);
 }else {
 }}
;
 }else {
RDebugUtils.currentLine=2293784;
 //BA.debugLineNum = 2293784;BA.debugLine="ToastMessageShow(\"Verificar la Conexión\", Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Verificar la Conexión"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=2293786;
 //BA.debugLineNum = 2293786;BA.debugLine="savedata.Release";
mostCurrent._savedata._release /*String*/ (null);
RDebugUtils.currentLine=2293788;
 //BA.debugLineNum = 2293788;BA.debugLine="savedata.Release";
mostCurrent._savedata._release /*String*/ (null);
 break; }
case 1: {
RDebugUtils.currentLine=2293791;
 //BA.debugLineNum = 2293791;BA.debugLine="If job.Success Then";
if (_job._success /*boolean*/ ) { 
RDebugUtils.currentLine=2293795;
 //BA.debugLineNum = 2293795;BA.debugLine="If job.GetString.Length < 1 Then";
if (_job._getstring /*String*/ (null).length()<1) { 
RDebugUtils.currentLine=2293797;
 //BA.debugLineNum = 2293797;BA.debugLine="ToastMessageShow(\"No existen Registros\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No existen Registros"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2293798;
 //BA.debugLineNum = 2293798;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2293801;
 //BA.debugLineNum = 2293801;BA.debugLine="ToastMessageShow(\"Registros\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Registros"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=2293807;
 //BA.debugLineNum = 2293807;BA.debugLine="ToastMessageShow(\"Verificar la Conexión\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Verificar la Conexión"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=2293810;
 //BA.debugLineNum = 2293810;BA.debugLine="readdata.Release";
mostCurrent._readdata._release /*String*/ (null);
 break; }
case 2: {
RDebugUtils.currentLine=2293814;
 //BA.debugLineNum = 2293814;BA.debugLine="If job.Success Then";
if (_job._success /*boolean*/ ) { 
RDebugUtils.currentLine=2293816;
 //BA.debugLineNum = 2293816;BA.debugLine="ToastMessageShow(\"Registro Actualizado\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Registro Actualizado"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=2293819;
 //BA.debugLineNum = 2293819;BA.debugLine="ToastMessageShow(\"Verificar la Conexión\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Verificar la Conexión"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=2293822;
 //BA.debugLineNum = 2293822;BA.debugLine="updatedata.Release";
mostCurrent._updatedata._release /*String*/ (null);
 break; }
case 3: {
RDebugUtils.currentLine=2293825;
 //BA.debugLineNum = 2293825;BA.debugLine="If job.Success Then";
if (_job._success /*boolean*/ ) { 
RDebugUtils.currentLine=2293827;
 //BA.debugLineNum = 2293827;BA.debugLine="ToastMessageShow(\"Registro Eliminado\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Registro Eliminado"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=2293830;
 //BA.debugLineNum = 2293830;BA.debugLine="ToastMessageShow(\"Verificar la Conexión\",False";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Verificar la Conexión"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=2293833;
 //BA.debugLineNum = 2293833;BA.debugLine="deletedata.Release";
mostCurrent._deletedata._release /*String*/ (null);
 break; }
}
;
RDebugUtils.currentLine=2293835;
 //BA.debugLineNum = 2293835;BA.debugLine="End Sub";
return "";
}
public static String  _lblback_click() throws Exception{
RDebugUtils.currentModule="registro";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblback_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblback_click", null));}
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub lblBack_Click";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="End Sub";
return "";
}
}