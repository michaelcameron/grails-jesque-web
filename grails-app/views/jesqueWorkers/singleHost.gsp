<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="jesque"/>
</head>
<body>

    <h1 class="wi">${workers.size()} Workers</h1>
    <p class="intro">The workers listed below are all registered as active on your system.</p>
    <table class="workers">
        <tr>
            <th>&nbsp;</th>
            <th>Where</th>
            <th>Queues</th>
            <th>Processing</th>
        </tr>
        <g:each in="${workers}" var="worker">
        <tr>
            <td class="icon"><img src="${g.resource(dir:'images', file:worker.state.toString().toLowerCase() + '.png')}" alt="${worker.state.toString().toLowerCase()}" title="${worker.state.toString().toLowerCase()}"></td>
            <td class="where"><g:link action="detail" id="${worker}">${worker.host}:${worker.pid}</g:link></td>
            <td class="queues"><g:each in="${worker.queues}" var="queue"><g:link class="queue-tag" controller="jesqueQueues" action="detail" id="${queue}">${queue}</g:link></g:each></td>
            <td class="process">
            <g:if test="${worker.status}">
                <code>${worker.status.payload.className}</code>
                <small><g:link class="queue time" controller="jesqueWorking" action="detail" id="${worker}"><jesque:formatDate date="${worker.status.runAt}"/></g:link></small>
            </g:if>
            <g:else>
                <span class="waiting">Waiting for a job...</span>
                <g:form action="remove" class="remove-worker" id="${worker.name}">
                    <input type="submit" name="" value="Remove Worker" onclick="return confirm('Are you absolutely sure? This cannot be undone.');" />
                </g:form>
            </g:else>
            </td>
        </tr>
        </g:each>
        <g:if test="${!workers}">
        <tr>
            <td colspan="4" class="no-data">There are no registered workers</td>
        </tr>
        </g:if>
    </table>

</body>
</html>