<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head></head>
    <body>

        <g:if test="${!queue}">
        <h1>Queue <span class="hl">${queueName}</span> is not a valid queue</h1>
        </g:if>
        <g:else>
        <h1>Pending jobs on <span class="hl">${queue}</span></h1>
        <form method="POST" action="/queues/${queue}/remove" class="remove-queue">
            <input type="submit" name="" value="Remove Queue" onclick="return confirm('Are you absolutely sure? This cannot be undone.');" />
        </form>
        <p class="sub">Showing x to y of <b>${queue.size}</b> jobs</p>
        <table class="jobs">
            <tr>
                <th>Class</th>
                <th>Args</th>
            </tr>
            <g:each in="${queue.jobs}" var="job">
            <tr>
                <td class="class">${job.className}</td>
                <%--todo: jsonify the args before showing--%>
                <td class="args">${job.args}</td>
            </tr>
            </g:each>
            <g:if test="${!queue.jobs}">
            <tr>
                <td class="no-data" colspan="2">There are no pending jobs in this queue</td>
            </tr>
            </g:if>
        </table>

        </g:else>
    
    </body>
</html>