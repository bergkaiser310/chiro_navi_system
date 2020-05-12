<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/layout/app.jsp">
    <c:param name="content">
    <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>顧客　一覧</h2>
        <table id="customer_list">
            <tbody>
            <tr>
               <!-- <th>id</th> -->
                <th>氏名</th>
                <th>住所</th>
                <th>電話番号</th>
                <th>操作</th>
                <th>予約情報</th>
            </tr>
            <c:forEach var="customers" items="${customers}" varStatus="status">
                <tr class="row${status.count % 2}">
                   <!--  <td><c:out value="${customers.id}" /></td> -->
                    <td><c:out value="${customers.name}" /></td>
                    <td><c:out value="${customers.adress}" /></td>
                    <td><c:out value="${customers.tel}" /></td>
                    <td><a href="<c:url value='/customers/show?id=${customers.id}' />">詳細ページへ</a></td>
                    <td><a href="<c:url value='/reservation/new?id=${customers.id }' />">予約登録</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    <div id="pagination">
            （全 ${customers_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((customers_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/customers/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>

    <p><a href="<c:url value='/customers/new' />">顧客新規登録ページ</a></p>
    <p><a href="../">トップページに戻る</a></p>
    </c:param>
</c:import>
