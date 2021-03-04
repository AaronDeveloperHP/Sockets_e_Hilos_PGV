package socketsServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class socketsServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int PORT = 40080;

        try {
            ServerSocket sk = new ServerSocket(PORT);

            while (true) {
                Socket socket = sk.accept();

                new ConnectClient(socket).start();
            }

        } catch (IOException ex) {
            Logger.getLogger(socketsServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
