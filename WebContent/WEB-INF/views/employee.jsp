<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Employee Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Employee
</h1>

<c:url var="addAction" value="/employee/add" ></c:url>

<form:form action="${addAction}" commandName="employee">
<table>
	<c:if test="${!empty employee.emp_name}">
	<tr>
		<td>
			<form:label path="emp_id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="emp_id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="emp_id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="emp_name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="emp_name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="emp_email">
				<spring:message text="Email"/>
			</form:label>
		</td>
		<td>
			<form:input path="emp_email" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="emp_pos">
				<spring:message text="Position"/>
			</form:label>
		</td>
		<td>
			<form:input path="emp_pos" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="emp_phone">
				<spring:message text="Phone"/>
			</form:label>
		</td>
		<td>
			<form:input path="emp_phone" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="emp_salary">
				<spring:message text="Salary"/>
			</form:label>
		</td>
		<td>
			<form:input path="emp_salary" />
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty employee.emp_name}">
				<input type="submit"
					value="<spring:message text="Edit Employee"/>" />
			</c:if>
			<c:if test="${empty employee.emp_name}">
				<input type="submit"
					value="<spring:message text="Add Employee"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Employees List</h3>
<c:if test="${!empty listEmployees}">
	<table class="tg">
	<tr>
		<th width="80">Employee ID</th>
		<th width="120">Employee Name</th>
		<th width="120">Employee Email</th>
		<th width="120">Employee Position</th>
		<th width="120">Employee Phone</th>
		<th width="120">Employee Salary</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listEmployees}" var="employee">
		<tr>
			<td>${employee.emp_id}</td>
			<td>${employee.emp_name}</td>
			<td>${employee.emp_email}</td>
			<td>${employee.emp_pos}</td>
			<td>${employee.emp_phone}</td>
			<td>${employee.emp_salary}</td>
			<td><a href="<c:url value='employee/edit/${employee.emp_id}' />" >Edit</a></td>
			<td><a href="<c:url value='employee/remove/${employee.emp_id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>