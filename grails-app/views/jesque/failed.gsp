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
				<a href="/workers/${job.worker}"><jesque:workerShortName workerName="${job.worker}"/></a> on <b class="queue-tag">${job.queue}</b> at <b><span class="time"><jesque:formatDate date="${job.failedAt}"/></span></b>
				<g:if test="${job.retriedAt}">
				<div class="retried">
					Retried <b><span class="time"><jesque:formatDate date="${job.retriedAt}"/></span></b>
					<a href="/failed/remove/${offset + index}" class="remove" rel="remove">Remove</a>
				</div>
				</g:if>
				<g:else>
				<div class="controls">
					<a href="/failed/requeue/${offset + index}" rel="retry">Retry</a>
					or
					<a href="/failed/remove/${offset + index}" rel="remove">Remove</a>
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
				<pre style="display: none;"><jesque:asBacktrace exception="${job.exception}"/></pre>
			</dd>
		</dl>
		<div class="r"></div>
	</li>
	</g:each>
</ul>
