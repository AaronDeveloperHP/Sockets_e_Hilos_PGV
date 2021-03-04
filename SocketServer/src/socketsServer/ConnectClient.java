package socketsServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random; 

public class ConnectClient extends Thread {
    Socket socket;

    public ConnectClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        serveClient(socket);
    }
    
    private static void serveClient(Socket socket) {
        BufferedReader br = null;
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            
            Scanner sc = new Scanner(System.in);
            
            String line;
            String lineToSendToClient;
            int loops = 1;
            int pts = 0;
            
            
            do{
                Random rand = new Random();
            lineToSendToClient = "Escriba las palabras que se pueden escribir con estas letras [a][s][p][o] ";
            bw.write(lineToSendToClient);
            bw.newLine();
            bw.flush();
            
                line = br.readLine();
 
                if(line.equals("sopa")){
                    bw.write("Correcto!");
                    bw.newLine();
                    bw.flush();
                    loops++;
                    pts++;
                }else if(line.equals("paso")) {
                          bw.write("Correcto!");
                    bw.newLine();
                    bw.flush();
                    loops++;
                    pts++;
                }else if(line.equals("sapo")) {
                          bw.write("Correcto!");
                    bw.newLine();
                    bw.flush();
                    loops++;
                    pts++;
                }
                else if(line.equals("")) {
                        
                } else {
                    bw.write("Incorrecto!");
                    bw.newLine();
                    bw.flush();
                    loops++;
                }
            } while (loops<=3);
            bw.write("Has acertado " + pts + " veces!");
            bw.newLine();
            bw.flush();
                
    
        } catch (IOException ex) {
            Logger.getLogger(socketsServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(br != null) try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(socketsServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
