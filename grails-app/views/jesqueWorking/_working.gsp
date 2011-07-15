<%@ page contentType="text/html;charset=UTF-8" %>

<h1 class="wi">${working.size()} of ${totalWorkerCount} Workers Working</h1>
<p class="intro">The list below contains all workers which are currently running a job.</p>
<table class="workers">
	<tr>
		<th>&nbsp;</th>
		<th>Where</th>
		<th>Queue</th>
		<th>Processing</th>
	</tr>
	<g:if test="${!working}">
	<tr>
		<td colspan="4" class="no-data">Nothing is happening right now...</td>
	</tr>
	</g:if>
	<g:each in="${working}" var="worker">
	<tr>
		<td class="icon"><img src="<g:resource dir="images" file="${worker.state.toLowerCase()}.png" />" alt="${worker.state.toLowerCase()}" />" title="${worker.state.toLowerCase()}" />"></td>
		<td class="where"><g:link controller="jesqueWorkers" action="detail" id="${worker}">${worker.host}:${worker.pid}</g:link></td>
		<td class="queues queue">
			<g:link class="queue-tag" controller="jesqueQueues" action="detail" id="${worker.status.queue}">${worker.status.queue}</g:link>
		</td>
		<td class="process">
		<g:if test="${!worker.status.queue}">
			<code>${worker.status.payload.className}"</code>
			<small><g:link class="queue time" controller="jesqueWorking" action="detail" id="/working/${worker}">${worker.status.runAt}"</g:link></small>
		</g:if>
		<g:else>
			<span class="waiting">Waiting for a job...</span>
        </g:else>
        </td>
	</tr>
	</g:each>
</table>
