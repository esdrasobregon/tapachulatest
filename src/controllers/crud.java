/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controllers;

import entidades.usuario;

/**
 *
 * @author esdra
 */
public interface crud {
    
    public boolean add();
    public usuario login(String contrasenya, String usuario);
    public boolean delete();
    public boolean update();
    
}
