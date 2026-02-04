package DAO;

import DB.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Cliente;

public class ClienteDAO {

    public ClienteDAO() {
    }

    public static boolean consultar(ArrayList<Cliente> modelos) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Connection conn = conexion.conectar();

        if (conn == null) {
            System.out.println("No se pudo conectar a la base de datos. ");
            return false;
        }

        String sql = "SELECT * FROM tb_clientes";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("codigoCliente"),
                        rs.getString("apellido"),
                        rs.getString("fechaNacimiento"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getString("historialServicio"),
                        rs.getString("nombre"),
                        rs.getString("identificacion")
                );
                modelos.add(cliente);
            }
            return true;

        } catch (SQLException ex) {
            System.out.println("ERROR AL CONSULTAR CLIENTES: " + ex.getMessage());
            return false;

        } catch (Exception ex) {
            System.out.println("ERROR GENERAL AL CONSULTAR CLIENTES: " + ex.getMessage());
            return false;

        } finally {
            conexion.desconectar();
        }
    }

    public static boolean agregar(Cliente cliente) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Connection conn = conexion.conectar();

        if (conn == null) {
            System.out.println("No se pudo conectar a la base de datos.");
            return false;
        }

        String sql = "INSERT INTO tb_clientes (nombre, apellido, fechaNacimiento, direccion, telefono, correo, identificacion, historialServicio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, cliente.getNombre());
            cs.setString(2, cliente.getApellido());
            cs.setString(3, cliente.getFechaNacimiento());
            cs.setString(4, cliente.getDireccion());
            cs.setString(5, cliente.getTelefono());
            cs.setString(6, cliente.getCorreo());
            cs.setString(7, cliente.getIdentificacion());
            cs.setString(8, cliente.getHistorialServicio());

            cs.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("ERROR AL AGREGAR CLIENTE: " + ex.getMessage());
            return false;

        } catch (Exception ex) {
            System.out.println("ERROR GENERAL AL AGREGAR CLIENTE: " + ex.getMessage());
            return false;

        } finally {
            conexion.desconectar();
        }
    }

    public static boolean editar(Cliente cliente) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Connection conn = conexion.conectar();

        if (conn == null) {
            System.out.println("No se pudo conectar a la base de datos.");
            return false;
        }

        String sql = "UPDATE tb_clientes SET nombre=?, apellido=?, fechaNacimiento=?, direccion=?, telefono=?, correo=?, identificacion=?, historialServicio=? WHERE codigoCliente=?";

        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, cliente.getNombre());
            cs.setString(2, cliente.getApellido());
            cs.setString(3, cliente.getFechaNacimiento());
            cs.setString(4, cliente.getDireccion());
            cs.setString(5, cliente.getTelefono());
            cs.setString(6, cliente.getCorreo());
            cs.setString(7, cliente.getIdentificacion());
            cs.setString(8, cliente.getHistorialServicio());
            cs.setInt(9, cliente.getCodigoCliente());

            cs.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("ERROR AL EDITAR CLIENTE: " + ex.getMessage());
            return false;

        } catch (Exception ex) {
            System.out.println("ERROR GENERAL AL EDITAR CLIENTE: " + ex.getMessage());
            return false;

        } finally {
            conexion.desconectar();
        }
    }

    public static boolean eliminar(Cliente cliente) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Connection conn = conexion.conectar();

        if (conn == null) {
            System.out.println("No se pudo conectar a la base de datos.");
            return false;
        }

        String sql = "DELETE FROM tb_clientes WHERE codigoCliente=?";

        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, cliente.getCodigoCliente());
            cs.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("ERROR AL ELIMINAR CLIENTE: " + ex.getMessage());
            return false;

        } catch (Exception ex) {
            System.out.println("ERROR GENERAL AL ELIMINAR CLIENTE: " + ex.getMessage());
            return false;

        } finally {
            conexion.desconectar();
        }
    }
}
