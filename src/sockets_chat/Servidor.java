/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets_chat;

import java.io.*;
import java.net.*;
import javax.swing.DefaultListModel;
import javax.swing.*;
/**
 *
 * @author gustavo
 */
public class Servidor {
    
   private DefaultListModel mensajes_chat = new DefaultListModel();

    
    
    public Servidor()
    {
     
          try
        {
            ServerSocket socketServidor = new ServerSocket(20000);
            while (true)
            {
                Socket cliente = socketServidor.accept();
                Runnable nuevoCliente = new Hilo(mensajes_chat, cliente);
                Thread hilo = new Thread(nuevoCliente);
                hilo.start();
                //String nu = nuevoCliente.mensaje();
                //JOptionPane.showMessageDialog(null, nu);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[]args)
    {
        new Servidor();
    }
        
        
        
    }
    

