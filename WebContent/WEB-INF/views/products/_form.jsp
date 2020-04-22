<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <option value="施術" ${product.category == "施術" ? "selected" : ""}>施術</option>
                            <option value="栄養" ${product.category == "栄養" ? "selected" : ""}>栄養</option>
                            <option value="睡眠" ${product.category == "睡眠" ? "selected" : ""}>睡眠</option>
                            <option value="運動" ${product.category == "運動" ? "selected" : ""}>運動</option>
                        </select>※必ず入力してください
                </th>
            </tr>
            <tr>
                <th>
                    <label for="stock">在庫数</label>
                    <input type="text" name="stock" value="${product.stock}">
                </th>
            </tr>
            <tr>
                <th>
                    <label for="content">備考</label>
                    <input type="text" name="content" value="${product.content}" />
                </th>
            </tr>

    </tbody>
</table>
<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>