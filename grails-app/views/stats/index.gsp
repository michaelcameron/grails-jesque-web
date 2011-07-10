<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head></head>
  <body>
  <h1>${title}</h1>
  <g:if test="${subTitle}"><p class="sub">${subTitle}</p></g:if>
  <table class="stats">
      <g:each in="${stats}" var="entry">
      <tr>
          <th>${entry.key}</th>
          <td>${entry.value}</td>
      </tr>
      </g:each>
      <g:if test="${keys}">
      <tr>
          <th class="statHeader">Key</th>
          <th class="statHeader">Type</th>
          <th class="statHeader">Size</th>
      </tr>
      <g:each in="${keys}" var="key">
      <tr>
          <th><a href="/stats/keys/${key}">${key}</a></th>
          <td>${key.type}</td>
          <td>${key.size}</td>
      </tr>
      </g:each>
      </g:if>
  </table>


  </body>
</html>