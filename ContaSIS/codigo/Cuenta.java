public class Cuenta {
    String Tipo;
    String Nombre;
    double Monto;

    // Esta clase guarda las cuentas

    public Cuenta(String Tipo,String Nombre, double Monto ){
        this.Tipo=Tipo;
        this.Nombre=Nombre;
        this.Monto=Monto;

        // Un metodo Constructor para crear las cuentas
        
    }

    public String getTipo(){
        return Tipo;
    }

    public String getNombre(){
        return Nombre;
    }

    public double getMonto(){
        return Monto;
    }

    // Getters para obtener cada atributo del objeto

    public String toString(){
        return Tipo + "-" + Nombre + "-" + Monto; // Esta metodo indica como deben mostrarse los objetos (Para que no muestre la ruta donde se guarda)
    }
}
