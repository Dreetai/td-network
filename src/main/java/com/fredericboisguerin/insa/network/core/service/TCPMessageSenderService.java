package com.fredericboisguerin.insa.network.core.service;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPMessageSenderService implements MessageSenderService {
    @Override
    public void sendMessageOn(String ipAddress, int port, String message) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        Socket chatSocket = serverSocket.accept();
        PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());
        writer.println(message);
        writer.close();
    }
}
