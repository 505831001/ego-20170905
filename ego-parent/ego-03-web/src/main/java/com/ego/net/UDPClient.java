package com.ego.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author liuweiwei
 * @since 2020-09-27
 */
public class UDPClient {
    protected static DatagramSocket socket;
    protected static DatagramPacket packet;

    public static void main(String[] args) throws SocketException {
        socket = new DatagramSocket(8848);
        try {
            String message = "林一明是个可爱的靓仔";
            byte[] bytes = message.getBytes();
            packet = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress("localhost", 8080));
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}
