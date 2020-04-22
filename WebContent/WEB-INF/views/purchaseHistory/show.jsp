<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${history != null}">
                <h2>${history.id}の詳細ページ</h2>
                <table>
                    <tbody>
                        <tr>
                            <th>購入日</th>
                            <td><c:out value="${history.sold_at}" /></td>
                        </tr>
                        <tr>
                            <th>購入者</th>
                            <td><c:out value="${history.customer.name}" /></td>
                        </tr>
                        <tr>
                            <th>商品名</th>
                            <td><c:out value="${history.product.name}" /></td>
                        </tr>
                        <tr>
                            <th>カテゴリー</th>
                            <td><c:out value="${history.product.category}" /></td>
                        </tr>
                        <tr>
                            <th>登録日時</th>
                            <td><c:out value="${report.created_at}" /></td>
                        </tr>
                        <tr>
                            <th>更新日時</th>
                            <td><c:out value="${report.updated_at}"/></td>
                        </tr>
                    </tbody>
                </table>
                    <a href="<c:url value='/purchasehistory/edit?id=${history.id}'/>">編集する</a>

            </c:when>
            <c:otherwise>
                <h2>お探しのページは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
        <p><a href="<c:url value='/purchasehistory/index' />">一覧に戻る</a></p>
       </c:param>
</c:import>