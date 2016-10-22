<%@page import="it.alfasoft.francesca.bean.RubricaBean"%>
<%@page import="it.alfasoft.francesca.bean.VoceBean"%>

<%@page import="it.alfasoft.francesca.service.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <jsp:useBean id="utente" class="it.alfasoft.francesca.bean.UtenteBean"
	scope="session"></jsp:useBean>
     <jsp:useBean id="message" class="Utility.MessageBean" scope="request"></jsp:useBean>

     <%
     String nome=request.getParameter("nome");
     String cognome= request.getParameter("cognome");
     String telefono= request.getParameter("telefono");
     
     Servizi s= new Servizi();
     
     String username = utente.getUsername();
     char ruolo=utente.getRuolo();
     RubricaBean rbean=s.trovaRubrica(username);

     VoceBean v= new VoceBean(nome,cognome,telefono);
     if(v.isValid()) {
    	 s.registraVoce(rbean, v);
    	 switch(ruolo) {
    	 
    	 case 'c' :
 	    	%>
 		<jsp:forward page="HomePageCliente.jsp" />
 		<%
 		break;
 		
 		case 'd' :
	    	%>
		<jsp:forward page="HomePageDipendente.jsp" />
		<%
		break;
    	 
    	 }
    	 
     }
     %>