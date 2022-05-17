package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import equipo.uno.connect.databinding.ActivityNotasRapidasBinding
import kotlinx.android.synthetic.main.activity_notas_rapidas.*

class NotasRapidasActivity : AppCompatActivity() {
    public final var REQUEST_CODE_NOTE: Int = 1
    private val notaRef = FirebaseDatabase.getInstance().getReference("connect")
    private lateinit var empRecyclerView : RecyclerView
    private lateinit var  tvLoadingData : TextView
    lateinit var binding: ActivityNotasRapidasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas_rapidas)

        empRecyclerView = findViewById(R.id.rv_notas)





        val addNote: ImageButton = findViewById(R.id.btn_AgregarNotaRapida)
        addNote.setOnClickListener {
            var intent: Intent = Intent(this, CrearNota::class.java)
            startActivity(intent)
        }


     //   notaRef.addChildEventListener(object : ChildEventListener {
       //     override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
         //       val nota = dataSnapshot.getValue(Nota::class.java)
           //     if (nota != null) {
             //       writeMark(nota)
               // }
            //}

         //   override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
          //  override fun onChildRemoved(snapshot: DataSnapshot) {}
          //  override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
          //  override fun onCancelled(error: DatabaseError) {}

       // })


        val volver: ImageButton = findViewById(R.id.btnVolverNotas)
        volver.setOnClickListener {
            var intent: Intent = Intent(this, menu_chat::class.java)
            startActivity(intent)
        }
    }



}