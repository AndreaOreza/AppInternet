B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=12.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Dim updatedata As HttpJob
	Dim txtCorreo As EditText
	Dim URL As String
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("UpdateV")
	URL="http://192.168.1.69/PHP/login.php"
End Sub

Sub validarcorreo(email As String) As Boolean
	If email.Contains("@") And email.Contains(".com") Then
		Return True
	Else
		Return False
	End If
End Sub

Private Sub btnIniciar_Click
	If validarcorreo(txtCorreo.Text) Then
		updatedata.Initialize("updatedata", Me)
		updatedata.PostString(URL,"actualizar&UsuarioID="&Welcome.idUser&"&Correo="&txtCorreo.Text)
	Else
		ToastMessageShow("Correo electrónico no válido", False)
	End If
End Sub

Sub JobDone (job As HttpJob)
	Select job
		Case updatedata
			If job.Success Then
				'success message
				ToastMessageShow("Correo Actualizado",False)
				Welcome.CorreoW = txtCorreo.Text
				txtCorreo.Text = ""
			Else
				ToastMessageShow("Verificar la Conexión",False)
			End If
				
			updatedata.Release
	End Select
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub lblBack_Click
	Activity.Finish
	StartActivity(Welcome)
End Sub