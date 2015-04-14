/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cfg.uapa.java.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cfg.uapa.java.entidades.Usuario;
import org.cfg.uapa.java.entidades.Cliente;

public class ServicioCliente {

    private static final ServicioCliente INSTANCIA = new ServicioCliente();

    public static ServicioCliente getInstancia() {
        return INSTANCIA;
    }

    public ServicioCliente() {
    }

    public List<Cliente> getListadoCliente() {

        List<Cliente> clientes = new ArrayList<>();

        try {

            Statement stmt = Coneccion.getInstancia().getConeccion().createStatement();

            ResultSet rs = stmt.executeQuery("select * from cliente");

            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setUsuario(rs.getString("usuario"));
                cliente.setClave(rs.getString("clave"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Error en el SQl");
        }

        return clientes;

    }

    public Usuario checkUsuario(String usuario, String clave) {

        Connection con = Coneccion.getInstancia().getConeccion();
        Usuario usuario1 = null;

        try (PreparedStatement pstmt = con.prepareStatement("select * from cliente where usuario = ? and clave= ?")) {

            pstmt.setString(1, usuario);
            pstmt.setString(2, clave);

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("Usuario: " + usuario + " Pass : " + clave);

                if (rs.next()) {

                    usuario1 = new Usuario();
                    usuario1.setCodigo(rs.getInt("id"));
                    usuario1.setNombres(rs.getString("nombre"));
                    usuario1.setApellidos(rs.getString("apellido"));
                    usuario1.setUsuario(rs.getString("usuario"));
                    usuario1.setPass(rs.getString("clave"));

                }
            }

        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).info(MessageFormat.format("Error en el SQl{0}", e.getMessage()));
            return null;
        }

        return usuario1;
    }

    public Cliente getClientePorId(int id) throws SQLException {

        String sql = "select * from cliente where id=?";

        Connection con = Coneccion.getInstancia().getConeccion();
        //PreparedStatement stmt = null;
        //ResultSet rs = null;
        Cliente cliente = null;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            //stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            //rs = stmt.executeQuery();
            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));

            } catch (SQLException e) {
                Logger.getLogger(ServicioEspecie.class.getName()).log(Level.SEVERE, null, e);
            } /*finally {
             try {
             if (rs != null) {
             rs.close();
             }
             if (stmt != null) {
             stmt.close();
             }
             if (con != null) {
             con.close();
             }
             } catch (SQLException e) {
             Logger.getLogger(ServicioEspecie.class.getName()).log(Level.SEVERE, null, e);
             }
             }*/

            return cliente;
        }
    }

}
