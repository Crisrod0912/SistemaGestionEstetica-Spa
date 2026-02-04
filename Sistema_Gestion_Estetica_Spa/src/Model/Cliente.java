package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;

public class Cliente extends Persona {

    private int codigoCliente;
    private String direccion;
    private String telefono;
    private String correo;
    private String historialServicio;

    public Cliente(int codigoCliente, String apellido, String fechaNacimiento, String direccion, String telefono, String correo, String historialServicio, String nombre, String identificacion) {
        super(nombre, apellido, fechaNacimiento, identificacion);
        this.codigoCliente = codigoCliente;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.historialServicio = historialServicio;
    }

    public Cliente(String apellido, String fechaNacimiento, String direccion, String telefono, String correo, String historialServicio, String nombre, String identificacion) {
        super(nombre, apellido, fechaNacimiento, identificacion);
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.historialServicio = historialServicio;
    }

    public Cliente() {
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getHistorialServicio() {
        return historialServicio;
    }

    public void setHistorialServicio(String historialServicio) {
        this.historialServicio = historialServicio;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Cliente: " + nombre + "\nHistorial: " + historialServicio);
    }

    @Override
    public String obtenerRol() {
        return "Cliente";
    }

    public String nombreCompleto() {
        return nombre + " " + apellido;
    }

    public void verificarCampos() throws Exception {
        if (nombre == null || nombre.isBlank()) {
            throw new Exception("El Nombre no puede quedar vacío. ");
        }
        if (apellido == null || apellido.isBlank()) {
            throw new Exception("El apellido no puede quedar vacío. ");
        }
        if (fechaNacimiento == null || fechaNacimiento.isBlank()) {
            throw new Exception("La fecha de nacimiento no puede quedar vacía. ");
        }
        try {
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .appendValue(ChronoField.DAY_OF_MONTH)
                    .appendLiteral('/')
                    .appendValue(ChronoField.MONTH_OF_YEAR)
                    .appendLiteral('/')
                    .appendValue(ChronoField.YEAR)
                    .toFormatter();

            LocalDate.parse(fechaNacimiento, formatter);
        } catch (DateTimeParseException e) {
            throw new Exception("El formato de la fecha de nacimiento es inválido. Use dd/MM/yyyy, por ejemplo 9/9/2025 o 09/09/2025");
        }
        if (direccion == null || direccion.isBlank()) {
            throw new Exception("La dirección no puede quedar vacía. ");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new Exception("El teléfono no puede quedar vacío. ");
        }
        if (!telefono.matches("[0-9\\- ]+")) {
            throw new Exception("El teléfono solo puede contener números. ");
        }
        if (correo == null || correo.isBlank()) {
            throw new Exception("El correo no puede quedar vacío. ");
        }
        if (identificacion == null || identificacion.isBlank()) {
            throw new Exception("La identificación no puede quedar vacía. ");
        }
        if (!identificacion.matches("[0-9\\- ]+")) {
            throw new Exception("La identificación solo puede contener números. ");
        }
        if (historialServicio == null || historialServicio.isBlank()) {
            throw new Exception("El historial de servicio no puede quedar vacío");
        }
    }
}
