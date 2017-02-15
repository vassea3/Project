<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <div class="signup-form"><!--sign up form-->
                <h2>Edit Contact Page</h2>
                <div>
                    <c:if test="${param.success eq true}">
                    <div class="alert alert-success">Contacts was edited!</div>
                </c:if>
                    <spring:form  action="updateContact"  commandName="contactPage" method="POST">
                        <spring:input type="hidden" path="id"   />
                        <spring:input type="text" path="city"  placeholder="City"/>
                        <spring:input type="text" path="street"  placeholder="Street"/>
                        <spring:input type="text" path="mobile"  placeholder="Mobile"/>
                        <spring:input type="email" path="email"  placeholder="Email"/>
                        <spring:button type="submit" class="btn btn-default">Update</spring:button>
                    </spring:form>

                </div><!--/sign up form-->
            </div>
        </div>
    </div>

