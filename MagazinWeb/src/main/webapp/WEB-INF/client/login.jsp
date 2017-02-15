<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>

<div class="container">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-1">
            <div class="login-form"><!--login form-->
                <h2>Login to your account</h2>
                <spring:form action="login.do" method="POST" commandName="users">
                    <spring:input type="text" path="username" placeholder="Username"/>
                    <spring:input type="password" path="password" placeholder="Password"/>
                    <span>
                        <%--<spring:input type="checkbox" path="signedIn" class="checkbox"/>--%> 
                        Keep me signed in
                    </span>
                    <spring:button type="submit" class="btn btn-default">Login</spring:button>
                </spring:form>
            </div><!--/login form-->
        </div>
        <div class="col-sm-1">
            <h2 class="or">OR</h2>
        </div>
        <div class="col-sm-4">
            <div class="signup-form"><!--sign up form-->
                <h2>New User Signup!</h2>
                <c:if test="${param.success eq true}">
                    <div class="alert alert-success">Registration successfull!</div>
                </c:if>
                <spring:form action="register.do" method="POST" commandName="users">
                    <spring:input type="text" path="firstName" placeholder="First Name"/>
                    <spring:input type="text" path="lastName" placeholder="Last Name"/>
                    <spring:input type="email" path="email" placeholder="Email Address"/>
                    <spring:input type="phone" path="phone" placeholder="Phone"/>
                    <spring:input type="text" path="username" placeholder="Username"/>
                    <spring:input type="password" path="password" placeholder="Password"/>
                    <spring:button type="submit" class="btn btn-default">Signup</spring:button>
                </spring:form>
            </div><!--/sign up form-->
        </div>
    </div>
</div>