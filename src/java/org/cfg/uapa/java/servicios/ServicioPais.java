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
import org.cfg.uapa.java.entidades.Pais;

public class ServicioPais {

    private static final ServicioPais INSTANCIA = new ServicioPais();

    private ServicioPais() {
    }

    public static ServicioPais getInstancia() {
        return INSTANCIA;
    }

    public List<Pais> getListadoPais() throws SQLException {

        List<Pais> lista = new ArrayList<>();

        String sql = "select * from pais";

        Connection con = Coneccion.getInstancia().getConeccion();
        //Statement stmt = null;
        //ResultSet rs = null;

        try (Statement stmt = con.createStatement()) {

            //stmt = con.createStatement();
            try (ResultSet rs = stmt.executeQuery(sql)) {
                //rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    Pais pais = new Pais();
                    pais.setId(rs.getInt("id"));
                    pais.setDescripcion(rs.getString("descripcion"));

                    lista.add(pais);
                }

            } catch (SQLException e) {
                Logger.getLogger(ServicioPais.class.getName()).log(Level.SEVERE, null, e);
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
             Logger.getLogger(ServicioPais.class.getName()).log(Level.SEVERE, null, e);
             }
             }*/

            return lista;
        }
    }

    public Pais getPaisPorId(int id) throws SQLException {

        String sql = "select * from pais where id=?";

        Connection con = Coneccion.getInstancia().getConeccion();
        //PreparedStatement stmt = null;
        //ResultSet rs = null;
        Pais pais = null;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            //stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                //rs = stmt.executeQuery();

                rs.next();
                pais = new Pais();
                pais.setId(rs.getInt("id"));
                pais.setDescripcion(rs.getString("descripcion"));

            } catch (SQLException e) {
                Logger.getLogger(ServicioPais.class.getName()).log(Level.SEVERE, null, e);
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
             Logger.getLogger(ServicioPais.class.getName()).log(Level.SEVERE, null, e);
             }
             }*/

            return pais;
        }
    }
}
