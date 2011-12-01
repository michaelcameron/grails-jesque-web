<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="jesque"/>
    </head>
    <body>
    <h1 class="wi">Workers</h1>
    <p class='intro'>The hostnames below all have registered workers. Select a hostname to view its workers, or "all" to see all workers.</p>
    <table class="queues">
        <tr>
            <th>Hostname</th>
            <th>Workers</th>
        </tr>
        <g:each in="${hostMap}" var="entry">
        <tr>
            <td class="queue"><g:link controller="jesqueWorkers" action="detail" id="${entry.key}">${entry.key}</g:link></td>
            <td class="size">${entry.value.size}</td>
        </tr>
        </g:each>
        <tr class="failed">
            <td class="queue failed"><g:link action="detail" id="all" class="queue">all workers</g:link></td>
            <td class="size">${totalWorkerCount}</td>
        </tr>
    </table>


    </body>
</html>