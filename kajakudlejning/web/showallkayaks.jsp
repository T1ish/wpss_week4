<%-- 
    Document   : showallkayaks
    Created on : Nov 29, 2016, 10:59:03 PM
    Author     : Z
--%>

<%@page import="control.User"%>
<%@page import="java.util.List"%>
<%@page import="control.Kayak"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book A Kayak</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <nav>
                Du er <%= session.getAttribute("username") %>
                <br>
                <a href="#" >Log ud</a>
            </nav>
        </header>
        
        <section>
            <h1>Available Kayaks:</h1>
            
            <table>

                    <tr> 
                        <th>Name</th> <th>Model</th> <th>Description</th> <th>Year</th> <th>Colour</th> <th>Length</th> <th>Date</th> <th>Book Now</th>  
                    </tr>


                    <% List<Kayak> kayaks = (List<Kayak>) session.getAttribute("kayaks"); %>
                    <% User user = (User)session.getAttribute("user"); %>

                    <% for(Kayak kayak : kayaks){
                        out.println("<tr>"
                                + "<td>" + kayak.getName() 
                                + "</td><td>" + kayak.getModel()
                                + "</td><td>" + kayak.getDescription()
                                + "</td><td>" + kayak.getYear()
                                + "</td><td>" + kayak.getColor()
                                + "</td><td>" + kayak.getLength()
                                + "</td><td>" 
                                    + "<form action='BookKayaks' method='POST' id=form" + kayak.getId() + "> </form>"
                                    + "<input type='date' form =form" + kayak.getId() + " name='date' min='2016-12-31'>"  
                                    + "</td><td>" 
                                    + "<input type = 'hidden' form =form" + kayak.getId() + " name = 'kayakId' value =" + kayak.getId() +"  / >"
                                    + "<input type='submit' form =form" + kayak.getId() + " value='Book kayak' />"
                                + "</td>" 
                                + "</tr>" );
                    }
            %>

            </table>
        </section>
    </body>
</html>
