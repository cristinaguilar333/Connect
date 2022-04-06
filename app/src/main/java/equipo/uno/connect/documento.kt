package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class documento : AppCompatActivity() {
    val volver : ImageButton = findViewById(R.id.btnVolver3)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_documento)

        volver.setOnClickListener{
            var intent : Intent = Intent(this,chatIndividual::class.java)
            startActivity(intent)
        }
    }
}