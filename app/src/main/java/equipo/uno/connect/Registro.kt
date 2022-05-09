package equipo.uno.connect

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Registro : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        auth = Firebase.auth

        val btncrearCuenta : Button = findViewById(R.id.btnCrearCuenta)
        val btnIniciaSesion : Button = findViewById(R.id.btnIniciaSesion)

        btncrearCuenta.setOnClickListener {

            val mEmail= findViewById<TextView>(R.id.etEmailRegistro).text.toString()
            val mPassword = findViewById<TextView>(R.id.etPasswordRegistro).text.toString()
            when {
                mEmail == "" || mPassword == "" -> {
                    Toast.makeText(
                        baseContext, "Favor de llenar todos los campos",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    createAccount(mEmail, mPassword)
                }
            }

        }

        btnIniciaSesion.setOnClickListener {
            var intent:Intent = Intent(this, InicioSesionActivity::class.java)
            startActivity(intent)
        }
    }
    private fun createAccount(email: String, password:String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.w(ContentValues.TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Usuario creado exitosamente",
                        Toast.LENGTH_SHORT).show()
                    var intent:Intent = Intent(this, CrearCuenta::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(ContentValues.TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Usuario creado de manera fallida",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}