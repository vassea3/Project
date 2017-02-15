<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<div id="contact-page" class="container">
    <div class="bg">
        <div class="row">    		
            <div class="col-sm-12">    			   			
                <h2 class="title text-center">Contact <strong>Us</strong></h2>    			    				    				
                <div id="gmap" class="contact-map" >
                    <iframe style="width: 100%; height: 100%;" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"  src="http://www.mapi.ie/create-google-map/map.php?width=100%&amp;height=600&amp;hl=en&amp;q=${contact.city}%20${contact.street.replace(" ","%20")}+()&amp;ie=UTF8&amp;t=&amp;z=14&amp;iwloc=A&amp;output=embed" ></iframe>
                </div>
            </div>			 		
        </div>    	
        <div class="row">  	
            <div class="col-sm-8">
                <div class="contact-form">
                    <h2 class="title text-center">Get In Touch</h2>
                    <div class="status alert alert-success" style="display: none"></div>
                     <c:if test="${param.success eq true}">
                    <div class="alert alert-success">Message was sent</div>
                </c:if>
                    <spring:form id="main-contact-form" class="contact-form row" action="send" commandName="messages" method="POST" >
                        <div class="form-group col-md-6">
                            <spring:input type="text" path="nume" class="form-control" required="required" placeholder="Name"/>
                        </div>
                        <div class="form-group col-md-6">
                            <spring:input type="email" path="email" class="form-control" required="required" placeholder="Email"/>
                        </div>
                        <div class="form-group col-md-12">
                            <spring:input type="text" path="subiect" class="form-control" required="required" placeholder="Subject"/>
                        </div>
                        <div class="form-group col-md-12">
                            <spring:textarea path="mesaj" id="message" required="required" class="form-control" rows="8" placeholder="Your Message Here"></spring:textarea>
                        </div>                        
                        <div class="form-group col-md-12">
                        <spring:button type="submit" class="btn btn-primary pull-right">Send</spring:button>
                        </div>
                    </spring:form>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="contact-info">
                    <h2 class="title text-center">Contact Info</h2>
                    <address>
                        <p>Termo MD</p>
                        <p>${contact.street}</p>
                        <p>${contact.city}</p>
                        <p>Mobile: ${contact.mobile}</p>  
                        <p>Email: ${contact.email}</p>
                    </address>
                    <div class="social-networks">
                        <h2 class="title text-center">Social Networking</h2>
                        <ul>
                            <li>
                                <a href="#"><i class="fa fa-facebook"></i></a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-google-plus"></i></a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-youtube"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>    			
        </div>  
    </div>	
</div><!--/#contact-page-->
