<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="utente" class="it.alfasoft.francesca.bean.UtenteBean"
	scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Registra una nuova voce nella tua rubrica</h1>

<form action="doRegistraVoce.jsp" method="post">
Nome: <input type="text" name="nome" /> <br>
Cognome: <input type="text" name="cognome"/> <br>
Telefono: <input type="text" name="telefono"/> <br>

<input type="submit" value ="Registrati"/>

</form>

</body>
</html>