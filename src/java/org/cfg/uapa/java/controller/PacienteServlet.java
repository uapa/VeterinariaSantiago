/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cfg.uapa.java.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.cfg.uapa.java.entidades.Cliente;
import org.cfg.uapa.java.servicios.ServicioCliente;
import org.cfg.uapa.java.entidades.Raza;
import org.cfg.uapa.java.servicios.ServicioRaza;
import org.cfg.uapa.java.entidades.Doctor;
import org.cfg.uapa.java.servicios.ServicioDoctor;
import org.cfg.uapa.java.entidades.Paciente;
import org.cfg.uapa.java.servicios.ServicioPaciente;
/**
 *
 * @author NAM
 */
public class PacienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String inputCliente = request.getParameter("inputCliente");
        String nombre = request.getParameter("name");
        String genero = request.getParameter("genero");
        String inputRaza = request.getParameter("inputRaza");
        String fecha = request.getParameter("fecha");
        String peso = request.getParameter("peso");
        String inputDoctor = request.getParameter("inputDoctor");
        
        Cliente cliente = ServicioCliente.getInstancia().getClientePorId(Integer.valueOf(inputCliente));
        Raza raza = ServicioRaza.getInstancia().getRazaPorId(Integer.valueOf(inputRaza));
        Doctor doctor = ServicioDoctor.getInstancia().getDoctorPorId(Integer.valueOf(inputDoctor));
        
        Paciente paciente = new Paciente();
        paciente.setCliente(cliente);
        paciente.setNombre(nombre);
        paciente.setGenero(genero);
        paciente.setRaza(raza);
        paciente.setFecha_nacimiento(fecha);
        paciente.setPeso(peso);
        paciente.setDoctor(doctor);
        
        boolean isCreado = ServicioPaciente.getInstancia().crearPaciente(paciente);

        if (isCreado) {

            response.sendRedirect("crearpaciente.jsp");

        } else {

            response.sendRedirect("index.jsp");

        }
        
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
