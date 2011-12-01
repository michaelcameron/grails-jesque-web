<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="jesque"/>
</head>

<body>

<g:render template="queues" model="${[queueList:queueList,totalFailureCount:totalFailureCount]}"/>

</body>
</html>