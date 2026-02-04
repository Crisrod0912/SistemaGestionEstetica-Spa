package Model;

public class EspacioAtencion {

    private int numero;
    private boolean disponible;
    private Cliente cliente;

    public EspacioAtencion(int numero) {
        this.numero = numero;
        this.disponible = true;
        this.cliente = null;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void asignarPaciente(Cliente cliente) throws Exception {
        if (disponible) {
            disponible = false;
            this.cliente = cliente;
            System.out.println("Cabina " + numero + " asignada. ");
        } else {
            throw new Exception("La cabina " + numero + " no esta disponible. ");
        }
    }

    public void liberarHabitacion() throws Exception {
        if (cliente == null) {
            throw new Exception("La cabina " + numero + " no tiene un cliente asignado. ");
        }
        disponible = true;
        this.cliente = null;
        System.out.println("Cabina " + numero + " liberada. ");
    }
}
