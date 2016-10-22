<%@page import="it.alfasoft.francesca.bean.RubricaBean"%>
<%@page import="it.alfasoft.francesca.bean.VoceBean"%>
<%@page import="java.util.List"%>
<%@page import="it.alfasoft.francesca.service.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="utente" class="it.alfasoft.francesca.bean.UtenteBean"
	scope="session"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="Stylesheet" type="text/css" href="css/stat.css">

<title>Insert title here</title>
</head>
<body>

	<div id="Container">

		<div id="header">
			<h1>
				<c:out value="${utente.nome}" />
				<c:out value="${utente.cognome}" />
			</h1>

		</div>


		<div class="menu">

			<jsp:include page="menuLateraleDipendente.jsp"></jsp:include>

		</div>
		<div id="content">

			<h2>Rubrica</h2>

			<table border="1">
				<thead>

					<tr>
						<th>n.</th>
						<th>nome</th>
						<th>cognome</th>
						<th>telefono</th>
					</tr>

				</thead>

				<%
					Servizi s = new Servizi();
					String usnm = utente.getUsername();
					RubricaBean rbean = s.trovaRubrica(usnm);
					List<VoceBean> lista = s.getVoci(rbean);
					session.setAttribute("lista", lista);
				%>

				<c:set var="i" value="1" scope="page" />

				<c:forEach items="${lista}" var="v">

					<tr>
						<td><c:out value="${i}" ></c:out></td>
						<td><c:out value="${v.nome}"></c:out></td>
						<td><c:out value="${v.cognome}" ></c:out></td>
						<td><c:out value="${v.telefono}" ></c:out></td>

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