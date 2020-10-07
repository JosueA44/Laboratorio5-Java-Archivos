
package ejercicio1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Metodos {
    
    private String texto="";
    
    public void escribirArchivo(String n){
        JOptionPane.showMessageDialog(null, "Creando Archivo");

            File archivo = new File(n);
            PrintWriter flujoSalida = null;
            try {
                flujoSalida = new PrintWriter(archivo);
            }
            catch(FileNotFoundException e){
                JOptionPane.showMessageDialog(null, "Error al intentar abrir el archivo" +archivo);
                System.exit(0);
            }
            
            JOptionPane.showMessageDialog(null, "Deberá ingresa una línea de texto");
            for (int i = 1; i <= 1; i++) {
                String linea = JOptionPane.showInputDialog("Ingrese la línea ");
                flujoSalida.println(linea);
            }
            
            flujoSalida.close();
            
            JOptionPane.showMessageDialog(null, "El texto fue guardado en el archivo: " +archivo);
        
    }
   
    public void leerArchivo(String n){
     try{
         BufferedReader bf=new BufferedReader(new FileReader(n));
         String tem="";
         String bfRead;
         while((bfRead=bf.readLine())!=null){
             tem=tem+bfRead;
         }
    
         texto=tem;
     }
     catch(Exception e){
          System.err.println("Ocurrio un error: No se encuentra el archivo");
    }
        System.out.println(texto);
    }
    
    
}
