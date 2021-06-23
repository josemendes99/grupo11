<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
	<form action="PessoaCon" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>Formulário:</legend>

			<div class="row">
				<div class="col-md-2">
					<label>id</label> <input class="form-control" type="number"
						readonly="readonly" name="id" value="${obj.id}">
				</div>
			</div>

			<div class="row">
				<div class="col-md-5">
					<label>titulo</label> <input class="form-control" type="text"
						name="titulo" readonly="readonly" value="${obj.titulo}">
				</div>
			</div>
			
				<div class="row">
				<div class="col-md-5">
					<label>descricao</label> <input class="form-control" type="text"
						name="descricao" readonly="readonly" value="${obj.descricao}">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-5">
					<label>lat</label> <input class="form-control" type="text"
						name="lat" readonly="readonly" value="${obj.lat}">
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-md-5">
					<label>log</label> <input class="form-control" type="text"
						name="log" readonly="readonly" value="${obj.log}">
				</div>
			</div>



			<div class="row">
				<div class="col-md-2">
				
					<label>Foto</label> 
					
					
					<input type="file" name="foto"/><br>
					
					
					<div id="areaImagem">
						<img name="imagem" id="imagem" width="200" height="200"
							 src="uploads/Foto${obj.id}.jpg" />
					</div>

					<br>
					
					<div id="areaImagemBD">
						<img name="imagemBD" id="imagemBD" width="300" height="300"
							 src="data:image/jpg;base64,${obj.fotoBase64}" />
					</div>






				</div>
			</div>


			<button class="btn btn-primary" type="submit" name="gravarFoto">Gravar</button>
			<button class="btn btn-primary" type="submit" name="cancelar">Cancelar</button>

		</fieldset>
	</form>

</body>
</html>