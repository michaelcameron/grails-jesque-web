<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html class="no-js ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]>    <html class="no-js ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]>    <html class="no-js ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html class="no-js" lang="en"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black" />
        <title>Resque.</title>
        <link rel="shortcut icon" href="<g:resource file="favicon.ico" />" />

        <r:require module="jesque"/>
        <r:layoutResources/>
    </head>
    <body>
        <div class="header">
            <ul class="nav">
            <g:each in="${tabs}" var="tab">
                <li <g:if test="${tab == activeTab}"> class="current"</g:if>>
                    <g:link controller="jesque${tab}" >${tab}</g:link>
                </li>
            </g:each>
            </ul>
            <g:if test="${namespace != 'resque'}">
                <abbr class="namespace" title="Resque's Redis Namespace">${namespace}</abbr>
            </g:if>
        </div>
        <g:if test="${subTabs}">
        <ul class="subnav">
        <g:each in="${subTabs}" var="subTab">
            <li<g:if test="${subTab == activeSubTab}"> class="current"</g:if>><g:link action="detail" id="${subTab}"><span>${subTab}</span></g:link></li>
        </g:each>
        </ul>
        </g:if>
        <div id="main">
            <g:layoutBody/>
        </div>
        <div id="footer">
            <p>Powered by <a href="https://github.com/gresrun/jesque">Jesque</a> v${version} - Inspired by <a href="https://github.com/defunkt/resque">Resque</a></p>
            <%--todo: add common properties via some DRY approach --%>
            <p>Connected to Redis namespace ${namespace} on ${redisUri}</p>
        </div>
        <r:layoutResources/>
    </body>
</html>
