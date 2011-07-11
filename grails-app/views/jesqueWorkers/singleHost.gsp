<%@ page contentType="text/html;charset=UTF-8" %>
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
		<td class="queues"><g:each in="${worker.queues}" var="queue"><a class="queue-tag" href="/queues/${queue}">${queue}</a></g:each></td>
		<td class="process">
		<g:if test="${worker.status}">
			<code>${worker.status.payload.className}</code>
			<small><a class="queue time" href="/working/${worker}"><jesque:formatDate date="${worker.status.runAt}"/></a></small>
		</g:if>
		<g:else>
			<span class="waiting">Waiting for a job...</span>
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
