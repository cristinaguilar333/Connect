package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MultimediaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multimedia)

        val volver : ImageButton = findViewById(R.id.btnVolverMultimedia)
        volver.setOnClickListener{
            var intent : Intent = Intent(this,menu_chat::class.java)
            startActivity(intent)
        }
    }
}