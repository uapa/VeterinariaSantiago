/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cfg.uapa.java.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.cfg.uapa.java.entidades.Pais;
import org.cfg.uapa.java.servicios.ServicioPais;
import org.cfg.uapa.java.entidades.Cliente;
import org.cfg.uapa.java.servicios.ServicioRegistro;
/**
 *
 * @author NAM
 */
@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

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
        String nombre = request.getParameter("name");
        String inputPais = request.getParameter("inputPais");
        String apellido = request.getParameter("lastname");
        String telefono = request.getParameter("phone");
        String calle = request.getParameter("calle");
        String apartamento = request.getParameter("apartamento");
        String ciudad = request.getParameter("ciudad");
        String usuario = request.getParameter("username");
        String clave = request.getParameter("password");
        
        

        Pais pais =  ServicioPais.getInstancia().getPaisPorId(Integer.valueOf(inputPais));
        
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setTelefono(telefono);
        cliente.setCalle(calle);
        cliente.setApartamento(apartamento);
        cliente.setCiudad(ciudad);
        cliente.setPais(pais);
        cliente.setUsuario(usuario);
        cliente.setClave(clave);
        
        boolean isCreado = ServicioRegistro.getInstancia().crearCliente(cliente);

        if (isCreado) {

            response.sendRedirect("index.jsp");

        } else {

            response.sendRedirect("login.jsp");

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
