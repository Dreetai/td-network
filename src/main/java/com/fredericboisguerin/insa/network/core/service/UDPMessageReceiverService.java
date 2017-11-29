package com.fredericboisguerin.insa.network.core.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class UDPMessageReceiverService implements MessageReceiverService {
    @Override
    public void listenOnPort(int port, IncomingMessageListener incomingMessageListener) throws Exception {
        incomingMessageListener.onNewIncomingMessage("Go");

        Socket chatSocket = new Socket("127.0.0.1",port);
        InputStreamReader stream = new InputStreamReader(chatSocket.getInputStream());
        BufferedReader reader = new BufferedReader(stream);
        String message = reader.readLine();
        System.out.println("Server said: "+message);
    }
}
