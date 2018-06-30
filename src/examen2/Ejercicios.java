/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author turupawn
 */
public class Ejercicios 
{
    static void guardar(String nombre_archivo, ArrayList<Producto> productos)
    {
        try
        {
            PrintWriter prod = new PrintWriter(nombre_archivo);

            for(Producto pro : productos)
            {
                prod.println(pro.nombre + " " + pro.categoria+" "+ pro.existencias+" "+pro.precio);
            }

            prod.close();
        }
        catch (Exception i)
        {
            System.out.println("No se a podido guardar, intente de nuevo ");
        }
    }
    
    static ArrayList<Producto> abrir(String nombre_archivo)
    {
        ArrayList<Producto> prod= new ArrayList<>(); 
        try
        {
            Scanner scanner = new Scanner(new File(nombre_archivo));
            while(scanner.hasNext())
            {
                
                String nombre = scanner.next();
                String categoria = scanner.next();
                int existencias = scanner.nextInt();
                double precio = scanner.nextDouble();
                prod.add (new Producto (nombre, categoria, existencias, precio) );
            }
            scanner.close();
        }
        catch(Exception i)
        {
            System.out.print("Nose pudo leer el archivo");
        }
        return prod;
       
    }
}
