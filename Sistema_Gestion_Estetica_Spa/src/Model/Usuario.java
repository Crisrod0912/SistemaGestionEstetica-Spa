package Model;

public class Usuario {

    private int codigoUsuario;
    private String idUsuario;
    private String contrasenna;
    private String nombre;
    private String rol;

    public Usuario(int codigoUsuario, String idUsuario, String contrasenna, String nombre, String rol) {
        this.codigoUsuario = codigoUsuario;
        this.idUsuario = idUsuario;
        this.contrasenna = contrasenna;
        this.nombre = nombre;
        this.rol = rol;
    }

    public Usuario(String idUsuario, String contrasenna, String nombre, String rol) {
        this.idUsuario = idUsuario;
        this.contrasenna = contrasenna;
        this.nombre = nombre;
        this.rol = rol;
    }

    public Usuario(int codigoUsuario, String idUsuario, String nombre, String rol) {
        this.codigoUsuario = codigoUsuario;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.rol = rol;
    }

    public Usuario() {
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void verificarCamposRegistro() throws Exception {
        if (idUsuario == null || idUsuario.isBlank()) {
            throw new Exception("El usuario no puede quedar vacío. ");
        }
        if (contrasenna == null || contrasenna.isBlank()) {
            throw new Exception("La contraseña no puede quedar vacía. ");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new Exception("El nombre no puede quedar vacío. ");
        }
        if (rol == null || rol.isBlank()) {
            throw new Exception("El rol no puede quedar vacío. ");
        }
    }

    public void verificarCamposEdicion() throws Exception {
        if (idUsuario == null || idUsuario.isBlank()) {
            throw new Exception("El usuario no puede quedar vacío. ");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new Exception("El nombre no puede quedar vacío. ");
        }
        if (rol == null || rol.isBlank()) {
            throw new Exception("El rol no puede quedar vacío.");
        }
    }
}
