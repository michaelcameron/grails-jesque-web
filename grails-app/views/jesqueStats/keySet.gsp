<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head></head>
    <body>

    <p class="sub">Showing ${offset + 1} to ${Math.min(offset + max, total)} of <b>${total}</b> elements</p>
    <h1>Key "${key}" is a ${key.type}</h1>
    <table>
        <g:each in="${key.arrayValue}" var="val">
        <tr>
            <td>${val}</td>
        </tr>
        </g:each>
    </table>
    <g:paginate total="${total}" offset="${offset}" max="${max}"/>

    </body>
</html>