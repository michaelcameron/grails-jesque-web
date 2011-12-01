<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="jesque"/>
    </head>
    <body>
    <g:if test="${!key}">
    <h1>Key "${keyName}" is not a valid key</h1>
    </g:if>
    <g:else>
    <h1>Key "${key}" is a ${key.type}</h1>
    <h2>size: ${key.size}</h2>
    <table>
        <tr>
            <td><jesque:toJson value="${key.arrayValue}" /></td>
        </tr>
    </table>
    </g:else>

    </body>
</html>