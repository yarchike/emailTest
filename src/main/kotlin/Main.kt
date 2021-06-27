fun main() {
    val tlsSender = SenderTLS("yarchikt@gmail.com", "password")
    val sslSender = SenderSSL("yarchikt@gmail.com", "password")

    tlsSender.send("This is Subject", "TLS: This is text!",  "yarchike@gmail.com");
   // sslSender.send("This is Subject", "SSL: This is text!",  "yarchike@gmail.com");
}