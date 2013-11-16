/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets_chat;
//modificacion
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author gustavo
 */
public class Hilo implements Runnable , ListDataListener{
    
    DefaultListModel mensajes_chat;
    Socket socket;
    DataInputStream dataInput;
    DataOutputStream dataOutput; 
    
    public String texto;
    
    public Hilo(DefaultListModel mensajes_chat, Socket socket)
    {
        this.mensajes_chat = mensajes_chat;
        this.socket = socket;
        try
        {
            dataInput = new DataInputStream(socket.getInputStream());
            dataOutput = new DataOutputStream(socket.getOutputStream());
            mensajes_chat.addListDataListener(this);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
 
        
    }
    
    public void run(){
    
        try
        {
            while (true)
            {
                String texto = dataInput.readUTF();
                synchronized (mensajes_chat)
                {
                    mensajes_chat.addElement(texto);
                    System.out.println(texto);
                }
                
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        
       
        
    }
    
     public void intervalAdded(ListDataEvent e)
    {
           String texto = (String) mensajes_chat.getElementAt(e.getIndex0());
           this.texto = texto;
        try
        {
            dataOutput.writeUTF(texto);
        } catch (Exception excepcion)
        {
            excepcion.printStackTrace();
        }
        
        
       
    }
     
     public void intervalRemoved(ListDataEvent e)
     {
         
     }
     public void contentsChanged(ListDataEvent e)
     {
         
     }
     
     public  String mensaje() 
             {
                 return this.texto;
             }
     
     
    
    
            
            
                
                        
                
    
}
