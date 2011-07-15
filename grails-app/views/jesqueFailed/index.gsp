<%@ page contentType="text/html;charset=UTF-8" %>

<h1>Failed Jobs</h1>
<g:if test="${failures}">
<form method="POST" action="/failed/clear" class="clear-failed">
	<input type="submit" name="" value="Clear Failed Jobs" />
</form>
</g:if>
<p class="sub">Showing x to y of <b>${fullFailureCount}</b> jobs</p>
<ul class="failed">
	<g:each in="${failures}" var="job" status="index">
	<li>
		<dl>
			<dt>Worker</dt>
			<dd>
				<g:link controller="jesqueWorkers" action="detail" id="${job.worker}"><jesque:workerShortName workerName="${job.worker}"/></g:link> on <b class="queue-tag">${job.queue}</b> at <b><span class="time"><jesque:formatDate date="${job.failedAt}"/></span></b>
				<g:if test="${job.retriedAt}">
				<div class="retried">
					Retried <b><span class="time"><jesque:formatDate date="${job.retriedAt}"/></span></b>
					<g:link controller="failed" action="remove" id="${offset + index}" class="remove" rel="remove">Remove</g:link>
				</div>
				</g:if>
				<g:else>
				<div class="controls">
                    <g:link controller="failed" action="requeue" id="${offset + index}" class="remove" rel="remove">Retry</g:link>
					or
                    <g:link controller="failed" action="remove" id="${offset + index}" class="remove" rel="remove">Remove</g:link>
				</div>
                </g:else>
            </dd>
			<dt>Class</dt>
			<dd><code>${job?.payload?.className ?: 'null'}</code></dd>
			<dt>Arguments</dt>
			<dd><pre><jesque:showArgs args="${job?.payload?.args ?: 'null'}"/></pre></dd>
			<dt>Exception</dt>
			<dd><code>${job.exception.class.name}</code></dd>
			<dt>Error</dt>
			<dd class="error">
				<a href="#" class="backtrace">${job.exception.message}</a>
				<pre style="display: none;">${job.exception}<%--<jesque:asBacktrace exception="${job.exception}"/>--%></pre>
			</dd>
		</dl>
		<div class="r"></div>
	</li>
	</g:each>
</ul>
