<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<section>
		<div class="container">
			<div class="row">
                            
                            
				<div class="col-sm-9">
					<div class="blog-post-area">
						<h2 class="title text-center">Messages</h2>
						
					</div><!--/blog-post-area-->
					<div class="response-area">
						
						<ul class="media-list">
                                                    <c:forEach items="${messages}" var="m">
							<li class="media">
							
								<div class="media-body">
									<ul class="sinlge-post-meta">
										<li><i class="fa fa-user"></i>${m.nume}</li>
										<li><i class="fa fa-clock-o"></i>${m.ora}</li>
										<li><i class="fa fa-calendar"></i>${m.data}</li>
									</ul>
                                                                                <p style="text-align: left">${m.email}</p>
									<p>${m.mesaj}</p>
									
                                                                        <a class="btn btn-primary" href="delete/${m.id}"><i class="fa fa-reply"></i>Delete message</a>
								</div>
							</li>
                                                    </c:forEach>
							
						</ul>					
					</div><!--/Response-area-->
				</div>	
			</div>
		</div>
	</section>
	