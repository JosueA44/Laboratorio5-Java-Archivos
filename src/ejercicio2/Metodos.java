
package ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Metodos {
    Vector vPrincipal=new Vector();
    
    public void guardar(Palabras palabras){
        vPrincipal.add(palabras);
    }
    
     public void guardarArchivo(Palabras palabra,String n){
        try{
            FileWriter fw=new FileWriter(n,true);
            BufferedWriter bw =new BufferedWriter(fw);
            PrintWriter pw =new PrintWriter(bw);
            pw.println(palabra.getPalabra());
            pw.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void crearArchivo(String n){
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
        flujoSalida.close();
            
        JOptionPane.showMessageDialog(null, "El texto fue guardado en el archivo: " +archivo);
    }
    
    public DefaultTableModel lista(String n){
        Vector cabeceras=new Vector();
        cabeceras.addElement("Datos");
        DefaultTableModel mdlTabla=new DefaultTableModel(cabeceras,0);
        try{
            FileReader fw=new FileReader(n);
            BufferedReader bw =new BufferedReader(fw);
            String d;
             while((d=bw.readLine())!=null){
                StringTokenizer dato=new StringTokenizer(d,"");  
                Vector x=new Vector();
                while(dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                }
                mdlTabla.addRow(x);
             }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return mdlTabla;
    }
    
    ///Elimina todos los datos de la fila
    public void limpiarTabla(JTable tabla){
        try {
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
  
}
