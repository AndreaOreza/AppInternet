B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=11.8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle:  False
#End Region

'#AdditionalRes: Main

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	
	Public idUser As Int
	Public CorreoW As String
	Public SelectedImageUri As String

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Dim URL As String
	Dim lblCorreo As Label
	Dim lblUser As Label
	Dim Panel1 As Panel
	Dim Panel2 As Panel
	Dim Panel3 As Panel
	Dim btnMenu As Button
    Dim imgUser As ImageView
	Dim btnimagen As Button
	Dim ImageChooser As ContentChooser
	Dim SelectedImage As Bitmap
	Dim SelectedImageBytes() As Byte
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("welcome")
    Panel2.Left = -250dip
	Panel3.Color = Colors.Transparent
    ImageChooser.Initialize("ImageChooser")
	
	Dim job As HttpJob
	URL = "http://192.168.1.69/PHP/login.php"
	job.Initialize("", Me)
job.PostString(URL, "buscar&Correo=" & CorreoW)
End Sub

Sub btnimagen_Click
	If idUser = 0 Then
		ToastMessageShow("Debes iniciar sesión antes de cargar una imagen de perfil.", True)
	Else
		ImageChooser.Show("image/*", "Seleccionar imagen de perfil")
	End If
End Sub

Sub ImageChooser_Result(Success As Boolean, Dir As String, FileName As String)
	If Success Then
		' Carga la imagen seleccionada en el ImageView
		Dim InputStream1 As InputStream
		InputStream1 = File.OpenInput(Dir, FileName)
		SelectedImage.Initialize2(InputStream1)
		imgUser.Bitmap = SelectedImage
        
		' Convierte la imagen en un arreglo de bytes
		Dim SelectedImageBytes() As Byte
		SelectedImageBytes = BitmapToBytes(SelectedImage)
        
	End If
End Sub

Sub BitmapToBytes(Bitmap As Bitmap) As Byte()
	Dim stream As OutputStream
	stream.InitializeToBytesArray(0)
	Bitmap.WriteToStream(stream, 100, "PNG")
	Dim ByteArray() As Byte
	ByteArray = stream.ToBytesArray
	stream.Close
	Return ByteArray
End Sub





Sub JobDone(job As HttpJob)
	ProgressDialogHide
    
	If job.Success Then
		Dim jsonResponse As String
		jsonResponse = job.GetString ' Obtiene la respuesta JSON del servidor
        
		If jsonResponse = "No existen Registros" Then
			' Maneja el caso en el que no se encontraron registros
			ToastMessageShow("No existen registros", True)
		Else
			' Parsea la respuesta JSON
			Dim parser As JSONParser
			parser.Initialize(jsonResponse)
			Dim root As Map
			root = parser.NextObject
            
			' Muestra los datos en etiquetas (labels)
			lblUser.Text = root.Get("Cuenta")
			lblCorreo.Text = root.Get("Correo")
			CorreoW = root.Get("Correo")
			idUser = root.Get("UsuarioID") 'guarda en la variable global el valor del id
		End If
	Else
		' Maneja errores en la solicitud HTTP
		ToastMessageShow("Error: " & job.ErrorMessage, True)
	End If
    
	job.Release
End Sub


Sub Activity_Resume
	
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub btnRegresar_Click
	Activity.Finish
	StartActivity(Main)
End Sub

Private Sub btnUpdate_Click
	Activity.Finish
	StartActivity(Actualizar)
End Sub

Private Sub btnMenu_Click
	If Panel2.Left = -250dip Then
		Panel2.Left = 0
	Else
		Panel2.Left = -250dip
	End If
End Sub

Private Sub btnUppass_Click
	Activity.Finish
	StartActivity(UpdatePass)
End Sub

Private Sub Panel3_Click
	Panel2.Left = -250dip
End Sub