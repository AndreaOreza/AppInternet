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
	Dim URL As String
	Dim updatedata As HttpJob
	
	Dim txtContraseña As EditText
	Dim txtConfirmar As EditText
	Private ImageView1 As ImageView
	Private ImageView2 As ImageView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("updatepass")
	URL="http://192.168.1.69/PHP/login.php"
	
	txtContraseña.PasswordMode = True
	ImageView1.SetBackgroundImage(LoadBitmap(File.DirAssets, "password_hidden.png"))
	
	txtConfirmar.PasswordMode= True
	ImageView2.SetBackgroundImage(LoadBitmap(File.DirAssets, "password_hidden.png"))

End Sub

Sub ImageView1_Click
	If ImageView1.Tag = "oculto" Then
		txtContraseña.PasswordMode = False
		ImageView1.Tag = "visible"
		ImageView1.SetBackgroundImage(LoadBitmap(File.DirAssets, "password_visible.png"))
	Else
		txtContraseña.PasswordMode = True
		ImageView1.Tag = "oculto"
		ImageView1.SetBackgroundImage(LoadBitmap(File.DirAssets, "password_hidden.png"))
	End If
End Sub

Sub ImageView2_Click
	If ImageView2.Tag = "oculto" Then
		txtConfirmar.PasswordMode = False
		ImageView2.Tag = "visible"
		ImageView2.SetBackgroundImage(LoadBitmap(File.DirAssets, "password_visible.png"))
	Else
		txtConfirmar.PasswordMode = True
		ImageView2.Tag = "oculto"
		ImageView2.SetBackgroundImage(LoadBitmap(File.DirAssets, "password_hidden.png"))
	End If
End Sub
Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub btnIniciar_Click
If(txtContraseña.Text == txtConfirmar.Text) Then
	'If para que la contraseña contenga al menos 8 caracteres
		If txtContraseña.Text.Length >= 8 Then
			updatedata.Initialize("updatedata", Me)
			updatedata.PostString(URL,"updatePas&UsuarioID="&Welcome.idUser&"&Contrasena="&txtConfirmar.Text)
		Else
			ToastMessageShow("La contraseña debe tener al menos 8 caracteres", False)
		End If
	Else
		ToastMessageShow("Las contraseñas no coinciden", False)
	End If
	
	
End Sub

Sub JobDone (job As HttpJob)
	Select job
		Case updatedata
			If job.Success Then
				'success message
				ToastMessageShow("Contraseña Actualizado",False)
				txtConfirmar.Text = ""
				txtContraseña.Text = ""
				ToastMessageShow("Se cerro la sesión",False)
				Activity.Finish
				StartActivity(Main)
			Else
				ToastMessageShow("Verificar la Conexión",False)
			End If
			updatedata.Release
	End Select
End Sub

Private Sub lblBack_Click
	Activity.Finish
	StartActivity(Welcome)
End Sub