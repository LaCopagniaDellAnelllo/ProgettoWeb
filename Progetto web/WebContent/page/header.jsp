<%@page import="bean.Utente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    	<!--  header -->
	<div>
		<!-- sfondo -->
		<div class="topunder"></div>

		
		<div class="top">

			<div class="logo">
				<img src="/Progetto_web/img/logo cantina.png" width="88px" height="80px"
					style="margin-top: -5px">
			</div>


			<% 
				Utente bean = (Utente) session.getAttribute("utente");
				String errore =(String) request.getAttribute("erroreLog");
				if (errore != null) {
			%>
			<script type="text/javascript">window.alert(errore);</script>			
			<% 
				} else if(bean != null) {
			%>
				<div class="logged">
					<img src="" alt="immagine profilo" style="float: right;">
					<p> <%=bean.getNome()%> 
					</p>
				</div>
				
				
				
			
			<%
				} else {				
				
			%>
			
			<div class="log">
				<ul>
					<li><a href="#" class="login"><img src="/Progetto_web/img/log in.png"
							style="margin-bottom: 5px;"></a></li>
					<li><a href="/Progetto_web/page/signin.jsp" class="signin"><img
							src="/Progetto_web/img/sign in.png"></a></li>
				</ul>
			</div>

			<div class="accesso">
				<form action="/Progetto_web/Login" method="post">
					<div class="riga">
						<p>Username:</p>
						<input type="text" name="Username">
					</div>
					<div class="riga">
						<p>Password:</p>
						<input type="password" name="Password">
					</div>
					
						<a href="/Progetto_web/page/signin.jsp"><input type="button" value="Signin"></a>
						<input type="submit" value="Login">
				</form>
			</div>
			<%
				}
			%>


			<div class="nomeazienda" align="center">
				<a href="index.jsp"><img src="/Progetto_web/img/La Cantinetta SCRITTA.png"
					class="nomeazienda"></a>
			</div>


		</div>

	</div>


	<div class="navigazione">
		<ul class="navigazione">
			<li class="navigazione"><a href="/Progetto_web/page/index.jsp">HOME</a></li>
			<li class="navigazione"><a href="/Progetto_web/page/storia.jsp">STORIA</a></li>
			<li class="navigazione"><a href="/Progetto_web/page/galleria.jsp">GALLERIA</a></li>
			<li class="navigazione"><a href="/Progetto_web/page/vini.jsp">VINI</a></li>
			<li class="navigazione"><a href="/Progetto_web/page/shop.jsp">SHOP</a></li>
			<li class="navigazione"><a href="/Progetto_web/page/contatti.jsp">CONTATTI</a></li>

		</ul>
	</div>