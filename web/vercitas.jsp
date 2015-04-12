<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="org.cfg.uapa.java.servicios.ServicioCita"%>
<%@ page import="org.cfg.uapa.java.entidades.Cita"%>
<jsp:include page="header.jsp"/>
<%
    List<Cita> cita = ServicioCita.getInstancia().getListadoCita();
%>
<div class="row">
    <div class="col-md-12">
        <div class="widget box">
            <div class="widget-header">
                <h4><i class="icon-reorder"></i> Cita <a href="crearcita.jsp"> Agregar Cita</a></h4>
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
                            <th>Fecha</th>
                            <th>Paciente</th>
                            <th>Doctor</th>
                            <th>Razon</th>
                            <th>Editar</th>
                            <th>Borrar</th>
                        </tr>
                    </thead>
                    <tbody>
                       <c:forEach items="<%=cita%>" var="cita">
                        <tr>
                            
                            <td>${cita.getId()}</td>
                            <td>${cita.getFecha()}</td>
                            <td>${cita.getPaciente().getNombre()}</td>
                            <td>${cita.getDoctor().getNombre()}</td>
                            <td>${cita.getRazon()}</td>
                            <td><a href="editarcita.jsp?id=${cita.getId()}"><i class="icon-edit"></i></a></td>
                            <td><a href="borrarcita.jsp?id=${cita.getId()}"><i class="icon-trash"></i></a></td>
                            
                            
                            
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>



<jsp:include page="footer.jsp"/>