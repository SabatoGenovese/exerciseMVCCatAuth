<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
  <head>
    <link rel="stylesheet" href="./css/stile.css" type="text/css">
  </head>
  <body>
      <ul>
        <c:choose>
          <c:when test="${utente == null}">
            <li id="utente">Salve utente ospite</li>
          </c:when>
          <c:otherwise>
            <li id="utente">Ciao ${utente.username}</li>
          </c:otherwise>
        </c:choose>
      </ul>
</body>
</html>