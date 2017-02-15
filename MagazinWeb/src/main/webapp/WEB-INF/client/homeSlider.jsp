<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="slider"><!--slider-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
							<li data-target="#slider-carousel" data-slide-to="1"></li>
							<li data-target="#slider-carousel" data-slide-to="2"></li>
						</ol>
						
						<div class="carousel-inner">
                                                    
                                                    
							<div class="item active">
								<div class="col-sm-6">
									<h1>TERMO<span>MD</span></h1>
									<h2>${homeSlide1.titlul}</h2>
									<p>${homeSlide1.descrierea}</p>
									
								</div>
								<div class="col-sm-6">
                                                                    <img style="width: 60%; height: 50%;" src="<c:url value='/resources/images/home/${homeSlide1.imgName}'/>" class="girl img-responsive" alt="" />
                                                                    <h1  class="pricing" ><span>${homeSlide1.reducerea}</span></h1>
								</div>
							</div>
                                                                    
                                                                    
							<div class="item">
								<div class="col-sm-6">
									<h1>TERMO<span>MD</span></h1>
									<h2>${homeSlide2.titlul}</h2>
									<p>${homeSlide2.descrierea}</p>
									
								</div>
								<div class="col-sm-6">
                                                                    <img style="width: 60%; height: 50%;" src="<c:url value='/resources/images/home/${homeSlide2.imgName}'/>" class="girl img-responsive" alt="" />
                                                                    <h1  class="pricing" ><span>${homeSlide2.reducerea}</span></h1>
								</div>
							</div>
							
							<div class="item">
								<div class="col-sm-6">
									<h1>TERMO<span>MD</span></h1>
									<h2>${homeSlide3.titlul}</h2>
									<p>${homeSlide3.descrierea}</p>
									
								</div>
								<div class="col-sm-6">
                                                                    <img style="width: 60%; height: 50%;" src="<c:url value='/resources/images/home/${homeSlide3.imgName}'/>" class="girl img-responsive" alt="" />
                                                                    <h1  class="pricing" ><span>${homeSlide3.reducerea}</span></h1>
								</div>
							</div>
							
						</div>
						
						<a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
							<i class="fa fa-angle-left"></i>
						</a>
						<a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
							<i class="fa fa-angle-right"></i>
						</a>
					</div>
					
				</div>
			</div>
		</div>
	</section><!--/slider-->