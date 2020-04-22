<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/layout/app.jsp">
    <c:param name="content">
        <h3>トップページ</h3>
        <p>ようこそ〇〇さん！今日は<fmt:formatDate value="${today}" pattern="MM/dd" />です！</p><br />
            <div class="flex">
                <div class="flexcontent">
                    <h4>今日と明日の予約</h4>
                    <c:if test="${latestReservations != null}">
                        <table>
                            <tr>
                                <th>予約日</th>
                                <th>名前</th>
                            </tr>
                            <c:forEach var="reserve" items="${latestReservations}" varStatus="status">
                                <tr class="row${status.count % 2}">
                                    <td><fmt:formatDate value="${reserve.reserve_at}" pattern='MM-dd'/></td>
                                    <td><a href="<c:url value='/customers/show?id=${reserve.customer.id}' />"><c:out value='${reserve.customer.name}'  /></a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
                <div class="flexcontent">
                    <h4>今月誕生日のお客様</h4>
                    <c:if test="${latestCustomers != null}">
                        <table>
                            <tr>
                                <th>誕生日</th>
                                <th>名前</th>
                            </tr>
                            <c:forEach var="customer" items="${latestCustomers}" varStatus="status">
                                <tr class="row${status.count % 2}">
                                    <td><c:out value="${customer.birthMonth}/${customer.birthDay}" /></td>
                                    <td><a href="<c:url value='/customers/show?id=${customer.id}' />"><c:out value='${customer.name}'  /></a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
            </div>
    </c:param>
</c:import>