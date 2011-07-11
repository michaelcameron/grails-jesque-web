<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head></head>
    <body>

    <g:render template="/jesqueQueues/queues" model="${[queueList:queueList,totalFailureCount:totalFailureCount]}"/>

    <hr />

    <g:render template="/jesqueWorking/working"/>

    </body>
</html>