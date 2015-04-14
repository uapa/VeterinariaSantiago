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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.cfg.uapa.java.entidades.Raza;

/**
 *
 * @author NAM
 */
public class ServicioRaza {

    private static final ServicioRaza INSTANCIA = new ServicioRaza();

    public static ServicioRaza getInstancia() {
        return INSTANCIA;
    }

    private ServicioRaza() {
    }

    public boolean crearRaza(Raza raza) {

        boolean estado = false;
        //PreparedStatement stmt = null ;
        String sql = "insert into raza(nombre,especied_id) values(?,?)";

        Connection con = Coneccion.getInstancia().getConeccion();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            //stmt = con.prepareStatement(sql);
            stmt.setString(1, raza.getNombre());
            stmt.setInt(2, raza.getEspecie().getId());

            stmt.executeUpdate();

            estado = true;

        } catch (SQLException e) {
            estado = false;
            Logger.getLogger(ServicioRaza.class.getName()).log(Level.SEVERE, null, e);
        }/*finally{
         if (stmt != null) {
         try {
         stmt.close();
         } catch (SQLException ex) {
         Logger.getLogger(ServicioRaza.class.getName()).log(Level.SEVERE, null, ex);
         }
         }
         }*/

        return estado;

    }

    public List<Raza> getListadoRazas() throws SQLException {

        List<Raza> lista = new ArrayList<>();

        String sql = "select * from raza";

        Connection con = Coneccion.getInstancia().getConeccion();
        //Statement stmt = null;
        //ResultSet rs = null;

        try (Statement stmt = con.createStatement()) {

            //stmt = con.createStatement();
            try (ResultSet rs = stmt.executeQuery(sql)) {
                //rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    Raza raza = new Raza();
                    raza.setId(rs.getInt("id"));
                    raza.setNombre(rs.getString("nombre"));
                    raza.setEspecie(ServicioEspecie.getInstancia().getEspeciePorId(rs.getInt("especied_id")));
                    lista.add(raza);
                }

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

            return lista;
        }
    }

    public Raza getRazaPorId(int id) throws SQLException {

        String sql = "select * from raza where id=?";

        Connection con = Coneccion.getInstancia().getConeccion();
        //PreparedStatement stmt = null;
        //ResultSet rs = null;
        Raza raza = null;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            //stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                //rs = stmt.executeQuery();

                rs.next();
                raza = new Raza();
                raza.setId(rs.getInt("id"));
                raza.setNombre(rs.getString("nombre"));

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

            return raza;
        }
    }

}
