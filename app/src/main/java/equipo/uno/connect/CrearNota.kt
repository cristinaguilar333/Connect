package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.database.FirebaseDatabase

class CrearNota : AppCompatActivity() {

    val database = FirebaseDatabase.getInstance()
    var ref = database.getReference("connect")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_nota)


        val volver : TextView = findViewById(R.id.btnCancelar)
        val guardar : TextView = findViewById(R.id.btnGuardarNota)

        volver.setOnClickListener{
            var intent : Intent = Intent(this,NotasRapidasActivity::class.java)
            startActivity(intent)
        }

        guardar.setOnClickListener {
            val contenido= findViewById<TextView>(R.id.etNota).text.toString()
            val titulo= findViewById<TextView>(R.id.etTituloNota).text.toString()

            createNote(contenido, titulo);

            var intent : Intent = Intent(this,NotasRapidasActivity::class.java )
            intent.putExtra("titulo", titulo)
            intent.putExtra("contenido", contenido)
            startActivity(intent)
        }

    }

    private fun createNote(contenido : String, titulo :String){
        val nota = Nota(titulo, contenido)
        ref = database.getReference().child("Nota").push()
        ref.setValue(nota)
    }


}