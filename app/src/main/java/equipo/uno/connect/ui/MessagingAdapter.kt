package equipo.uno.connect.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import equipo.uno.connect.R
import equipo.uno.connect.data.Message
import equipo.uno.connect.utils.Constants.RECEIVE_ID
import equipo.uno.connect.utils.Constants.SEND_ID
import kotlinx.android.synthetic.main.message_item.view.*

class MessagingAdapter: RecyclerView.Adapter<MessagingAdapter.MessageViewHolder>() {

    var messageList = mutableListOf<Message>()


    inner class MessageViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        init{
            itemView.setOnClickListener {

            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false))
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentMessage = messageList[position]

        when(currentMessage.id){
            SEND_ID -> {
                holder.itemView.tv_message.apply{
                    text = currentMessage.message
                    visibility = View.VISIBLE

                }

                holder.itemView.tv_message2.visibility = View.GONE
            }
            RECEIVE_ID ->{
                holder.itemView.tv_message2.apply{
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_message.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }
    fun insertMessage(message:Message){
        this.messageList.add(message)
        notifyItemInserted(messageList.size)
        notifyDataSetChanged()
    }
}