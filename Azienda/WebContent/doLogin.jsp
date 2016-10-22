<%@page import="Utility.MessageBean"%>
<%@page import="it.alfasoft.francesca.bean.UtenteBean"%>
<%@page import="it.alfasoft.francesca.service.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="utente" class="it.alfasoft.francesca.bean.UtenteBean"
	scope="session"></jsp:useBean>
<jsp:useBean id="message" class="Utility.MessageBean" scope="request"></jsp:useBean>

<jsp:setProperty property="*" name="utente" />

<%
    Servizi s= new Servizi();
    
	String usnm= request.getParameter("username");
    UtenteBean u= s.getUtente(usnm);
    String pass= request.getParameter("password");
    
    pass=s.convertiPass(pass);
    
    if(u!=null && u.getPassword().equals(pass))
    {
    	char ruolo= u.getRuolo();
    	utente.setNome(u.getNome());
    	utente.setCognome(u.getCognome());
    	utente.setRuolo(ruolo);
    		
    		switch(ruolo) {
 				
    		case 'a' :   
    			%>
			<jsp:forward page="HomePageAdmin.jsp" />
			<%
			break;

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
    else{
    	message.setMessage("Username o password non corretti");
    			%>
			<jsp:forward page="login.jsp" />
			<%
    }
    
    %>