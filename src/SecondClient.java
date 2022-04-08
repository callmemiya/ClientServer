import java.io.*;
import java.net.Socket;

public class SecondClient {
    private static int port = 8000;
    private static Socket client1;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            client1 = new Socket("localhost", port);
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(client1.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(client1.getOutputStream()));
            while (true) {
                String answer = in.readLine();
                System.out.println("Клиент 1 написал:" + answer);
                if (answer.equals("stop")){
                    client1.close();
                    in.close();
                    out.close();
                    reader.close();
                    break;
                }
                String word = reader.readLine();
                out.write(word + "\n");
                out.flush();
                if (word.equals("stop")){
                    client1.close();
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