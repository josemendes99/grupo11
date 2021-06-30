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
	
	<br>
			<div class="row">
				<div class="col-md-7">
					<label for="ronda">Id da Ronda:</label> 
					<select name = "ronda" id = "ronda">
						<c:forEach items="${ronda}" var = "l" varStatus="index">
							<option value="${l.id}">${l.id}
						</c:forEach>
					</select>
				</div>
			</div>
	
	
	        	
	        <button class="btn btn-primary" type="submit" name="gravar">Gravar</button>	
	        <button type="submit" name="cancelar">Cancelar</button>
		
		</fieldset>
	</form>

</body>
</html>