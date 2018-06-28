<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>La cantinetta</title>
<link rel="icon" href="../img/logo cantina.png" type="image/png" />
<link rel="stylesheet" href="../style/header.css">
<link rel="stylesheet" href="../style/home.css">
<script src="../JavaScript/jquery.js"></script>
<script src="../JavaScript/SliderHome.js"></script>
<script src="../JavaScript/login.js"></script>
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
</head>
<body>



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
					<li><a href="#" class="login"><img src="../img/log in.png"
							style="margin-bottom: 5px;"></a></li>
					<li><a href="#" class="signin"><img
							src="../img/sign in.png"></a></li>
				</ul>
			</div>

			<div class="accesso">
				<form action="Accasso" method="post">
					<div class="riga">
						<p>Username:</p>
						<input type="text" name="Username">
					</div>
					<div class="riga">
						<p>Password:</p>
						<input type="password" name="Password">
					</div>
					
						<input type="button" value="Signin">
						<input type="submit" value="Login">
				</form>
			</div>



			<div class="nomeazienda" align="center">
				<a href="index.jsp"><img src="../img/La Cantinetta SCRITTA.png"
					class="nomeazienda"></a>
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


	<div class="corpo" align="center">


		<div id="slider">

			<a href="#" class="control_next">&gt;</a> <a href="#"
				class="control_prev">&lt;</a>
			<ul>
				<li><img
					src="../img/immagini dello slder/poderibosco_01foto_di_a.manna.jpg"></li>
				<li><img
					src="../img/immagini dello slder/poderibosco_02foto_di_a.manna.jpg"></li>
				<li><img
					src="../img/immagini dello slder/poderibosco_03foto_di_a.manna.jpg"></li>
				<li><img
					src="../img/immagini dello slder/poderibosco_05foto_di_a.manna.jpg"></li>
				<li><img
					src="../img/immagini dello slder/poderibosco_06foto_di_a.manna.jpg"></li>
				<li><img
					src="../img/immagini dello slder/poderibosco_07foto_di_a.manna.jpg"></li>
				<li><img
					src="../img/immagini dello slder/poderibosco_08foto_di_a.manna.jpg"></li>
				<li><img
					src="../img/immagini dello slder/poderibosco_09foto_di_a.manna.jpg"></li>
				<li><img
					src="../img/immagini dello slder/poderibosco_10foto_di_a.manna.jpg"></li>
				<li><img
					src="../img/immagini dello slder/poderibosco_11foto_di_a.manna.jpg"></li>
				<li><img
					src="../img/immagini dello slder/poderibosco_13foto_di_a.manna.jpg"></li>
				<li><img
					src="../img/immagini dello slder/poderibosco_14foto_di_a.manna.jpg"></li>
				<li><img
					src="../img/immagini dello slder/poderibosco_15foto_di_a.manna.jpg"></li>
				<li><img
					src="../img/immagini dello slder/poderibosco_17foto_di_a.manna.jpg"></li>
				<li><img
					src="../img/immagini dello slder/poderibosco_19foto_di_a.manna.jpg"></li>
				<li><img
					src="../img/immagini dello slder/poderibosco_20foto_di_a.manna.jpg"></li>
				<li><img src="../img/immagini dello slder/s4200039.jpg"></li>
				<li><img src="../img/immagini dello slder/vignasfondo_18.jpg"></li>
			</ul>

		</div>

		<div class="text">
			<p id="title">L'Azienda</p>
			<p id="text">La selezione di uve nobili, la ricerca del giusto
				grado di freschezza ed umidità unito allo scorrere del tempo, vecchi
				segreti tramandati da vinificatori del luogo e tecniche di
				elaborazione all’avanguardia danno vita a vini di elevatissima
				qualità, stimati in tutto il mondo.</p>

		</div>



	</div>


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