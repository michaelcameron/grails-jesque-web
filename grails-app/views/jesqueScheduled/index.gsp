<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="${(grailsApplication.config.jesque.views.layout) ?: 'jesque'}"/>
</head>
<body>

    <h1 class="wi">Scheduled Jobs</h1>

    <p class="intro">The list below contains all of the scheduled jobs</p>
    <table class="workers">
        <thead>
        <tr>
            <th>Job Name</th>
            <th>Cron Expression</th>
            <th>Next Fire Time</th>
            <th>Jesque Queue</th>
            <th>Jesque Job Name</th>
            <th>Args</th>
        </tr>
        </thead>
        <g:if test="${!scheduledJobs}">
            <tr>
                <td colspan="4" class="no-data">No scheduled jobs</td>
            </tr>
        </g:if>
        <g:each in="${scheduledJobs}" var="scheduledJob">
            <tr>
                <td>
                    ${scheduledJob.name}
                </td>
                <td>
                    ${scheduledJob.cronExpression}
                </td>
                <td>    
                    ${scheduledJob.trigger.nextFireTime}
                </td>
                <td>
                    ${scheduledJob.jesqueJobQueue}
                </td>
                <td>
                    ${scheduledJob.jesqueJobName}
                </td>
                <td>
                    ${scheduledJob.args}
                </td>

            </tr>
        </g:each>
    </table>

</body>
</html>