/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientehilos;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author luisgillamaignere
 */
public class Cliente {

    
    
    private ArrayList<String> contenidos=new ArrayList<String>();
   public static void main(String[] args) {
       
       
        Scanner entrada=new Scanner(System.in);
        try {
             System.out.println("Puerto:");
            int puerto = Integer.parseInt(entrada.nextLine());
            System.out.println("Cuantas conexiones quieres:");
            int conex = Integer.parseInt(entrada.nextLine());
            System.out.println("Cuantos mensajes envias:");
            int mensajes = Integer.parseInt(entrada.nextLine());
            new Cliente(puerto,conex,mensajes);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("El puerto debe ser un numero");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
       
        
    }
//constructor del cliente con las excepciones controladas
    public Cliente(int puerto,int conex,int mensajes) {
        try {
          
            //instancio el socket pasandole como parametro el puerto
           
            //instancio el controlador del cliente
            for (int i = 1; i <= conex; i++) {
              new ClienteHilos(puerto,"Cliente "+i,mensajes);
              
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

