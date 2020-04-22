<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/layout/app.jsp">
    <c:param name="content">
        <h2>商品新規登録ページ</h2>
        <form method="POST" action="<c:url value='/products/create' />">
            <c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>
    </div>
</c:if>
<table>
    <tbody>
            <tr>
                 <th>
                    <label for="name">商品名</label><br />
                    <input type="text" name="name" value="${product.name}" />※必ず入力してください
                 </th>
            </tr>
            <tr>
                <th>
                     <label for="modelCode">型番</label><br />
                    <input type="text" name="modelCode" value="${product.modelCode}" />
                    <br />
                </th>
            </tr>
            <tr>
                <th>
                    <label for="category">カテゴリー</label>
                        <select name="category">
                            <option value="施術">施術</option>
                            <option value="栄養">栄養</option>
                            <option value="睡眠">睡眠</option>
                            <option value="運動">運動</option>
                        </select>※必ず入力してください
                </th>
            </tr>
            <tr>
                <th>
                    <label for="stock">在庫数</label>
                    <input type="text" name="stock" value="0">※在庫がない場合は「０」を入力してください
                </th>
            </tr>
            <tr>
                <th>
                    <label for="content">備考</label>
                    <input type="text" name="content" value="${customer.content}" />
                </th>
            </tr>

    </tbody>
</table>
<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>
        </form>
        <p><a href="<c:url value='/products/index' />">商品一覧ページへ</a></p>

    </c:param>
</c:import>