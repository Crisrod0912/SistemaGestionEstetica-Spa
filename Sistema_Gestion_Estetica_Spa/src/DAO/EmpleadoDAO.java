package DAO;

import DB.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Model.Empleado;

public class EmpleadoDAO {

    public EmpleadoDAO() {
    }

    public static boolean agregar(Empleado empleado) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Connection conn = conexion.conectar();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos. ");
            return false;
        }

        String sql = "INSERT INTO tb_empleados (nombre, apellido, fechaNacimiento, identificacion, salario, especialidad, disponibilidad) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);
            cs.setString(1, empleado.getNombre());
            cs.setString(2, empleado.getApellido());
            cs.setString(3, empleado.getFechaNacimiento());
            cs.setString(4, empleado.getIdentificacion());
            cs.setDouble(5, empleado.getSalario());
            cs.setString(6, empleado.getEspecialidad());
            cs.setString(7, empleado.getDisponible());

            cs.execute();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar empleado: " + ex.getMessage());
            return false;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error general: " + ex.getMessage());
            return false;

        } finally {
            conexion.desconectar();
        }
    }

    public static boolean consultar(ArrayList<Empleado> modelos) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Connection conn = conexion.conectar();

        if (conn == null) {
            System.out.println("No se pudo conectar a la base de datos. ");
            return false;
        }

        String sql = "SELECT * FROM tb_empleados";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Empleado empleado = new Empleado(
                        rs.getInt("codigoEmpleado"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("fechaNacimiento"),
                        rs.getString("identificacion"),
                        rs.getDouble("salario"),
                        rs.getString("especialidad"),
                        rs.getString("disponibilidad")
                );
                modelos.add(empleado);
            }
            return true;

        } catch (SQLException ex) {
            System.out.println("ERROR AL CONSULTAR EMPLEADOS: " + ex.getMessage());
            return false;

        } catch (Exception ex) {
            System.out.println("ERROR GENERAL: " + ex.getMessage());
            return false;

        } finally {
            conexion.desconectar();
        }
    }

    public static boolean eliminar(Empleado empleado) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Connection conn = conexion.conectar();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos. ");
            return false;
        }

        String sql = "DELETE FROM tb_empleados WHERE codigoEmpleado=?";

        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, empleado.getCodigoEmpleado());
            cs.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("ERROR AL ELIMINAR EMPLEADO: " + ex.getMessage());
            return false;

        } catch (Exception ex) {
            System.out.println("ERROR GENERAL AL ELIMINAR EMPLEADO: " + ex.getMessage());
            return false;

        } finally {
            conexion.desconectar();
        }
    }

    public static boolean editar(Empleado empleado) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Connection conn = conexion.conectar();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos. ");
            return false;
        }

        String sql = "UPDATE tb_empleados SET nombre=?, fechaNacimiento=?, identificacion=?, salario=?, especialidad=?, disponibilidad=? WHERE codigoEmpleado=?";

        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, empleado.getNombre());
            cs.setString(2, empleado.getFechaNacimiento());
            cs.setString(3, empleado.getIdentificacion());
            cs.setDouble(4, empleado.getSalario());
            cs.setString(5, empleado.getEspecialidad());
            cs.setString(6, empleado.getDisponible());
            cs.setInt(7, empleado.getCodigoEmpleado());

            cs.execute();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al editar empleado: " + ex.getMessage());
            return false;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error general: " + ex.getMessage());
            return false;

        } finally {
            conexion.desconectar();
        }
    }
}
