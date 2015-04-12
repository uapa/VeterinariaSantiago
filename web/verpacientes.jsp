<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="org.cfg.uapa.java.servicios.ServicioPaciente"%>
<%@ page import="org.cfg.uapa.java.entidades.Paciente"%>
<jsp:include page="header.jsp"/>
<%
    List<Paciente> paciente = ServicioPaciente.getInstancia().getListadoPacientes();
%>
<div class="row">
    <div class="col-md-12">
        <div class="widget box">
            <div class="widget-header">
                <h4><i class="icon-reorder"></i> Paciente <a href="crearpaciente.jsp"> Agregar paciente</a></h4>
                <div class="toolbar no-padding">
                    <div class="btn-group">
                        <span class="btn btn-xs widget-collapse"><i class="icon-angle-down"></i></span>
                    </div>
                </div>
            </div>
            <div class="widget-content no-padding">
                <table class="table table-striped table-bordered table-hover table-checkable table-responsive datatable">
                    <thead>
                        <tr>
                            
                            <th data-class="expand">#</th>
                            <th>Cliente</th>
                            <th>Nombre</th>
                            <th>Genero</th>
                            <th>Raza</th>
                            <th>Fecha de Nacimiento</th>
                            <th>Peso</th>
                            <th>Doctor</th>
                        </tr>
                    </thead>
                    <tbody>
                       <c:forEach items="<%=paciente%>" var="paciente">
                        <tr>
                            
                            <td>${paciente.getId()}</td>
                            <td>${paciente.getCliente().getNombre()}</td>
                            <td>${paciente.getNombre()}</td>
                            <td>${paciente.getGenero()}</td>
                            <td>${paciente.getRaza().getNombre()}</td>
                            <td>${paciente.getFecha_nacimiento()}</td>
                            <td>${paciente.getPeso()}</td>
                            <td>${paciente.getDoctor().getNombre()}</td>
                            
                            
                            
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>



<jsp:include page="footer.jsp"/>