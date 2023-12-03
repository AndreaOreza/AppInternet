package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class registro_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (registro) ","registro",2,registro.mostCurrent.activityBA,registro.mostCurrent,28);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.registro.remoteMe.runUserSub(false, "registro","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 28;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 29;BA.debugLine="Activity.LoadLayout(\"Registro\")";
Debug.ShouldStop(268435456);
registro.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Registro")),registro.mostCurrent.activityBA);
 BA.debugLineNum = 30;BA.debugLine="URL=\"http://192.168.1.69/PHP/Registro.php\"";
Debug.ShouldStop(536870912);
registro.mostCurrent._url = BA.ObjectToString("http://192.168.1.69/PHP/Registro.php");
 BA.debugLineNum = 33;BA.debugLine="txtContraseña.PasswordMode = True";
Debug.ShouldStop(1);
registro.mostCurrent._txtcontraseña.runVoidMethod ("setPasswordMode",registro.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 34;BA.debugLine="ImageView1.SetBackgroundImage(LoadBitmap(File.Dir";
Debug.ShouldStop(2);
registro.mostCurrent._imageview1.runVoidMethod ("SetBackgroundImageNew",(Object)((registro.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(registro.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("password_hidden.png"))).getObject())));
 BA.debugLineNum = 36;BA.debugLine="txtConfirmar.PasswordMode= True";
Debug.ShouldStop(8);
registro.mostCurrent._txtconfirmar.runVoidMethod ("setPasswordMode",registro.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 37;BA.debugLine="ImageView2.SetBackgroundImage(LoadBitmap(File.Dir";
Debug.ShouldStop(16);
registro.mostCurrent._imageview2.runVoidMethod ("SetBackgroundImageNew",(Object)((registro.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(registro.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("password_hidden.png"))).getObject())));
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("Activity_Pause (registro) ","registro",2,registro.mostCurrent.activityBA,registro.mostCurrent,47);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.registro.remoteMe.runUserSub(false, "registro","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 47;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Activity_Resume (registro) ","registro",2,registro.mostCurrent.activityBA,registro.mostCurrent,43);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.registro.remoteMe.runUserSub(false, "registro","activity_resume");}
 BA.debugLineNum = 43;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1024);
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("btnIniciar_Click (registro) ","registro",2,registro.mostCurrent.activityBA,registro.mostCurrent,75);
if (RapidSub.canDelegate("btniniciar_click")) { return b4a.example.registro.remoteMe.runUserSub(false, "registro","btniniciar_click");}
RemoteObject _consulta = RemoteObject.createImmutable("");
 BA.debugLineNum = 75;BA.debugLine="Private Sub btnIniciar_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 76;BA.debugLine="savedata.Initialize(\"savedata\", Me)";
Debug.ShouldStop(2048);
registro.mostCurrent._savedata.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,registro.processBA,(Object)(BA.ObjectToString("savedata")),(Object)(registro.getObject()));
 BA.debugLineNum = 79;BA.debugLine="If(txtContraseña.Text == txtConfirmar.Text) Then";
