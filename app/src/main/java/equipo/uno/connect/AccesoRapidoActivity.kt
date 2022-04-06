package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class AccesoRapidoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acceso_rapido)

        val chat : TextView = findViewById(R.id.tvChat)
        val calendario: TextView = findViewById(R.id.tvCalendario)
        val ajustes : ImageButton = findViewById(R.id.btnAjustes)
        val amigos : ImageButton = findViewById(R.id.btnAmigos)
        val perfil : ImageButton = findViewById(R.id.btnPerfil)


        calendario.setOnClickListener {
            var intent : Intent = Intent(this, Calendario::class.java)
            startActivity(intent)
        }

        chat.setOnClickListener {
            var intent : Intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }

        ajustes.setOnClickListener {
            var intent :Intent = Intent(this, configuracion::class.java)
            startActivity(intent)
        }

        amigos.setOnClickListener {
            var intent : Intent = Intent(this, AmigosActivity::class.java)
            startActivity(intent)
        }

        perfil.setOnClickListener {
            var intent : Intent = Intent(this, perfil::class.java)
            startActivity(intent)
        }

    }
}