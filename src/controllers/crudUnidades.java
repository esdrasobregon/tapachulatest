/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import data.credentials;
import entidades.unidades;
import entidades.usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
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
            ps.setDate(1, new Date(un.getFecha_ingreso().getTime()));
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

    public boolean delete(unidades un) {
        boolean us = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = credentials.getConnector();
            //here sonoo is database name, root is username and password 
            PreparedStatement ps
                    = con.prepareStatement("delete from unidades where idbus = ?");
            ps.setInt(1, un.getIdbus());
            ps.execute();
            con.close();
            us = true;
            return us;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public ArrayList<unidades> getAllUnidades() {
        ArrayList<unidades> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = credentials.getConnector();
            //here sonoo is database name, root is username and password 
            PreparedStatement ps
                    = con.prepareStatement("select "
                            + "idbus,"
                            + " activo,"
                            + " tipo,"
                            + " fecha_ingreso,"
                            + " modelo,"
                            + " placa,"
                            + " marca"
                            + " from unidades"
                    );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                unidades un = new unidades();
                un.setIdbus(rs.getInt(1));
                un.setActivo(rs.getInt(2));
                un.setTipo(rs.getInt(3));
                un.setFecha_ingreso(rs.getDate(4));
                un.setModelo(rs.getInt(5));
                un.setPlaca(rs.getString(6));
                un.setMarca(rs.getString(7));
                list.add(un);
            }
            con.close();
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

}
