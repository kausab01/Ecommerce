<%@ page import="java.util.*,com.ecommerce.model.Cart" %>

<%
List<Cart> cartList = (List<Cart>) request.getAttribute("cartList");
double total = 0;
%>

<h2>Your Cart 🛒</h2>

<table border="1" cellpadding="10">
<tr>
    <th>Product</th>
    <th>Price</th>
    <th>Qty</th>
    <th>Subtotal</th>
</tr>

<% for(Cart c : cartList){
    double sub = c.getPrice() * c.getQuantity();
    total += sub;
%>

<tr>
    <td><%= c.getProductName() %></td>
    <td>₹ <%= c.getPrice() %></td>
    <td><%= c.getQuantity() %></td>
    <td>₹ <%= sub %></td>
</tr>

<% } %>

<tr>
    <td colspan="3"><b>Total</b></td>
    <td><b>₹ <%= total %></b></td>
</tr>

</table>