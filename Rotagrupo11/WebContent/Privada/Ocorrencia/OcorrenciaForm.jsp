<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
	<form action="OcorrenciaCon" method="post">
		<fieldset>
		    <legend>Formulário:</legend>
	
			<div class="row">
				<div class="col-md-2">
					<label>Id</label>
	        		<input class="form-control" type="number" name="id" value="${obj.id}">
				</div>
			</div>
	
			<div class="row">
				<div class="col-md-5">
			        <label>dataHora</label>
			        <input class="form-control"  type="text" name="dataHora" value="${obj.dataHora}">			
				</div>
			</div>
	
			<div class="row">
				<div class="col-md-2">
			        <label>titulo</label>
			        <input class="form-control"  type="text" name="titulo" value="${obj.titulo}">			
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-2">
			        <label>descricao</label>
			        <input class="form-control"  type="text" name="descricao" value="${obj.descricao}">			
				</div>
			</div>
	
	        <div class="row">
				<div class="col-md-2">
			        <label>latitude</label>
			        <input class="form-control"  type="number" step="0.01" name="lat" value="${obj.lat}">			
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-md-2">
			        <label>logitude</label>
			        <input class="form-control"  type="number" step="0.01" name="log" value="${obj.log}">			
				</div>
			</div>
	
	
	
	
	        	
	        <button class="btn btn-primary" type="submit" name="gravar">Gravar</button>	
	        <button type="submit" name="cancelar">Cancelar</button>
		
		</fieldset>
	</form>

</body>
</html>