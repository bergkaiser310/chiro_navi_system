<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${product != null }">
                <h2>商品情報　編集ページ</h2>
                <form method="POST" action="<c:url value='/products/update' />">
                    <c:import url="_form.jsp" />
                </form><br />
                <form method="POST" action="<c:url value='/products/destroy' />">
                    <button type="submit">削除</button>
                </form>
            </c:when>
            <c:otherwise>
                <h2>お探しのページは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
        <a href="<c:url value='/products/index' /> ">商品一覧ページに戻る</a>
    </c:param>
</c:import>

