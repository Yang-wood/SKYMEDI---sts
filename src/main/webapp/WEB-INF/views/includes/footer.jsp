<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<footer>
        <div class="contain">
            <div class="footA">
                <div class="footB">
                    <ul>
                        <li><a href="#">병원소개</a></li>
                        <li><a href="#" class="line">오시는길</a></li>
                        <li><a href="#">공지사항</a></li>
                    </ul>
                </div>
                <p>광주광역시 서구 농성동</p>
                <div class="corp">ⓒ하늘병원 corp. All rights reserved.</div>
                <nav class="footD">
				 	<ul>
				 		<li>
				 			<a href="#">
				 				<span class="fa fa-twitter"></span>
				 				<span class="sr-only">Twitter</span>
				 			</a>
				 		</li>
				 		<li>
				 			<a href="#">
				 				<span class="fa fa-facebook"></span>
				 				<span class="sr-only">Facebook</span>
				 			</a>
				 		</li>
				 		<li>
				 			<a href="#">
				 				<span class="fa fa-google-plus"></span>
				 				<span class="sr-only">Google Plus</span>
				 			</a>
				 		</li>
				 		<li>
				 			<a href="#">
				 				<span class="fa fa-instagram"></span>
				 				<span class="sr-only">Instagram</span>
				 			</a>
				 		</li>
				 		<li>
				 			<a href="#">
				 				<span class="fa fa-youtube"></span>
				 				<span class="sr-only">YouTube</span>
				 			</a>
				 		</li>
				 	</ul>
			 	</nav>
            </div>
            <div class="footC">
                <h2><a href="${ctx}">하늘병원</a></h2>
            </div>

        </div>
    </footer>
    <!-- jQuery -->
    <!-- <script src="/resources/vendor/jquery/jquery.min.js"></script> -->

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
	    $(document).ready(function() {
	        $('#dataTables-example').DataTable({
	            responsive: true
	        });
	        $(".sidebar-nav")
	        .attr("class","sidebar-nav navbar-collapse collapse")
	        .attr("aria-expanded","false")
	        .attr("style","height:1px");
	    });
    </script>
    <script src="<c:url value='/resources/js/main.js'/>"></script>
</body>
</html>