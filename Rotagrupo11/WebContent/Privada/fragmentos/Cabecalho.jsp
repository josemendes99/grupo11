<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>App</title>

	<script src="../../resources/jquery/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="../../resources/jquery-confirm/jquery-confirm.min.css">
    <script src="../../resources/jquery-confirm/jquery-confirm.min.js"></script> 	

	<link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.min.css">
	<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>

	<link href="../../resources/fontawesome/css/all.css" rel="stylesheet">

	<link href="../../resources/smartmenus/css/sm-core-css.css" rel="stylesheet" type="text/css"/>
	<link href="../../resources/smartmenus/css/sm-mint/sm-mint.css" rel="stylesheet" type="text/css" />	
	    

	
	<link href="../../resources/estilos.css" rel="stylesheet">
	
</head>
<body>
    <h3>Aplicação...</h3>
    <h2>${sessionScope.usuarioLogado.nome}</h2>
    
	<nav class="main-nav">

	  <ul id="main-menu" class="sm sm-mint">
	    <li><a href="../Home/Home.jsp">Home</a></li>
	    <li><a href="#">Cadastros</a>
	      <ul>
	        <li><a href="../Ocorrencia/OcorrenciaCon">Ocorrencia</a></li>
	         <li><a href="../Ronda/RondaCon">Ronda</a></li>
	          <li><a href="../Pessoa/PessoaCon">Pessoa</a></li>
	           <li><a href="../Locomocao/LocomocaoCon">Locomocao</a></li>
	            <li><a href="../Localizacao/LocalizacaoCon">Localização</a></li>
	           
	       
	        
	       
	      </ul>
	    </li> 
	     <li><a href="#">Relatórios</a>
	      <ul>
	        <li><a href="../Relatorios/RelPessoasServlet" target="blank">Pessoa</a></li>
	       <li><a href="../Relatorios/RelRondaServlet" target="blank">Ronda</a></li>
	       <li><a href="../Relatorios/RelOcorrenciaServlet" target="blank">Ocorrencia</a></li>
	  </ul>
	  
	</nav>


	<!-- SmartMenus jQuery plugin -->
	<script type="text/javascript"	src="../../resources/smartmenus/jquery.smartmenus.js"></script>
	<!-- SmartMenus jQuery init -->
	<script type="text/javascript">
		$(function() {
			$('#main-menu').smartmenus({
				subMenusSubOffsetX : 1,
				subMenusSubOffsetY : -8
			});
		});
	</script>


</body>
</html>