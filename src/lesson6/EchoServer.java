package lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;

    public static void main(String[] args) throws IOException {
        Socket clientSocket = null;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8188, 1);
            System.out.println("Сервер запущен, ожидаем подключения клиента");
            clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился");
            inputStream = new DataInputStream(clientSocket.getInputStream());
            outputStream = new DataOutputStream(clientSocket.getOutputStream());
            Thread inputThread = new Thread(EchoServer::getMessage);
            inputThread.start();
            sendMessage(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (clientSocket != null) clientSocket.close();
        }
    }

    private static void sendMessage(DataOutputStream outputStream) throws IOException {
        String adminMessage;
        do {
            adminMessage = reader.readLine();
            if (!adminMessage.trim().isEmpty()) {
                outputStream.writeUTF(adminMessage);
            }
        } while (!adminMessage.equals("/end"));
    }

    private static void getMessage() {
        String message;
        while (true) {
            try {
                message = inputStream.readUTF();
                System.out.println("From user: " + message);
            } catch (IOException e) {
                System.out.println("Connection has been closed!");
                break;
            }
        }
    }
}
