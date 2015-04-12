
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="org.cfg.uapa.java.servicios.ServicioPaciente"%>
<%@ page import="org.cfg.uapa.java.entidades.Paciente"%>
<%@ page import="org.cfg.uapa.java.servicios.ServicioDoctor"%>
<%@ page import="org.cfg.uapa.java.entidades.Doctor"%>
<%@ page import="org.cfg.uapa.java.servicios.ServicioCita"%>
<%@ page import="org.cfg.uapa.java.entidades.Cita"%>
<jsp:include page="header.jsp"/>
<%
    int id = Integer.parseInt(request.getParameter("id"));   
    List<Paciente> paciente = ServicioPaciente.getInstancia().getListadoPacientes();
    List<Doctor> doctor = ServicioDoctor.getInstancia().getListadoDoctores();
    Cita cita = ServicioCita.getInstancia().getCitaPorId(id);
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


    
        <form class="form-vertical login-form" action="/VeterianariaSantiago/BorrarCitaServlet" method="post">

            <h3 class="form-title">Borrar Cita</h3>



            <input name="id" type="hidden" value="<%=cita.getId()%>">
            <div class="form-actions">

                <button type="submit" class="submit btn btn-primary pull-right">
                    Borrar Cita <i class="icon-angle-right"></i>
                </button>
            </div>
</div>
 

</form>
<jsp:include page="footer.jsp"/>
