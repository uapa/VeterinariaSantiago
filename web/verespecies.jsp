<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="org.cfg.uapa.java.servicios.ServicioEspecie"%>
<%@ page import="org.cfg.uapa.java.entidades.Especie"%>
<jsp:include page="header.jsp"/>
<%
    List<Especie> especie = ServicioEspecie.getInstancia().getListadoEspecie();
%>
<div class="row">
    <div class="col-md-12">
        <div class="widget box">
            <div class="widget-header">
                <h4><i class="icon-reorder"></i> Especies <a href="crearespecie.jsp"> Agregar Especie</a></h4>
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
                            <th data-class="expand">#</th>
                            <th>Nombre</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                       <c:forEach items="<%=especie%>" var="especie">
                        <tr>
                            <td class="checkbox-column">
                                <input type="checkbox" class="uniform">
                            </td>
                            <td>${especie.getId()}</td>
                            <td>${especie.getNombre()}</td>
                            
                            
                            
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>



<jsp:include page="footer.jsp"/>