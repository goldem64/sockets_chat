/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets_chat;

import java.net.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.math.*;

/**
 *
 * @author gustavo
 */
public class Cliente {
    
    private Socket socket;
    
    private PanelCliente panel;
    
    public Cliente()
    {
        try
        {
            
            ventana();
            socket = new Socket("localhost",20000);
            ControlCliente control = new ControlCliente(socket,panel);
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void ventana()
    {
        JFrame f = new JFrame();
        panel = new PanelCliente(f.getContentPane());
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
        
    }
    
    public static void main(String[]args)
    {
        new Cliente();
    }
            
    
    
}
