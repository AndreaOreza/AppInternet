package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,28);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 28;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 29;BA.debugLine="Activity.LoadLayout(\"iniciosesion\")";
Debug.ShouldStop(268435456);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("iniciosesion")),main.mostCurrent.activityBA);
 BA.debugLineNum = 30;BA.debugLine="URL=\"http://192.168.1.69/PHP/login.php\"";
Debug.ShouldStop(536870912);
main.mostCurrent._url = BA.ObjectToString("http://192.168.1.69/PHP/login.php");
 BA.debugLineNum = 32;BA.debugLine="txtContraseña.PasswordMode = True";
Debug.ShouldStop(-2147483648);
main.mostCurrent._txtcontraseña.runVoidMethod ("setPasswordMode",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 33;BA.debugLine="ImageView3.SetBackgroundImage(LoadBitmap(File.Dir";
Debug.ShouldStop(1);
main.mostCurrent._imageview3.runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("password_hidden.png"))).getObject())));
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,40);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 40;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,36);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 36;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8);
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("btnIniciar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,55);
if (RapidSub.canDelegate("btniniciar_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btniniciar_click");}
RemoteObject _email = RemoteObject.createImmutable("");
RemoteObject _password = RemoteObject.createImmutable("");
RemoteObject _postdata = RemoteObject.createImmutable("");
 BA.debugLineNum = 55;BA.debugLine="Private Sub btnIniciar_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="Dim email As String = txtCorreo.Text";
Debug.ShouldStop(8388608);
_email = main.mostCurrent._txtcorreo.runMethod(true,"getText");Debug.locals.put("email", _email);Debug.locals.put("email", _email);
 BA.debugLineNum = 57;BA.debugLine="Dim password As String = txtContraseña.Text";
Debug.ShouldStop(16777216);
_password = main.mostCurrent._txtcontraseña.runMethod(true,"getText");Debug.locals.put("password", _password);Debug.locals.put("password", _password);
 BA.debugLineNum = 60;BA.debugLine="If validarcorreo(txtCorreo.Text) Then";
Debug.ShouldStop(134217728);
if (_validarcorreo(main.mostCurrent._txtcorreo.runMethod(true,"getText")).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 61;BA.debugLine="Dim postData As String = \"fetch=true&Correo=\" & e";
Debug.ShouldStop(268435456);
_postdata = RemoteObject.concat(RemoteObject.createImmutable("fetch=true&Correo="),_email,RemoteObject.createImmutable("&Contrasena="),_password);Debug.locals.put("postData", _postdata);Debug.locals.put("postData", _postdata);
 BA.debugLineNum = 62;BA.debugLine="savedata.Initialize(\"savedata\", Me)";
Debug.ShouldStop(536870912);
main.mostCurrent._savedata.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("savedata")),(Object)(main.getObject()));
 BA.debugLineNum = 63;BA.debugLine="savedata.PostString(URL, postData)";
Debug.ShouldStop(1073741824);
main.mostCurrent._savedata.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(main.mostCurrent._url),(Object)(_postdata));
 }else {
 BA.debugLineNum = 65;BA.debugLine="ToastMessageShow(\"Correo electrónico no válido\",";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Correo electrónico no válido")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnregistro_click() throws Exception{
try {
		Debug.PushSubsStack("btnRegistro_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,107);
if (RapidSub.canDelegate("btnregistro_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnregistro_click");}
 BA.debugLineNum = 107;BA.debugLine="Private Sub btnRegistro_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 108;BA.debugLine="StartActivity(Registro)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._registro.getObject())));
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 20;BA.debugLine="Dim savedata As HttpJob";
main.mostCurrent._savedata = RemoteObject.createNew ("b4a.example.httpjob");
 //BA.debugLineNum = 21;BA.debugLine="Private txtCorreo As EditText";
main.mostCurrent._txtcorreo = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private txtContraseña As EditText";
main.mostCurrent._txtcontraseña = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim URL As String";
main.mostCurrent._url = RemoteObject.createImmutable("");
 //BA.debugLineNum = 24;BA.debugLine="Private ImageView3 As ImageView";
