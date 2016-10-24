<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="admin" class="it.alfasoft.francesca.bean.AdminBean"
	scope="session"></jsp:useBean>
		 <jsp:useBean id="message" class="Utility.MessageBean" scope="request"></jsp:useBean>
		 
		 <% 
if(admin.isValid()){
%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="Stylesheet" type="text/css" href="css/stat.css">

<title>Insert title here</title>
</head>
<body>

<div id="Container">
  
  <div id="header">
  <h2>Admin</h2>
<h1>
  <c:out value="${admin.nome}"/>
  <c:out value="${admin.cognome}"/>
</h1>
  </div>
  
  
    <div  class="menu">
 
  <jsp:include page="MenuLateraleAdmin.jsp"></jsp:include>
  
  </div>
    <div id="content">
   <h1>Registrazione Nuovo Dipendente</h1>
   <%=message.getMessage()%>
<form action="doRegistraDipendente.jsp" method="post">
Nome : <input type="text" name="nome" /> <br>
Cognome : <input type="text" name="cognome"/> <br>
Username : <input type="text" name="username"/> <br>
Password : <input type="password" name="password"/> <br>
Posizione : <input type="text" name="posizione"/> <br>
Stipendio : <input type="number" name="stipendio"/> <br>

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
	session.invalidate();
	response.sendRedirect("login.jsp");
}
%>