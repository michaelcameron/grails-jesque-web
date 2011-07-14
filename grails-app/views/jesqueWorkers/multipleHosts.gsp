<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head></head>
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
            <td class="queue"><a class="queue" href="/workers/${entry.key}">${entry.key}</a></td>
            <td class="size">${entry.value.size}</td>
        </tr>
        </g:each>
        <tr class="failed">
            <td class="queue failed"><a class="queue" href="/workers/all">all workers</a></td>
            <td class="size">${totalWorkerCount}</td>
        </tr>
    </table>


    </body>
</html>