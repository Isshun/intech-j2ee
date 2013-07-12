<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <h2>Welcome to <strong>IFPWAFCAD</strong>, the International Former
        Professional Wrestlers' Association for Counseling and Development!
    </h2>

    <table border="0">
        <thead>
            <tr>
                <th>IFPWAFCAD offers expert counseling in a wide range of fields.</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>To view the contact details of an IFPWAFCAD certified former
                    professional wrestler in your area, select a subject below:</td>
            </tr>
            <tr>
                <td>
                    <form action="Response">
					    <strong>Select a subject:</strong>
					    <select name="subject_id">
					        <c:forEach var="row" items="${subjects}">
					                <option value="${row.key}">${row.value}</option>
					        </c:forEach>
					    </select>
					    <input type="submit" />
					</form>
                </td>
            </tr>
        </tbody>
    </table>
	<form action="Report">
	    <strong>Force reporting:</strong>
	    <input type="submit" />
	</form>
</body>
</html>