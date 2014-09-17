#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%-- http://shiro.apache.org/web.html${symbol_pound}Web-JSP%2FGSPTagLibrary --%>
<html>
<body>
<h2>Hello World!</h2>
Hello, <shiro:guest>Guest</shiro:guest><shiro:user><shiro:principal/></shiro:user>, how are you today?
</body>
</html>
