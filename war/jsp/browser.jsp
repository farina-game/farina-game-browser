<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="java.util.List"%>
<%@ page import="net.falsecam.farina_game_browser.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Farina Game Browser</title>
</head>

<body>
	<%
		List<Game> games = Game.getGames();
	%>
	<ol>
	<%
		for (Game game : games) {
	%>
	<li>Name=<%=game.getName()%>, Host=<%=game.getHost()%>, Port=<%=game.getPort()%></li>
	<%
		}
	%>
	</ol>
</body>
</html>