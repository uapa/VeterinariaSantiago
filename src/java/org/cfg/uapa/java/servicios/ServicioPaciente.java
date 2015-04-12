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
import org.cfg.uapa.java.entidades.Paciente;

/**
 *
 * @author NAM
 */
public class ServicioPaciente {
    private static final ServicioPaciente INSTANCIA = new ServicioPaciente();

    public static ServicioPaciente getInstancia() {
        return INSTANCIA;
    }

    private ServicioPaciente() {
    } 
    
    public boolean crearPaciente(Paciente paciente) {
        boolean estado = false;
        PreparedStatement stmt = null ;
        String sql = "insert into paciente(cliente_id,nombre,genero,raza_id,fecha_nacimiento,peso,doctor_id) values(?,?,?,?,?,?,?)";
        
         Connection con = Coneccion.getInstancia().getConeccion();

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, paciente.getCliente().getId());
            stmt.setString(2, paciente.getNombre());
            stmt.setString(3, paciente.getGenero());
            stmt.setInt(4, paciente.getRaza().getId());
            stmt.setString(5, paciente.getFecha_nacimiento());
            stmt.setString(6, paciente.getPeso());
            stmt.setInt(7, paciente.getDoctor().getId());
            
            
            

            stmt.executeUpdate();
            
            estado = true;

        } catch (SQLException e) {
            estado = false;
             Logger.getLogger(ServicioPaciente.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServicioPaciente.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
        }
        
        return estado;
    }
    public List<Paciente> getListadoPacientes() {

        List<Paciente> lista = new ArrayList<Paciente>();

        String sql = "select * from paciente";

        Connection con = Coneccion.getInstancia().getConeccion();
        Statement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setCliente(ServicioCliente.getInstancia().getClientePorId(rs.getInt("cliente_id")));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setGenero(rs.getString("genero"));
                paciente.setRaza(ServicioRaza.getInstancia().getRazaPorId(rs.getInt("raza_id")));
                paciente.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                paciente.setPeso(rs.getString("peso"));
                paciente.setDoctor(ServicioDoctor.getInstancia().getDoctorPorId(rs.getInt("doctor_id")));
                
                
                lista.add(paciente);
            }

        } catch (SQLException e) {
            Logger.getLogger(ServicioPaciente.class.getName()).log(Level.SEVERE, null, e);
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
                Logger.getLogger(ServicioPaciente.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return lista;
    }
    public Paciente getPacientePorId(int id) {

        String sql = "select * from paciente where id=?";

        Connection con = Coneccion.getInstancia().getConeccion();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paciente paciente1 = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            rs.next();
            paciente1 = new Paciente();
            paciente1.setId(rs.getInt("id"));
            paciente1.setNombre(rs.getString("nombre"));

        } catch (SQLException e) {
            Logger.getLogger(ServicioPaciente.class.getName()).log(Level.SEVERE, null, e);
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
                Logger.getLogger(ServicioPaciente.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return paciente1;
    }
    
}
