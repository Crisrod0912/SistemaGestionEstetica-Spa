package Model;

abstract class Miembro extends Persona {

    protected double salario;

    public Miembro(String nombre, String apellido, String fechaNacimiento, String identificacion, double salario) {
        super(nombre, apellido, fechaNacimiento, identificacion);
        this.salario = salario;
    }

    public Miembro() {
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public abstract double calcularSalario();
}
