<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <div class="signup-form"><!--sign up form-->
                <h2>Edit Home Slideshow</h2>
                 <c:if test="${param.success eq true}">
                    <div class="alert alert-success">Slide was edited!</div>
                </c:if>
                <div>
                    
                    <form  action="updateSlide"  method="POST" enctype="multipart/form-data">
                        <input type="hidden" name="id"  value="${homeSlide.id}" />
                        <input type="text" name="titlul" value="${homeSlide.titlul}" placeholder="Title"/>
                        <input type="text" name="descrierea" value="${homeSlide.descrierea}" placeholder="Description"/>
                        <input type="text" name="reducerea" value="${homeSlide.reducerea}" placeholder="Discount"/>
                        <input type="file" name="file"  placeholder="Select image"/>
                        <input type="submit" class="btn btn-default" value=Update" />
                    </form>

                </div><!--/sign up form-->
            </div>
        </div>
    </div>

