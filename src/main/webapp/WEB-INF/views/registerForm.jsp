<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Register</h1>

<!--
    <form method="POST"> no tiene  un parámetro action configurado. Con lo que al enviar el formulario
    se publica en la misma URL que lo ha mostrado
      First Name: <input type="text" name="firstName" /><br/>
      Last Name: <input type="text" name="lastName" /><br/>
      Email: <input type="email" name="email" /><br/>
      Username: <input type="text" name="userName" /><br/>
      Password: <input type="password" name="password" /><br/>
      <input type="submit" value="Register" />
    </form>
    -->

    <spring:form commandName="spitter">
    <spring:errors path="*" element="div" cssClass="errors" />
    UserName: <spring:input path="userName"/> <br/>
    First Name: <spring:input path="firstName"/> <br/>
    <input type="submit" value="Register" />
    </spring:form>
  </body>
</html>
