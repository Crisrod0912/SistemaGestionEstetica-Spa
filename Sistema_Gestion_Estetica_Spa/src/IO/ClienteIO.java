package IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClienteIO {

    public static String verificar(String fecha, String hora, int codigoEmpleado) {
        try {
            Socket socket = new Socket("127.0.0.1", 5600);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out.writeUTF(fecha);
            out.writeUTF(hora);
            out.writeUTF(String.valueOf(codigoEmpleado));

            String respuesta = in.readUTF();
            return respuesta;

        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
            return "ERROR";
        }
    }
}
