import java.io.*;
import java.net.*;

public class DictionaryClient {
    public static void main(String[] args) {
        String host = "16.4.17.148";
        int port = 5000;

        try (Socket socket = new Socket(host, port);
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.print("Enter a word: ");
            String word = console.readLine();
            out.println(word);

            String response = in.readLine();
            System.out.println("Meaning: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
