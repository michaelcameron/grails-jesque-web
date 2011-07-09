<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head></head>
    <body>

    <g:render template="queues" model="${[queueList:queueList,totalFailureCount:totalFailureCount]}"/>

    <hr />

    <g:render template="working"/>

    </body>
</html>