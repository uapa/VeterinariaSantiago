<jsp:include page="header.jsp"/>
<form class="form-vertical login-form" action="/VeterianariaSantiago/DoctorServlet" method="post">
    
    <h3 class="form-title">Crear Doctor</h3>
    <div class="form-group">
                        <!--<label for="username">Username:</label>-->
                        <div class="input-icon">
                            <i class="icon-user"></i>
                            <input type="text" name="name" class="form-control" placeholder="Nombre" autofocus="autofocus" data-rule-required="true"  />
                        </div>
                    </div>
    <div class="form-group">
                        <!--<label for="username">Username:</label>-->
                        <div class="input-icon">
                            <i class="icon-user"></i>
                            <input type="text" name="lastname" class="form-control" placeholder="Apellidos" autofocus="autofocus" data-rule-required="true"  />
                        </div>
                    </div>
    
       <div class="form-actions">
                        
                        <button type="submit" class="submit btn btn-primary pull-right">
                            Enviar <i class="icon-angle-right"></i>
                        </button>
                    </div>
    </form>
    
    
    


<jsp:include page="footer.jsp"/>