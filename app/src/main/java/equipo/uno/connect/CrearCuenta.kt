package equipo.uno.connect

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import equipo.uno.connect.data.User
import equipo.uno.connect.databinding.ActivityCrearCuentaBinding
import equipo.uno.connect.databinding.ActivityMainBinding

class CrearCuenta : AppCompatActivity() {

    private lateinit var binding : ActivityCrearCuentaBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var databaseReference : DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var imageUri : Uri
    private lateinit var bin : ActivityCrearCuentaBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearCuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("connect")

        binding.imageButton2.setOnClickListener{
            seleccionarImagen()

        }
        binding.btnEmpezar.setOnClickListener {
            val nombre = binding.etUsuario2.text.toString()

            val user = User(nombre)
            if(uid != null){
                databaseReference.child(uid).setValue(user).addOnCompleteListener {

                    if(it.isSuccessful){
                        cargarImagen()
                    }else{
                        Toast.makeText(this@CrearCuenta, "No se pudo guardar la foto de perfil", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        val btnComienza : Button = findViewById(R.id.btnEmpezar)

        btnComienza.setOnClickListener {
            var intent : Intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }
    }

    private fun seleccionarImagen() {
        val intent = Intent()
        intent.type = "images/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(intent, 100)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK){
            imageUri = data?.data!!
            bin.profileImage.setImageURI(imageUri)
        }

    }

    fun onclick(view: View) {
        cargarImagen()
    }

    private fun cargarImagen(){
        imageUri = Uri.parse("android.resource://$packageName/${R.drawable.profile}")
        storageReference = FirebaseStorage.getInstance().getReference("connect/"+auth.currentUser?.uid)
        storageReference.putFile(imageUri).addOnSuccessListener {
            Toast.makeText(this@CrearCuenta, "Foto de perfil guardada", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this@CrearCuenta, "No se pudo guardar la foto de perfil", Toast.LENGTH_SHORT).show()
        }
    }
}