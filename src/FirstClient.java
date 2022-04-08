import java.io.*;
import java.net.Socket;

public class FirstClient {
    private static int port = 8000;
    private static Socket client;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            client = new Socket("localhost", port);
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            System.out.println("Отправьте сообщение");
            while (true) {
                String word = reader.readLine();
                out.write(word + "\n");
                out.flush();
                if (word.equals("stop")){
                    in.close();
                    out.close();
                    reader.close();
                    client.close();
                    break;
                }
                String answer = in.readLine();
                System.out.println("Клиент 2 написал:");
                System.out.println(answer);
                if (answer.equals("stop")){
                    client.close();
                    in.close();
                    out.close();
                    reader.close();
                    break;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
