<%-- 
    Document   : user-navigation
    Created on : Feb 25, 2019, 8:14:31 PM
    Author     : annachristofaris
--%> <header>

        <div class="row justify-content-between topnav">
            <div class="col-4">
                <img src="./Logo.png" class="logo" alt="logo">
            </div>

            <div class="col-4">
                <ul>
                    <li><a href="ProfileController?action=signout">Sign Out</a></li>
                    <!-- link to the "my items" page -->
                    <li><a href="ProfileController?action=viewMyCorner">My Corner</a></li>
                    <li><a href="#" class="disabled">Cart</a></li>
                </ul>
                <p class="username">Hello, [placeholder name]</p>
            </div>
        </div>

    </header>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

