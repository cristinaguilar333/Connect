package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class menu_chat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val volver : ImageButton = findViewById(R.id.btnVolverMenupuntos)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_chat)

        volver.setOnClickListener{
            var intent : Intent = Intent(this,chatIndividual::class.java)
            startActivity(intent)
        }
    }
}