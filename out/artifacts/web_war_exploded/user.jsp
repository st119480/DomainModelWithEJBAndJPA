<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>User lookup</title>
</head>
<body>
<h2>User lookup</h2>

<jsp:useBean id="user" scope="request"
             class="com.bazaar.domain.User" />

<table>
    <tr>
        <th align="left">ID:</th>
        <td><jsp:getProperty name="user" property="userId" /></td>
    </tr>
    <tr>
        <th align="left">First name:</th>
        <td><jsp:getProperty name="user" property="firstName" /></td>
    </tr>
    <tr>
        <th align="left">Last name:</th>
        <td><jsp:getProperty name="user" property="lastName" /></td>
    </tr>
    <tr>
        <th align="left">Username:</th>
        <td><jsp:getProperty name="user" property="username" /></td>
    </tr>
    <tr>
        <th align="left">Password:</th>
        <td><jsp:getProperty name="user" property="password" /></td>
    </tr>
</table>

</body>
</html>