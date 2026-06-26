import java.util.*;
import javax.swing.*;
import java.io.*;

public class Estado {

    ArrayList<Cuenta> cuentasIngresos = new ArrayList<>();
    ArrayList<Cuenta> cuentasCostos = new ArrayList<>();
    ArrayList<Cuenta> cuentasGastos = new ArrayList<>();

    public void AgCuentaIngresos(Cuenta c) {
        cuentasIngresos.add(c);
    }

    public void AgCuentaCosto(Cuenta c) {
        cuentasCostos.add(c);
    }

    public void AgCuentagGastos(Cuenta c) {
        cuentasGastos.add(c);
    }

    public String PedirFecha() {
        String dia;
        String mes;
        String año;

        dia = JOptionPane.showInputDialog(null, "Ingrese el dia:", "Fecha:", 1);

        mes = JOptionPane.showInputDialog(null, "Ingrese el mes", "Fecha:", 1);

        año = JOptionPane.showInputDialog(null, "Ingrese el año", "Fecha:", 1);

        return dia + "/" + mes + "/" + año;
    }

    public void CalcularEstado() {

        String fechaIni;
        String fechaFin;

        JOptionPane.showMessageDialog(null, "Ingrese la Fecha de Inicio:");
        fechaIni = PedirFecha();
        JOptionPane.showMessageDialog(null, "Ingrese la Fecha Final:");
        fechaFin = PedirFecha();

        double TotIngresos = 0;
        double TotCostos = 0;
        double TotGastos = 0;

        try {

        JOptionPane.showMessageDialog(null, "Seleccione la carpeta de destino para guardar sus reportes");

        String ruta="";
        JFileChooser fileChooser = new JFileChooser(); // Instancio el componente Filechooser para seleccionar archivos

        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // uso la instancia del componente instanciada con el metodo (setFileSelectionMode) y el parametro (JFileChooser.DIRECTORIES_ONLY) para que solo permita seleccionar carpetas

        int resultado = fileChooser.showOpenDialog(null); // Abre la ventana para que el usuario elija la carpeta y guarda el resultado que retorna el metodo

            if (resultado == JFileChooser.APPROVE_OPTION) { // valida que el usuario presiono "Aceptar"
                File carpSelec = fileChooser.getSelectedFile(); //Obtiene la carpeta seleccionada
                ruta = carpSelec.getAbsolutePath(); // Guarda la ruta de la carpeta
            } else {
                System.out.println("Selección cancelada.");
            }

        String nombreRep = JOptionPane.showInputDialog("Ingresa el nombre del archivo:");    

            FileWriter archivo = new FileWriter(ruta+"/"+nombreRep+".txt");
            PrintWriter escribir = new PrintWriter(archivo);

            escribir.println("ESTADO DE RESULTADOS: ");
            escribir.println("Periodo: " + fechaIni + " al " + fechaFin);
            escribir.println("----------------");

            for (int i = 0; i < cuentasIngresos.size(); i++) {
                double Ingresos = cuentasIngresos.get(i).getMonto();
                TotIngresos = TotIngresos + Ingresos;
                escribir.println(cuentasIngresos.get(i).getNombre() + ": $" + cuentasIngresos.get(i).getMonto());
            }
            escribir.println("Total Ingresos: $" + TotIngresos);
            System.out.println("Total Ingresos: $" + TotIngresos);

            escribir.println("----------------");

            for (int i = 0; i < cuentasCostos.size(); i++) {
                double Costos = cuentasCostos.get(i).getMonto();
                TotCostos = TotCostos + Costos;
                escribir.println(cuentasCostos.get(i).getNombre() + ": $" + cuentasCostos.get(i).getMonto());
            }
            escribir.println("Total Costos: $" + TotCostos);
            System.out.println("Total Costos: $" + TotCostos);

            escribir.println("----------------");

            double UtilidadBruta = TotIngresos - TotCostos;
            escribir.println("Utilidad Bruta: $" + UtilidadBruta);
            System.out.println("Utilidad Bruta: $" + UtilidadBruta);

            escribir.println("----------------");

            for (int i = 0; i < cuentasGastos.size(); i++) {
                double Gastos = cuentasGastos.get(i).getMonto();
                TotGastos = TotGastos + Gastos;
                escribir.println(cuentasGastos.get(i).getNombre() + ": $" + cuentasGastos.get(i).getMonto());
            }
            escribir.println("Total Gastos: $" + TotGastos);
            System.out.println("Total Gastos: $" + TotGastos);

            escribir.println("----------------");

            double UtilidadNeta = UtilidadBruta - TotGastos;
            escribir.println("Utilidad Neta: $" + UtilidadNeta);
            System.out.println("Utilidad Neta: $" + UtilidadNeta);

            escribir.close();

            JTextArea MostrarRes = new JTextArea();
            MostrarRes.setText("Periodo: " + fechaIni + " al " + fechaFin + "\n" +
                    "Total Ingresos: $" + TotIngresos + "\n" +
                    "Total Costos: $" + TotCostos + "\n" +
                    "Utilidad Bruta: $" + UtilidadBruta + "\n" +
                    "Total Gastos: $" + TotGastos + "\n" +
                    "Utilidad Neta: $" + UtilidadNeta);

            JOptionPane.showMessageDialog(null, MostrarRes);

        } catch (Exception e) {
            System.out.println("Error de Archivo");
        }
    }

}