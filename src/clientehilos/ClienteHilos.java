/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientehilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author luisgillamaignere
 */
public class ClienteHilos extends Thread{

    Socket socket;
    private DataInputStream dataInput;
    private String nombre;
    //creo el flujo de datos de salida del socket
    private DataOutputStream dataOutput;
    int mensajes;
    public ClienteHilos(int puerto,String nombre,int mensajes){
        
        this.mensajes=mensajes;
        this.nombre=nombre;
        try {
            socket=new Socket("Localhost",puerto);
            dataInput = new DataInputStream(socket.getInputStream());
            dataOutput = new DataOutputStream(socket.getOutputStream());
            Thread hilo = new Thread(this);
            hilo.start();
            
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
    }
    
    public void run() {
       try {
            //recibo los datos
            
            //variable que controla que no se haya escrito salir
            
            //mientras no se escriba salir sigue con el bucle
           
               for (int i = 1; i <= mensajes; i++) {
                    dataOutput.writeUTF(nombre+"-->Este es el mensaje "+i);
                

                String texto = dataInput.readUTF();
                
                
                //System.out.println("El servidor dice:" + texto);
                
               System.out.println(texto);
               
           }
                
              
                 
                
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
