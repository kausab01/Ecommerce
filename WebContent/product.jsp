<%@ page import="java.util.*,com.ecommerce.dao.ProductDAO,com.ecommerce.model.Product" %>

<%
List<Product> products = ProductDAO.getAllProducts();
%>

<!DOCTYPE html>
<html>
<head>
<title>Products</title>
<style>
body { font-family: Arial; }
.card {
    border:1px solid #ddd;
    padding:15px;
    margin:15px;
    width:220px;
    float:left;
    text-align:center;
}
button {
    background:green;
    color:white;
    padding:8px 15px;
    border:none;
}
</style>
</head>

<body>

<h2> Available Products</h2>

<% for(Product p : products){ %>

<div class="card">
    <h3><%= p.getName() %></h3>
    <p><%= p.getDescription() %></p>
    <h4>₹ <%= p.getPrice() %></h4>

    <form action="AddToCartServlet" method="post">
        <input type="hidden" name="productId" value="<%= p.getId() %>">
        <button type="submit">Add to Cart</button>
    </form>
</div>

<% } %>
<a href="viewCart">View Cart</a>
</body>
</html>