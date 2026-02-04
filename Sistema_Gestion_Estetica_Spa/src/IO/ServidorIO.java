package IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorIO implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Servidor de disponibilidad iniciado... ");
            ServerSocket servidor = new ServerSocket(5600);
            while (true) {
                try (Socket cliente = servidor.accept()) {
                    System.out.println("Cliente conectado. ");

                    DataInputStream in = new DataInputStream(cliente.getInputStream());
                    DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
                    String fecha = in.readUTF();
                    String hora = in.readUTF();
                    int codigoEmpleado = Integer.parseInt(in.readUTF());

                    boolean disponible = DAO.ReservaDAO.fechaDisponible(fecha, hora, codigoEmpleado);

                    if (disponible) {
                        out.writeUTF("DISPONIBLE. ");
                    } else {
                        out.writeUTF("NO DISPONIBLE. ");
                    }
                }
                System.out.println("Cliente desconectado. ");
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(ServidorIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
