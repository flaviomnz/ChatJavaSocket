import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.IOException;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 4000);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Responsável por LER o que é enviado pelo outro lado
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true); // Responsável por enviar a mensagem
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Responsável por ler as o que é digitado pelo usuário.

            String message;
            while (true) {
                System.out.print("Digite uma mensagem para enviar: ");
                message = reader.readLine(); // Capta as teclas do que é digitado pelo usuário
                output.println(message); // Envia a mensagem.

                if (message.equalsIgnoreCase("sair")) {
                    break;
                }

                System.out.println("Mensagem recebida do SERVER: " + input.readLine()); // Recebe a mensagem do outro lado
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

