
package ejemploArchivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EjemploArchivo {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"Iniciamos escribiendo un archivo.\nNombre el archivo con su numero de carnet");
        escribirArchivo();

    }
    
    public static void escribirArchivo(){
        JOptionPane.showMessageDialog(null, "Ejemplo crear archivo");
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto","txt");
        
        JFileChooser seleccionador = new JFileChooser();
        seleccionador.setFileFilter(filtro);
        seleccionador.setDialogTitle("Abrir");
        
        seleccionador.showOpenDialog(null);
        
        if (seleccionador.getSelectedFile() != null) {
            File archivo = seleccionador.getSelectedFile();
            PrintWriter flujoSalida = null;
            try {
                flujoSalida = new PrintWriter(archivo+".txt");
            }
            catch(FileNotFoundException e){
                JOptionPane.showMessageDialog(null, "Error al intentar abrir el archivo" +archivo);
                System.exit(0);
            }
            
            JOptionPane.showMessageDialog(null, "Deberá ingresa tres líneas de texto");
            for (int i = 1; i <= 3; i++) {
                String linea = JOptionPane.showInputDialog("Ingrese la línea " + i);
                flujoSalida.println(i + " " + linea);
            }
            
            flujoSalida.close();
            
            JOptionPane.showMessageDialog(null, "El texto fue guardado en el archivo: " +archivo);
        } 
    }  
}
