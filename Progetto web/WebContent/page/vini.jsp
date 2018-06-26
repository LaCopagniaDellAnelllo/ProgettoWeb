<%@ page language="java" import="control.EsecutoreQuery, java.sql.*, java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>La cantinetta</title>
<link rel="icon" href="../img/logo cantina.png" type="image/png" />
<link rel="stylesheet" href="../style/header.css">
<link rel="stylesheet" href="../style/home.css">
<script src="../JavaScript/jquery.js"></script>
<script src="../JavaScript/SliderHome.js"></script>
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
</head>
<body>
	<div>

		<!--  header -->
		<div>
			<div class="topunder"></div>

			<div class="top">

				<div class="logo">
					<img src="../img/logo cantina.png" width="88px" height="80px"
						style="margin-top: -5px">
				</div>


				<div class="log">
					<ul>
						<li><img src="../img/log in.png" style="margin-bottom: 5px;"></li>
						<li><img src="../img/sign in.png"></li>
					</ul>
				</div>

				<div align="center" style="opacity: 0.6; margin-top: 10px">
					<a href="index.jsp"><img src="../img/La Cantinetta SCRITTA.png"
						class="nomeazienda"></a>
				</div>

			</div>

		</div>


	</div>
	<div class="navigazione">
		<ul class="navigazione">
			<li class="navigazione"><a href="index.jsp">HOME</a></li>
			<li class="navigazione"><a href="storia.jsp">STORIA</a></li>
			<li class="navigazione"><a href="galleria.jsp">GALLERIA</a></li>
			<li class="navigazione"><a href="vini.jsp">VINI</a></li>
			<li class="navigazione"><a href="shop.jsp">SHOP</a></li>
			<li class="navigazione"><a href="contatti.jsp">CONTATTI</a></li>

		</ul>
	</div>


<%
String query = "select immagine, Descrizione, VinoSfuso_Nome, VinoSfuso_Anno from vino";
EsecutoreQuery eq = new EsecutoreQuery();
ArrayList<String[]> result = eq.exeQuery(query);
if (result != null) {
%>

	<div>
		<table>
		<%for(int i = 0; i < result.size(); i++) {
			String[] vino = result.get(i);
			%>
			<tr>
			<%=vino[1]%>
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
	<footer>
		<!--  logo footer -->
		<div align="left" class="logof">
			<img src="../img/logo cantina.png" width="160px" height="150px"
				style="padding-top: 60px;">
		</div>

		<!--  social -->
		<div class="social" align="right">
			<p>Seguici sui nostri social</p>

			<ul>
				<li class="social"><a href="heVolevi.jsp"> <img
						src="../img/9-2-twitter-high-quality-png.png" width="50px"
						height="50px"></a></li>
				<li class="social"><a href="heVolevi.jsp"> <img
						src="../img/instagram-colourful-icon.png" width="50px"
						height="50px"></a></li>
				<li class="social"><a href="heVolevi.jsp"> <img
						src="../img/md_5a9794da1b10e.png" width="50px" height="50px"></a></li>
			</ul>
		</div>

		<!--  contatti -->
		<div class="contact">
			<p>Azienda agricola La Cantinetta</p>
			<p>Via Roma 21</p>
			<p>Fisciano</p>
			<p>84084 Fisciano(Sa)</p>
		</div>



	</footer>

</body>
</html>