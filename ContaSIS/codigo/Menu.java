import java.io.File;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Menu {

    public static void PedirDatos(int opc){

        Balance Bal = new Balance(); // Instancio la clase Balance para llamar los metodos que ocupe
        Estado Est = new Estado();

        String TipoC [] = {"Activo","Pasivo"}; 
        String TipoCE [] = {"Ingreso","Costo","Gasto"};

                    int tipo=0;
                    String tipoStr="";
                    String nom="";
                    String MontStr="";
                    double mont=0;
                    int conti=0;


                    while (conti!=1) {
                    if (opc==0) { // Para las cuentas del balance
                        
                        tipo = JOptionPane.showOptionDialog(null, "Seleccione el Tipo de Cuenta", "Tipo de Cuenta", 0, 1, null, TipoC, null); 
                        // Este metodo solo devuelve 0 y 1 dependiendo de la opcion elegida (0 es activo y 1 es pasivo)

                        nom = JOptionPane.showInputDialog(null,"Ingrese el Nombre de la Cuenta:","Cuenta:",1);

                        MontStr = JOptionPane.showInputDialog(null,"Ingrese el Monto de la Cuenta:","Monto:",1);
                    }else{ // Para las cuentas del Estado

                        tipo = JOptionPane.showOptionDialog(null, "Seleccione el Tipo de Cuenta", "Tipo de Cuenta", 0, 1, null, TipoCE, null); 

                        nom = JOptionPane.showInputDialog(null,"Ingrese el Nombre de la Cuenta:","Cuenta:",1);

                        MontStr = JOptionPane.showInputDialog(null,"Ingrese el Monto de la Cuenta:","Monto:",1);
                    }

                    try {
                        Double.parseDouble(nom);
                        JOptionPane.showMessageDialog(null, "Error: Caracteres No validos (Solo letras)");
                    } catch (Exception e) {

                    try {
                        mont = Double.parseDouble(MontStr); // convertimos a double
                    if(opc==0){ // Decide que cuentas va usar el objeto para ser creado
                        tipoStr = TipoC[tipo]; // Guarda el texto de la posicion que devuelva (tipo) 
                    }else{
                        tipoStr = TipoCE[tipo]; 
                    }    
                        Cuenta c = new Cuenta(tipoStr,nom,mont); // Instancio el constuctor

                    if(opc==0){    
                        if(tipo==0){
                            Bal.AgCuentaActivos(c); // Accedo al metodo AgCuentaActivos() de la clase Balance para enviar el objeto
                        }
                        else{
                            Bal.AgCuentaPasivos(c);
                        }
                    }else{
                        if (tipo==0) {
                            Est.AgCuentaIngresos(c);
                        }else if(tipo==1){
                            Est.AgCuentaCosto(c);
                        }else{
                            Est.AgCuentagGastos(c);
                        }
                        // Mandar cuentas Ingreso costo y gasto a Estado de resultados
                    }
                        String SiNo [] = {"Si","No"};

                        conti = JOptionPane.showOptionDialog(null, "Agregar Otra Cuenta?:", "Cuenta", 0, 3, null, SiNo, null);
                        // Preguntamos si quiere agregar otra cuenta
                    }catch(Exception a){
                        JOptionPane.showMessageDialog(null, "Error: Caracteres No validos (Solo Numeros)");
                    }

                    }

                }    

                if(opc==0){
                    Bal.CalcularBalance();
                }else{
                    Est.CalcularEstado();
                }                
        }

    public static void main(String[] args) {
        
        Balance Bal = new Balance();
        int opc;

        do{

            String ops [] = {"Balance General","Estado de Resultados","Salir"};

            opc = JOptionPane.showOptionDialog(null, "Seleccione la Operacion a Realizar:", "Menu:", 0, 1, null, ops, null);

            switch (opc) {
                case 0:
                    PedirDatos(opc); // Llamo al metodo pedir datos que pide el valor opcion de operacion elegida
                break;

                case 1:
                    PedirDatos(opc);
                break;
            }
            
        }while(opc!=2);


    }
}
