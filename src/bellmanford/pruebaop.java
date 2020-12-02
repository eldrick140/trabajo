
package bellmanford;
import java.util.ArrayList;
import java.util.Scanner;



/**
 * @author Eldrick Mendoza
 */
public class pruebaop {
    
    
    public static void bellmanford(ArrayList<ArrayList<Integer>> listaop, int nodos, int aristas, int nodop)
    {
        //algoritmo de bellman-ford utilizando una lista de listas de numeros enteros 
        //primero se colocan distancias maximas a un nuervo arreglo de distancias que ira alamacenando varibles
        int[] distancia = new int[nodos];
        for(int i=0; i<nodos; i++)
        {
            distancia[i]=1000;
        }
        distancia[nodop]=0;
        /*se recorren todos los datos de la lista mayor ingresados para asi ir ctualizando las lista de distancias 
          segun encuentre una distancia menor*/
        for(int i=1;i<=nodos;i++)
        {
            for(int j=0;j<aristas;j++)
            {
                //para cada arista o dato que esta en la lista de datos, se van dando los valores y ingresandolos al if, para 
                //ver si la comparacion entre estos con los que ya entan en la lista de distancia son menores
                // y de ser asi, de cambiara la data que hay en la lista de distancias 
                int inicio = listaop.get(j).get(0);
                int destino = listaop.get(j).get(1);
                int peso = listaop.get(j).get(2);
                if((distancia[inicio]+peso)<distancia[destino])
                {
                    distancia[destino]=distancia[inicio]+peso;
                }
            }
        }
        // un for que realiza nuevamente el recorrido de la data para ver si  se tienen ciclos negativos  y de ser asi imprimir un aviso
        for(int i=0;i<aristas;i++)
        {
            int inicio = listaop.get(i).get(0);
            int destino = listaop.get(i).get(1);
            int peso = listaop.get(i).get(2);
            
            if((distancia[inicio]+peso)<distancia[destino])
                {
                    System.out.println("este grafico contiene un ciclo negativo");
                }
        }
        
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("UTILIZANDO EL NODO "+nodop+ " COMO NODO PRINCIPAL LAS DISTANCIAS MINIMAS SERIAN");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("");
        for(int i=0; i<nodos; i++)
        {
            System.out.println("Hasta el nodo "+ i + " la distancia seria de: "+distancia[i]);
        }
        System.out.println("");
        System.out.println("----------------------------------------------------------------------");
   
    }
    

    public static void main(String[] args) 
    {
        // se incresa la localidad del archivo de texto para asi sacar los datos de este y colocarlos al array list
        texto a = new texto();
        ArrayList<ArrayList<Integer>> lit = new ArrayList<ArrayList<Integer>>();
        lit = a.leertext("C:\\Users\\Eldrick Mendoza\\Desktop\\6cicloOP\\REDES OP\\textoop\\rednumero2.txt");
            
        // se ingresan los datos principales de la topoliguia (la cantidad de los nodos de la red,  la cantidad de aristas y el nodo principal
        Scanner sc = new Scanner(System.in);
        System.out.println("ingresar el numero de nodos de el grafico: "); 
        int nodos=sc.nextInt();
        System.out.println("ingrear el numero de aristas del el grafico: ");
        int aristas= sc.nextInt();
        System.out.println("ingresar el numero del nodo principal del grafico: ");
        int nodop=sc.nextInt();
        
        // se ejecuta el algoritmo principal dandole todos los datos necesarios como parametros
        

        
        long startTime = System.nanoTime();
        bellmanford(lit, nodos, aristas, nodop); 
        long endTime = System.nanoTime() - startTime; 
       
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) + " bytes.");
        System.out.println("tiempo transcurrido: " + endTime/1e6 + "ms");
        
        // para la red 1 ingresar los datos :  5 | 7 | 0
        // para la red 2 ingresar los datos :  8 | 18 | 0
        // para la red 3 ingresar los datos :  16 | 56 | 0
    }
}
