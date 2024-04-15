import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.IOException;

public class ChatCliente {
    public static void main(String[] args) throws IOException {
        // Conecta ao servidor
        Socket socket = new Socket("localhost", 4000);
        System.out.println("Conectado ao servidor");

        // Cria as streams de entrada e saída
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // método que facita o envio de mensagens em um fluxo de sáida (OUTPUT = SAÍDA) 
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // BufferedReader é um objeto de entrada que é usado para LER a entrada do usuário pelo console..

        // Envia mensagens para o servidor
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)); // leitor das mensagens de entrada
        String message; // declaração da string mensagem.
        while ((message = userInput.readLine()) != null) {
            out.println(message);
            if (message.equalsIgnoreCase("sair")) { 
                break;
            }
        }

        // Fecha as streams e o socket
        out.close();
        in.close();
        socket.close();
    }
}
