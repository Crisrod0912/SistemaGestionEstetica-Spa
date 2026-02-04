package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;

public class Empleado extends Miembro {

    private int codigoEmpleado;
    private String especialidad;
    private String disponible;

    public Empleado(int codigoEmpleado, String nombre, String apellido, String fechaNacimiento, String identificacion, double salario, String especialidad, String disponible) {
        super(nombre, apellido, fechaNacimiento, identificacion, salario);
        this.codigoEmpleado = codigoEmpleado;
        this.especialidad = especialidad;
        this.disponible = disponible;
    }

    public Empleado(String nombre, String apellido, String fechaNacimiento, String identificacion, double salario, String especialidad, String disponible) {
        super(nombre, apellido, fechaNacimiento, identificacion, salario);
        this.especialidad = especialidad;
        this.disponible = disponible;
    }

    public Empleado() {
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    @Override
    public double calcularSalario() {
        return salario + 500;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Empleado: " + nombre + ", Especialidad: " + especialidad);
    }

    @Override
    public String obtenerRol() {
        return "Empleado";
    }

    public String nombre_completo() {
        return nombre + " " + apellido;
    }

    public void verificarCampos() throws Exception {
        if (nombre == null || nombre.isBlank()) {
            throw new Exception("El nombre no puede quedar vacío. ");
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

        if (identificacion == null || identificacion.isBlank()) {
            throw new Exception("La identificación no puede quedar vacía. ");
        }
        if (!identificacion.matches("[0-9\\- ]+")) {
            throw new Exception("La identificación solo puede contener números. ");
        }

        if (especialidad == null || especialidad.equals("Seleccionar") || especialidad.isBlank()) {
            throw new Exception("La especialidad no puede quedar vacía ni sin seleccionar. ");
        }

        if (disponible == null || disponible.equals("Seleccionar") || disponible.isBlank()) {
            throw new Exception("La disponibilidad no puede quedar vacía ni sin seleccionar. ");
        }

        if (salario <= 0) {
            throw new Exception("El salario debe ser mayor a 0. ");
        }
    }
}
