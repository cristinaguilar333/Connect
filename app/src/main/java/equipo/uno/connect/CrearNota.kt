package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class CrearNota : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_nota)


        val volver : TextView = findViewById(R.id.btnCancelar)
        volver.setOnClickListener{
            var intent : Intent = Intent(this,NotasRapidasActivity::class.java)
            startActivity(intent)
        }
    }
}