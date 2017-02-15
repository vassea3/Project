<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-sm-3">
    <div class="left-sidebar">
        <h2>Category</h2>
        <div class="panel-group category-products" id="accordian"><!--category-productsr-->
            <c:forEach items="${category}" var="cat"> 
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordian" href="#${cat.key.replace(" ", "1")}">
                                <span class="badge pull-right"><i class="fa fa-plus"></i></span></a>
                            <a href="products/${cat.key}"> ${cat.key}</a>

                        </h4>
                    </div>
                    <div id="${cat.key.replace(" ", "1")}" class="panel-collapse collapse">
                        <div class="panel-body">

                            <c:forEach items="${cat.value}" var="sub">

                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordian1" href="#${sub.key.replace(" ", "1")}">
                                            <span class="badge pull-right"><i class="fa fa-plus"></i></span> </a>
                                        <a href="products/${sub.key}">${sub.key} </a>

                                    </h4>
                                </div>
                                <div id="${sub.key.replace(" ", "1")}" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul>
                                            <c:forEach items="${sub.value}" var="tip">
                                                <li><a href="products/${tip}">${tip} </a></li>
                                                </c:forEach>
                                        </ul>
                                    </div>
                                </div>

                            </c:forEach>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div><!--/category-products-->

        <div class="brands_products"><!--brands_products-->
            <h2>Brands</h2>
            <div class="brands-name">
                <ul class="nav nav-pills nav-stacked">
                    <c:forEach items="${company}" var="com">
                        <li><a href="products/${com}"> ${com}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div><!--/brands_products-->
    </div>
</div>