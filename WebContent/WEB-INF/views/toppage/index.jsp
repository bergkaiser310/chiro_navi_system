<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>顧客管理システム</title>
    </head>
    <body>
        <h2>顧客管理システム</h2>
        <p><a href="<c:url value='/customers/index' /> ">顧客管理</a></p>
        <p><a href="<c:url value='/products/index' /> ">商品管理</a></p>

    </body>
</html>