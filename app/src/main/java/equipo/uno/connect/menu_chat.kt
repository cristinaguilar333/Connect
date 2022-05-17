package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_menu_chat.*

class menu_chat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_chat)

        val volver : ImageButton = findViewById(R.id.btnVolverMenu)
        val multimedia1 : Button = findViewById(R.id.multimedia1)
        val multimedia2 : Button = findViewById(R.id.multimedia2)
        val multimedia3 : Button = findViewById(R.id.multimedia3)
        nombrechat.setText("María")

        val doc1 : Button = findViewById(R.id.doc1)
        val doc2 : Button = findViewById(R.id.doc2)
        val doc3 : Button = findViewById(R.id.doc3)

        val pizarra : TextView = findViewById(R.id.pizarra)
        val btnpizarra : ImageButton = findViewById(R.id.btnPizarra)

        val notas : TextView = findViewById(R.id.notarapida)
        val btnnotas : ImageButton = findViewById(R.id.btnNotas)

        val encuesta : TextView = findViewById(R.id.encuesta)
        val btnencuesta : ImageButton = findViewById(R.id.btnEncuesta)

        encuesta.setOnClickListener{
            var intent : Intent = Intent(this,EncuestasRapidasActivity::class.java)
            startActivity(intent)
        }

        btnencuesta.setOnClickListener{
            var intent : Intent = Intent(this,EncuestasRapidasActivity::class.java)
            startActivity(intent)
        }

        notas.setOnClickListener{
            var intent : Intent = Intent(this,NotasRapidasActivity::class.java)
            intent.putExtra("nombre", "María")
            startActivity(intent)
        }

        btnnotas.setOnClickListener{
            var intent : Intent = Intent(this,NotasRapidasActivity::class.java)
            startActivity(intent)
        }

        pizarra.setOnClickListener{
            var intent : Intent = Intent(this,PizarraVirtualActivity::class.java)
            startActivity(intent)
        }

        btnpizarra.setOnClickListener{
            var intent : Intent = Intent(this,PizarraVirtualActivity::class.java)
            startActivity(intent)
        }

        volver.setOnClickListener{
            var intent : Intent = Intent(this,chatIndividual::class.java)
            startActivity(intent)
        }

        multimedia1.setOnClickListener{
            var intent : Intent = Intent(this,MultimediaActivity::class.java)
            startActivity(intent)
        }
        multimedia2.setOnClickListener{
            var intent : Intent = Intent(this,MultimediaActivity::class.java)
            startActivity(intent)
        }
        multimedia3.setOnClickListener{
            var intent : Intent = Intent(this,MultimediaActivity::class.java)
            startActivity(intent)
        }

        doc1.setOnClickListener{
            var intent : Intent = Intent(this,documento::class.java)
            startActivity(intent)
        }
        doc2.setOnClickListener{
            var intent : Intent = Intent(this,documento::class.java)
            startActivity(intent)
        }
        doc3.setOnClickListener{
            var intent : Intent = Intent(this,documento::class.java)
            startActivity(intent)
        }
    }
}