<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<c:import url="/WEB-INF/layout/app.jsp">
    <c:param name="content">
        <h2>予約　登録</h2>
        <form method="POST" action="<c:url value='/reservation/create' />">
            <c:import url="_form.jsp" />
        </form>
    </c:param>
</c:import>
<a href="<c:url value='/customers/index' />">顧客一覧画面に戻る</a>