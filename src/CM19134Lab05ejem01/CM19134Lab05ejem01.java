
package CM19134Lab05ejem01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CM19134Lab05ejem01 {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"Iniciamos escribiendo un archivo.\nNombre el archivo con su numero de carnet");
        escribirArchivo();
        JOptionPane.showMessageDialog(null, "Ahora leeremos el archivo creado.\nElija el nombre del archivo recién creado");
        leerArchivo();
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
    
    public static void leerArchivo(){
        JOptionPane.showMessageDialog(null, "Ejemplo leer archivo");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto","txt");
        JFileChooser seleccionador = new JFileChooser();
        seleccionador.setFileFilter(filtro);
        seleccionador.setDialogTitle("Abrir");
        seleccionador.showOpenDialog(null);
        if (seleccionador.getSelectedFile() != null) {
            File nombreArchivo = seleccionador.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Ejemplo leer archivo");
            try {
                FileInputStream fstream = new FileInputStream(nombreArchivo);
                DataInputStream entrada = new DataInputStream(fstream);
                BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
                String strLinea;
                while ((strLinea = buffer.readLine()) != null) {
                    System.out.println(strLinea);
                }
                entrada.close();
            }
            catch (Exception e) { 
                System.err.println("Ocurrio un error: " + e.getMessage());
            }
        }

    }   
    
}
