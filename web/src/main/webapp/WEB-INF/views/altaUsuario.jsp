<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>


<s:url value="/resources/css/master.css" var="cssStyle"/>

<head>
    <link rel="stylesheet" type="text/css" href="${cssStyle}" >
</head>

<sf:form method="POST" modelAttribute="userForm" action="usuario">

    <sf:label path="userName" for="userName">
        <s:message code="usuario" />
    </sf:label>
    <sf:input path="userName" tabindex="1" autofocus="true" maxlength="12"/>
    <sf:errors path="userName" cssClass="errors" />

    <sf:label path="password" for="password">
        <s:message code="password" />
    </sf:label>
    <sf:input path="password" tabindex="2" maxlength="12"/>
    <sf:errors path="password" cssClass="errors" />

    <input type="submit" tabindex="3" value="<s:message code="enviar" />"/>
</sf:form>
