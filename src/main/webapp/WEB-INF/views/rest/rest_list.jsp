<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Insert title here</title>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   <script type="text/javascript">
   		$(document).ready(function (){
   			$(".a-delete").click( function(event){
   				//preventDefault()는 href로 연결해 주지 않고 단순히 click에 대한 처리는 하도록 해준다.
   				event.preventDefault();
   				console.log("ajax 호출전...");
   				
   				var trObj = $(this).parent().parent();
   				
   				console.log($(this).attr("href"));
   				
   				$.ajax({
   					type : "DELETE",
   					url : $(this).attr("href"),
   					success : function(result) {
   						console.log(result);
   						if(result == "SUCCESS") {
   							$(trObj).remove();
   						}
   					},
   					error : function() {
   						console.log(e);
   					}
   				});
   			});
   		});
   </script>
</head>
<body>
   <table width="80%" cellpadding="0" cellspacing="0" border="1">
      <tr>
         <td>번호</td>
         <td>이름</td>
         <td>제목</td>
         <td>날짜</td>
         <td>히트</td>
      </tr>
      <c:forEach var="board" items="${list}" >
         <tr>
            <td>${board.bid}</td>
            <td>${board.bname}</td>
            <td>
               <c:forEach begin="1" end="${board.bindent}">-</c:forEach>
               <a href="content_view?bid=${board.bid}">${board.btitle}</a></td>
            <td>${board.bdate}</td>
            <td>${board.bhit}</td>
            <td>
            	<a class="a-delete" data-bid='${board.bid}' href="${pageContext.request.contextPath}/rest/board/${board.bid}">삭제</a>
            </td>
         </tr>
      </c:forEach>
      <tr>
         <td colspan="5"> <a href="write_view">글작성</a> </td>
      </tr>
   </table>

</body>
</html>
</body>
</html>