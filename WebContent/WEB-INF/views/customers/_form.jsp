<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <label for="name">氏名</label><br />
                    <input type="text" name="name" value="${customer.name}" />
                 </th>
            </tr>
            <tr>
                <th>
                    <label for="postalCode">郵便番号</label><br />
                    <input type="text" name="postalCode" value="${customer.postalCode}" /><br />
                     <label for="adress">住所</label><br />
                    <input type="text" name="adress" value="${customer.adress}" />
                    <br />
                </th>
            </tr>
            <tr>
                <th>
                    <label for="tel">電話番号</label><br />
                    <input type="text" name="tel" value="${customer.tel}" />
                </th>
             </tr>
             <tr>
                <th>
                    <label for="mail">メールアドレス</label><br />
                    <input type="text" name="mail" value="${customer.mail}" />
                </th>
             <tr>
                <th>
                    <label for="birthYear">生年月日<br />
                        <select name="birthYear">
                                <c:forEach var="i" begin="1930" end="2020" step="1" >
                                    <option value="${i}"><c:out value="${i}" /></option>
                                </c:forEach>
                        </select>／
                    </label>
                    <label for="birthMonth">
                            <select name="birthMonth">
                                <c:forEach var="j" begin="1" end="12" step="1">
                                    <option value="${j}"><c:out value="${j}" /></option>
                                </c:forEach>
                            </select>／
                    </label>
                    <label for="birthDay">
                        <select name="birthDay">
                            <c:forEach var="k" begin="1" end="31" step="1" >
                                <option value="${k}"><c:out value="${k}" /></option>
                            </c:forEach>
                        </select>
                    </label>
                </th>
            </tr>
            <tr>
                <th>
                    <label for="family">家族構成</label>
                        <select name="family">
                            <option value="単身">単身</option>
                            <option value="本人＋配偶者">本人＋配偶者</option>
                            <option value="本人+親・子等">本人+親・子等</option>
                            <option value="本人＋配偶者＋親・子等">本人＋配偶者＋親・子等</option>
                        </select>
                </th>
            </tr>
            <tr>
                <th>
                    <label for="illness">持病</label>
                    <input type="text" name="illness" value="${customer.illness}" />
                </th>
            </tr>
            <tr>
                <th>
                    <label for="purpose">受診の目的</label>
                    <input type="text" name="purpose" value="${customer.purpose}" />
                </th>
            </tr>
            <tr>
                <th>
                    <label for="introduce">紹介者</label>
                    <input type="text" name="introduce" value="${customer.introduce}" />
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
