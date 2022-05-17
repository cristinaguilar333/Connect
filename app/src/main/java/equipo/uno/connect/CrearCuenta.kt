package equipo.uno.connect

import android.Manifest
import android.app.ProgressDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import equipo.uno.connect.data.User
import equipo.uno.connect.databinding.ActivityCrearCuentaBinding
import equipo.uno.connect.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_crear_cuenta.*
import java.io.IOException
import java.util.*

class CrearCuenta : AppCompatActivity() {

    private lateinit var binding : ActivityCrearCuentaBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var databaseReference : DatabaseReference
    private lateinit var imageUri : Uri
    private lateinit var bin : ActivityCrearCuentaBinding
    private var filePath: Uri? =null
    private var PICK_IMAGE_REQUEST=1234

    internal var storage:FirebaseStorage?=null
    internal var storageReference:StorageReference?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityCrearCuentaBinding.inflate(layoutInflater)
         setContentView(R.layout.activity_crear_cuenta)//setContentView(binding.root)

        /**
         * if((ContextCompat.checkSelfPermission(this,
        Manifest.permission.READ_EXTERNAL_STORAGE) !=
        PackageManager.PERMISSION_GRANTED
        )|| (ContextCompat.checkSelfPermission(this,
        Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
        PackageManager.PERMISSION_GRANTED
        ) || (ContextCompat.checkSelfPermission(this, Manifest.permission.MANAGE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)){
        ActivityCompat.requestPermissions(
        this,
        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.MANAGE_EXTERNAL_STORAGE), 123
        )
        }
          */

        //auth = FirebaseAuth.getInstance()

        //val uid = auth.currentUser?.uid
        //databaseReference = FirebaseDatabase.getInstance().getReference("connect")
        val imageButton : ImageButton = findViewById(R.id.imageButton2)
        val empezar : Button = findViewById(R.id.btnEmpezar)
        imageButton.setOnClickListener{
            seleccionarImagen()

        }
        //binding.btnEmpezar.setOnClickListener {
           // val nombre = binding.etUsuario2.text.toString()

            //val user = User(nombre)
            //if(uid != null){
              //  databaseReference.child(uid).setValue(user).addOnCompleteListener {

                   // if(it.isSuccessful){
                    //    cargarImagen()
                   // }else{
                     //   Toast.makeText(this@CrearCuenta, "No se pudo guardar la foto de perfil", Toast.LENGTH_SHORT).show()
                   // }
               // }
           // }
        //}

        val btnComienza : Button = findViewById(R.id.btnEmpezar)

        btnComienza.setOnClickListener {
            var intent : Intent = Intent(this, ChatActivity::class.java)
            intent.putExtra("nombreUsuario", etUsuario2.text.toString())
            startActivity(intent)
        }
    }

    private fun seleccionarImagen() {
        val intent=Intent()
        intent.type="image/"
        intent.action=Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent,"SELECT PICTURE"),PICK_IMAGE_REQUEST)
        //val intent = Intent()
        //intent.type = "images/*"
        //intent.action = Intent.ACTION_GET_CONTENT

        //startActivityForResult(intent, 100)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== RESULT_OK){
            try {
                val bitmap= MediaStore.Images.Media.getBitmap(contentResolver,filePath)
                //imageView!!.setImageBitmap(bitmap)
            }catch(e: IOException){
                e.printStackTrace()
            }
        }

        //if (requestCode == 100 && resultCode == RESULT_OK){
          //  imageUri = data?.data!!
            //bin.profileImage.setImageURI(imageUri)
        //}

    }

    fun onclick(view: View) {
        cargarImagen()
    }

    private fun cargarImagen(){
        if(filePath!=null) {
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Cargando...")
            progressDialog.show()

            val imageRef=storageReference!!.child("image/"+ UUID.randomUUID().toString())
            imageRef.putFile(filePath!!)
                .addOnSuccessListener {
                    progressDialog.dismiss()
                    Toast.makeText(applicationContext,"File Upload",Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{
                    progressDialog.dismiss()
                    Toast.makeText(applicationContext,"Failded",Toast.LENGTH_SHORT).show()
                }
                .addOnProgressListener {taskSnapShop->
                    val progress=100.0*taskSnapShop.bytesTransferred/taskSnapShop.totalByteCount
                    progressDialog.setMessage("Uploaded"+progress.toInt()+"%...")
                }
        }
       // imageUri = Uri.parse("android.resource://$packageName/${R.drawable.profile}")
        //storageReference = FirebaseStorage.getInstance().getReference("connect/"+auth.currentUser?.uid)
        //storageReference.putFile(imageUri).addOnSuccessListener {
          //  Toast.makeText(this@CrearCuenta, "Foto de perfil guardada", Toast.LENGTH_SHORT).show()
        //}.addOnFailureListener{
          //  Toast.makeText(this@CrearCuenta, "No se pudo guardar la foto de perfil", Toast.LENGTH_SHORT).show()
        //}
    }
}