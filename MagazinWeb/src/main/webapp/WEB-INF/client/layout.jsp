<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:getAsString name="title" /></title>
        <link href="<c:url value='/resources/css/bootstrap.min.css'/>"  rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/font-awesome.min.css'/>"  rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/prettyPhoto.css'/>" rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/price-range.css'/>"  rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/responsive.css'/>"  rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/animate.css'/>"  rel="stylesheet"></link>
        <link href="<c:url value='/resources/css/main.css'/>"  rel="stylesheet"></link>
        

        <link rel="shortcut icon" href="<c:url value='/resources/images/ico/favicon.ico'/>">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value='/resources/images/ico/apple-touch-icon-144-precomposed.png'/>">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<c:url value='/resources/images/ico/apple-touch-icon-114-precomposed.png'/>">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value='/resources/images/ico/apple-touch-icon-72-precomposed.png'/>">
        <link rel="apple-touch-icon-precomposed" href="<c:url value='/resources/images/ico/apple-touch-icon-57-precomposed.png'/>">

    </head>

    <body>
        <div >
            <tiles:insertAttribute name="header" />
        </div>

        <div >
            <tiles:insertAttribute name="homeSlider" />
        </div>
        <div style="text-align: center">
            <tiles:insertAttribute name="leftMenu" />
            <tiles:insertAttribute name="body" />
        </div>

        <div >
            <tiles:insertAttribute name="footer" />
        </div>
        <script src="<c:url value='/resources/js/jquery.js'/>"></script>
        <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
        <script src="<c:url value='/resources/js/jquery.scrollUp.min.js'/>"></script>
        <script src="<c:url value='/resources/js/price-range.js'/>"></script>
        <script src="<c:url value='/resources/js/jquery.prettyPhoto.js'/>"></script>
        <script src="<c:url value='/resources/js/main.js'/>"></script>
    </body>
</html>