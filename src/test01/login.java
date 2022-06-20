/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test01;

import controllers.crudUsuario;
import entidades.usuario;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author esdra
 */
public class login extends JFrame implements ActionListener {

    JButton btnIngresar, btnSalir;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    JTextField txtUsuario, txtContrasenya;
    usuario currentUsser;

    public login() {
        this.currentUsser = null;
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Welcome");
        setSize(300, 150);
        setResizable(false);
        setControllers();
        add(newPanel);

    }

    private void setControllers() {
        //create label for username   
        userLabel = new JLabel();
        userLabel.setText("Username");      //set label value for textField1  

        //create text field to get username from the user  
        txtUsuario = new JTextField(15);
        passLabel = new JLabel();
        passLabel.setText("Password");
        //create text field to get password from the user  
        txtContrasenya = new JPasswordField(15);    //set length for the password  

        //create submit button  
        btnIngresar = new JButton("Ingresar"); //set label to button  
        this.btnSalir = new JButton("Salir");

        newPanel = new JPanel();
        newPanel.setSize(100, 500);
        newPanel.add(userLabel);    //set username label to pa
        newPanel.add(txtUsuario);   //set text field to panel  
        newPanel.add(passLabel);    //set password label to panel  
        newPanel.add(txtContrasenya);   //set text field to panel  
        //add event listeners to the buttos
        btnIngresarEventListener();
        this.btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        newPanel.add(btnIngresar);
        newPanel.add(this.btnSalir);
    }

    private void btnIngresarEventListener() {
        this.btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crudUsuario crud = new crudUsuario();
                String usuario = txtUsuario.getText();
                String contrasenya = txtContrasenya.getText();
                //usuario us = crud.login(contrasenya, usuario);
                usuario us = crud.login("12345", "edras");
                if (us.getNombreUsuario() != null) {
                    JOptionPane.showMessageDialog(null, "Bienvenido: " + us.getNombreUsuario());
                    currentUsser = us;
                    formUnidades in = new formUnidades();

                    in.setVisible(true);

                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña erronea");
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
