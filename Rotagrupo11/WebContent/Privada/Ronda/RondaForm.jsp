<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
	<form action="RondaCon" method="post">
		<fieldset>
		    <legend>Formulário:</legend>
	
			<div class="row">
				<div class="col-md-2">
					<label>lat</label>
	        		<input class="form-control" type="number" name="latUltima" value="${obj.latUltima}">
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label>log</label>
	        		<input class="form-control" type="number" name="longUltima" value="${obj.longUltima}">
				</div>
			</div>
	

	
	
	
	
	        	
	        <button class="btn btn-primary" type="submit" name="gravar">Gravar</button>	
	        <button type="submit" name="cancelar">Cancelar</button>
		
		</fieldset>
	</form>

</body>
</html>