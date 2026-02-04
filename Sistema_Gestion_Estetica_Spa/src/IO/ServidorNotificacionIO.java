package IO;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorNotificacionIO implements Runnable {

    @Override
    public void run() {
        ServerSocket servidor;
        Socket cliente;

        try {
            System.out.println("Servidor iniciado... ");
            servidor = new ServerSocket(6900);
            while (true) {
                cliente = servidor.accept();
                System.out.println("Cliente conectado. ");

                DataInputStream in = new DataInputStream(cliente.getInputStream());

                String nombre = in.readUTF();
                String fecha = in.readUTF();
                String hora = in.readUTF();

                System.out.println("📩 Notificación enviada a " + nombre
                        + " para el día " + fecha + " a las " + hora);
                cliente.close();

                System.out.println("Cliente desconectado. ");
            }
        } catch (IOException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
    }
}
