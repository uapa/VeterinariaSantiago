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
import org.cfg.uapa.java.entidades.Doctor;

public class ServicioDoctor {
    private static final ServicioDoctor INSTANCIA = new ServicioDoctor();

    public static ServicioDoctor getInstancia() {
        return INSTANCIA;
    }

    private ServicioDoctor() {
    }
    
    public boolean crearDoctor(Doctor doctor) {

        boolean estado = false;
        PreparedStatement stmt = null ;
        String sql = "insert into doctor(nombre,apellido) values(?,?)";
        
         Connection con = Coneccion.getInstancia().getConeccion();

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, doctor.getNombre());
            stmt.setString(2, doctor.getApellido());

            stmt.executeUpdate();
            
            estado = true;

        } catch (SQLException e) {
            estado = false;
             Logger.getLogger(ServicioDoctor.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServicioDoctor.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
        }
        
        return estado;

    }
    public List<Doctor> getListadoDoctores() {

        List<Doctor> lista1 = new ArrayList<Doctor>();

        String sql = "select * from doctor";

        Connection con = Coneccion.getInstancia().getConeccion();
        Statement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Doctor doctor2 = new Doctor();
                doctor2.setId(rs.getInt("id"));
                doctor2.setNombre(rs.getString("nombre"));
                doctor2.setApellido(rs.getString("apellido"));

                lista1.add(doctor2);
            }

        } catch (SQLException e) {
            Logger.getLogger(ServicioDoctor.class.getName()).log(Level.SEVERE, null, e);
        } finally {
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
                Logger.getLogger(ServicioDoctor.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return lista1;
    }
    public Doctor getDoctorPorId(int id) {

        String sql = "select * from doctor where id=?";

        Connection con = Coneccion.getInstancia().getConeccion();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Doctor doctor1 = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            rs.next();
            doctor1 = new Doctor();
            doctor1.setId(rs.getInt("id"));
            doctor1.setNombre(rs.getString("nombre"));

        } catch (SQLException e) {
            Logger.getLogger(ServicioDoctor.class.getName()).log(Level.SEVERE, null, e);
        } finally {
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
                Logger.getLogger(ServicioDoctor.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return doctor1;
    }
    
    
}
