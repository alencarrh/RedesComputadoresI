package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.Servidor;

/**
 * @class MainServer
 * @author Alencar Rodrigo Hentges <alencarhentges@gmail.com>
 * @date 25/03/2017
 */
public class ServidorMain {

    private static Servidor server;
    private static final BufferedReader KEYBOARD_INPUT = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, InterruptedException {
        server = new Servidor(6789);

        Thread startServer = new Thread(() -> {
            try {
                server.iniciarServidor();
            } catch (IOException ex) {
                Logger.getLogger(ServidorMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        startServer.start();

        System.out.println("Preciona 'Enter' a qualquer momento para parar o servidor...");
        KEYBOARD_INPUT.readLine();

        server.pararServidor();
    }
}
