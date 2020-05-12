<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <c:choose>
            <c:when test="${customer != null}">
                <h2>顧客情報　詳細ページ</h2>
                <div class="flex">
                    <div class="flexcontent">
                        <h3>顧客情報</h3>
                        <table id="customer_show">
                            <tbody>
                                <tr>
                                    <th>氏名</th>
                                    <td><c:out value="${customer.name}" /></td>
                                </tr>
                                <tr>
                                    <th>郵便番号・住所</th>
                                    <td><c:out value="${customer.postalCode}" /><br />
                                        <c:out value="${customer.adress}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>電話番号</th>
                                    <td><c:out value="${customer.tel}" /></td>
                                </tr>
                                <tr>
                                    <th>メールアドレス</th>
                                    <td><c:out value="${customer.mail}" /></td>
                                </tr>
                                <tr>
                                    <th>生年月日</th>
                                    <td><c:out value="${customer.birthYear}" />年<c:out value="${customer.birthMonth}" />月<c:out value="${customer.birthDay}" />日</td>
                                </tr>
                                <tr>
                                    <th>家族構成</th>
                                    <td><c:out value="${customer.family}" /></td>
                                </tr>
                                <tr>
                                    <th>持病</th>
                                    <td><c:out value="${customer.illness}" /></td>
                                </tr>
                                <tr>
                                    <th>受診の目的</th>
                                    <td><c:out value="${customer.purpose}" /></td>
                                </tr>
                                <tr>
                                    <th>紹介者</th>
                                    <td><c:out value="${customer.introduce}" /></td>
                                </tr>
                                <tr>
                                    <th>備考</th>
                                    <td><c:out value="${customer.content}" /></td>
                                </tr>
                                <tr>
                                    <th>登録日時</th>
                                    <td>
                                        <fmt:formatDate value="${customer.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>更新日時</th>
                                    <td>
                                        <fmt:formatDate value="${customer.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <a href="<c:url value='/customers/edit?id=${customer.id}' />">この顧客情報を編集する</a>
                        <form method="POST" action="<c:url value='/customers/destroy' />">
                            <button type="button" onclick="confirmDestroy();">削除</button>
                        </form>
                    </div>
                    <div class="flexcontent">
                        <h3>購入履歴</h3>
                        <table id="show">
                            <tbody>
                                <tr>
                                    <th>購入日</th>
                                    <th>商品名</th>
                                    <th>カテゴリー</th>
                                    <th>操作</th>
                                </tr>
                                <c:forEach var="myHistory" items="${myHistory}">
                                    <tr>
                                        <td><c:out value="${myHistory.sold_at}" /></td>
                                        <td><c:out value="${myHistory.product.name}" /></td>
                                        <td><c:out value="${myHistory.product.category}" /></td>
                                        <td><button type="button" onclick="location.href='<c:url value="/purchasehistory/edit?id=${myHistory.id}" />'">編集</button></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <p><a href="<c:url value='/purchasehistory/new?id=${customer.id}' /> ">購入情報の登録</a></p>
                        <h3>予約</h3>
                        <table id="show">
                            <tbody>
                                <tr>
                                    <th>予約日</th>
                                </tr>
                                <c:forEach var="myReservation" items="${myReservation}">
                                    <tr>
                                        <td><c:out value="${myReservation.reserve_at}" /></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <p><a href="<c:url value='/reservation/new?id=${customer.id}' /> ">予約の登録</a></p>
                    </div>
               </div>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
        <p><a href="<c:url value='/customers/index' />">一覧に戻る</a></p>
    </c:param>
</c:import>