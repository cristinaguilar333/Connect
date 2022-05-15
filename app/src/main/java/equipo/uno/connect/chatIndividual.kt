package equipo.uno.connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import equipo.uno.connect.data.Message
import equipo.uno.connect.ui.MessagingAdapter
import equipo.uno.connect.utils.BotResponse
import equipo.uno.connect.utils.Constants.RECEIVE_ID
import equipo.uno.connect.utils.Constants.SEND_ID
import equipo.uno.connect.utils.Time
import kotlinx.android.synthetic.main.activity_chat_individual.*
import kotlinx.coroutines.*

class chatIndividual : AppCompatActivity() {

    private val TAG = "chatIndividual"
    var messagesList = mutableListOf<Message>()

    private lateinit var adapter:MessagingAdapter
    private val botList = listOf("Peter", "Francesca", "Luigi","Igor")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_individual)

        recyclerView()
        clickEvents()

        val random = (0..3).random()
        customBotMessage("Hola! estas hablando con ${botList[random]}, en que te ayudo?")


        val volver : ImageButton = findViewById(R.id.btnVolver1)
        val btnEnviar : ImageButton = findViewById(R.id.btnEnviar)
        val etMessage : EditText = findViewById(R.id.etMessage)
        val rv_messages : RecyclerView= findViewById(R.id.rv_messages)

        volver.setOnClickListener{
            var intent : Intent = Intent(this,ChatActivity::class.java)
            startActivity(intent)
        }
    }

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
        val timeStamp = Time.timeStamp()

        if(message.isNotEmpty()){
            messagesList.add(Message(message, SEND_ID, timeStamp))
            etMessage.setText("")

            adapter.insertMessage(Message(message, SEND_ID, timeStamp))
            rv_messages.scrollToPosition(adapter.itemCount-1)

            botResponse(message)

        }
    }

    private fun botResponse(message:String){
        val timeStamp = Time.timeStamp()
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
                val timeStamp = Time.timeStamp()
                messagesList.add(Message(message, RECEIVE_ID, timeStamp))
                adapter.insertMessage(Message(message, RECEIVE_ID, timeStamp))

                rv_messages.scrollToPosition(adapter.itemCount-1)
            }
        }
    }
}