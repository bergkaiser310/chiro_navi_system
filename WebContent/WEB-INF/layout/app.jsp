<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>顧客管理システム</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                 <div id="header_menu">
                    <h1>顧客管理システム</h1>&nbsp;&nbsp;
                    <a href="<c:url value='/customers/index' />">顧客管理</a>&nbsp;
                    <a href="<c:url value='/products/index' />">商品管理</a>&nbsp;
                    <a href="<c:url value='/reservation/index' />">予約一覧</a>&nbsp;
                 </div>
            </div>
            <div id="content">
                ${param.content}
            </div>
            <div id="footer">
                by Tomoya Sato
            </div>
        </div>


    </body>
</html>