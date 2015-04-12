<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="org.cfg.uapa.java.servicios.ServicioCliente"%>
<%@ page import="org.cfg.uapa.java.entidades.Cliente"%>
<%@ page import="org.cfg.uapa.java.servicios.ServicioRaza"%>
<%@ page import="org.cfg.uapa.java.entidades.Raza"%>
<%@ page import="org.cfg.uapa.java.servicios.ServicioDoctor"%>
<%@ page import="org.cfg.uapa.java.entidades.Doctor"%>
<jsp:include page="header.jsp"/>
<%
    List<Cliente> cliente = ServicioCliente.getInstancia().getListadoCliente();
    List<Raza> raza = ServicioRaza.getInstancia().getListadoRazas();
    List<Doctor> doctor = ServicioDoctor.getInstancia().getListadoDoctores();
%>
<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen"
     href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
    </script>
<form class="form-vertical login-form" action="/VeterianariaSantiago/PacienteServlet" method="post">

    <h3 class="form-title">Crear Paciente</h3>
    
     <div class="form-group">
        <div class="col-md-10">
            <select name="inputCliente" id="input17" class="select2-select-00 col-md-12 full-width-fix">

                <option>Seleccione un Cliente</option>
                <option></option>
                <c:forEach items="<%=cliente%>" var="cliente">
                    <option value="${cliente.getId()}">${cliente.getNombre()}</option>
                </c:forEach>

            </select>
        </div>
    </div>
    
    <br></br>  
    <div class="form-group">
        <label class="form-title">Nombre:</label>
        <div class="input-icon">
            <i class="icon-user"></i>
            <input type="text" name="name" class="form-control" placeholder="Nombre" autofocus="autofocus" data-rule-required="true"  />
        </div>
    </div>

    
    <div class="form-group">
        <label class="form-title">Genero:</label>
        <div class="input-icon">
            <i class="icon-user"></i>
            <input type="text" name="genero" class="form-control" placeholder="Genero" data-rule-required="true"  />
        </div>
    </div>
    <br></br> 
    <div class="form-group">
        <div class="col-md-10">
            <select name="inputRaza" id="input17" class="select2-select-00 col-md-12 full-width-fix">

                <option>Seleccione una Raza</option>
                <option></option>
                <c:forEach items="<%=raza%>" var="raza">
                    <option value="${raza.getId()}">${raza.getNombre()}</option>
                </c:forEach>

            </select>
        </div>
    </div>
    <br></br> 
    <label class="col-md-3 control-label">Seleccione fecha de nacimiento:</label>
                <div class="well">
  <div id="datetimepicker4" class="input-append">
    <input name="fecha" data-format="yyyy-MM-dd" type="text" ></input>
    <span class="add-on">
      <i data-time-icon="icon-time" data-date-icon="icon-calendar">
      </i>
    </span>
  </div>
</div>
<script type="text/javascript">
  $(function() {
    $('#datetimepicker4').datetimepicker({
      pickTime: false
    });
  });
</script>
</br>
    <div class="form-group">
        <label class="form-title">Peso:</label>
        <div class="input-icon">
            <i class="icon-user"></i>
            <input type="text" name="peso" class="form-control" placeholder="Peso" data-rule-required="true"  />
        </div>
    </div>
    <br></br> 
    <div class="form-group">
        <div class="col-md-10">
            <select name="inputDoctor" id="input17" class="select2-select-00 col-md-12 full-width-fix">

                <option>Seleccione un Doctor</option>
                <option></option>
                <c:forEach items="<%=doctor%>" var="doctor">
                    <option value="${doctor.getId()}">${doctor.getNombre()}</option>
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