Debug.ShouldStop(16384);
if ((RemoteObject.solveBoolean("=",registro.mostCurrent._txtcontraseña.runMethod(true,"getText"),registro.mostCurrent._txtconfirmar.runMethod(true,"getText")))) { 
 BA.debugLineNum = 81;BA.debugLine="If txtContraseña.Text.Length >= 8 Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("g",registro.mostCurrent._txtcontraseña.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 8))) { 
 BA.debugLineNum = 83;BA.debugLine="If validarcorreo(txtCorreo.Text) Then";
Debug.ShouldStop(262144);
if (_validarcorreo(registro.mostCurrent._txtcorreo.runMethod(true,"getText")).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 85;BA.debugLine="Dim consulta As String";
Debug.ShouldStop(1048576);
_consulta = RemoteObject.createImmutable("");Debug.locals.put("consulta", _consulta);
 BA.debugLineNum = 86;BA.debugLine="consulta = \"check&Usuario=\" & txtUsuario.Text";
Debug.ShouldStop(2097152);
_consulta = RemoteObject.concat(RemoteObject.createImmutable("check&Usuario="),registro.mostCurrent._txtusuario.runMethod(true,"getText"),RemoteObject.createImmutable("&Correo="),registro.mostCurrent._txtcorreo.runMethod(true,"getText"));Debug.locals.put("consulta", _consulta);
 BA.debugLineNum = 87;BA.debugLine="savedata.PostString(URL, consulta)";
Debug.ShouldStop(4194304);
registro.mostCurrent._savedata.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(registro.mostCurrent._url),(Object)(_consulta));
 }else {
 BA.debugLineNum = 89;BA.debugLine="ToastMessageShow(\"Correo electrónico no válido";
Debug.ShouldStop(16777216);
registro.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Correo electrónico no válido")),(Object)(registro.mostCurrent.__c.getField(true,"False")));
 };
 }else {
 BA.debugLineNum = 92;BA.debugLine="ToastMessageShow(\"La contraseña debe tener al m";
Debug.ShouldStop(134217728);
registro.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("La contraseña debe tener al menos 8 caracteres")),(Object)(registro.mostCurrent.__c.getField(true,"False")));
 };
 }else {
 BA.debugLineNum = 95;BA.debugLine="ToastMessageShow(\"Las contraseñas no coinciden\",";
Debug.ShouldStop(1073741824);
registro.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Las contraseñas no coinciden")),(Object)(registro.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 14;BA.debugLine="Dim deletedata As HttpJob";
registro.mostCurrent._deletedata = RemoteObject.createNew ("b4a.example.httpjob");
 //BA.debugLineNum = 15;BA.debugLine="Dim updatedata As HttpJob";
registro.mostCurrent._updatedata = RemoteObject.createNew ("b4a.example.httpjob");
 //BA.debugLineNum = 16;BA.debugLine="Dim readdata As HttpJob";
registro.mostCurrent._readdata = RemoteObject.createNew ("b4a.example.httpjob");
 //BA.debugLineNum = 17;BA.debugLine="Dim savedata As HttpJob";
registro.mostCurrent._savedata = RemoteObject.createNew ("b4a.example.httpjob");
 //BA.debugLineNum = 18;BA.debugLine="Private txtUsuario As EditText";
registro.mostCurrent._txtusuario = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private txtCorreo As EditText";
registro.mostCurrent._txtcorreo = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private txtContraseña As EditText";
registro.mostCurrent._txtcontraseña = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private txtConfirmar As EditText";
registro.mostCurrent._txtconfirmar = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private ImageView1 As ImageView";
registro.mostCurrent._imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private ImageView2 As ImageView";
registro.mostCurrent._imageview2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Dim URL As String";
registro.mostCurrent._url = RemoteObject.createImmutable("");
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _imageview1_click() throws Exception{
try {
		Debug.PushSubsStack("ImageView1_Click (registro) ","registro",2,registro.mostCurrent.activityBA,registro.mostCurrent,51);
if (RapidSub.canDelegate("imageview1_click")) { return b4a.example.registro.remoteMe.runUserSub(false, "registro","imageview1_click");}
 BA.debugLineNum = 51;BA.debugLine="Sub ImageView1_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 52;BA.debugLine="If ImageView1.Tag = \"oculto\" Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",registro.mostCurrent._imageview1.runMethod(false,"getTag"),RemoteObject.createImmutable(("oculto")))) { 
 BA.debugLineNum = 53;BA.debugLine="txtContraseña.PasswordMode = False";
Debug.ShouldStop(1048576);
registro.mostCurrent._txtcontraseña.runVoidMethod ("setPasswordMode",registro.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 54;BA.debugLine="ImageView1.Tag = \"visible\"";
Debug.ShouldStop(2097152);
registro.mostCurrent._imageview1.runMethod(false,"setTag",RemoteObject.createImmutable(("visible")));
 BA.debugLineNum = 55;BA.debugLine="ImageView1.SetBackgroundImage(LoadBitmap(File.Di";
Debug.ShouldStop(4194304);
registro.mostCurrent._imageview1.runVoidMethod ("SetBackgroundImageNew",(Object)((registro.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(registro.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("password_visible.png"))).getObject())));
 }else {
 BA.debugLineNum = 57;BA.debugLine="txtContraseña.PasswordMode = True";
Debug.ShouldStop(16777216);
registro.mostCurrent._txtcontraseña.runVoidMethod ("setPasswordMode",registro.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 58;BA.debugLine="ImageView1.Tag = \"oculto\"";
Debug.ShouldStop(33554432);
registro.mostCurrent._imageview1.runMethod(false,"setTag",RemoteObject.createImmutable(("oculto")));
 BA.debugLineNum = 59;BA.debugLine="ImageView1.SetBackgroundImage(LoadBitmap(File.Di";
Debug.ShouldStop(67108864);
registro.mostCurrent._imageview1.runVoidMethod ("SetBackgroundImageNew",(Object)((registro.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(registro.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("password_hidden.png"))).getObject())));
 };
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
public static RemoteObject  _imageview2_click() throws Exception{
try {
		Debug.PushSubsStack("ImageView2_Click (registro) ","registro",2,registro.mostCurrent.activityBA,registro.mostCurrent,63);
if (RapidSub.canDelegate("imageview2_click")) { return b4a.example.registro.remoteMe.runUserSub(false, "registro","imageview2_click");}
 BA.debugLineNum = 63;BA.debugLine="Sub ImageView2_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 64;BA.debugLine="If ImageView2.Tag = \"oculto\" Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",registro.mostCurrent._imageview2.runMethod(false,"getTag"),RemoteObject.createImmutable(("oculto")))) { 
 BA.debugLineNum = 65;BA.debugLine="txtConfirmar.PasswordMode = False";
Debug.ShouldStop(1);
registro.mostCurrent._txtconfirmar.runVoidMethod ("setPasswordMode",registro.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 66;BA.debugLine="ImageView2.Tag = \"visible\"";
Debug.ShouldStop(2);
registro.mostCurrent._imageview2.runMethod(false,"setTag",RemoteObject.createImmutable(("visible")));
 BA.debugLineNum = 67;BA.debugLine="ImageView2.SetBackgroundImage(LoadBitmap(File.Di";
Debug.ShouldStop(4);
registro.mostCurrent._imageview2.runVoidMethod ("SetBackgroundImageNew",(Object)((registro.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(registro.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("password_visible.png"))).getObject())));
 }else {
 BA.debugLineNum = 69;BA.debugLine="txtConfirmar.PasswordMode = True";
Debug.ShouldStop(16);
registro.mostCurrent._txtconfirmar.runVoidMethod ("setPasswordMode",registro.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 70;BA.debugLine="ImageView2.Tag = \"oculto\"";
Debug.ShouldStop(32);
registro.mostCurrent._imageview2.runMethod(false,"setTag",RemoteObject.createImmutable(("oculto")));
 BA.debugLineNum = 71;BA.debugLine="ImageView2.SetBackgroundImage(LoadBitmap(File.Di";
Debug.ShouldStop(64);
registro.mostCurrent._imageview2.runVoidMethod ("SetBackgroundImageNew",(Object)((registro.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(registro.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("password_hidden.png"))).getObject())));
 };
 BA.debugLineNum = 73;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("JobDone (registro) ","registro",2,registro.mostCurrent.activityBA,registro.mostCurrent,111);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.registro.remoteMe.runUserSub(false, "registro","jobdone", _job);}
