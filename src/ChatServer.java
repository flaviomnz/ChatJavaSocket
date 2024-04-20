import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class ChatServer {
    public static void main(String[] args) {
        try {
            // Socket do Servidor: Quando ligado, o servidor cria um SOCKET de espera por uma conexão.
            ServerSocket serverSocket = new ServerSocket(4000); // Estabelecendo uma conexão na porta 4000
            System.out.println("Servidor aguardando conexão...");

            Socket socket = serverSocket.accept(); // Aceitando a conexão do usuário, e quando é aceita, é criado outro SOCKET de comunicação com o cliente. 
            System.out.println("Conexão estabelecida com o cliente: " + socket);  

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream())); // LER O QUE É ENVIADO PELO OUTRO LADO
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true); // ENVIA A MENSAGEM PARA O OUTRO LADO

            String textoMensagem; // Definindo mensagem
            
            while (true) {
                textoMensagem = input.readLine(); // RECEBE A MENSAGEM DO OUTRO LADO ( LER ) 

                if (textoMensagem == null || textoMensagem.equalsIgnoreCase("sair")) { // CASO O USUÁRIO QUEIRA SAIR, DIGITA "SAIR" - (TA EM IGNORE CASE PRA IGNORAR CAIXA ALTA)
                    break; // FINALIZA
                }
                System.out.println("Mensagem recebida do CLIENTE: " + textoMensagem);  // Recebe a mensagem do outro lado.

                System.out.print("Digite uma mensagem para enviar de volta: ");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // LER O QUE ESTÁ SENDO DIGITADO PELO USUÁRIO, OU SEJA, CAPTA AS TECLAS.
                output.println(reader.readLine()); // ENVIA OQ FOI DIGITADO
            }

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
  
 
}
