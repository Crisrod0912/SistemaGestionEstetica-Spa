package IO;

import java.awt.HeadlessException;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ClienteNotificacionIO {

    public static void enviar(String nombreCliente, String fecha, String hora) {
        try {
            Socket socket = new Socket("127.0.0.1", 6900);

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF(nombreCliente);
            out.writeUTF(fecha);
            out.writeUTF(hora);

            JOptionPane.showMessageDialog(null,
                    "Notificación enviada a " + nombreCliente
                    + " para la reserva del día " + fecha + " a las " + hora,
                    "Notificación", JOptionPane.INFORMATION_MESSAGE);

        } catch (HeadlessException | IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
