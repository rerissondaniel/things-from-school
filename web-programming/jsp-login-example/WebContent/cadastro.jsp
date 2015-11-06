<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro</title>
</head>

<body>
	<table>
		<tr>
			<td>
				 <form action="loginServlet.do" method = "POST">
					<table>
						<tr>
							<td>
								<label for="usuario">Usuario</label>
							</td>
							<td> 
								<input type="text"
								name="usuario">
							</td>
						</tr>
						<tr>
							<td>
								<label for="senha">Senha</label> 
							</td>
							<td>
								<input type="password" name="senha">
							</td>
						</tr>
						<tr>
							<td rowspan = "2">
								<input type = "submit" value = "Enviar">
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action = "cadastroServlet.do" method = "POST">
					<table>
							<tr>
								<td>
									<label for="usuario">Usuario</label>
								</td>
								<td> 
									<input type="text" name="usuario">
								</td>
							</tr>
							<tr>
								<td>
									<label for="senha">Senha</label> 
								</td>
								<td>
									<input type="password" name="senha">
								</td>
							</tr>
							<tr>
								<td>
									<label for="senha">Re-senha</label> 
								</td>
								<td>
									<input type="password" name="re-senha">
								</td>
							</tr>
							
							<tr>
								<td>
									<label for="genero">Gênero</label> 
								</td>
								<td>
									<select name = "genero">
										<option>Masculino</option>
										<option>Feminino</option>
										<option>Outro</option>
									</select>
								</td>
							</tr>
							
							<tr>
								<td>
									<label for="nascimento">Nascimento</label> 
								</td>
								<td>
									<input type="date" name="nascimento">
								</td>
							</tr>
								
							<tr>
								<td rowspan = "2">
									<input type = "submit" value = "Enviar">
								</td>
							</tr>
						</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>