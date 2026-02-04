package DAO;

import DB.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Model.Cliente;
import Model.Empleado;
import Model.Reserva;

public class ReservaDAO {

    public static boolean agregar(Reserva reserva) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Connection conn = conexion.conectar();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con la base de datos. ");
            return false;
        }

        String sql = "INSERT INTO tb_reservas (codigoEmpleado, codigoCliente, fechaReserva, horaReserva) VALUES (?, ?, ?, ?)";

        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, reserva.getEmpleado().getCodigoEmpleado());
            cs.setInt(2, reserva.getCliente().getCodigoCliente());
            cs.setString(3, reserva.getFecha());
            cs.setString(4, reserva.getHora());

            cs.execute();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar la reserva: " + ex.getMessage());
            return false;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error general al agregar reserva: " + ex.getMessage());
            return false;

        } finally {
            conexion.desconectar();
        }
    }

    public static boolean editar(Reserva reserva) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Connection conn = conexion.conectar();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con la base de datos. ");
            return false;
        }

        String sql = "UPDATE tb_reservas SET codigoEmpleado=?, codigoCliente=?, fechaCita=?, horaCita=? WHERE codigoReserva=?";

        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, reserva.getEmpleado().getCodigoEmpleado());
            cs.setInt(2, reserva.getCliente().getCodigoCliente());
            cs.setString(3, reserva.getFecha());
            cs.setString(4, reserva.getHora());
            cs.setInt(5, reserva.getCodigoReserva());

            cs.execute();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al editar reserva: " + ex.getMessage());
            return false;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error general al editar reserva: " + ex.getMessage());
            return false;

        } finally {
            conexion.desconectar();
        }
    }

    public static boolean consultar(ArrayList<Reserva> modelos) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Connection conn = conexion.conectar();

        if (conn == null) {
            System.out.println("No se pudo establecer conexión con la base de datos. ");
            return false;
        }

        String sql = """
        SELECT r.codigoReserva, r.fechaReserva, r.horaReserva,
               e.codigoEmpleado, e.nombre AS nombreEmpleado, e.apellido AS apellidoEmpleado, e.especialidad,
               c.codigoCliente AS codigoCliente, c.nombre AS nombreCliente, c.apellido AS apellidoCliente
        FROM tb_reservas r
        JOIN tb_empleados e ON r.codigoEmpleado = e.codigoEmpleado
        JOIN tb_clientes c ON r.codigoCliente = c.codigoCliente
        """;

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
                empleado.setNombre(rs.getString("nombreEmpleado"));
                empleado.setApellido(rs.getString("apellidoEmpleado"));
                empleado.setEspecialidad(rs.getString("especialidad"));

                Cliente cliente = new Cliente();
                cliente.setCodigoCliente(rs.getInt("codigoCliente"));
                cliente.setNombre(rs.getString("nombreCliente"));
                cliente.setApellido(rs.getString("apellidoCliente"));

                Reserva reserva = new Reserva(
                        rs.getInt("codigoReserva"),
                        empleado,
                        cliente,
                        rs.getString("fechaReserva"),
                        rs.getString("horaReserva")
                );

                modelos.add(reserva);
            }

            return true;

        } catch (SQLException ex) {
            System.out.println("ERROR AL CONSULTAR RESERVAS: " + ex.getMessage());
            return false;

        } catch (Exception ex) {
            System.out.println("ERROR GENERAL AL CONSULTAR RESERVAS: " + ex.getMessage());
            return false;

        } finally {
            conexion.desconectar();
        }
    }

    public static boolean eliminar(Reserva reserva) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Connection conn = conexion.conectar();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con la base de datos. ");
            return false;
        }

        String sql = "DELETE FROM tb_reservas WHERE codigoReserva=?";

        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, reserva.getCodigoReserva());
            cs.execute();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la reserva: " + ex.getMessage());
            return false;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error general al eliminar reserva: " + ex.getMessage());
            return false;

        } finally {
            conexion.desconectar();
        }
    }

    public static boolean fechaDisponible(String fecha, String hora, int codigoEmpleado) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Connection conn = conexion.conectar();

        String sql = "SELECT * FROM tb_reservas WHERE fechaReserva = ? AND horaReserva = ? AND codigoEmpleado = ?";

        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, fecha);
            cs.setString(2, hora);
            cs.setInt(3, codigoEmpleado);

            ResultSet rs = cs.executeQuery();

            boolean disponible = !rs.next();
            return disponible;

        } catch (SQLException ex) {
            System.out.println("ERROR AL CONSULTAR DISPONIBILIDAD: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("ERROR GENERAL: " + ex.getMessage());
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    public static boolean consultarHistorial(ArrayList<Reserva> modelos, String idCliente) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Connection conn = conexion.conectar();

        if (conn == null) {
            System.out.println("No se pudo establecer conexión con la base de datos. ");
            return false;
        }

        String sql = """
        SELECT r.codigoReserva, r.fechaReserva, r.horaReserva,
        	   e.codigoEmpleado, e.nombre AS nombreEmpleado, e.apellido AS apellidoEmpleado, e.especialidad,
        	   c.codigoCliente AS codigoCliente, c.nombre AS nombreCliente, c.apellido AS apellidoCliente
        FROM tb_reservas r
        JOIN tb_empleados e ON r.codigoEmpleado = e.codigoEmpleado
        JOIN tb_clientes c ON r.codigoCliente = c.codigoCliente
        WHERE c.codigoCliente = ?;
        """;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idCliente);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
                empleado.setNombre(rs.getString("nombreEmpleado"));
                empleado.setApellido(rs.getString("apellidoEmpleado"));
                empleado.setEspecialidad(rs.getString("especialidad"));

                Cliente cliente = new Cliente();
                cliente.setCodigoCliente(rs.getInt("codigoCliente"));
                cliente.setNombre(rs.getString("nombreCliente"));
                cliente.setApellido(rs.getString("apellidoCliente"));

                Reserva reserva = new Reserva(
                        rs.getInt("codigoReserva"),
                        empleado,
                        cliente,
                        rs.getString("fechaReserva"),
                        rs.getString("horaReserva")
                );

                modelos.add(reserva);
            }

            return true;

        } catch (SQLException ex) {
            System.out.println("ERROR AL CONSULTAR RESERVAS: " + ex.getMessage());
            return false;

        } catch (Exception ex) {
            System.out.println("ERROR GENERAL AL CONSULTAR RESERVAS: " + ex.getMessage());
            return false;

        } finally {
            conexion.desconectar();
        }
    }
}
