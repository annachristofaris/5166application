<%-- 
    Document   : myItems
    Created on : Feb 25, 2019, 7:47:47 PM
    Author     : annachristofaris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
 <jsp:include page ="./header.jsp" />

<body>
 <jsp:include page ="./user-navigation.jsp" />
 
 <jsp:include page ="./site-navigation.jsp" />

        <!-- bootstrap for  main content area -->
        <div class="col-9 mainArea">
            <div class="row justify-content-center">
                <h1>Anna's Corner</h1>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Saved Content</th>
                            <th scope="col">Category</th>
                            <th scope="col">Rating</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <th scope="row">5 Foolproof Decor Tips</th>
                            <td>Tips & Tricks</td>
                            <td><i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i></td>
                                <!-- update (wrench icon) and delete (trash icon) -->
                                <td><a href="./item.html"><i class="fas fa-wrench"></i></a>
                                <a href="./myItems.html"><i class="far fa-trash-alt"></i></a></td>
                        </tr>

                        <tr>
                            <th scope="row">How-to: Restore Wood Furniture</th>
                            <td>How-to Guides</td>
                            <td> <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i></td>
                            <!-- update (wrench icon) and delete (trash icon) -->
                            <td><a href="./item.html"><i class="fas fa-wrench"></i></a>
                                <a href="./myItems.html"><i class="far fa-trash-alt"></i></a></td>
                        </tr>
                    </tbody>
                </table>

            </div>
            <h2>You have not yet shared any content. <a href="#">Click here to upload and share!</a></h2>
        </div>
    </div>

       <jsp:include page ="footer.jsp" />
</body>