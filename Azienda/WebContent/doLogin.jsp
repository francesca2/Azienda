<%@page import="Utility.MessageBean"%>
<%@page import="it.alfasoft.francesca.bean.UtenteBean"%>
<%@page import="it.alfasoft.francesca.service.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="utente2" class="it.alfasoft.francesca.bean.UtenteBean"
	scope="session"></jsp:useBean>
<jsp:useBean id="u" class="it.alfasoft.francesca.bean.UtenteBean"
	scope="page"></jsp:useBean>
<jsp:useBean id="message" class="Utility.MessageBean" scope="request"></jsp:useBean>

<jsp:setProperty property="*" name="utente2" />
<%
	String call=request.getParameter("call");
    if(call==null)
    {
    	%>
<jsp:forward page="login.jsp" />
<%
    }
    else {
    Servizi s= new Servizi();
    
    u= s.getUtente(utente2.getUsername());
    String pass= utente2.getPassword();
    
    pass=s.convertiPass(pass);
    
    if(u!=null && u.getPassword().equals(pass))
    {
    	utente2.setNome(u.getNome());
    	utente2.setCognome(u.getCognome());
    	%>
<jsp:forward page="welcome.jsp" />
<%
    }
    else{
    	message.setMessage("Username o password non corretti");
    	%>
<jsp:forward page="login.jsp" />
<%
    }
    }
    
    %>