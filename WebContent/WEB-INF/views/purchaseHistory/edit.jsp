<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${history != null}">
                <h2>購入履歴　編集ページ</h2>
                <form method="POST" action="<c:url value='/purachasehistory/update' />">
                <c:if test="${eroors != null}">
                    <div id="flush_error">
                        入力内容にエラーがあります。<br />
                        <c:forEach var="error" items="${errors}">
                            <c:out value="${error}" /><br />
                        </c:forEach>
                    </div>
                </c:if>
                <table>
                    <tbody>
                        <tr>
                            <th>
                                <label for="customer_name">購入者</label>
                                <c:out value="${history.customer.name}" />
                            </th>
                        </tr>
                        <tr>
                            <th>
                                <label for="sold_at">購入日</label>
                                <input type="date" name="sold_at" value="<fmt:formatDate value='${history.sold_at}' pattern='yyyy-MM-dd' />">
                            </th>
                        </tr>
                        <tr>
                            <th>
                                <label for="product">商品名
                                    <select name="product">
                                        <c:forEach var="product" items="${products}">
                                            <option value="${product.id}">
                                                <c:out value="${product.name}" />
                                            </option>
                                        </c:forEach>
                                    </select>
                                </label>
                            </th>
                        </tr>
                        <tr>
                            <th>
                                <label for="content">備考</label>
                                <input type="text" name="content" value="${history.content}">
                            </th>
                        </tr>
                    </tbody>
                </table>

                <input type="hidden" name="_token" value="${_token}" />
                <button type="submit">登録</button>

                </form>
                <form method="POST" action="<c:url value='/purchasehistory/destory' />">
                    <input type="hidden" name="_token" value="${_token}" />
                    <button type="submit">削除</button>
                </form>
            </c:when>
            <c:otherwise>
                <h2>お探しのページは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
        <a href="<c:url value='/customers/show?id=${history.customer.id}' /> ">顧客情報画面に戻る</a>
    </c:param>
</c:import>