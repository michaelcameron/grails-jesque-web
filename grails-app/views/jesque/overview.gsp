<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head><title>Simple GSP page</title></head>
    <body>

    <h1 class="wi">Queues</h1>
    <p class="intro">The list below contains all the registered queues with the number of jobs currently in the queue. Select a queue from above to view all jobs currently pending on the queue.</p>
    <table class="queues">
        <tr>
            <th>Name</th>
            <th>Jobs</th>
        </tr>
        <g:each in="${queues}" var="queue">
        <tr>
            <td class="queue"><a class="queue" href="/queues/${queue}">${queue}</a></td>
            <td class="size">${queue.size}</td>
        </tr>
        </g:each>
        <tr class="${(totalFailureCount == 0) ? 'failed' : 'failure'}">
            <td class="queue failed"><a class="queue" href="/failed">failed</a></td>
            <td class="size">${totalFailureCount}</td>
        </tr>
    </table>


    </body>
</html>