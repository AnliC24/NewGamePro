<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="slider">
	<ul class="rslides" id="slider">
		<li><img src="images/banner10.jpg" class="img-responsive" alt="" /></li>
		<li><img src="images/banner11.jpg" class="img-responsive" alt="" /></li>
		<li><img src="images/banner12.jpg" class="img-responsive" alt="" /></li>
	</ul>
</div>
<!-- Banner-Slider-JavaScript -->
<script src="js/responsiveslides.min.js"></script>
<script>
	$(function() {
		$("#slider").responsiveSlides({
			auto : true,
			nav : true,
			speed : 1000,
			namespace : "callbacks",
			pager : true,
		});
	});
</script>