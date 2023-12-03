package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class updatepass_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (updatepass) ","updatepass",3,updatepass.mostCurrent.activityBA,updatepass.mostCurrent,24);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.updatepass.remoteMe.runUserSub(false, "updatepass","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"updatepass\")";
Debug.ShouldStop(16777216);
updatepass.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("updatepass")),updatepass.mostCurrent.activityBA);
 BA.debugLineNum = 26;BA.debugLine="URL=\"http://192.168.1.69/PHP/login.php\"";
Debug.ShouldStop(33554432);
updatepass.mostCurrent._url = BA.ObjectToString("http://192.168.1.69/PHP/login.php");
 BA.debugLineNum = 28;BA.debugLine="txtContraseña.PasswordMode = True";
Debug.ShouldStop(134217728);
updatepass.mostCurrent._txtcontraseña.runVoidMethod ("setPasswordMode",updatepass.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 29;BA.debugLine="ImageView1.SetBackgroundImage(LoadBitmap(File.Dir";
Debug.ShouldStop(268435456);
updatepass.mostCurrent._imageview1.runVoidMethod ("SetBackgroundImageNew",(Object)((updatepass.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(updatepass.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("password_hidden.png"))).getObject())));
 BA.debugLineNum = 31;BA.debugLine="txtConfirmar.PasswordMode= True";
