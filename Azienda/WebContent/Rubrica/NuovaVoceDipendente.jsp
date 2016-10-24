<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:useBean id="dipendente" class="it.alfasoft.francesca.bean.DipendenteBean"
	scope="session"></jsp:useBean>
  
   		 <% 
if(dipendente.isValid()){
%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stat.css">

<title>Insert title here</title>
</head>
<body>

  <div class="header">
<h2>Home page Dipendente</h2>
<p>
  <c:out value="${dipendente.nome}"/>
  <c:out value="${dipendente.cognome}"/>
</p>
  
  </div>
  
<div class="row">
  
<div class="col-3 menu">
  <jsp:include page="../MenuLaterale/menuLateraleDipendente.jsp"></jsp:include>
  
  </div>
  
    <div class="col-9 content">
<h1>Registra una nuova voce nella tua rubrica</h1>

<form action="doRegistraVoceDipendente.jsp" method="post">
Nome:<br>
 <input type="text" name="nome" /> <br>
Cognome:<br>
 <input type="text" name="cognome"/> <br>
Telefono:<br>
 <input type="text" name="telefono"/> <br>

<input type="submit" value ="Registra"/>

</form>
 </div>
    <div id="footer">
 <h1>Footer</h1>
 
  </div>
  
  
  </div> <!--  end of container -->
</body>
</html>

<%
}else {
	response.sendRedirect("../Accesso/login.jsp");
}
%>