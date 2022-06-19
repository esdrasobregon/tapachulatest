/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import data.credentials;
import entidades.unidades;
import entidades.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author esdra
 */
public class crudUnidades {

    public boolean add(unidades un) {
        boolean us = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = credentials.getConnector();
            //here sonoo is database name, root is username and password 
            PreparedStatement ps
                    = con.prepareStatement("insert into unidades "
                            + "(fecha_ingreso,"
                            + " marca,"
                            + " modelo,"
                            + " placa,"
                            + " activo,"
                            + " tipo) values (?,?,?,?,?,?)");
            ps.setString(1, un.getFecha_ingreso().toString());
            ps.setString(2, un.getMarca());
            ps.setInt(3, un.getModelo());
            ps.setString(4, un.getPlaca());
            ps.setInt(5, un.getActivo());
            ps.setInt(6, un.getTipo());
            ps.execute();
            con.close();
            us = true;
            return us;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

}
