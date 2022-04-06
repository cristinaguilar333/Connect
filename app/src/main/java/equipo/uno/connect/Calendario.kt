package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class Calendario : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)

        val accesoRapido : TextView = findViewById(R.id.tvAccesoRapido)
        val chat : TextView = findViewById(R.id.tvChat)
        val ajustes : ImageButton = findViewById(R.id.btnAjustes)
        val amigos : ImageButton = findViewById(R.id.btnAmigos)
        val perfil : ImageButton = findViewById(R.id.btnPerfil)


        accesoRapido.setOnClickListener {
            var intent : Intent = Intent(this,AccesoRapidoActivity::class.java)
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