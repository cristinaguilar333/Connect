package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class PizarraVirtualActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizarra_virtual)

        val volver : ImageButton = findViewById(R.id.btnVolverPizarra)
        volver.setOnClickListener{
            var intent : Intent = Intent(this,menu_chat::class.java)
            startActivity(intent)
        }
    }
}