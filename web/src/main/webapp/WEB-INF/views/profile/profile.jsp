<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<head>
    <link rel="stylesheet" type="text/css" href="${cssStyle}" >
</head>


<sf:form method="POST" enctype="multipart/form-data" modelAttribute="profileForm" action="upload">

    <sf:label path="multipartFile" for="multipartFile">
        <s:message code="usuario" />
    </sf:label>
    <sf:input path="multipartFile" tabindex="1" autofocus="true" type="file"/>
    <sf:errors path="multipartFile" cssClass="errors" />

    <input type="submit" tabindex="2" value="<s:message code="enviar" />"/>
</sf:form>
