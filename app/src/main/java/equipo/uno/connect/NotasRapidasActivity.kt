package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class NotasRapidasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas_rapidas)

        val volver : ImageButton = findViewById(R.id.btnVolverNotas)
        volver.setOnClickListener{
            var intent : Intent = Intent(this,menu_chat::class.java)
            startActivity(intent)
        }
    }
}