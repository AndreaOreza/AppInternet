B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11.8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
End Sub

Sub Globals


	Dim deletedata As HttpJob
	Dim updatedata As HttpJob
	Dim readdata As HttpJob
	Dim savedata As HttpJob
	Private txtUsuario As EditText
	Private txtCorreo As EditText
	Private txtContraseña As EditText
	Private txtConfirmar As EditText
	
	Private ImageView1 As ImageView
	Private ImageView2 As ImageView
	Dim URL As String
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("Registro")
	URL="http://192.168.1.69/PHP/Registro.php"
	
	
	txtContraseña.PasswordMode = True
	ImageView1.SetBackgroundImage(LoadBitmap(File.DirAssets, "password_hidden.png"))
	
	txtConfirmar.PasswordMode= True
	ImageView2.SetBackgroundImage(LoadBitmap(File.DirAssets, "password_hidden.png"))
	
End Sub



Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

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

Private Sub btnIniciar_Click
	savedata.Initialize("savedata", Me)
    
	'If para validar que las contra sean iguales
	If(txtContraseña.Text == txtConfirmar.Text) Then
		'If para que la contraseña contenga al menos 8 caracteres
		If txtContraseña.Text.Length >= 8 Then
			' If para comprobar que el correo sea valido
			If validarcorreo(txtCorreo.Text) Then
				'Para saber si el usuario existe
				Dim consulta As String
				consulta = "check&Usuario=" & txtUsuario.Text & "&Correo=" & txtCorreo.Text
				savedata.PostString(URL, consulta)
			Else
				ToastMessageShow("Correo electrónico no válido", False)
			End If
		Else
			ToastMessageShow("La contraseña debe tener al menos 8 caracteres", False)
		End If
	Else
		ToastMessageShow("Las contraseñas no coinciden", False)
	End If
	
	
End Sub

Sub validarcorreo(email As String) As Boolean
    If email.Contains("@") And email.Contains(".com") Then
        Return True
    Else
     Return False
    End If
	End Sub 
Sub lblBack_Click
	Activity.Finish
End Sub
Sub JobDone (job As HttpJob)
	Select job
	
		Case savedata
			If job.Success Then
				Dim respuesta As String
				respuesta = job.GetString

				If respuesta = "EXISTE" Then
					ToastMessageShow("El usuario o correo ya existen", False)
					Else If respuesta = "NO_EXISTE" Then
					Dim consultaGuardar As String
					consultaGuardar = "save&Cuenta=" & txtUsuario.Text & "&Contrasena=" & txtContraseña.Text & "&Correo=" & txtCorreo.Text
					ToastMessageShow("Registro Guardado",False)
					'Limpiar los text
					txtUsuario.Text=""
					txtContraseña.Text = ""
					txtCorreo.Text = ""
					txtConfirmar.Text = ""
					savedata.PostString(URL, consultaGuardar)
				Else
					
				End If
			Else
				ToastMessageShow("Verificar la Conexión", False)
			End If
			savedata.Release
			' ...
			savedata.Release
			'fetch data
		Case readdata
			If job.Success Then
				
				
				' check if their is data from response
				If job.GetString.Length < 1 Then
					'No data message
					ToastMessageShow("No existen Registros",False)
					Return
				End If
				'success message
				ToastMessageShow("Registros",False)
				'set editText value to the one fetched from database
				'EditText1.Text=job.GetString
				'prevData= EditText1.Text
			Else
				   
				ToastMessageShow("Verificar la Conexión",False)
			End If
				
			readdata.Release
			
			'update data
		Case updatedata
			If job.Success Then
				'success message
				ToastMessageShow("Registro Actualizado",False)
			Else
				   
				ToastMessageShow("Verificar la Conexión",False)
			End If
				
			updatedata.Release
			'delete data
		Case deletedata
			If job.Success Then
				'success message
				ToastMessageShow("Registro Eliminado",False)
			Else
				   
				ToastMessageShow("Verificar la Conexión",False)
			End If
				
			deletedata.Release
	End Select
End Sub