package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class NotasRapidasActivity : AppCompatActivity() {
    public final var REQUEST_CODE_NOTE : Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas_rapidas)

        val addNote : ImageButton = findViewById(R.id.btn_AgregarNotaRapida)
        addNote.setOnClickListener{
            var intent : Intent = Intent(this,CrearNota::class.java)
            startActivity(intent)
        }


        val volver : ImageButton = findViewById(R.id.btnVolverNotas)
        volver.setOnClickListener{
            var intent : Intent = Intent(this,menu_chat::class.java)
            startActivity(intent)
        }
    }
}