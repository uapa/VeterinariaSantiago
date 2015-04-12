/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cfg.uapa.java.servicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cfg.uapa.java.entidades.Cliente;

public class ServicioRegistro {
    private static final ServicioRegistro INSTANCIA = new ServicioRegistro();
    
    public static ServicioRegistro getInstancia() {
        return INSTANCIA;
    }
    private ServicioRegistro() {
    }
    
    public boolean crearCliente(Cliente cliente) {

        boolean estado = false;
        PreparedStatement stmt = null ;
        String sql = "insert into cliente(nombre,apellido,telefono,calle,apartamento,ciudad,pais_id,usuario,clave) values(?,?,?,?,?,?,?,?,?)";
        
         Connection con = Coneccion.getInstancia().getConeccion();

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getCalle());
            stmt.setString(5, cliente.getApartamento());
            stmt.setString(6, cliente.getCiudad());
            stmt.setInt(7, cliente.getPais().getId());
            stmt.setString(8, cliente.getUsuario());
            stmt.setString(9, cliente.getClave());

            stmt.executeUpdate();
            
            estado = true;

        } catch (SQLException e) {
            estado = false;
             Logger.getLogger(ServicioRegistro.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServicioRegistro.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
        }
        
        return estado;

    }
    
    
    
}
