import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class Servidor {
    public static void main(String[] args) throws IOException {
        // cria um servidor socket
        ServerSocket serverSocket = new ServerSocket(4000); // porta do servidor: 4000
        System.out.println("Servidor aguardando conexão...");

        // aceita a conexão do cliente
        Socket clientSocket = serverSocket.accept();
        System.out.println("Cliente conectado");

        // cria as streams de entrada e saída
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // recebe mensagens do cliente e as envia para o outro cliente
        String message;
        while ((message = in.readLine()) != null) { // Esse WHILE é um loop infinito que server para o usuário mandar várias mensagens... E quando ele for != NULL (diferente ou igual a nulo)ele finaliza.
            System.out.println("Cliente: " + message);
            if (message.equalsIgnoreCase("sair")) { // Se a mensagem for igual a "SAIR" ele finaliza. (TA COM IGNORE CASE, OU SEJA, IGNORA CAIXA ALTA)
                break;
            }
        }

        // Fecha as streams e o socket
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}


/*
Referente ao *PrintWriter*, é um objeto que é usado para enviar mensagens para o cliente através do socket. 
Ele é um método que facita o envio de mensagens em um fluxo de sáida (OUTPUT = SAÍDA) 
*/
