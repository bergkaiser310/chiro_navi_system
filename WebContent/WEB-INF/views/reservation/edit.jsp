<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${reservation != null}">
                <h2>予約　編集ページ</h2>
                <form method="POST" action="<c:url value='/reservation/update' />">
                    <c:import url="_form.jsp" />
                </form>
                 <form method="POST" action="<c:url value='/resrvation/destroy' />">
                    <button type="button" onclick="confirmDestroy();">削除</button>
                 </form>
                 <script>
                 function confirmDestroy(){
                     if(confirm("本当に削除してよろしいでしょうか？")){
                          document.forms[1].submit();
                     }
                 }
                 </script>
            </c:when>
            <c:otherwise>
                <h2>お探しのページは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
        <a href="<c:url value='/reservation/index' />">予約一覧へ戻る</a>
    </c:param>
</c:import>