Debug.ShouldStop(1073741824);
updatepass.mostCurrent._txtconfirmar.runVoidMethod ("setPasswordMode",updatepass.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 32;BA.debugLine="ImageView2.SetBackgroundImage(LoadBitmap(File.Dir";
Debug.ShouldStop(-2147483648);
updatepass.mostCurrent._imageview2.runVoidMethod ("SetBackgroundImageNew",(Object)((updatepass.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(updatepass.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("password_hidden.png"))).getObject())));
 BA.debugLineNum = 34;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (updatepass) ","updatepass",3,updatepass.mostCurrent.activityBA,updatepass.mostCurrent,63);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.updatepass.remoteMe.runUserSub(false, "updatepass","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 63;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (updatepass) ","updatepass",3,updatepass.mostCurrent.activityBA,updatepass.mostCurrent,59);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.updatepass.remoteMe.runUserSub(false, "updatepass","activity_resume");}
 BA.debugLineNum = 59;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btniniciar_click() throws Exception{
try {
		Debug.PushSubsStack("btnIniciar_Click (updatepass) ","updatepass",3,updatepass.mostCurrent.activityBA,updatepass.mostCurrent,68);
if (RapidSub.canDelegate("btniniciar_click")) { return b4a.example.updatepass.remoteMe.runUserSub(false, "updatepass","btniniciar_click");}
 BA.debugLineNum = 68;BA.debugLine="Private Sub btnIniciar_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 69;BA.debugLine="If(txtContraseña.Text == txtConfirmar.Text) Then";
Debug.ShouldStop(16);
if ((RemoteObject.solveBoolean("=",updatepass.mostCurrent._txtcontraseña.runMethod(true,"getText"),updatepass.mostCurrent._txtconfirmar.runMethod(true,"getText")))) { 
 BA.debugLineNum = 71;BA.debugLine="If txtContraseña.Text.Length >= 8 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("g",updatepass.mostCurrent._txtcontraseña.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 8))) { 
 BA.debugLineNum = 72;BA.debugLine="updatedata.Initialize(\"updatedata\", Me)";
Debug.ShouldStop(128);
updatepass.mostCurrent._updatedata.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,updatepass.processBA,(Object)(BA.ObjectToString("updatedata")),(Object)(updatepass.getObject()));
 BA.debugLineNum = 73;BA.debugLine="updatedata.PostString(URL,\"updatePas&UsuarioID=";
Debug.ShouldStop(256);
updatepass.mostCurrent._updatedata.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(updatepass.mostCurrent._url),(Object)(RemoteObject.concat(RemoteObject.createImmutable("updatePas&UsuarioID="),updatepass.mostCurrent._welcome._iduser /*RemoteObject*/ ,RemoteObject.createImmutable("&Contrasena="),updatepass.mostCurrent._txtconfirmar.runMethod(true,"getText"))));
 }else {
 BA.debugLineNum = 75;BA.debugLine="ToastMessageShow(\"La contraseña debe tener al m";
Debug.ShouldStop(1024);
updatepass.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("La contraseña debe tener al menos 8 caracteres")),(Object)(updatepass.mostCurrent.__c.getField(true,"False")));
 };
 }else {
 BA.debugLineNum = 78;BA.debugLine="ToastMessageShow(\"Las contraseñas no coinciden\",";
Debug.ShouldStop(8192);
updatepass.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Las contraseñas no coinciden")),(Object)(updatepass.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 82;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim URL As String";
updatepass.mostCurrent._url = RemoteObject.createImmutable("");
 //BA.debugLineNum = 16;BA.debugLine="Dim updatedata As HttpJob";
updatepass.mostCurrent._updatedata = RemoteObject.createNew ("b4a.example.httpjob");
 //BA.debugLineNum = 18;BA.debugLine="Dim txtContraseña As EditText";
updatepass.mostCurrent._txtcontraseña = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Dim txtConfirmar As EditText";
updatepass.mostCurrent._txtconfirmar = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private ImageView1 As ImageView";
updatepass.mostCurrent._imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private ImageView2 As ImageView";
updatepass.mostCurrent._imageview2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _imageview1_click() throws Exception{
try {
		Debug.PushSubsStack("ImageView1_Click (updatepass) ","updatepass",3,updatepass.mostCurrent.activityBA,updatepass.mostCurrent,36);
if (RapidSub.canDelegate("imageview1_click")) { return b4a.example.updatepass.remoteMe.runUserSub(false, "updatepass","imageview1_click");}
 BA.debugLineNum = 36;BA.debugLine="Sub ImageView1_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="If ImageView1.Tag = \"oculto\" Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",updatepass.mostCurrent._imageview1.runMethod(false,"getTag"),RemoteObject.createImmutable(("oculto")))) { 
 BA.debugLineNum = 38;BA.debugLine="txtContraseña.PasswordMode = False";
Debug.ShouldStop(32);
updatepass.mostCurrent._txtcontraseña.runVoidMethod ("setPasswordMode",updatepass.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 39;BA.debugLine="ImageView1.Tag = \"visible\"";
Debug.ShouldStop(64);
updatepass.mostCurrent._imageview1.runMethod(false,"setTag",RemoteObject.createImmutable(("visible")));
 BA.debugLineNum = 40;BA.debugLine="ImageView1.SetBackgroundImage(LoadBitmap(File.Di";
Debug.ShouldStop(128);
updatepass.mostCurrent._imageview1.runVoidMethod ("SetBackgroundImageNew",(Object)((updatepass.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(updatepass.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("password_visible.png"))).getObject())));
 }else {
 BA.debugLineNum = 42;BA.debugLine="txtContraseña.PasswordMode = True";
Debug.ShouldStop(512);
updatepass.mostCurrent._txtcontraseña.runVoidMethod ("setPasswordMode",updatepass.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 43;BA.debugLine="ImageView1.Tag = \"oculto\"";
Debug.ShouldStop(1024);
updatepass.mostCurrent._imageview1.runMethod(false,"setTag",RemoteObject.createImmutable(("oculto")));
 BA.debugLineNum = 44;BA.debugLine="ImageView1.SetBackgroundImage(LoadBitmap(File.Di";
Debug.ShouldStop(2048);
updatepass.mostCurrent._imageview1.runVoidMethod ("SetBackgroundImageNew",(Object)((updatepass.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(updatepass.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("password_hidden.png"))).getObject())));
 };
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _imageview2_click() throws Exception{
try {
		Debug.PushSubsStack("ImageView2_Click (updatepass) ","updatepass",3,updatepass.mostCurrent.activityBA,updatepass.mostCurrent,48);
if (RapidSub.canDelegate("imageview2_click")) { return b4a.example.updatepass.remoteMe.runUserSub(false, "updatepass","imageview2_click");}
 BA.debugLineNum = 48;BA.debugLine="Sub ImageView2_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="If ImageView2.Tag = \"oculto\" Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",updatepass.mostCurrent._imageview2.runMethod(false,"getTag"),RemoteObject.createImmutable(("oculto")))) { 
 BA.debugLineNum = 50;BA.debugLine="txtConfirmar.PasswordMode = False";
Debug.ShouldStop(131072);
updatepass.mostCurrent._txtconfirmar.runVoidMethod ("setPasswordMode",updatepass.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 51;BA.debugLine="ImageView2.Tag = \"visible\"";
Debug.ShouldStop(262144);
updatepass.mostCurrent._imageview2.runMethod(false,"setTag",RemoteObject.createImmutable(("visible")));
 BA.debugLineNum = 52;BA.debugLine="ImageView2.SetBackgroundImage(LoadBitmap(File.Di";
Debug.ShouldStop(524288);
updatepass.mostCurrent._imageview2.runVoidMethod ("SetBackgroundImageNew",(Object)((updatepass.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(updatepass.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("password_visible.png"))).getObject())));
 }else {
 BA.debugLineNum = 54;BA.debugLine="txtConfirmar.PasswordMode = True";
Debug.ShouldStop(2097152);
updatepass.mostCurrent._txtconfirmar.runVoidMethod ("setPasswordMode",updatepass.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 55;BA.debugLine="ImageView2.Tag = \"oculto\"";
Debug.ShouldStop(4194304);
updatepass.mostCurrent._imageview2.runMethod(false,"setTag",RemoteObject.createImmutable(("oculto")));
 BA.debugLineNum = 56;BA.debugLine="ImageView2.SetBackgroundImage(LoadBitmap(File.Di";
Debug.ShouldStop(8388608);
updatepass.mostCurrent._imageview2.runVoidMethod ("SetBackgroundImageNew",(Object)((updatepass.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(updatepass.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("password_hidden.png"))).getObject())));
 };
 BA.debugLineNum = 58;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (updatepass) ","updatepass",3,updatepass.mostCurrent.activityBA,updatepass.mostCurrent,84);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.updatepass.remoteMe.runUserSub(false, "updatepass","jobdone", _job);}
Debug.locals.put("job", _job);
 BA.debugLineNum = 84;BA.debugLine="Sub JobDone (job As HttpJob)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="Select job";
Debug.ShouldStop(1048576);
switch (BA.switchObjectToInt(_job,updatepass.mostCurrent._updatedata)) {
case 0: {
 BA.debugLineNum = 87;BA.debugLine="If job.Success Then";
Debug.ShouldStop(4194304);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 89;BA.debugLine="ToastMessageShow(\"Contraseña Actualizado\",Fals";
Debug.ShouldStop(16777216);
updatepass.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Contraseña Actualizado")),(Object)(updatepass.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 90;BA.debugLine="txtConfirmar.Text = \"\"";
Debug.ShouldStop(33554432);
updatepass.mostCurrent._txtconfirmar.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 91;BA.debugLine="txtContraseña.Text = \"\"";
Debug.ShouldStop(67108864);
updatepass.mostCurrent._txtcontraseña.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 92;BA.debugLine="ToastMessageShow(\"Se cerro la sesión\",False)";
Debug.ShouldStop(134217728);
updatepass.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Se cerro la sesión")),(Object)(updatepass.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 93;BA.debugLine="Activity.Finish";
Debug.ShouldStop(268435456);
updatepass.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 94;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(536870912);
updatepass.mostCurrent.__c.runVoidMethod ("StartActivity",updatepass.processBA,(Object)((updatepass.mostCurrent._main.getObject())));
 }else {
 BA.debugLineNum = 96;BA.debugLine="ToastMessageShow(\"Verificar la Conexión\",False";
Debug.ShouldStop(-2147483648);
updatepass.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Verificar la Conexión")),(Object)(updatepass.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 98;BA.debugLine="updatedata.Release";
Debug.ShouldStop(2);
updatepass.mostCurrent._updatedata.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 break; }
}
;
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lblback_click() throws Exception{
try {
		Debug.PushSubsStack("lblBack_Click (updatepass) ","updatepass",3,updatepass.mostCurrent.activityBA,updatepass.mostCurrent,102);
if (RapidSub.canDelegate("lblback_click")) { return b4a.example.updatepass.remoteMe.runUserSub(false, "updatepass","lblback_click");}
 BA.debugLineNum = 102;BA.debugLine="Private Sub lblBack_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 103;BA.debugLine="Activity.Finish";
Debug.ShouldStop(64);
updatepass.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 104;BA.debugLine="StartActivity(Welcome)";
Debug.ShouldStop(128);
updatepass.mostCurrent.__c.runVoidMethod ("StartActivity",updatepass.processBA,(Object)((updatepass.mostCurrent._welcome.getObject())));
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}