<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="org.cfg.uapa.java.servicios.ServicioDoctor"%>
<%@ page import="org.cfg.uapa.java.entidades.Doctor"%>
<jsp:include page="header.jsp"/>
<%
    List<Doctor> doctor = ServicioDoctor.getInstancia().getListadoDoctores();
%>
<div class="row">
    <div class="col-md-12">
        <div class="widget box">
            <div class="widget-header">
                <h4><i class="icon-reorder"></i> Doctores <a href="creardoctor.jsp"> Agregar Doctor</a></h4>
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
                            <th class="checkbox-column">
                                <input type="checkbox" class="uniform">
                            </th>
                            <th data-class="expand">Nombre</th>
                            <th>Apellido</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                       <c:forEach items="<%=doctor%>" var="doctor">
                        <tr>
                            <td class="checkbox-column">
                                <input type="checkbox" class="uniform">
                            </td>
                            <td>${doctor.getNombre()}</td>
                            <td>${doctor.getApellido()}</td>
                            
                            
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>



<jsp:include page="footer.jsp"/>