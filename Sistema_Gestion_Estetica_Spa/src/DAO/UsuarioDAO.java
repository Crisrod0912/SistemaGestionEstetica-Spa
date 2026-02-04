package DAO;

import DB.ConexionBD;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Model.Usuario;
import java.awt.HeadlessException;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioDAO {

    public static boolean registrarUsuario(Usuario user) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        if (user.getIdUsuario() == null || user.getIdUsuario().isBlank()
                || user.getContrasenna() == null || user.getContrasenna().isBlank()
                || user.getNombre() == null || user.getNombre().isBlank()
                || user.getRol() == null || user.getRol().isBlank()) {

            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios. ");
            return false;
        }

        String revisarUsuarioSQL = "SELECT * FROM tb_usuarios WHERE idUsuario = ?";
        String registrarSQL = "INSERT INTO tb_usuarios (idUsuario, contrasenna, nombre, rol) VALUES (?, ?, ?, ?)";
        String hashed = BCrypt.hashpw(user.getContrasenna(), BCrypt.gensalt());

        try {
            CallableStatement checkCS = conexion.conectar().prepareCall(revisarUsuarioSQL);
            checkCS.setString(1, user.getIdUsuario());
            ResultSet rs = checkCS.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe. ");
                return false;
            }

            CallableStatement cs = conexion.conectar().prepareCall(registrarSQL);
            cs.setString(1, user.getIdUsuario());
            cs.setString(2, hashed);
            cs.setString(3, user.getNombre());
            cs.setString(4, user.getRol());

            cs.execute();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL: " + ex.getMessage());
            return false;

        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error general: " + ex.getMessage());
            return false;

        } finally {
            conexion.desconectar();
        }
    }

    public static boolean autenticar(String idUsuario, String contrasenna) throws SQLException {
        ConexionBD conexion = new ConexionBD();

        String sql = "SELECT * FROM tb_usuarios WHERE idUsuario = ?";

        try {

            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setString(1, idUsuario);

            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                String hashed = rs.getString(3);

                if (BCrypt.checkpw(contrasenna, hashed)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la autenticación. ");
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se puede establecer conexion con la base de datos. ");
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }

        return false;
    }

    public static boolean consultar(ArrayList<Usuario> usuarios) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        String sql = "SELECT * FROM tb_usuarios";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("codigoUsuario"),
                        rs.getString("idUsuario"),
                        rs.getString("contrasenna"),
                        rs.getString("nombre"),
                        rs.getString("rol")
                );
                usuarios.add(u);
            }
            return true;

        } catch (SQLException ex) {
            System.out.println("ERROR AL CONSULTAR USUARIOS: " + ex.getMessage());
            return false;

        } finally {
            conexion.desconectar();
        }
    }

    public static boolean editar(Usuario user) throws SQLException {
        ConexionBD conexion = new ConexionBD();

        String sql = "UPDATE tb_usuarios SET nombre = ?, rol = ? WHERE idUsuario = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);
            cs.setString(1, user.getNombre());
            cs.setString(2, user.getRol());
            cs.setString(3, user.getIdUsuario());

            int filas = cs.executeUpdate();
            return filas > 0;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al editar usuario: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error general: " + ex.getMessage());
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    public static boolean eliminar(Usuario user) throws SQLException {
        ConexionBD conexion = new ConexionBD();

        String sql = "DELETE FROM tb_usuarios WHERE idUsuario = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);
            cs.setString(1, user.getIdUsuario());

            int filas = cs.executeUpdate();
            return filas > 0;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error general: " + ex.getMessage());
            return false;
        } finally {
            conexion.desconectar();
        }
    }
}
