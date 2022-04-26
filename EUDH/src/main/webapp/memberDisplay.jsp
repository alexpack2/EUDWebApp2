<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.eudh.Member"%>
<%@page import="com.eudh.Work"%>
<%@page import="com.eudh.Home"%>

<html>
<head>
<meta charset="UTF-8">
<title>Display</title>
</head>
<body>
<% boolean details = (boolean)session.getAttribute("details");%>
<% ArrayList<Member> members =(ArrayList<Member>)session.getAttribute("members"); %>
<% ArrayList<Home> homeL =(ArrayList<Home>)session.getAttribute("homeL"); %>
<% ArrayList<Work> workL =(ArrayList<Work>)session.getAttribute("workL"); %>
<% if (!details){ %>
<ul>
  <%
  for(int i=0;i<members.size();i++){ 
  %>
  <li><p><a target ="_blank" href="Display?idDetails=<%=members.get(i).getId()%>"><%= members.get(i).getName() + "  " +members.get(i).getSurname() %></a>
     <span class="text-orientation-right-css">   <a class="btn btn-danger" href="Display?idToDelete=<%=members.get(i).getId()%>">delete</a></span></p></li>
  <% } %>
</ul>
<% } %>
<div class="container">
<table border="1"
<%
if(!details){
%>
 hidden
 <%} %>>
<tr>
<th>Name</th>
<th>Surname</th>
<th>Gender</th>
<th>Birthdate</th>
<th>Work Address</th>
<th>Home Address</th>
</tr>
<%
members =(ArrayList<Member>)session.getAttribute("members");
for(int i=0;i<members.size();i++){ 
	if(details && members.get(i).getId()==(int)session.getAttribute("idDetails")){
		if(workL.get(i).getWorkAddress()==null)
		{
			workL.get(i).setWorkAddress("");
		}
		if(homeL.get(i).getHomeAddress()==null)
		{
			homeL.get(i).setHomeAddress("");
		}
%>
<tr>
<td><%= members.get(i).getName() %></a></td>
<td><%= members.get(i).getSurname() %></td>
<td><%= members.get(i).getGender() %></td>
<td><%= members.get(i).getBirthdate() %></td>
<td><%= workL.get(i).getWorkAddress() %></td>
<td><%= homeL.get(i).getHomeAddress() %></td>
</tr>	
<% }} %>
</table>
</div>
</body>
</html>