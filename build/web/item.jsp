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
            <a href="ProfileController?action=save&itemCode=<c:out value="${detailItem.itemCode}"/>">
                <i class="fas fa-plus-circle"> Save to Your Corner</i></a>

            <a href="ProfileController?action=feedback&itemCode=<c:out value="${detailItem.itemCode}"/>">
                <i class="fas fa-star starfill"> Feedback</i></a>


            <div class="row justify-content-left">
                <div class="col-10">
                    <img src=${detailItem.imageURL} alt="itemDetail">
                    <ul>
                        <li>${detailItem.desc}</li>
                    </ul>
                </div>
            </div>
            <a href="./categories.jsp"><i class="far fa-arrow-alt-circle-left"> Go Back</i></a>
        </div>

        <jsp:include page ="footer.jsp" />
    </body>
    <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
    
    <script>
    
        $('.fa-star.one').click(function() {
          $('.fa-star').removeClass('starfill');
          $('.fa-star.one').addClass('starfill');
          // POST VALUE TO DATABASE
    //      $.post( "url", {
    //        name: "Donald Duck",
    //        city: "Duckburg"
    //      }, 
    //    function(data) {
    //        $( ".result" ).html( data );
    //      });
        });
        
        $('.fa-star.two').click(function() {
          $('.fa-star').removeClass('starfill');
          $('.fa-star.one, .fa-star.two').addClass('starfill');
        });
        
        $('.fa-star.three').click(function() {
          $('.fa-star').removeClass('starfill');
          $('.fa-star.one, .fa-star.two, .fa-star.three').addClass('starfill');
        });
        
        $('.fa-star.four').click(function() {
          $('.fa-star').removeClass('starfill');
          $('.fa-star.one, .fa-star.two, .fa-star.three, .fa-star.four').addClass('starfill');
        });
       
        </script>-->