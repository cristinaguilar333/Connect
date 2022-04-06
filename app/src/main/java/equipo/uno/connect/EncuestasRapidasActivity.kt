package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class EncuestasRapidasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encuestas_rapidas)

        val volver : ImageButton = findViewById(R.id.btnVolverEncuesta)
        volver.setOnClickListener{
            var intent : Intent = Intent(this,menu_chat::class.java)
            startActivity(intent)
        }
    }
}