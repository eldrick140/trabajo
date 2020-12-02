/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bellmanford;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Eldrick Mendoza
 */
public class texto {
    
    public ArrayList leertext (String direccion)
    {
        // recoge la informacion y los dato desde el archivo de texto y los mete a un array list 
        ArrayList<ArrayList<Integer>> listOLists = new ArrayList<ArrayList<Integer>>();
        String texto = "";
        try
        {
            int cont = 0;
            BufferedReader bf = new BufferedReader (new FileReader(direccion));
            
            String bfRead;
            while((bfRead = bf.readLine()) != null)
            {
                /* se separa los datos del archivo por espacios donde el primer dato sera el nodo inicial el segundo el nodo destino 
                y el tercero la distancia*/
                ArrayList<Integer> list = new ArrayList<Integer>();
                int j = 0;
                String linea = bfRead;
                String [] campos = linea.split(" ");
                while(j<campos.length)  // se ingresan los datos a la lita que enteros que luego se añadra al arraylist
                {
//                  System.out.println(campos[j]);
                    list.add(Integer.valueOf(campos[j]));
                    j++;
                }                        
                listOLists.add(list);
                cont++;
            } 
        }
        // esta parte se activa si es que se encuentra algun error en el archivo de texto
        catch(Exception e)
        {
            System.out.println("no se encontro archivo");
        }
        
    return listOLists;   
    }    
}
