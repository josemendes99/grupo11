<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
	
	

	
	
	
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
	
		<script type="text/javascript">
	    function confirmar(){
	    	$.confirm({
	    	    title: 'Confirmar',
	    	    content: 'Confirmar a exclusão?',
	    	    type: 'orange',
	    	    typeAnimated: true,
	    	    buttons: {
	    	        Sim: { 
	    	        	text: 'Sim',
	    	            btnClass: 'btn-orange',
	    	            action: function(){ 
	    	            	$("#excluir").attr("type", "submit");
	    	            	$("#excluir").click();
	    	        	}
	    	        },
	    	        Nao: { 
	    	        	text: 'Não',
	    	            btnClass: 'btn-dark',
	    	            action: function(){ 
	    	            	// programar algo se clicou não
	    	        	}
	    	        },
	    	    }
	    	});
	    	
	    	
	    }
	</script>
	
	
	<h1>LISTAGEM DE Localizacao</h1>
	
	<form action="LocalizacaoCon">
	
<input type="button" onclick="location.href='LocalizacaoForm.jsp';" value="Incluir" />
		
		<table border="1" class="table table-hover table-condensed">
		    <thead>
		       <tr>
		           <td>Id</td>
		           <td>data Hora</td>
		           <td>latitude </td>
		           <td>logitude</td>
		         
		           <td></td>
		           <td></td>
		       </tr>
		    </thead>
			<c:forEach items="${lista}" var="p" varStatus="cont">
			   <tr>
			      <td>${p.id}</td>
			      <td>${p.dataHora}</td> 
			      <td>${p.lat}</td>  
			       <td>${p.log}</td>       
			      
			     
			      <td><button type="submit" name="alterar" value="${p.id}">Alterar</button></td>
			      <td><button type="button" onclick="confirmar()" id="excluir" name="excluir" value="${p.id}">Excluir</button></td>
			   </tr>
		    </c:forEach>
		</table>
	</form>

</body>
</html>