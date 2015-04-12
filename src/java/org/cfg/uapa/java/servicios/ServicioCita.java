/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cfg.uapa.java.servicios;

import org.cfg.uapa.java.entidades.Cita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NAM
 */
public class ServicioCita {

    private static final ServicioCita INSTANCIA = new ServicioCita();

    public static ServicioCita getInstancia() {
        return INSTANCIA;
    }

    private ServicioCita() {
    }

    public boolean crearCita(Cita cita) {

        boolean estado;
        //PreparedStatement stmt = null ;
        String sql = "insert into cita(fecha,paciente_id,doctor_id,razon) values(?,?,?,?)";

        Connection con = Coneccion.getInstancia().getConeccion();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            //stmt = con.prepareStatement(sql);
            stmt.setString(1, cita.getFecha());
            stmt.setInt(2, cita.getPaciente().getId());
            stmt.setInt(3, cita.getDoctor().getId());
            stmt.setString(4, cita.getRazon());

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

    public List<Cita> getListadoCita() {

        List<Cita> lista = new ArrayList<>();

        String sql = "select * from cita";

        Connection con = Coneccion.getInstancia().getConeccion();
        //Statement stmt = null;
        //ResultSet rs = null;

        try (Statement stmt = con.createStatement()) {

            //stmt = con.createStatement();
            //rs = stmt.executeQuery(sql);
            try (ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Cita cita = new Cita();
                    cita.setId(rs.getInt("id"));
                    cita.setFecha(rs.getString("fecha"));
                    cita.setPaciente(ServicioPaciente.getInstancia().getPacientePorId(rs.getInt("paciente_id")));
                    cita.setDoctor(ServicioDoctor.getInstancia().getDoctorPorId(rs.getInt("doctor_id")));
                    cita.setRazon(rs.getString("razon"));
                    lista.add(cita);
                }
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

    public Cita getCitaPorId(int id) throws SQLException {

        String sql = "select * from cita where id=?";

        Connection con = Coneccion.getInstancia().getConeccion();
        //PreparedStatement stmt = null;
        //ResultSet rs = null;
        Cita cita = null;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            //stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            //rs = stmt.executeQuery();
            try(ResultSet rs = stmt.executeQuery()){
            rs.next();
            cita = new Cita();
            cita.setId(rs.getInt("id"));
            cita.setFecha(rs.getString("fecha"));
            cita.setPaciente(ServicioPaciente.getInstancia().getPacientePorId(rs.getInt("paciente_id")));
            cita.setDoctor(ServicioDoctor.getInstancia().getDoctorPorId(rs.getInt("doctor_id")));
            cita.setRazon(rs.getString("razon"));

        } catch (SQLException e) {
            Logger.getLogger(ServicioCita.class.getName()).log(Level.SEVERE, null, e);
        }/* finally {
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

        return cita;
    }}

    public boolean editarCita(Cita cita) {

        boolean estado;
        //PreparedStatement stmt = null ;
        String sql = "update cita set fecha = ?,paciente_id = ?,doctor_id = ?,razon = ? where id = ?";

        Connection con = Coneccion.getInstancia().getConeccion();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            //stmt = con.prepareStatement(sql);
            stmt.setString(1, cita.getFecha());
            stmt.setInt(2, cita.getPaciente().getId());
            stmt.setInt(3, cita.getDoctor().getId());
            stmt.setString(4, cita.getRazon());
            stmt.setInt(5,cita.getId());

            stmt.executeUpdate();

            estado = true;

        } catch (SQLException e) {
            estado = false;
            Logger.getLogger(ServicioCita.class.getName()).log(Level.SEVERE, null, e);
        }

        return estado;

    }

    public boolean borrarCita(Cita cita) {

        boolean estado;
        String sql = "delete from cita where id = ?";

        Connection con = Coneccion.getInstancia().getConeccion();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1,cita.getId());
            stmt.executeUpdate();

            estado = true;

        } catch (SQLException e) {
            estado = false;
            Logger.getLogger(ServicioCita.class.getName()).log(Level.SEVERE, null, e);
        }

        return estado;

    }

}
