<%@ page language="java" import="model.EsecutoreQuery, java.sql.*, java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>La cantinetta</title>
<link rel="icon" href="/Progetto_web/img/logo cantina.png" type="image/png" />
<link rel="stylesheet" href="/Progetto_web/style/header.css">
<link rel="stylesheet" href="/Progetto_web/style/vini.css">
<script src="/Progetto_web/JavaScript/jquery.js"></script>
<script src="/Progetto_web/JavaScript/SliderHome.js"></script>
<script src="/Progetto_web/JavaScript/login.js"></script>
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
		<%@ include file="header.jsp"%>


<%
String query = "select immagine, Descrizione, VinoSfuso_Nome from vino";
EsecutoreQuery eq = new EsecutoreQuery();
ArrayList<String[]> result = eq.exeQuery(query, 3);
if (result != null) {
%>

	<div>
		<table class="bacheca">
			<%
				for (int i = 0; i < result.size(); i++) {
						String[] vino = result.get(i);
			%>
			<tr>
				<td class="bottiglia">
					<img src="<%=vino[0]%>">
				</td>
				
				<td class="descrizione">
					<h2><%=vino[2]%></h2>
					<p><%=vino[1]%></p>
				</td>
				
			</tr>
			<%
				}
			%>
		</table>
	</div>
<%	
} else {
%>
	<div>
		<p align="center">
			Abbiamo riscontrato un problema nel database
		</p>
	</div>
<%	
}
%>
		<%@ include file="footer.jsp"%>

</body>
</html>