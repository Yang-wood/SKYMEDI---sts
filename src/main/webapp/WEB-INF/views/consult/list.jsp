<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header2.jsp" %>
<link href="${ctx}/resources/css/list_consult.css" rel="stylesheet">

<div class="board-container">
	<h1>내 상담내역</h1>
	
	<a href="${ctx }/consult/writer" class="write-btn blue">글쓰기</a>
	
	<table>
	    <thead>
	        <tr>
	            <th style="width: 10%;">번호</th>
	            <th style="width: 50%;">제목</th>
	            <th style="width: 15%;">작성자</th>
	            <th style="width: 15%;">작성일</th>
	            <th style="width: 10%;">답변상태</th>
	        </tr>
	    </thead>
	    	<c:set var="startNum" value="${total - ((cri.pageNum - 1) * cri.amount)}" />
	    <tbody>
	    	<c:forEach items="${list }" var="consult" varStatus="status">
	    		<tr>
	    			<td>${startNum - status.index}</td>
	    			<td><a class="move" href="${consult.cno }">${consult.title}</a></td>
	    			<td>
		    			<c:choose>
							<c:when test="${not empty sessionScope.login }">
								${sessionScope.login.username}
							</c:when>
							<c:when test="${not empty sessionScope.guestInfo}">
								${sessionScope.guestInfo.g_email}
							</c:when>
		    			</c:choose>
	    			</td>
	    			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${consult.reg_date}"/></td>
	    			<td>${consult.status}</td>
	    		</tr>
	    	</c:forEach>
	    </tbody>
	</table>
	
	<!-- 페이징 기능 -->
	<div class="pagination">
		<c:if test="${pageMaker.startPage > 1 }">
			<li class="paginate_button previous">
			    <a href="?pageNum=1&amount=${pageMaker.cri.amount}" aria-label="First">
			    	<span>&laquo;&laquo;</span>
			    </a>
			</li>
		</c:if>
		<c:if test="${pageMaker.prev }">
			<li class="paginate_button previous">
			    <a href="?pageNum=${pageMaker.startPage - 1}&amount=${pageMaker.cri.amount}" aria-label="Prev">
			    	<span>&laquo;</span>
			    </a>
			</li>
		</c:if>
		<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage }">
		    <li class="${pageMaker.cri.pageNum == num ? 'active' : ''}">
			    <a href="?pageNum=${num}&amount=${pageMaker.cri.amount}">${num }</a>
		    </li>
		</c:forEach>
	   	<c:if test="${pageMaker.next }">
	   		<li class="paginate_button next">
			    <a href="?pageNum=${pageMaker.endPage + 1}&amount=${pageMaker.cri.amount}" aria-label="Next">
			    	<span>&raquo;</span>
			    </a>
	   		</li>
		</c:if>
		<c:if test="${pageMaker.realEnd > pageMaker.endPage}">
			<li class="paginate_button next">
			    <a href="?pageNum=${pageMaker.realEnd}&amount=${pageMaker.cri.amount}" aria-label="End">
			    	<span>&raquo;&raquo;</span>
			    </a>
			</li>
		</c:if>
	</div>
	
	
	<div class="search-box">
	    <input type="text" placeholder="검색어를 입력하세요">
	    <button type="submit" class="blue">검색</button>
	</div>
</div>

<%@ include file="../includes/footer2.jsp"  %>