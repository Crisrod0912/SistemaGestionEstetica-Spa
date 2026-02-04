package Model;

public class Factura {

    private Reserva reserva;
    private Cliente cliente;
    private double monto;

    public Factura(Reserva reserva, double monto) {
        if (reserva == null || reserva.getCliente() == null) {
            throw new IllegalArgumentException("La reserva o el cliente no pueden ser nulos. ");
        }
        if (monto < 0) {
            throw new IllegalArgumentException("El monto de la factura no puede ser negativo. ");
        }

        this.reserva = reserva;
        this.cliente = reserva.getCliente();
        this.monto = monto;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("El monto de la factura no puede ser negativo. ");
        }
        this.monto = monto;
    }

    public void mostrarFactura() {
        if (cliente == null || cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
            throw new IllegalStateException("No se puede mostrar la factura, el paciente no tiene nombre. ");
        }
        System.out.println("Factura para " + cliente.getNombre() + ": $" + monto + ". ");
    }
}
