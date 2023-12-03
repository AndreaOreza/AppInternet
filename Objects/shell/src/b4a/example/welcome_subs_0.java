package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class welcome_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (welcome) ","welcome",1,welcome.mostCurrent.activityBA,welcome.mostCurrent,36);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.welcome.remoteMe.runUserSub(false, "welcome","activity_create", _firsttime);}
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 36;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="Activity.LoadLayout(\"welcome\")";
Debug.ShouldStop(16);
welcome.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("welcome")),welcome.mostCurrent.activityBA);
 BA.debugLineNum = 38;BA.debugLine="Panel2.Left = -250dip";
Debug.ShouldStop(32);
welcome.mostCurrent._panel2.runMethod(true,"setLeft",BA.numberCast(int.class, -(double) (0 + welcome.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250))).<Integer>get().intValue())));
 BA.debugLineNum = 39;BA.debugLine="Panel3.Color = Colors.Transparent";
Debug.ShouldStop(64);
welcome.mostCurrent._panel3.runVoidMethod ("setColor",welcome.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 40;BA.debugLine="ImageChooser.Initialize(\"ImageChooser\")";
Debug.ShouldStop(128);
welcome.mostCurrent._imagechooser.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("ImageChooser")));
 BA.debugLineNum = 42;BA.debugLine="Dim job As HttpJob";
Debug.ShouldStop(512);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("job", _job);
 BA.debugLineNum = 43;BA.debugLine="URL = \"http://192.168.1.69/PHP/login.php\"";
Debug.ShouldStop(1024);
welcome.mostCurrent._url = BA.ObjectToString("http://192.168.1.69/PHP/login.php");
 BA.debugLineNum = 44;BA.debugLine="job.Initialize(\"\", Me)";
Debug.ShouldStop(2048);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,welcome.processBA,(Object)(BA.ObjectToString("")),(Object)(welcome.getObject()));
 BA.debugLineNum = 45;BA.debugLine="job.PostString(URL, \"buscar&Correo=\" & CorreoW)";
