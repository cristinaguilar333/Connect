package equipo.uno.connect.utils

object BotResponse {

    fun basicResponse(_message:String):String{
        val random = (0..2).random()
        val message = _message.toLowerCase()

        return when{

            message.contains("hola") && message.contains("Hola") ->{
                when(random){
                    0 -> "Hola amigo"
                    1 -> "Hola! En qu[e puedo ayudarte?"
                    2 -> "Eale"
                    else -> "error"
                }
            }
            else -> {
                when(random){
                    0 -> "No entendi"
                    1 -> "Sabe"
                    2 -> "Ok"
                    else -> "error"
                }
            }
        }
    }
}