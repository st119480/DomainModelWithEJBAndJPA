<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Hello world EJB</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/sayHello">
  <input type="text" name="name" /><input type="submit" value="Press me!" />
</form>

<form action="${pageContext.request.contextPath}/createUser"
      method="get">
  <table border="0">
    <tr>
      <td align="right"><font color="black" size="4">First
        name</font></td>
      <td align="left"><input type="text" name="firstName"></td>
    </tr>
    <tr>
      <td align="right"><font color="black" size="4">Last
        name</font></td>
      <td align="left"><input type="text" name="lastName"></td>
    </tr>
    <tr>
      <td align="right"><font color="black" size="4">Username</font></td>
      <td align="left"><input type="text" name="username"></td>
    </tr>
    <tr>
      <td align="right"><font color="black" size="4">Password</font></td>
      <td align="left"><input type="password" name="password"></td>
    </tr>
    <tr>
      <td align="right"><input type="submit" value="Create user"></td>
      <td></td>
    </tr>
  </table>
</form>

<form action="${pageContext.request.contextPath}/showUser"
      method="get">
  <input type="text" name="id" /> <input type="submit"
                                         value="Show user" />
</form>
</body>
</html>