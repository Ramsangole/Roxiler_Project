<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Store Listings</title>
</head>
<body>
<h2>Stores</h2>
    <form method="get" action="storeList.jsp">
        <input type="text" name="name" placeholder="Store Name" />
        <input type="text" name="address" placeholder="Address" />
        <input type="submit" value="Search" />
    </form>

    <%
        String name = request.getParameter("name") != null ? request.getParameter("name") : "";
        String address = request.getParameter("address") != null ? request.getParameter("address") : "";

        StoreOperations storeOps = new StoreOperations();
        List<Store> storeList = storeOps.searchStores(name, address);
    %>

    <table border="1">
        <tr>
            <th>Store Name</th>
            <th>Address</th>
            <th>Rating</th>
        </tr>
        <%
            for (Store store : storeList) {
        %>
        <tr>
            <td><%= store.getStoreName() %></td>
            <td><%= store.getAddress() %></td>
            <td><%= store.getRating() %></td>
        </tr>
        <%
            }
        %>
    </table>

</body>
</html>