RemoteObject _respuesta = RemoteObject.createImmutable("");
RemoteObject _consultaguardar = RemoteObject.createImmutable("");
Debug.locals.put("job", _job);
 BA.debugLineNum = 111;BA.debugLine="Sub JobDone (job As HttpJob)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 112;BA.debugLine="Select job";
Debug.ShouldStop(32768);
switch (BA.switchObjectToInt(_job,registro.mostCurrent._savedata,registro.mostCurrent._readdata,registro.mostCurrent._updatedata,registro.mostCurrent._deletedata)) {
case 0: {
 BA.debugLineNum = 115;BA.debugLine="If job.Success Then";
Debug.ShouldStop(262144);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 116;BA.debugLine="Dim respuesta As String";
Debug.ShouldStop(524288);
_respuesta = RemoteObject.createImmutable("");Debug.locals.put("respuesta", _respuesta);
 BA.debugLineNum = 117;BA.debugLine="respuesta = job.GetString";
Debug.ShouldStop(1048576);
_respuesta = _job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("respuesta", _respuesta);
 BA.debugLineNum = 119;BA.debugLine="If respuesta = \"EXISTE\" Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_respuesta,BA.ObjectToString("EXISTE"))) { 
 BA.debugLineNum = 120;BA.debugLine="ToastMessageShow(\"El usuario o correo ya exis";
Debug.ShouldStop(8388608);
registro.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("El usuario o correo ya existen")),(Object)(registro.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 121;BA.debugLine="Else If respuesta = \"NO_EXISTE\" Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_respuesta,BA.ObjectToString("NO_EXISTE"))) { 
 BA.debugLineNum = 122;BA.debugLine="Dim consultaGuardar As String";
Debug.ShouldStop(33554432);
_consultaguardar = RemoteObject.createImmutable("");Debug.locals.put("consultaGuardar", _consultaguardar);
 BA.debugLineNum = 123;BA.debugLine="consultaGuardar = \"save&Cuenta=\" & txtUsuario";
Debug.ShouldStop(67108864);
_consultaguardar = RemoteObject.concat(RemoteObject.createImmutable("save&Cuenta="),registro.mostCurrent._txtusuario.runMethod(true,"getText"),RemoteObject.createImmutable("&Contrasena="),registro.mostCurrent._txtcontraseña.runMethod(true,"getText"),RemoteObject.createImmutable("&Correo="),registro.mostCurrent._txtcorreo.runMethod(true,"getText"));Debug.locals.put("consultaGuardar", _consultaguardar);
 BA.debugLineNum = 124;BA.debugLine="ToastMessageShow(\"Registro Guardado\",False)";
Debug.ShouldStop(134217728);
registro.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Registro Guardado")),(Object)(registro.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 126;BA.debugLine="txtUsuario.Text=\"\"";
Debug.ShouldStop(536870912);
registro.mostCurrent._txtusuario.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 127;BA.debugLine="txtContraseña.Text = \"\"";
Debug.ShouldStop(1073741824);
registro.mostCurrent._txtcontraseña.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 128;BA.debugLine="txtCorreo.Text = \"\"";
Debug.ShouldStop(-2147483648);
registro.mostCurrent._txtcorreo.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 129;BA.debugLine="txtConfirmar.Text = \"\"";
Debug.ShouldStop(1);
registro.mostCurrent._txtconfirmar.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 130;BA.debugLine="savedata.PostString(URL, consultaGuardar)";
Debug.ShouldStop(2);
registro.mostCurrent._savedata.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(registro.mostCurrent._url),(Object)(_consultaguardar));
 }else {
 }}
