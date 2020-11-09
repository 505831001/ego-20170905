package com.ego.net;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author liuweiwei
 * @since 2020-09-27
 */
public class UDPServer {
    private static DatagramSocket socket;
    private static DatagramPacket packet;

    public static void main(String[] args) throws SocketException {
        socket = new DatagramSocket(8848);
        try {
            byte[] bytes = new byte[1024 * 64];
            packet = new DatagramPacket(bytes, 0, bytes.length);
            socket.receive(packet);
            System.out.println(packet.getData());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}
