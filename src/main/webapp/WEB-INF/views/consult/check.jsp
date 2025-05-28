<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/header.jsp" %>
	<h1>선택해주세요</h1>
	<label><a href="${ctx}/member/login">회원</a></label>
	<label><a href="${ctx}/guest/login">비회원</a></label>
<%@ include file="../includes/footer.jsp"  %>