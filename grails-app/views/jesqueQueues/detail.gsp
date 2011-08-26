<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head></head>
    <body>

        <g:if test="${!queue}">
        <h1>Queue <span class="hl">${queueName}</span> is not a valid queue</h1>
        </g:if>
        <g:else>
        <h1>Pending jobs on <span class="hl">${queue}</span></h1>
        <g:form action="remove" class="remove-queue" id="${queue.name}">
            <input type="submit" name="" value="Remove Queue" onclick="return confirm('Are you absolutely sure? This cannot be undone.');" />
        </g:form>
        <p class="sub">Showing ${total ? offset + 1 : 0} to ${Math.min(offset + max, total)} of <b>${total}</b> jobs</p>
        <table class="jobs">
            <tr>
                <th>Class</th>
                <th>Args</th>
            </tr>
            <g:each in="${queue.jobs}" var="job">
            <tr>
                <td class="class">${job.className}</td>
                <td class="args"><jesque:toJson value="${job.args}"/></td>
            </tr>
            </g:each>
            <g:if test="${!queue.jobs}">
            <tr>
                <td class="no-data" colspan="2">There are no pending jobs in this queue</td>
            </tr>
            </g:if>
        </table>

        </g:else>
    
        <g:paginate total="${total}" offset="${offset}" max="${max}"/>
    </body>
</html>