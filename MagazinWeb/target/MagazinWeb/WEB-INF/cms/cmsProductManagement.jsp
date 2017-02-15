<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <script type='text/javascript'>
            function addFields() {
                // Number of inputs to create
               
                    // Container <div> where dynamic content will be placed
                    var container = document.getElementById("container");
                    // Clear previous contents of the container


                    // Create an <input> element, set its type and name attributes
                    var input = document.createElement("input");
                    input.type = "file";
                    input.name = "imgFiles";
                    input.class = "btn btn-default";
                    container.appendChild(input);
//                    var input1 = document.createElement("img");
//                    
//                    input1.value="close";
//                    input1.onclick =container.disabled;
//                    container.appendChild(input1);
                    //container.appendChild(document.createElement("br"));

                
            }
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <div class="signup-form"><!--sign up form-->
                        <h2>Add New Product</h2>
                        <%--<spring:select  path="categoria">--%>
                        <%--<spring:option  path="categoria"></spring:option>--%>
                        <%--</spring:select>--%>
                        <%--<spring:select  path="subcategoria">--%>
                        <%--<spring:option  path="categoria"></spring:option>--%>
                        <%--</spring:select>--%>
                        <%--<spring:select  path="tipul">--%>
                        <%--<spring:option  path="categoria"></spring:option>--%>
                        <%--</spring:select>--%>
                        <div>
                            <form name="saveProduct" action="saveProduct" method="POST" enctype="multipart/form-data">
                                <input type="hidden" name="productId"  value="${id}" />
                                <!--<input type="hidden" name="images"  value="${product.images}" />-->
                                <input type="text" name="categoria" value="${product.categoria}" placeholder="Categoria"/>
                                <input type="text" name="subcategoria" value="${product.subcategoria}" placeholder="Subcategoria"/>
                                <input type="text" name="tipul" value="${product.tipul}" placeholder="Tipul"/>
                                <input type="text" name="compania" value="${product.compania}" placeholder="Compania"/>
                                <input type="text" name="modelul" value="${product.modelul}" placeholder="Modelul"/>
                                <input type="text" name="cod" value="${product.cod}"placeholder="Codul"/>
                                <input type="text" name="pret" value="${product.pret}" placeholder="pretul"/>
                                <textarea name="descrierea" id="message" required="required" class="form-control" rows="8" placeholder="Descrierea">${product.descrierea}</textarea>

                                
                                    <c:forEach items="${imgList}" var="img">
                                        <div style="float: left; margin-left: 5px">
                                        <a href="#">Update</a><br/>
                                        <img style="width: 50px; height: 50px; border: 1px solid grey" src="<c:url value='/resources/images/home/${img}'/>"/><br/>
                                        <a href="${product.modelul}/${img}">Delete</a>
                                    </div>
                                    </c:forEach>
                                <div id="container">  </div>
                                <input type="file"  name="imgFiles" class="btn btn-default" />
                                <a  style="cursor: pointer; " onclick="addFields()"  title="Fill Details">Add New File</a>
                                
                                <input type="submit" class="btn btn-default" value="Save"/>
                            </form>

                        </div><!--/sign up form-->
                    </div>
                </div>
            </div>
    </body>
</html>
