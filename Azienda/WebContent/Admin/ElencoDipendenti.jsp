<%@page import="it.alfasoft.francesca.bean.DipendenteBean"%>
<%@page import="java.util.List"%>
<%@page import="it.alfasoft.francesca.service.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="admin" class="it.alfasoft.francesca.bean.AdminBean"
	scope="session"></jsp:useBean>
	
	<% 
if(admin.isValid()){
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
  <h2>Admin</h2>
	<p>
  <c:out value="${admin.nome}"/>
  <c:out value="${admin.cognome}"/>
	</p>
</div>
  
<div class="row">
  
<div class="col-2 menu">
<jsp:include page=".././MenuLaterale/MenuLateraleAdmin.jsp"></jsp:include>
</div>

    <div class="col-10 content">
    	<h2>Elenco Dipendenti</h2>

			<table border="1">
				<thead>

					<tr>
						<th>n.</th>
						<th>nome</th>
						<th>cognome</th>
						<th>username</th>
						<th>posizionee</th>
						<th>stipendio</th>
					</tr>

				</thead>

				<%
					Servizi s = new Servizi();
					String usnm = admin.getUsername();
					List<DipendenteBean> lista = s.getDipendenti();
					session.setAttribute("lista", lista);
				%>
				<c:set var="i" value="1" scope="page" />

				<c:forEach items="${lista}" var="u">

					<tr>
						<td><c:out value="${i}" /></td>
						<td><c:out value="${u.nome}" /></td>
						<td><c:out value="${u.cognome}" /></td>
						<td><c:out value="${u.username}" /></td>
						<td><c:out value="${u.posizione}" /></td>
						<td><c:out value="${u.stipendio}" /></td>
					</tr>
					<c:set var="i" value="${i + 1}" scope="page" />
				</c:forEach>


			</table>
		</div>
		<div id="footer">
			<h1>Footer</h1>

		</div>


	</div>
	<!--  end of container -->
</body>
</html>

<%
}else {
	response.sendRedirect("../Accesso/login.jsp");
}

%>