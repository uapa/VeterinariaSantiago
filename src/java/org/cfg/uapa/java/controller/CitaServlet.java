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
import org.cfg.uapa.java.entidades.Cita;
import org.cfg.uapa.java.servicios.ServicioCita;
import org.cfg.uapa.java.entidades.Doctor;
import org.cfg.uapa.java.servicios.ServicioDoctor;
import org.cfg.uapa.java.entidades.Paciente;
import org.cfg.uapa.java.servicios.ServicioPaciente;
/**
 *
 * @author NAM
 */
public class CitaServlet extends HttpServlet {

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
        String fecha = request.getParameter("inputFecha");
        String inputPaciente = request.getParameter("inputPaciente");
        String inputDoctor = request.getParameter("inputDoctor");
        String razon = request.getParameter("inputRazon");
        
        Paciente paciente = ServicioPaciente.getInstancia().getPacientePorId(Integer.valueOf(inputPaciente));
        Doctor doctor = ServicioDoctor.getInstancia().getDoctorPorId(Integer.valueOf(inputDoctor));
        
        
        Cita cita = new Cita();
        cita.setFecha(fecha);
        cita.setPaciente(paciente);
        cita.setDoctor(doctor);        
        cita.setRazon(razon);
        
        boolean isCreado = ServicioCita.getInstancia().crearCita(cita);

        if (isCreado) {

            response.sendRedirect("crearcita.jsp");

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
