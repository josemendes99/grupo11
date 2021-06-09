<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>


</head>
<body>


<form action="LoginServlet" method="post">

	<div class="panel panel-default" style="width: 300px; margin: auto; margin-top: 15%;"> 
	   <div class="panel-heading"> 
	      <!-- cabeçalho do painel --> 
	      <label>AUTENTICAÇÃO</label> 
	      
	      
	   </div> 
	   <div class="panel-body"> 
	   <!-- corpo do painel --> 
	      <label>Login</label>
	      <input type="text" name="login" class="form-control">

	      <label>Senha</label>
	      <input type="password" name="senha" class="form-control">
	   
	   
	   
	   </div> 
	   <div class="panel-footer"> 
	      <!-- rodapé do painel --> 
	      <button type="submit">Login</button>   
	      <br>
	      
	      
	      
	   </div> 
	</div> 

</form>

<center>
<h4>${requestScope.mensagemLogin}</h4>
 </center>




</body>
</html>