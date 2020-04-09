<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null }">
            <div id="flush_success">
                <c:out value="${flush}" />
            </div>
        </c:if>
        <h2>商品　一覧</h2>
        <table id="products_list">
            <tbody>
                <tr>
                    <th>ID</th>
                    <th>商品名</th>
                    <th>カテゴリー</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="products" items="${products}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <th><c:out value="${products.id}" /></th>
                        <th><c:out value="${products.name}" /></th>
                        <th><c:out value="${products.category}" /></th>
                        <th><a href="/products/show?id=${products.id}">詳細ページへ</a></th>
                </c:forEach>
            </tbody>
        </table>
        <p><a href="<c:url value='/products/new' />">商品新規登録ページ</a></p>
        <a href="../">トップページに戻る</a>
    </c:param>
</c:import>