<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <c:out value="${customer.name}" />
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
                <input type="text" name="content">
            </th>
        </tr>
    </tbody>
</table>

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>
