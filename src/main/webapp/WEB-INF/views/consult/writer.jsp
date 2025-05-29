<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header2.jsp" %>
<style>
.conA {
	height: 20vh;
    max-height: 40px;
}
.conB {
  padding: 30px 15px;
  background-color: #f9f9f9;
  min-height: 100vh;
}

.page-header {
  font-family: 'Montserrat', sans-serif;
  font-weight: 700;
  color: #2c3e50;
  margin-bottom: 30px;
}

.panel-default {
  width: 900px;
  max-width: 100%;
  margin: 40px auto;
  padding-top: 30px;
  padding-bottom: 30px;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0,0,0,0.1);
  border-color: #ddd;
  background-color: #fff;
}

.panel-heading {
  background-color: #3498db;
  color: white;
  font-size: 18px;
  font-weight: 600;
  border-radius: 8px 8px 0 0;
  padding: 12px 20px;
}

.panel-body {
  padding: 20px 25px;
}

.form-group label {
  font-weight: 600;
  color: #34495e;
  margin-bottom: 8px;
  display: block;
}

.form-control {
  height: 50px;
  padding: 10px 12px;
  font-size: 16px;
  border-radius: 5px;
  border: 1px solid #ccc;
  transition: border-color 0.3s ease;
}

textarea.form-control {
  height: 150px;
  padding: 12px 15px;
  resize: vertical;
}

.form-control:focus {
  border-color: #3498db;
  box-shadow: 0 0 8px rgba(52, 152, 219, 0.3);
}

.btn-default {
  background-color: #3498db;
  color: white;
  border: none;
  padding: 8px 18px;
  border-radius: 5px;
  font-weight: 600;
  margin-right: 10px;
  transition: background-color 0.3s ease;
  cursor: pointer;
}

.btn-default:hover, .btn-default:focus {
  background-color: #2980b9;
  color: white;
}

.conB > .row {
  padding-top: 40px;
  padding-bottom: 40px;
  max-width: 1000px;
  margin: 0 auto;
  width: 100%;
}
</style>
<section class="conA">
</section>
<section class="conB">
	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
	        <div class="panel panel-default">
	            <div class="panel-heading"> 문의하기 </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
			        <form role="form" action="${ctx}/consult/register" method="post">
			          <div class="form-group">
			            <label>제목</label> 
			            <input class="form-control" name='title'>
			          </div>
			
			          <div class="form-group">
			            <label>내용</label>
			            <textarea class="form-control" rows="3" name='content'></textarea>
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