/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets_chat;

/**
 *
 * @author gustavo
 */

    
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class PanelCliente {




   
    private JScrollPane scroll;

    
    private JTextArea textArea;

  
    private JTextField textField;

  
    private JButton boton;


    public PanelCliente(Container contenedor)
    {
        contenedor.setLayout(new BorderLayout());
        textArea = new JTextArea();
        scroll = new JScrollPane(textArea);

        JPanel panel = new JPanel(new FlowLayout());
        textField = new JTextField(50);
        boton = new JButton("Enviar");
        panel.add(textField);
        panel.add(boton);

        contenedor.add(scroll, BorderLayout.CENTER);
        contenedor.add(panel, BorderLayout.SOUTH);
    }

  
    public void addActionListener(ActionListener accion)
    {
        textField.addActionListener(accion);
        boton.addActionListener(accion);

    }

  
    public void addTexto(String texto)
    {
        textArea.append(texto);
    }

   
    
    public String getTexto()
    {
        String texto = textField.getText();
        textField.setText("");
        return texto;
    }
}

    

