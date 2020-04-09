<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${customer != null}">
                <h2>顧客情報　詳細ページ</h2>

                <table>
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

                <p><a href="<c:url value='/customers/edit?id=${customer.id}' />">この顧客情報を編集する</a></p>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/customers/index' />">一覧に戻る</a></p>
    </c:param>
</c:import>