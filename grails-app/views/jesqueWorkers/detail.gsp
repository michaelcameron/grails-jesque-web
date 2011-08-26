<%@ page contentType="text/html;charset=UTF-8" %>
<h1>Worker ${worker}</h1>
<table class="workers">
    <tr>
        <th>&nbsp;</th>
        <th>Host</th>
        <th>Pid</th>
        <th>Started</th>
        <th>Queues</th>
        <th>Processed</th>
        <th>Failed</th>
        <th>Processing</th>
    </tr>
    <tr>
        <td class="icon"><img src="<g:resource dir="images" file="${worker.state.toString().toLowerCase()}.png"/>" alt="${worker.state.toString().toLowerCase()}" title="${worker.state.toString().toLowerCase()}"></td>
        <td>${worker.host}</td>
        <td>${worker.pid}</td>
        <td><span class="time"><jesque:formatDate date="${worker.started}"/></span></td>
        <td class="queues"><g:each in="${worker.queues}" var="queue"><g:link controller="jesqueQueues" action="detail" id="${queue}" class="queue-tag">${queue}</g:link></g:each></td>
        <td>${worker.processed}</td>
        <td>${worker.failed}</td>
        <td class="process">
        <g:if test="${worker.status}">
            <code>${worker.status.payload.className}</code>
            <small><g:link controller="jesqueWorking" action="detail" id="${worker}" class="queue time"><jesque:formatDate date="${worker.status.runAt}" /></g:link></small>
        </g:if>
        <g:else>
            <span class="waiting">Waiting for a job...</span>
        </g:else>
        </td>
    </tr>
</table>
