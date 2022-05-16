package equipo.uno.connect

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import equipo.uno.connect.data.Message
import equipo.uno.connect.databinding.ActivityChatIndividualBinding
import equipo.uno.connect.databinding.ActivityCrearCuentaBinding
import equipo.uno.connect.ui.MessagingAdapter
import equipo.uno.connect.utils.BotResponse
import equipo.uno.connect.utils.Constants.RECEIVE_ID
import equipo.uno.connect.utils.Constants.SEND_ID
import kotlinx.android.synthetic.main.activity_chat_individual.*
import kotlinx.android.synthetic.main.activity_menu_chat.*
import kotlinx.coroutines.*
import java.sql.Time
import java.util.*


class chatIndividual : AppCompatActivity() {

    private lateinit var storageReference: StorageReference
    private lateinit var imageUri : Uri

    private lateinit var binding : ActivityChatIndividualBinding

    private val TAG = "chatIndividual"
    var messagesList = mutableListOf<Message>()

    private lateinit var adapter:MessagingAdapter
    private val botList = listOf("Peter", "Francesca", "Luigi","Igor")

    //AAAAA
    private lateinit var auth: FirebaseAuth


    val database = FirebaseDatabase.getInstance()
    var ref = database.getReference("connect")
    ///

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_individual)

        binding = ActivityChatIndividualBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnImagen.setOnClickListener{
            seleccionarImagen()

        }

        recyclerView()
        clickEvents()

        auth = Firebase.auth

        val random = (0..3).random()
        customBotMessage("Hola! estas hablando con ${botList[random]}, en que te ayudo?")


        val volver : ImageButton = findViewById(R.id.btnVolver1)
        val btnEnviar : ImageButton = findViewById(R.id.btnEnviar)
        val etMessage : EditText = findViewById(R.id.etMessage)
        val rv_messages : RecyclerView= findViewById(R.id.rv_messages)
        val btnmenupuntos : ImageButton = findViewById(R.id.btnmenupuntos)

        btnmenupuntos.setOnClickListener {
            var intent : Intent = Intent(this, menu_chat::class.java)
            startActivity(intent)
        }

        volver.setOnClickListener{
            var intent : Intent = Intent(this,ChatActivity::class.java)
            startActivity(intent)
        }

        ///aaaaa
        btnEnviar.setOnClickListener{
            val contenido= findViewById<TextView>(R.id.etMessage).text.toString()

            createMensaje(contenido);

        }

    }

    ///images

    private fun seleccionarImagen() {
        val intent = Intent()
        intent.type = "images/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(intent, 100)

    }

    fun onclick(view: View) {
        cargarImagen()
    }

    private fun cargarImagen(){
        imageUri = Uri.parse("android.resource://$packageName/${R.drawable.send_round_box}")
        storageReference = FirebaseStorage.getInstance().getReference("connect/"+auth.currentUser?.uid)
        storageReference.putFile(imageUri).addOnSuccessListener {
            Toast.makeText(this@chatIndividual, "Imagen enviada", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this@chatIndividual, "No se pudo enviar enviar la imagen", Toast.LENGTH_SHORT).show()
        }
    }

    ///images

    private fun clickEvents(){
        btnEnviar.setOnClickListener{
            sendMessage()
        }

        etMessage.setOnClickListener{
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main){
                   rv_messages.scrollToPosition(adapter.itemCount - 1)
                }
            }
        }
    }

    private fun recyclerView(){
        adapter = MessagingAdapter()
        //rv_messages.adapter = adapter
        //rv_messages.layoutManager = LinearLayoutManager(applicationContext)


        rv_messages.adapter = adapter

        rv_messages.layoutManager = LinearLayoutManager(applicationContext)
    }

    override fun onStart(){
        super.onStart()

        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main){
                rv_messages.scrollToPosition(adapter.itemCount-1)
            }
        }
    }

    private fun sendMessage(){
        val message = etMessage.text.toString()
        val timeStamp = equipo.uno.connect.utils.Time.timeStamp()

        if(message.isNotEmpty()){

            messagesList.add(Message(message, SEND_ID, timeStamp))
            etMessage.setText("")

            adapter.insertMessage(Message(message, SEND_ID, timeStamp))
            rv_messages.scrollToPosition(adapter.itemCount-1)

            botResponse(message)

        }
    }

    private fun botResponse(message:String){
        val timeStamp = equipo.uno.connect.utils.Time.timeStamp()
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main){
                val responde = BotResponse.basicResponse(message)
                //agregar a la lista de mensajes
                messagesList.add(Message(message, RECEIVE_ID, timeStamp))
                //poner los mensajes en el adapter
                adapter.insertMessage(Message(message, RECEIVE_ID, timeStamp))

               rv_messages.scrollToPosition(adapter.itemCount-1)

                when(responde){

                }
            }
        }
    }

    private fun customBotMessage(message: String){
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main){
                val timeStamp = equipo.uno.connect.utils.Time.timeStamp()
                messagesList.add(Message(message, RECEIVE_ID, timeStamp))
                adapter.insertMessage(Message(message, RECEIVE_ID, timeStamp))

                rv_messages.scrollToPosition(adapter.itemCount-1)
            }
        }
    }

    private fun createMensaje(contenido : String){
        //val currentTime = Calendar.getInstance().time
        val mensaje = Mensaje1(contenido)
        ref = database.getReference().child("Mensaje").push()
        ref.setValue(mensaje)

    }
}