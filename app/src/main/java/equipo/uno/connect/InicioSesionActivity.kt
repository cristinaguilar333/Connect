package equipo.uno.connect

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class InicioSesionActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciosesion)
        auth = Firebase.auth

        val iniciar : Button = findViewById(R.id.btnEntrar)

        iniciar.setOnClickListener{
            val mEmail= findViewById<TextView>(R.id.etEmail).text.toString()
            val mPassword = findViewById<TextView>(R.id.etPassword).text.toString()
            when {
                mEmail == "" || mPassword == "" -> {
                    Toast.makeText(
                        baseContext, "Mail o contraseña incorrecta.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    SignIn(mEmail, mPassword)
                }
            }
        }
    }
    private fun SignIn(email:String, password:String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(ContentValues.TAG, "signInWithEmail:success")
                    //val user = auth.currentUser
                    //updateUI(user)
                    Toast.makeText(baseContext, "Conectado exitosamente.",
                        Toast.LENGTH_SHORT).show()
                    var intent : Intent = Intent(this, ChatActivity::class.java)
                    startActivity(intent)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(ContentValues.TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }

    }

}