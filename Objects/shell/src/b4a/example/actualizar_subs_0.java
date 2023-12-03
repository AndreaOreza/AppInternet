package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class actualizar_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (actualizar) ","actualizar",4,actualizar.mostCurrent.activityBA,actualizar.mostCurrent,21);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.actualizar.remoteMe.runUserSub(false, "actualizar","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 21;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 22;BA.debugLine="Activity.LoadLayout(\"UpdateV\")";
Debug.ShouldStop(2097152);
actualizar.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("UpdateV")),actualizar.mostCurrent.activityBA);
 BA.debugLineNum = 23;BA.debugLine="URL=\"http://192.168.1.69/PHP/login.php\"";
Debug.ShouldStop(4194304);
actualizar.mostCurrent._url = BA.ObjectToString("http://192.168.1.69/PHP/login.php");
 BA.debugLineNum = 24;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Activity_Pause (actualizar) ","actualizar",4,actualizar.mostCurrent.activityBA,actualizar.mostCurrent,63);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.actualizar.remoteMe.runUserSub(false, "actualizar","activity_pause", _userclosed);}
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
		Debug.PushSubsStack("Activity_Resume (actualizar) ","actualizar",4,actualizar.mostCurrent.activityBA,actualizar.mostCurrent,59);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.actualizar.remoteMe.runUserSub(false, "actualizar","activity_resume");}
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
		Debug.PushSubsStack("btnIniciar_Click (actualizar) ","actualizar",4,actualizar.mostCurrent.activityBA,actualizar.mostCurrent,34);
if (RapidSub.canDelegate("btniniciar_click")) { return b4a.example.actualizar.remoteMe.runUserSub(false, "actualizar","btniniciar_click");}
 BA.debugLineNum = 34;BA.debugLine="Private Sub btnIniciar_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 35;BA.debugLine="If validarcorreo(txtCorreo.Text) Then";
Debug.ShouldStop(4);
if (_validarcorreo(actualizar.mostCurrent._txtcorreo.runMethod(true,"getText")).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 36;BA.debugLine="updatedata.Initialize(\"updatedata\", Me)";
Debug.ShouldStop(8);
actualizar.mostCurrent._updatedata.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,actualizar.processBA,(Object)(BA.ObjectToString("updatedata")),(Object)(actualizar.getObject()));
 BA.debugLineNum = 37;BA.debugLine="updatedata.PostString(URL,\"actualizar&UsuarioID=";
Debug.ShouldStop(16);
actualizar.mostCurrent._updatedata.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(actualizar.mostCurrent._url),(Object)(RemoteObject.concat(RemoteObject.createImmutable("actualizar&UsuarioID="),actualizar.mostCurrent._welcome._iduser /*RemoteObject*/ ,RemoteObject.createImmutable("&Correo="),actualizar.mostCurrent._txtcorreo.runMethod(true,"getText"))));
 }else {
 BA.debugLineNum = 39;BA.debugLine="ToastMessageShow(\"Correo electrónico no válido\",";
Debug.ShouldStop(64);
actualizar.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Correo electrónico no válido")),(Object)(actualizar.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
 //BA.debugLineNum = 15;BA.debugLine="Dim updatedata As HttpJob";
actualizar.mostCurrent._updatedata = RemoteObject.createNew ("b4a.example.httpjob");
 //BA.debugLineNum = 16;BA.debugLine="Dim txtCorreo As EditText";
actualizar.mostCurrent._txtcorreo = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim URL As String";
actualizar.mostCurrent._url = RemoteObject.createImmutable("");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (actualizar) ","actualizar",4,actualizar.mostCurrent.activityBA,actualizar.mostCurrent,43);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.actualizar.remoteMe.runUserSub(false, "actualizar","jobdone", _job);}
Debug.locals.put("job", _job);
 BA.debugLineNum = 43;BA.debugLine="Sub JobDone (job As HttpJob)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="Select job";
Debug.ShouldStop(2048);
switch (BA.switchObjectToInt(_job,actualizar.mostCurrent._updatedata)) {
case 0: {
 BA.debugLineNum = 46;BA.debugLine="If job.Success Then";
Debug.ShouldStop(8192);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 48;BA.debugLine="ToastMessageShow(\"Correo Actualizado\",False)";
Debug.ShouldStop(32768);
actualizar.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Correo Actualizado")),(Object)(actualizar.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 49;BA.debugLine="Welcome.CorreoW = txtCorreo.Text";
Debug.ShouldStop(65536);
actualizar.mostCurrent._welcome._correow /*RemoteObject*/  = actualizar.mostCurrent._txtcorreo.runMethod(true,"getText");
 BA.debugLineNum = 50;BA.debugLine="txtCorreo.Text = \"\"";
Debug.ShouldStop(131072);
actualizar.mostCurrent._txtcorreo.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 }else {
 BA.debugLineNum = 52;BA.debugLine="ToastMessageShow(\"Verificar la Conexión\",False";
Debug.ShouldStop(524288);
actualizar.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Verificar la Conexión")),(Object)(actualizar.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 55;BA.debugLine="updatedata.Release";
Debug.ShouldStop(4194304);
actualizar.mostCurrent._updatedata.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 break; }
}
;
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("lblBack_Click (actualizar) ","actualizar",4,actualizar.mostCurrent.activityBA,actualizar.mostCurrent,67);
if (RapidSub.canDelegate("lblback_click")) { return b4a.example.actualizar.remoteMe.runUserSub(false, "actualizar","lblback_click");}
 BA.debugLineNum = 67;BA.debugLine="Private Sub lblBack_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8);
actualizar.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 69;BA.debugLine="StartActivity(Welcome)";
Debug.ShouldStop(16);
actualizar.mostCurrent.__c.runVoidMethod ("StartActivity",actualizar.processBA,(Object)((actualizar.mostCurrent._welcome.getObject())));
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
public static RemoteObject  _validarcorreo(RemoteObject _email) throws Exception{
try {
		Debug.PushSubsStack("validarcorreo (actualizar) ","actualizar",4,actualizar.mostCurrent.activityBA,actualizar.mostCurrent,26);
if (RapidSub.canDelegate("validarcorreo")) { return b4a.example.actualizar.remoteMe.runUserSub(false, "actualizar","validarcorreo", _email);}
Debug.locals.put("email", _email);
 BA.debugLineNum = 26;BA.debugLine="Sub validarcorreo(email As String) As Boolean";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 27;BA.debugLine="If email.Contains(\"@\") And email.Contains(\".com\")";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean(".",_email.runMethod(true,"contains",(Object)(RemoteObject.createImmutable("@")))) && RemoteObject.solveBoolean(".",_email.runMethod(true,"contains",(Object)(RemoteObject.createImmutable(".com"))))) { 
 BA.debugLineNum = 28;BA.debugLine="Return True";
Debug.ShouldStop(134217728);
if (true) return actualizar.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 30;BA.debugLine="Return False";
Debug.ShouldStop(536870912);
if (true) return actualizar.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}