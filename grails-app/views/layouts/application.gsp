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
		<link rel="apple-touch-icon-precomposed" href="apple-touch-icon-precomposed.png" />
		<link rel="apple-touch-icon-precomposed" sizes="72x72" href="apple-touch-icon-72x72-precomposed.png" />
		<link rel="apple-touch-icon-precomposed" sizes="114x114" href="apple-touch-icon-114x114-precomposed.png" />
		<link rel="stylesheet" type="text/css" href="<g:resource dir="css" file="reset.css" />" />
		<link rel="stylesheet" type="text/css" href="<g:resource dir="css" file="style.css" />" />
		<script type="text/javascript" src="<g:resource dir="js" file="date.js" />"></script>
		<script type="text/javascript" src="<g:resource dir="js" file="jquery-1.5.1.min.js" />"></script>
		<script type="text/javascript" src="<g:resource dir="js" file="jquery.relatize_date.js" />"></script>
		<script type="text/javascript" src="<g:resource dir="js" file="jesque.js" />"></script>
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
			<li<g:if test="${subTab == activeSubTab}"> class="current"</g:if>><a href="${activeTab}/${subTab}"><span>${subTab}</span></a></li>
		</g:each>
		</ul>
		</g:if>
		<div id="main">
            <g:layoutBody/>
        </div>
        <div id="footer">
            <p>Powered by <a href="https://github.com/gresrun/jesque">Jesque</a> v${version} - Inspired by <a href="https://github.com/defunkt/resque">Resque</a></p>
            <p>Connected to Redis namespace ${namespace} on ${redisUri}</p>
        </div>
    </body>
</html>
