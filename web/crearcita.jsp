<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="org.cfg.uapa.java.servicios.ServicioPaciente"%>
<%@ page import="org.cfg.uapa.java.entidades.Paciente"%>
<%@ page import="org.cfg.uapa.java.servicios.ServicioDoctor"%>
<%@ page import="org.cfg.uapa.java.entidades.Doctor"%>
<jsp:include page="header.jsp"/>
<%
    List<Paciente> paciente = ServicioPaciente.getInstancia().getListadoPacientes();
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


    
        <form class="form-vertical login-form" action="/VeterianariaSantiago/CitaServlet" method="post">

            <h3 class="form-title">Crear Cita</h3>



           

<label class="col-md-3 control-label">Seleccione fecha y hora:</label>
                <div class="well">
  <div id="datetimepicker2" class="input-append">
      <input data-format="yyyy/MM/dd HH:mm:ss" type="text" name="inputFecha"></input>
    <span class="add-on">
      <i data-time-icon="icon-time" data-date-icon="icon-calendar">
      </i>
    </span>
  </div>
</div>
<script type="text/javascript">
  $(function() {
    $('#datetimepicker2').datetimepicker({
      language: 'en',
      pick12HourFormat: false
    });
  });
</script>
          


   
            <div class="row">
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
                </div>
            <div class="row">
            <div class="form-group">
        <div class="col-md-10">
            <select name="inputPaciente" id="input17" class="select2-select-00 col-md-12 full-width-fix">

                <option>Seleccione un Paciente</option>
                <option></option>
                <c:forEach items="<%=paciente%>" var="paciente">
                    <option value="${paciente.getId()}">${paciente.getNombre()}</option>
                </c:forEach>

            </select>
        </div>
    </div>
                </div>

<div class="row">
            <div class="form-group">
                <label class="col-md-2 control-label">Razon de la cita:</label>
                <div class="col-md-10"><textarea rows="3" cols="5" name="inputRazon" class="form-control"></textarea></div>
            </div>
            <div class="form-actions">

                <button type="submit" class="submit btn btn-primary pull-right">
                    Crear Cita <i class="icon-angle-right"></i>
                </button>
            </div>
</div>
 

</form>
<jsp:include page="footer.jsp"/>