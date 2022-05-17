package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_perfil.*

class perfil : AppCompatActivity() {


    lateinit var volver : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nombreUsuario = intent.getStringExtra("nombreUsuario")

        etUsuario.setText(nombreUsuario.toString())

        volver = findViewById(R.id.btnVolver)

        volver.setOnClickListener{
            var intent : Intent = Intent(this,ChatActivity::class.java)
            startActivity(intent)
        }
    }


}