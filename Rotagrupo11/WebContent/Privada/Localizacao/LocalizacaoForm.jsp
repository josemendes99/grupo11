<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
	<form action="LocalizacaoCon" method="post">
		<fieldset>
		    <legend>Formulário:</legend>
	
			<div class="row">
				<div class="col-md-5">
			        <label>id</label>
			        <input class="form-control"  type="text" name="id" value="${obj.id}">			
				</div>
			</div>
	
				<div class="row">
				<div class="col-md-7">
					<label for="dataHora">Data Hora de Inicio:</label> 
					<input type="datetime-local" id="dataHora" name="dataHora" 
					pattern="YYYY-MM-DDThh:mm"
					value="<fmt:formatDate value = "${o.dataHora}" pattern = "yyyy-MM-dd"/>T<fmt:formatDate value = "${o.dataHora}" pattern= "HH:mm"/>" 
					class="form-control">
				</div>
			</div>
	
			<div class="row">
				<div class="col-md-2">
			        <label>latitude</label>
			        <input class="form-control"  type="text" step="0.01" name="lat" value="${obj.lat}">			
				</div>
			</div>
	
			<div class="row">
				<div class="col-md-2">
			        <label>logitude</label>
			        <input class="form-control"  type="text" step="0.01" name="log" value="${obj.log}">			
				</div>
			</div>
	
	
	
	        	
	        <button class="btn btn-primary" type="submit" name="gravar">Gravar</button>	
	        <button type="submit" name="cancelar">Cancelar</button>
		
		</fieldset>
	</form>

</body>
</html>