<%@page import="it.alfasoft.francesca.bean.UtenteBean"%>
<%@page import="it.alfasoft.francesca.service.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:setProperty property="*" name="dipendente"/>
    
        <jsp:useBean id="utente" class="it.alfasoft.francesca.bean.UtenteBean"
	scope="session"></jsp:useBean>
	 <jsp:useBean id="message" class="Utility.MessageBean" scope="request"></jsp:useBean>

	 <%
	 
	 Servizi s= new Servizi();
	 String username= request.getParameter("username");
	 String nome = request.getParameter("nome");
	 String cognome = request.getParameter("cognome");
	 String password = request.getParameter("password");
	 password=s.convertiPass(password);
	 
	 UtenteBean u= s.getUtente(username);
	 
	 if(u!=null && u.getNome()==nome && u.getCognome()==cognome && u.getPassword()==password) {
		boolean b=s.eliminaUtente(u);
		if(b==true)
		{
			message.setMessage("Utente eliminato");
	        %>
	    	<jsp:forward page="../HomePage/HomePageAdmin.jsp"/>
	    <%
		}
		else
		{
			//Non si può eliminare un account admin!
			message.setMessage("Impossibile eliminare questo utente");
	        %>
	    	<jsp:forward page="CancellaUtente.jsp"/>
	    <%
		}
	 }
	 else {
		 message.setMessage("I dati inseriti non sono corretti");
	        %>
	    	<jsp:forward page="CancellaUtente.jsp"/>
	    <%
	 }
	 
	 
	 %>