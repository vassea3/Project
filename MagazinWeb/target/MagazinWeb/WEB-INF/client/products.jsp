<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section>
    <div class="container">
        <div class="row">


            <div class="col-sm-9 padding-right">

                <div class="features_items"><!--features_items-->
                    <h2 class="title text-center">${titleProducts} ${allProduct}</h2>
                    <c:forEach items="${prodList}" var="p"> 
                        <div class="col-sm-4">

                            <div class="product-image-wrapper">
                                <div class="single-products">
                                    <div class="productinfo text-center">

                                        <img style="width: 100%; height: 40%" src="<c:url value='/resources/images/home/${p.value.get(0)}'/>" alt="" />

                                        <h2>${p.key.pret}</h2>
                                        <p>${p.key.modelul}</p>
                                        <a href="/addToCart/${p.key.modelul}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                    </div>
                                    <div class="product-overlay">
                                        <div class="overlay-content">
                                            <h2>${p.key.pret}</h2>
                                            <p>${p.key.compania}</p>
                                            <a href="/addToCart/${p.key.modelul}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="choose">
                                    <ul class="nav nav-pills nav-justified">
                                        <li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
                                        <li><a href="products/${p.key.modelul}/productDetails"><i class="fa fa-plus-square"></i>View details</a></li>
                                    </ul>
                                </div>
                            </div>

                        </div>
                    </c:forEach>

                </div><!--features_items-->



            </div>
        </div>
    </div>
</section>