<%@ page contentType="text/html;charset=UTF-8" %>
<h1 class="wi">Queues</h1>
<p class="intro">The list below contains all the registered queues with the number of jobs currently in the queue. Select a queue from above to view all jobs currently pending on the queue.</p>
<table class="queues">
    <tr>
        <th>Name</th>
        <th>Jobs</th>
    </tr>
    <g:each in="${queueList}" var="queue">
    <tr>
        <td class="queue"><g:link controller="jesqueQueues" action="detail" id="${queue}">${queue}</g:link></td>
        <td class="size">${queue.size}</td>
    </tr>
    </g:each>
    <tr class="${(totalFailureCount == 0) ? 'failed' : 'failure'}">
        <td class="queue failed"><g:link controller="jesqueFailed">failed</g:link></td>
        <td class="size">${totalFailureCount}</td>
    </tr>
</table>
