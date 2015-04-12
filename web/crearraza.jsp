<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="org.cfg.uapa.java.servicios.ServicioEspecie"%>
<%@ page import="org.cfg.uapa.java.entidades.Especie"%>

<jsp:include page="header.jsp"/>
<%
    List<Especie> especie = ServicioEspecie.getInstancia().getListadoEspecie();

%>
<form class="form-vertical login-form" action="/VeterianariaSantiago/RazaServlet" method="post">

    <h3 class="form-title">Crear Raza</h3>
    <div class="form-group">
        <!--<label for="username">Username:</label>-->
        <div class="input-icon">
            <i class="icon-user"></i>
            <input type="text" name="name" class="form-control" placeholder="Nombre" autofocus="autofocus" data-rule-required="true"  />
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-10">
            <select name="inputEspecie" id="input17" class="select2-select-00 col-md-12 full-width-fix">

                <option>Seleccione un Especie</option>
                <option></option>
                <c:forEach items="<%=especie%>" var="especie">
                    <option value="${especie.getId()}">${especie.getNombre()}</option>
                </c:forEach>

            </select>
        </div>
    </div>


    <div class="form-actions">

        <button type="submit" class="submit btn btn-primary pull-right">
            Enviar <i class="icon-angle-right"></i>
        </button>
    </div>
</form>





<jsp:include page="footer.jsp"/>