main.mostCurrent._imageview3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _imageview3_click() throws Exception{
try {
		Debug.PushSubsStack("ImageView3_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,44);
if (RapidSub.canDelegate("imageview3_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","imageview3_click");}
 BA.debugLineNum = 44;BA.debugLine="Sub ImageView3_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 45;BA.debugLine="If ImageView3.Tag = \"oculto\" Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",main.mostCurrent._imageview3.runMethod(false,"getTag"),RemoteObject.createImmutable(("oculto")))) { 
 BA.debugLineNum = 46;BA.debugLine="txtContraseña.PasswordMode = False";
Debug.ShouldStop(8192);
main.mostCurrent._txtcontraseña.runVoidMethod ("setPasswordMode",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 47;BA.debugLine="ImageView3.Tag = \"visible\"";
Debug.ShouldStop(16384);
main.mostCurrent._imageview3.runMethod(false,"setTag",RemoteObject.createImmutable(("visible")));
 BA.debugLineNum = 48;BA.debugLine="ImageView3.SetBackgroundImage(LoadBitmap(File.Di";
Debug.ShouldStop(32768);
main.mostCurrent._imageview3.runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("password_visible.png"))).getObject())));
 }else {
 BA.debugLineNum = 50;BA.debugLine="txtContraseña.PasswordMode = True";
Debug.ShouldStop(131072);
main.mostCurrent._txtcontraseña.runVoidMethod ("setPasswordMode",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 51;BA.debugLine="ImageView3.Tag = \"oculto\"";
Debug.ShouldStop(262144);
main.mostCurrent._imageview3.runMethod(false,"setTag",RemoteObject.createImmutable(("oculto")));
 BA.debugLineNum = 52;BA.debugLine="ImageView3.SetBackgroundImage(LoadBitmap(File.Di";
Debug.ShouldStop(524288);
main.mostCurrent._imageview3.runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("password_hidden.png"))).getObject())));
 };
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("JobDone (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,73);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.main.remoteMe.runUserSub(false, "main","jobdone", _job);}
Debug.locals.put("job", _job);
 BA.debugLineNum = 73;BA.debugLine="Sub JobDone (job As HttpJob)";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="Select job";
Debug.ShouldStop(512);
switch (BA.switchObjectToInt(_job,main.mostCurrent._savedata)) {
case 0: {
 BA.debugLineNum = 76;BA.debugLine="If job.Success Then";
Debug.ShouldStop(2048);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 77;BA.debugLine="If job.GetString.Contains(\"Inicio de sesión ex";
Debug.ShouldStop(4096);
if (_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("Inicio de sesión exitoso"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 79;BA.debugLine="ToastMessageShow(\"Inicio de sesión exitoso. ¡";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Inicio de sesión exitoso. ¡Bienvenido!")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 80;BA.debugLine="Welcome.CorreoW = txtCorreo.Text";
Debug.ShouldStop(32768);
main.mostCurrent._welcome._correow /*RemoteObject*/  = main.mostCurrent._txtcorreo.runMethod(true,"getText");
 BA.debugLineNum = 81;BA.debugLine="txtCorreo.Text = \"\"";
Debug.ShouldStop(65536);
main.mostCurrent._txtcorreo.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 82;BA.debugLine="txtContraseña.Text = \"\"";
Debug.ShouldStop(131072);
main.mostCurrent._txtcontraseña.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 83;BA.debugLine="Activity.Finish";
Debug.ShouldStop(262144);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 84;BA.debugLine="StartActivity(Welcome)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._welcome.getObject())));
 }else {
 BA.debugLineNum = 87;BA.debugLine="ToastMessageShow(\"REVISA TU CORREO O CONTRASE";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("REVISA TU CORREO O CONTRASEÑA.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 }else {
 BA.debugLineNum = 91;BA.debugLine="ToastMessageShow(\"Verificar la Conexión\", Fals";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Verificar la Conexión")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 95;BA.debugLine="savedata.Release";
Debug.ShouldStop(1073741824);
main.mostCurrent._savedata.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 break; }
}
;
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("lblBack_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,69);
if (RapidSub.canDelegate("lblback_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","lblback_click");}
 BA.debugLineNum = 69;BA.debugLine="Sub lblBack_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 71;BA.debugLine="Activity.Finish";
Debug.ShouldStop(64);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
welcome_subs_0._process_globals();
registro_subs_0._process_globals();
updatepass_subs_0._process_globals();
actualizar_subs_0._process_globals();
starter_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
welcome.myClass = BA.getDeviceClass ("b4a.example.welcome");
registro.myClass = BA.getDeviceClass ("b4a.example.registro");
updatepass.myClass = BA.getDeviceClass ("b4a.example.updatepass");
actualizar.myClass = BA.getDeviceClass ("b4a.example.actualizar");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
fileprovider.myClass = BA.getDeviceClass ("b4a.example.fileprovider");
httputils2service.myClass = BA.getDeviceClass ("b4a.example.httputils2service");
httpjob.myClass = BA.getDeviceClass ("b4a.example.httpjob");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 16;BA.debugLine="Public idus As String";
main._idus = RemoteObject.createImmutable("");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _validarcorreo(RemoteObject _email) throws Exception{
try {
		Debug.PushSubsStack("validarcorreo (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,99);
if (RapidSub.canDelegate("validarcorreo")) { return b4a.example.main.remoteMe.runUserSub(false, "main","validarcorreo", _email);}
Debug.locals.put("email", _email);
 BA.debugLineNum = 99;BA.debugLine="Sub validarcorreo(email As String) As Boolean";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="If email.Contains(\"@\") And email.Contains(\".com\")";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean(".",_email.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("@")))) && RemoteObject.solveBoolean(".",_email.runMethod(true,"contains",(Object)(RemoteObject.createImmutable(".com"))))) { 
 BA.debugLineNum = 101;BA.debugLine="Return True";
Debug.ShouldStop(16);
if (true) return main.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 103;BA.debugLine="Return False";
Debug.ShouldStop(64);
if (true) return main.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}