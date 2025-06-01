<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header2.jsp" %>
<link href="${ctx}/resources/css/writer_consult.css" rel="stylesheet">

<script src="${ctx}/resources/js/writer_consult.js"></script>
<section class="conA">
</section>
<section class="conB">
	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
	        <div class="panel panel-default">
	        	<a href="${ctx }/consult/list" class="write-btn">내 상담</a>
	            <div class="panel-heading"> 문의하기 </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
			        <form role="form" action="${ctx}/consult/register" method="post">
			          <div class="form-group">
			            <label>제목</label> 
			            <input class="form-control" id="title" name='title'>
			          </div>
			
			          <div class="form-group">
			            <label>내용</label>
			            <textarea class="form-control" id="content" rows="3" name='content'></textarea>
			          </div>
			          <button type="submit" class="btn btn-default">등록</button>
			          <button type="reset" class="btn btn-default">지우기</button>
			        </form>
	            </div>
	            <!-- /.panel-body -->
	        </div>
	        <!-- /.panel -->
	    </div>
	    <!-- /.col-lg-6 -->
	</div>
	<!-- /.row -->
</section>

<%@ include file="../includes/footer2.jsp"  %>