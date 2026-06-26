import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.io.*;

public class Balance {

    ArrayList<Cuenta> cuentasAct = new ArrayList<>();
    ArrayList<Cuenta> cuentasPas = new ArrayList<>();
 
    public void AgCuentaActivos(Cuenta c){ // Este metodo recibe el objeto cuenta = tipo (clase) y c = variable(parametro) en pocas palabras recibe el objeto lo nombra "c" y guarda en el ArrayList
        cuentasAct.add(c); 
    }

    public void AgCuentaPasivos(Cuenta c){ // Lo mismo con este pero recibe los pasivos
        cuentasPas.add(c);
    }

    public void CalcularBalance(){

    double TotActivos=0;

    try{

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
    
        FileWriter archivo = new FileWriter(ruta+"/"+nombreRep+".txt"); // Instancio el metodo writer para crear el archivo y donde se guarda
        PrintWriter escribir = new PrintWriter(archivo); // Instancio el metodo PrintWriter para editar el archivo
        
        JOptionPane.showMessageDialog(null, "Guardado exitosamente en: " +ruta); //Muestro donde se guardo la ruta

        escribir.println("BALANCE GENERAL: ");
        escribir.println("----------------");
        
        for(int i=0; i<cuentasAct.size();i++){
           double Activos = cuentasAct.get(i).getMonto();
           TotActivos = TotActivos+Activos;

           escribir.println(cuentasAct.get(i).getNombre() + ": $" + cuentasAct.get(i).getMonto());// Guardo cuentas en el .txt
        }
        escribir.println("Total Activos: $"+TotActivos); // Guardo su total

        escribir.println("----------------"); // inserto linea de separacion en el txt

        double TotPasivos=0;

        for(int i=0; i<cuentasPas.size();i++){
           double Pasivos = cuentasPas.get(i).getMonto();
           TotPasivos = TotPasivos+Pasivos;

           escribir.println(cuentasPas.get(i).getNombre()+": $"+cuentasPas.get(i).getMonto());// Guardo cuentas en el .txt
        }
        escribir.println("Total Pasivos: $"+TotPasivos); // Guardo su total

        escribir.println("----------------");

        double Capital;

        Capital = TotActivos-TotPasivos;

        escribir.println("Capital: $"+Capital); // Guardo capital
        escribir.close();

        JTextArea MostrarRes = new JTextArea(); //  Instancio un JArea para mostrar los resultados

        MostrarRes.setText("Total de Activos: $"+TotActivos+"\n"+"Total de Pasivos: $"+TotPasivos+"\n"+"Capital: $"+Capital); // Indicamos lo que quiero mostrar

        JOptionPane.showMessageDialog(null, MostrarRes); // Se muestra

    }catch(Exception e){
        System.out.println("Error de Archivo");
    }
       
    }

}
