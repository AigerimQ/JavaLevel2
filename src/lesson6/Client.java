package lesson6;

import java.io.*;
import java.net.Socket;

public class Client {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;


    //  Метод EchoClient нужен для создания нового socket клиента и связывания его с сервером по ip-адресу и номеру порта.
    private Client(String server_addr, int server_port) throws IOException {
        Socket socket = new Socket(server_addr, server_port);
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());
    }

    //  Метод sendMessage нужен для отправки сообщения на сервер.
    private static void sendMessage(DataOutputStream outputStream) throws IOException {
        String userMessage;
        do {
            userMessage = reader.readLine();
            if (!userMessage.trim().isEmpty()) {
                outputStream.writeUTF(userMessage);
            }
        } while (!userMessage.equals("/end"));
    }

    //  Метод getMessage нужен для получения сообщения от сервера.
    private void getMessage() {
        while (true) {
            try {
//              Запись в новую переменную входящего сообщения от сервера.
                String strFromServer = inputStream.readUTF();
                System.out.println("From admin: " + strFromServer);
            } catch (Exception e) {
                System.out.println("Connection has been closed!");
                break;
            }
        }

    }

    public static void main(String[] args) {
        try {
//          Создаем новый клиент и связываем его с сервером по IP-адресу и номеру порта.
            Client client = new Client("localhost", 8188);
//          Создаем новый поток отдельно от основного для получения сообщений от сервера.
            Thread inputThread = new Thread(client::getMessage);
            inputThread.start();
//          Из основного потока отправляем сообщения пользователя на сервер.
            sendMessage(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
