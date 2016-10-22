<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="utente" class="it.alfasoft.francesca.bean.UtenteBean"
	scope="session"></jsp:useBean>
		 <jsp:useBean id="message" class="Utility.MessageBean" scope="request"></jsp:useBean>
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
<h1>Header</h1>
  
  </div>
  
  
    <div  class="menu">
 
  <jsp:include page="MenuLateraleAdmin.jsp"></jsp:include>
  
  </div>
    <div id="content">
   <h1>Registrazione Nuovo Cliente</h1>
   <%=message.getMessage()%>
<form action="doRegistraCliente.jsp" method="post">
Nome : <input type="text" name="nome" /> <br>
Cognome : <input type="text" name="cognome"/> <br>
Username : <input type="text" name="username"/> <br>
Password : <input type="password" name="password"/> <br>
Ragione Sociale : <input type="text" name="ragioneSociale"/> <br>
Partita IVA : <input type="text" name="piva"/> <br>

<input type="submit" value ="Registra"/>

</form>

   
  </div>
    <div id="footer">
 <h1>Footer</h1>
 
  </div>
  
  
  </div> <!--  end of container -->
</body>
</html>