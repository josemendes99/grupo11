<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
					<label>id</label>
	        		<input class="form-control" type="number" name="id" value="${obj.id}">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-2">
					<label>latitude</label>
	        		<input class="form-control" type="number" name="latUltima" step="0.01" value="${obj.latUltima}">
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label>logitude</label>
	        		<input class="form-control" type="number" step="0.01" name="longUltima" value="${obj.longUltima}">
				</div>
			</div>
	
	
		
	<br>
			<div class="row">
				<div class="col-md-7">
					<label for="locomocao">Locomocao:</label> 
					<select name = "locomocao" id = "locomocao">
						<c:forEach items="${locomo}" var = "l" varStatus="index">
							<option value="${l.id}">${l.id} - ${l.descricao}
						</c:forEach>
					</select>
				</div>
			</div>
	
	<div class="row">
				<div class="col-md-7">
					<label for="dataHoraInicio">Data Hora de Inicio:</label> 
					<input type="datetime-local" id="dataHoraInicio" name="dataHoraInicio" 
					pattern="YYYY-MM-DDThh:mm"
					value="<fmt:formatDate value = "${o.dataHoraInicio}" pattern = "yyyy-MM-dd"/>T<fmt:formatDate value = "${o.dataHoraInicio}" pattern= "HH:mm"/>" 
					class="form-control">
				</div>
			</div>
	
	
	
	<div class="row">
				<div class="col-md-7">
					<label for="dataHoraFim">Data Hora de Fim:</label> 
					<input type="datetime-local" id="dataHoraFim" name="dataHoraFim" 
					pattern="YYYY-MM-DDThh:mm"
					value="<fmt:formatDate value = "${o.dataHoraFim}" pattern = "yyyy-MM-dd"/>T<fmt:formatDate value = "${o.dataHoraFim}" pattern= "HH:mm"/>" 
					class="form-control">
				</div>
			</div>
	
	
	
	
	<div class="row">
				<div class="col-md-7">
					<label for="dataHoraUltima">Data Hora de Ultima:</label> 
					<input type="datetime-local" id="DataHoraUltima" name="dataHoraUltima" 
					pattern="YYYY-MM-DDThh:mm"
					value="<fmt:formatDate value = "${o.dataHoraUltima}" pattern = "yyyy-MM-dd"/>T<fmt:formatDate value = "${o.dataHoraUltima}" pattern= "HH:mm"/>" 
					class="form-control">
				</div>
			</div>
	        	
	        <button class="btn btn-primary" type="submit" name="gravar">Gravar</button>	
	        <button type="submit" name="cancelar">Cancelar</button>
		
		</fieldset>
	</form>

</body>
</html>