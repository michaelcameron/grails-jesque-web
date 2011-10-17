<%@ page contentType="text/html;charset=UTF-8" %>

<h1>Failed Jobs</h1>
<g:if test="${failures}">
<g:form action="clear" class="clear-failed">
    <input type="submit" name="" value="Clear Failed Jobs" />
</g:form>
</g:if>
<p class="sub">Showing ${total ? offset + 1 : 0} to ${Math.min(offset + max, total)} of <b>${total}</b> jobs</p>
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
                    <g:link controller="jesqueFailed" action="remove" id="${offset + index}" class="remove" rel="remove">Remove</g:link>
                </div>
                </g:if>
                <g:else>
                <div class="controls">
                    <g:link controller="jesqueFailed" action="requeue" id="${offset + index}" class="remove" rel="remove">Retry</g:link>
                    or
                    <g:link controller="jesqueFailed" action="remove" id="${offset + index}" class="remove" rel="remove">Remove</g:link>
                </div>
                </g:else>
            </dd>
            <dt>Class</dt>
            <dd><code>${job?.payload?.className ?: 'null'}</code></dd>
            <dt>Arguments</dt>
            <dd><pre><jesque:showArgs args="${job?.payload?.args ?: 'null'}"/></pre></dd>
            <dt>Exception</dt>
            <dd><code>${job?.exceptionString ?: 'null'}</code></dd>
            <dt>Error</dt>
            <dd class="error">
                <a href="#" class="backtrace">${job?.error ?: 'no message'}</a>
                <pre style="display: none;">${job?.exception}<jesque:asBacktrace failure="${job}"/></pre>
            </dd>
        </dl>
        <div class="r"></div>
    </li>
    </g:each>
    <g:paginate total="${total}" offset="${offset}" max="${max}"/>
</ul>
