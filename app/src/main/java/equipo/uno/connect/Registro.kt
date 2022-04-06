package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val btncrearCuenta : Button = findViewById(R.id.btnCrearCuenta)
        val btnIniciaSesion : Button = findViewById(R.id.btnIniciaSesion)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)



        btncrearCuenta.setOnClickListener {
            var intent:Intent = Intent(this, CrearCuenta::class.java)
            startActivity(intent)
        }

        btnIniciaSesion.setOnClickListener {
            var intent:Intent = Intent(this, activity_iniciosesion::class.java)
            startActivity(intent)
        }
    }
}