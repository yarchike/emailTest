import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

public class SenderSSL (val username : String, val password: String, val props: Properties = Properties()){
    init {
        props["mail.smtp.host"] = "smtp.gmail.com"
        props["mail.smtp.socketFactory.port"] = "465"
        props["mail.smtp.socketFactory.class"] = "javax.net.ssl.SSLSocketFactory"
        props["mail.smtp.auth"] = "true"
        props["mail.smtp.port"] = "465"
    }
    fun send(subject: String, text: String,  toEmail: String){
        val session: Session = Session.getDefaultInstance(props, object: Authenticator(){
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(username, password)
            }
        })
        try{
            val message : Message = MimeMessage(session)
            //от кого
            message.setFrom(InternetAddress(username))
            //кому
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail))
            //Заголовок письма
            message.setSubject(subject)
            //Содержимое
            message.setText(text)

            //Отправляем сообщение
            Transport.send(message);
        }catch (e: MessagingException) {
            throw RuntimeException(e);
        }


    }


}
