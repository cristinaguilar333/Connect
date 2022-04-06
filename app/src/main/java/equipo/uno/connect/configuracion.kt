package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class configuracion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)

        val volver : ImageButton = findViewById(R.id.btnVolver2)

        volver.setOnClickListener{
            var intent : Intent = Intent(this,ChatActivity::class.java)
            startActivity(intent)
        }
    }
}