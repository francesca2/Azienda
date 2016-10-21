<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
   <form action="" method="post">
   
   <input type="text" name="nome" required />
   <input type="submit" value="Registra"  />
   </form>
   
  </div>
    <div id="footer">
 <h1>Footer</h1>
 
  </div>
  
  
  </div> <!--  end of container -->
</body>
</html>