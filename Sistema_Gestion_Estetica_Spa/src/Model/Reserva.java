package Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;

public class Reserva {

    private int codigoReserva;
    private Empleado empleado;
    private Cliente cliente;
    private String fecha;
    private String hora;

    public Reserva(int codigoReserva, Empleado empleado, Cliente cliente, String fecha, String hora) {
        this.codigoReserva = codigoReserva;
        this.empleado = empleado;
        this.cliente = cliente;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Reserva(Empleado empleado, Cliente cliente, String fecha, String hora) {
        this.empleado = empleado;
        this.cliente = cliente;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Reserva() {
    }

    public int getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(int codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void mostrarDetalles() {
        System.out.println("Reserva con nuestro Empleado " + empleado.getNombre() + " para el cliente " + cliente.getNombre() + " el " + fecha + " a las " + hora + ". ");
    }

    public void verificarCampos() throws Exception {
        if (empleado == null || empleado.getCodigoEmpleado() <= 0) {
            throw new Exception("Debe seleccionar un empleado válido. ");
        }

        if (empleado == null || empleado.getCodigoEmpleado() <= 0) {
            throw new Exception("Debe seleccionar un cliente válido. ");
        }

        if (fecha == null || fecha.isBlank()) {
            throw new Exception("La fecha no puede quedar vacía. ");
        }

        try {
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .appendValue(ChronoField.DAY_OF_MONTH)
                    .appendLiteral('/')
                    .appendValue(ChronoField.MONTH_OF_YEAR)
                    .appendLiteral('/')
                    .appendValue(ChronoField.YEAR)
                    .toFormatter();

            LocalDate.parse(fecha, formatter);
        } catch (DateTimeParseException e) {
            throw new Exception("El formato de la fecha es inválido. Usa dd/MM/yyyy, por ejemplo 08/04/2025. ");
        }

        if (hora == null || hora.isBlank()) {
            throw new Exception("La hora no puede quedar vacía. ");
        }

        try {
            LocalTime.parse(hora, DateTimeFormatter.ofPattern("H:mm"));
        } catch (DateTimeParseException e) {
            throw new Exception("El formato de la hora es inválido. Usa HH:mm, por ejemplo 13:30. ");
        }
    }
}
