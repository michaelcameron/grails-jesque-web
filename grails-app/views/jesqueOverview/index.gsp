<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="${(grailsApplication.config?.jesque?.views?.layout)?:'jesque'}"/> 
    </head>

    <body>


    <g:render template="/jesqueQueues/queues" model="${[queueList:queueList,totalFailureCount:totalFailureCount]}"/>

    <hr />

    <g:render template="/jesqueWorking/working"/>

    </body>
</html>