Debug.ShouldStop(4096);
_job.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(welcome.mostCurrent._url),(Object)(RemoteObject.concat(RemoteObject.createImmutable("buscar&Correo="),welcome._correow)));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (welcome) ","welcome",1,welcome.mostCurrent.activityBA,welcome.mostCurrent,121);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.welcome.remoteMe.runUserSub(false, "welcome","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 121;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 123;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("Activity_Resume (welcome) ","welcome",1,welcome.mostCurrent.activityBA,welcome.mostCurrent,117);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.welcome.remoteMe.runUserSub(false, "welcome","activity_resume");}
 BA.debugLineNum = 117;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 119;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _bitmaptobytes(RemoteObject _bitmap) throws Exception{
try {
		Debug.PushSubsStack("BitmapToBytes (welcome) ","welcome",1,welcome.mostCurrent.activityBA,welcome.mostCurrent,71);
if (RapidSub.canDelegate("bitmaptobytes")) { return b4a.example.welcome.remoteMe.runUserSub(false, "welcome","bitmaptobytes", _bitmap);}
RemoteObject _stream = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
RemoteObject _bytearray = null;
Debug.locals.put("Bitmap", _bitmap);
 BA.debugLineNum = 71;BA.debugLine="Sub BitmapToBytes(Bitmap As Bitmap) As Byte()";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="Dim stream As OutputStream";
Debug.ShouldStop(128);
_stream = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");Debug.locals.put("stream", _stream);
 BA.debugLineNum = 73;BA.debugLine="stream.InitializeToBytesArray(0)";
Debug.ShouldStop(256);
_stream.runVoidMethod ("InitializeToBytesArray",(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 74;BA.debugLine="Bitmap.WriteToStream(stream, 100, \"PNG\")";
Debug.ShouldStop(512);
_bitmap.runVoidMethod ("WriteToStream",(Object)((_stream.getObject())),(Object)(BA.numberCast(int.class, 100)),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Bitmap.CompressFormat"),RemoteObject.createImmutable("PNG"))));
 BA.debugLineNum = 75;BA.debugLine="Dim ByteArray() As Byte";
Debug.ShouldStop(1024);
_bytearray = RemoteObject.createNewArray ("byte", new int[] {0}, new Object[]{});Debug.locals.put("ByteArray", _bytearray);
 BA.debugLineNum = 76;BA.debugLine="ByteArray = stream.ToBytesArray";
Debug.ShouldStop(2048);
_bytearray = _stream.runMethod(false,"ToBytesArray");Debug.locals.put("ByteArray", _bytearray);
 BA.debugLineNum = 77;BA.debugLine="stream.Close";
Debug.ShouldStop(4096);
_stream.runVoidMethod ("Close");
 BA.debugLineNum = 78;BA.debugLine="Return ByteArray";
Debug.ShouldStop(8192);
if (true) return _bytearray;
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnimagen_click() throws Exception{
try {
		Debug.PushSubsStack("btnimagen_Click (welcome) ","welcome",1,welcome.mostCurrent.activityBA,welcome.mostCurrent,48);
if (RapidSub.canDelegate("btnimagen_click")) { return b4a.example.welcome.remoteMe.runUserSub(false, "welcome","btnimagen_click");}
 BA.debugLineNum = 48;BA.debugLine="Sub btnimagen_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="If idUser = 0 Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",welcome._iduser,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 50;BA.debugLine="ToastMessageShow(\"Debes iniciar sesión antes de";
Debug.ShouldStop(131072);
welcome.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Debes iniciar sesión antes de cargar una imagen de perfil.")),(Object)(welcome.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 52;BA.debugLine="ImageChooser.Show(\"image/*\", \"Seleccionar imagen";
Debug.ShouldStop(524288);
welcome.mostCurrent._imagechooser.runVoidMethod ("Show",welcome.processBA,(Object)(BA.ObjectToString("image/*")),(Object)(RemoteObject.createImmutable("Seleccionar imagen de perfil")));
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
public static RemoteObject  _btnmenu_click() throws Exception{
try {
		Debug.PushSubsStack("btnMenu_Click (welcome) ","welcome",1,welcome.mostCurrent.activityBA,welcome.mostCurrent,136);
if (RapidSub.canDelegate("btnmenu_click")) { return b4a.example.welcome.remoteMe.runUserSub(false, "welcome","btnmenu_click");}
 BA.debugLineNum = 136;BA.debugLine="Private Sub btnMenu_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 137;BA.debugLine="If Panel2.Left = -250dip Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",welcome.mostCurrent._panel2.runMethod(true,"getLeft"),BA.numberCast(double.class, -(double) (0 + welcome.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250))).<Integer>get().intValue())))) { 
 BA.debugLineNum = 138;BA.debugLine="Panel2.Left = 0";
Debug.ShouldStop(512);
welcome.mostCurrent._panel2.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 }else {
 BA.debugLineNum = 140;BA.debugLine="Panel2.Left = -250dip";
Debug.ShouldStop(2048);
welcome.mostCurrent._panel2.runMethod(true,"setLeft",BA.numberCast(int.class, -(double) (0 + welcome.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250))).<Integer>get().intValue())));
 };
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnregresar_click() throws Exception{
try {
		Debug.PushSubsStack("btnRegresar_Click (welcome) ","welcome",1,welcome.mostCurrent.activityBA,welcome.mostCurrent,126);
if (RapidSub.canDelegate("btnregresar_click")) { return b4a.example.welcome.remoteMe.runUserSub(false, "welcome","btnregresar_click");}
 BA.debugLineNum = 126;BA.debugLine="Private Sub btnRegresar_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 127;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1073741824);
welcome.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 128;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(-2147483648);
welcome.mostCurrent.__c.runVoidMethod ("StartActivity",welcome.processBA,(Object)((welcome.mostCurrent._main.getObject())));
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnupdate_click() throws Exception{
try {
		Debug.PushSubsStack("btnUpdate_Click (welcome) ","welcome",1,welcome.mostCurrent.activityBA,welcome.mostCurrent,131);
if (RapidSub.canDelegate("btnupdate_click")) { return b4a.example.welcome.remoteMe.runUserSub(false, "welcome","btnupdate_click");}
 BA.debugLineNum = 131;BA.debugLine="Private Sub btnUpdate_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 132;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8);
welcome.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 133;BA.debugLine="StartActivity(Actualizar)";
Debug.ShouldStop(16);
welcome.mostCurrent.__c.runVoidMethod ("StartActivity",welcome.processBA,(Object)((welcome.mostCurrent._actualizar.getObject())));
 BA.debugLineNum = 134;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnuppass_click() throws Exception{
try {
		Debug.PushSubsStack("btnUppass_Click (welcome) ","welcome",1,welcome.mostCurrent.activityBA,welcome.mostCurrent,144);
if (RapidSub.canDelegate("btnuppass_click")) { return b4a.example.welcome.remoteMe.runUserSub(false, "welcome","btnuppass_click");}
 BA.debugLineNum = 144;BA.debugLine="Private Sub btnUppass_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 145;BA.debugLine="Activity.Finish";
Debug.ShouldStop(65536);
welcome.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 146;BA.debugLine="StartActivity(UpdatePass)";
Debug.ShouldStop(131072);
welcome.mostCurrent.__c.runVoidMethod ("StartActivity",welcome.processBA,(Object)((welcome.mostCurrent._updatepass.getObject())));
 BA.debugLineNum = 147;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 21;BA.debugLine="Dim URL As String";
welcome.mostCurrent._url = RemoteObject.createImmutable("");
 //BA.debugLineNum = 22;BA.debugLine="Dim lblCorreo As Label";
welcome.mostCurrent._lblcorreo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim lblUser As Label";
welcome.mostCurrent._lbluser = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Dim Panel1 As Panel";
welcome.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Dim Panel2 As Panel";
welcome.mostCurrent._panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Dim Panel3 As Panel";
welcome.mostCurrent._panel3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim btnMenu As Button";
welcome.mostCurrent._btnmenu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim imgUser As ImageView";
welcome.mostCurrent._imguser = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Dim btnimagen As Button";
welcome.mostCurrent._btnimagen = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Dim ImageChooser As ContentChooser";
welcome.mostCurrent._imagechooser = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.ContentChooser");
 //BA.debugLineNum = 31;BA.debugLine="Dim SelectedImage As Bitmap";
welcome.mostCurrent._selectedimage = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Dim SelectedImageBytes() As Byte";
welcome._selectedimagebytes = RemoteObject.createNewArray ("byte", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _imagechooser_result(RemoteObject _success,RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("ImageChooser_Result (welcome) ","welcome",1,welcome.mostCurrent.activityBA,welcome.mostCurrent,56);
if (RapidSub.canDelegate("imagechooser_result")) { return b4a.example.welcome.remoteMe.runUserSub(false, "welcome","imagechooser_result", _success, _dir, _filename);}
RemoteObject _inputstream1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");
Debug.locals.put("Success", _success);
Debug.locals.put("Dir", _dir);
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 56;BA.debugLine="Sub ImageChooser_Result(Success As Boolean, Dir As";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 57;BA.debugLine="If Success Then";
Debug.ShouldStop(16777216);
if (_success.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 59;BA.debugLine="Dim InputStream1 As InputStream";
Debug.ShouldStop(67108864);
_inputstream1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");Debug.locals.put("InputStream1", _inputstream1);
 BA.debugLineNum = 60;BA.debugLine="InputStream1 = File.OpenInput(Dir, FileName)";
Debug.ShouldStop(134217728);
_inputstream1 = welcome.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenInput",(Object)(_dir),(Object)(_filename));Debug.locals.put("InputStream1", _inputstream1);
 BA.debugLineNum = 61;BA.debugLine="SelectedImage.Initialize2(InputStream1)";
Debug.ShouldStop(268435456);
welcome.mostCurrent._selectedimage.runVoidMethod ("Initialize2",(Object)((_inputstream1.getObject())));
 BA.debugLineNum = 62;BA.debugLine="imgUser.Bitmap = SelectedImage";
Debug.ShouldStop(536870912);
welcome.mostCurrent._imguser.runMethod(false,"setBitmap",(welcome.mostCurrent._selectedimage.getObject()));
 BA.debugLineNum = 65;BA.debugLine="Dim SelectedImageBytes() As Byte";
Debug.ShouldStop(1);
welcome._selectedimagebytes = RemoteObject.createNewArray ("byte", new int[] {0}, new Object[]{});
 BA.debugLineNum = 66;BA.debugLine="SelectedImageBytes = BitmapToBytes(SelectedImage";
Debug.ShouldStop(2);
welcome._selectedimagebytes = _bitmaptobytes(welcome.mostCurrent._selectedimage);
 };
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("JobDone (welcome) ","welcome",1,welcome.mostCurrent.activityBA,welcome.mostCurrent,85);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.welcome.remoteMe.runUserSub(false, "welcome","jobdone", _job);}
RemoteObject _jsonresponse = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("job", _job);
 BA.debugLineNum = 85;BA.debugLine="Sub JobDone(job As HttpJob)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 86;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(2097152);
welcome.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 88;BA.debugLine="If job.Success Then";
Debug.ShouldStop(8388608);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 89;BA.debugLine="Dim jsonResponse As String";
Debug.ShouldStop(16777216);
_jsonresponse = RemoteObject.createImmutable("");Debug.locals.put("jsonResponse", _jsonresponse);
 BA.debugLineNum = 90;BA.debugLine="jsonResponse = job.GetString ' Obtiene la respue";
Debug.ShouldStop(33554432);
_jsonresponse = _job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("jsonResponse", _jsonresponse);
 BA.debugLineNum = 92;BA.debugLine="If jsonResponse = \"No existen Registros\" Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_jsonresponse,BA.ObjectToString("No existen Registros"))) { 
 BA.debugLineNum = 94;BA.debugLine="ToastMessageShow(\"No existen registros\", True)";
Debug.ShouldStop(536870912);
welcome.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No existen registros")),(Object)(welcome.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 97;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(1);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 98;BA.debugLine="parser.Initialize(jsonResponse)";
Debug.ShouldStop(2);
_parser.runVoidMethod ("Initialize",(Object)(_jsonresponse));
 BA.debugLineNum = 99;BA.debugLine="Dim root As Map";
Debug.ShouldStop(4);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("root", _root);
 BA.debugLineNum = 100;BA.debugLine="root = parser.NextObject";
Debug.ShouldStop(8);
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);
 BA.debugLineNum = 103;BA.debugLine="lblUser.Text = root.Get(\"Cuenta\")";
Debug.ShouldStop(64);
welcome.mostCurrent._lbluser.runMethod(true,"setText",BA.ObjectToCharSequence(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Cuenta"))))));
 BA.debugLineNum = 104;BA.debugLine="lblCorreo.Text = root.Get(\"Correo\")";
Debug.ShouldStop(128);
welcome.mostCurrent._lblcorreo.runMethod(true,"setText",BA.ObjectToCharSequence(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Correo"))))));
 BA.debugLineNum = 105;BA.debugLine="CorreoW = root.Get(\"Correo\")";
Debug.ShouldStop(256);
welcome._correow = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Correo")))));
 BA.debugLineNum = 106;BA.debugLine="idUser = root.Get(\"UsuarioID\") 'guarda en la va";
Debug.ShouldStop(512);
welcome._iduser = BA.numberCast(int.class, _root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("UsuarioID")))));
 };
 }else {
 BA.debugLineNum = 110;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
Debug.ShouldStop(8192);
welcome.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(welcome.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 113;BA.debugLine="job.Release";
Debug.ShouldStop(65536);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 114;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _panel3_click() throws Exception{
try {
		Debug.PushSubsStack("Panel3_Click (welcome) ","welcome",1,welcome.mostCurrent.activityBA,welcome.mostCurrent,149);
if (RapidSub.canDelegate("panel3_click")) { return b4a.example.welcome.remoteMe.runUserSub(false, "welcome","panel3_click");}
 BA.debugLineNum = 149;BA.debugLine="Private Sub Panel3_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 150;BA.debugLine="Panel2.Left = -250dip";
Debug.ShouldStop(2097152);
welcome.mostCurrent._panel2.runMethod(true,"setLeft",BA.numberCast(int.class, -(double) (0 + welcome.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250))).<Integer>get().intValue())));
 BA.debugLineNum = 151;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 12;BA.debugLine="Public idUser As Int";
welcome._iduser = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 13;BA.debugLine="Public CorreoW As String";
welcome._correow = RemoteObject.createImmutable("");
 //BA.debugLineNum = 14;BA.debugLine="Public SelectedImageUri As String";
welcome._selectedimageuri = RemoteObject.createImmutable("");
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}