;
 }else {
 BA.debugLineNum = 135;BA.debugLine="ToastMessageShow(\"Verificar la Conexión\", Fals";
Debug.ShouldStop(64);
registro.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Verificar la Conexión")),(Object)(registro.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 137;BA.debugLine="savedata.Release";
Debug.ShouldStop(256);
registro.mostCurrent._savedata.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 139;BA.debugLine="savedata.Release";
Debug.ShouldStop(1024);
registro.mostCurrent._savedata.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 break; }
case 1: {
 BA.debugLineNum = 142;BA.debugLine="If job.Success Then";
Debug.ShouldStop(8192);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 146;BA.debugLine="If job.GetString.Length < 1 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("<",_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ ).runMethod(true,"length"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 148;BA.debugLine="ToastMessageShow(\"No existen Registros\",False";
Debug.ShouldStop(524288);
registro.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No existen Registros")),(Object)(registro.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 149;BA.debugLine="Return";
Debug.ShouldStop(1048576);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 152;BA.debugLine="ToastMessageShow(\"Registros\",False)";
Debug.ShouldStop(8388608);
registro.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Registros")),(Object)(registro.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 158;BA.debugLine="ToastMessageShow(\"Verificar la Conexión\",False";
Debug.ShouldStop(536870912);
registro.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Verificar la Conexión")),(Object)(registro.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 161;BA.debugLine="readdata.Release";
Debug.ShouldStop(1);
registro.mostCurrent._readdata.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 break; }
case 2: {
 BA.debugLineNum = 165;BA.debugLine="If job.Success Then";
Debug.ShouldStop(16);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 167;BA.debugLine="ToastMessageShow(\"Registro Actualizado\",False)";
Debug.ShouldStop(64);
registro.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Registro Actualizado")),(Object)(registro.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 170;BA.debugLine="ToastMessageShow(\"Verificar la Conexión\",False";
Debug.ShouldStop(512);
registro.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Verificar la Conexión")),(Object)(registro.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 173;BA.debugLine="updatedata.Release";
Debug.ShouldStop(4096);
registro.mostCurrent._updatedata.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 break; }
case 3: {
 BA.debugLineNum = 176;BA.debugLine="If job.Success Then";
Debug.ShouldStop(32768);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 178;BA.debugLine="ToastMessageShow(\"Registro Eliminado\",False)";
Debug.ShouldStop(131072);
registro.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Registro Eliminado")),(Object)(registro.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 181;BA.debugLine="ToastMessageShow(\"Verificar la Conexión\",False";
Debug.ShouldStop(1048576);
registro.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Verificar la Conexión")),(Object)(registro.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 184;BA.debugLine="deletedata.Release";
Debug.ShouldStop(8388608);
registro.mostCurrent._deletedata.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 break; }
}
;
 BA.debugLineNum = 186;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("lblBack_Click (registro) ","registro",2,registro.mostCurrent.activityBA,registro.mostCurrent,108);
if (RapidSub.canDelegate("lblback_click")) { return b4a.example.registro.remoteMe.runUserSub(false, "registro","lblback_click");}
 BA.debugLineNum = 108;BA.debugLine="Sub lblBack_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 109;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4096);
registro.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 110;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _validarcorreo(RemoteObject _email) throws Exception{
try {
		Debug.PushSubsStack("validarcorreo (registro) ","registro",2,registro.mostCurrent.activityBA,registro.mostCurrent,101);
if (RapidSub.canDelegate("validarcorreo")) { return b4a.example.registro.remoteMe.runUserSub(false, "registro","validarcorreo", _email);}
Debug.locals.put("email", _email);
 BA.debugLineNum = 101;BA.debugLine="Sub validarcorreo(email As String) As Boolean";
Debug.ShouldStop(16);
 BA.debugLineNum = 102;BA.debugLine="If email.Contains(\"@\") And email.Contains(\".co";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean(".",_email.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("@")))) && RemoteObject.solveBoolean(".",_email.runMethod(true,"contains",(Object)(RemoteObject.createImmutable(".com"))))) { 
 BA.debugLineNum = 103;BA.debugLine="Return True";
Debug.ShouldStop(64);
if (true) return registro.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 105;BA.debugLine="Return False";
Debug.ShouldStop(256);
if (true) return registro.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 107;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}