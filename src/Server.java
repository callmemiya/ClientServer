import java.net.*;
import java.io.*;

public class Server {
    private static final int port = 8000;
    private static Socket[] clients = new Socket[2];
    private static ServerSocket server;
    private static BufferedReader[] in = new BufferedReader[2];
    private static BufferedWriter[] out = new BufferedWriter[2];

//    private void close() throws IOException{
//        for (int i = 0; i < 2; i++){
//            clients[i].close();
//            in[i].close();
//            out[i].close();
//        }
//    }

    public static void main(String[] args) throws IOException {
        server = new ServerSocket(port);
        System.out.println("Чат создан!");
        try{
            try {
                for (int i = 0; i < 2; i++) {
                    clients[i] = server.accept();
                    in[i] = new BufferedReader(new InputStreamReader(clients[i].getInputStream()));
                    out[i] = new BufferedWriter(new OutputStreamWriter(clients[i].getOutputStream()));
                }
                while (true) {
                    String word = in[0].readLine();
                    System.out.println("Клиент 1 написал: " + word);
                    out[1].write(word + "\n");
                    out[1].flush();
                    if (word.equals("stop")) {
                        for (int i = 0; i < 2; i++){
                            clients[i].close();
                            in[i].close();
                            out[i].close();
                        }
                        break;
                    }
                    String word1 = in[1].readLine();
                    System.out.println("Клиент 2 написал: " + word1);
                    out[0].write(word1 + "\n");
                    out[0].flush();
                    if (word1.equals("stop")) {
                        for (int i = 0; i < 2; i++){
                            clients[i].close();
                            in[i].close();
                            out[i].close();
                        }
                        break;
                    }
                }
            } finally {
                System.out.println("Чат закрыт");
                server.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
