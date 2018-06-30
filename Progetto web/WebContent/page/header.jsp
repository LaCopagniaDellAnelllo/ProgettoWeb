<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
				<form action="Accesso" method="post">
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