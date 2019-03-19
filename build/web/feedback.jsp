<%-- 
    Document   : item
    Created on : Feb 25, 2019, 7:47:11 PM
    Author     : annachristofaris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <jsp:include page ="./header.jsp" />

    <body>
        <jsp:include page ="./user-navigation.jsp" />

        <jsp:include page ="./site-navigation.jsp" />

        <!-- bootstrap for  main content area -->
        <div class="col-10 mainArea">
            <h1>${detailItem.title}</h1>              
            <h2>Submit your rating: </h2>

            <form action="CatalogController?action=rating&value=${detailItem.itemCode}" method="post">

                <select name="newRating">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>


                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1" name ="favorite">
                    <label class="custom-control-label" for="customCheck1">Favorite this page?</label>
                </div>

                <input type="submit" />
                <input type="hidden" name="value" value ="${detailItem.itemCode}">
                <input type='hidden' name="action" value ="rating">


            </form>

            <div class="row justify-content-left">
                <div class="col-10">
                    <img src=${detailItem.imageURL} alt="itemDetail">
                    <ul>
                        <li>${detailItem.desc}</li>

                    </ul>
                </div>
            </div>

        </div>

        <jsp:include page ="footer.jsp" />
    </body>