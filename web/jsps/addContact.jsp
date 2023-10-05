<%-- 
    Document   : addClient
    Created on : 25 nov. 2021, 20:07:02
    Author     : Christian Novoa
--%>

<%@page import="ec.espe.edu.contacts.controller.ContactController"%>
<%@page import="ec.espe.edu.contacts.model.Contact"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adding Contact</title>
        <link href="../css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <center><br><h1>Contact Addeded</h1></center>
        <%
            Contact contact;
            contact = new Contact(request.getParameter("id"), request.getParameter("name"), request.getParameter("phoneNumber"), request.getParameter("description"));
        %>
        <main class="no-center">
            <div class="content">
                <div class="row2"><% out.println("<span class=\"blue\">ID: </span>  " + contact.getId()); %></div>
                <div class="row2"><% out.println("<span class=\"blue\">Name: </span>  " + contact.getName()); %></div>
                <div class="row2"><% out.println("<span class=\"blue\">Phone Number: </span>  " + contact.getPhoneNumber()); %></div>
                <div class="row2"><% out.println("<span class=\"blue\">Description: </span>  " + contact.getDescription());%></div>

                <%
                    ContactController contactController = new ContactController();
                    boolean result = contactController.addClient(contact);
                    if(!result){
                        out.println("<div class=\"row2\"><span class=\"red\">Fail saving in MongoDB database</span></div>");
                    } else{
                        out.println("<div class=\"row2\"><span class=\"green\">Succesfully saved in MongoDB database</span></div>");
                    }
                %>
            </div>
        </main>
        <a href="javascript:history.go(-1);" class="return">Return</a>
        <footer class="footer">Christian Novoa</footer>
    </body>
</html>
