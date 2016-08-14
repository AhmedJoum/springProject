<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Employee Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<h1>Add a Employee</h1>

	<c:url var="addAction" value="/department/add"></c:url>

	<form:form action="${addAction}" commandName="department">
		<table>
			<c:if test="${!empty department.dep_name}">
				<tr>
					<td><form:label path="dep_id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="dep_id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="dep_id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="dep_name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="dep_name" /></td>
			</tr>

			<tr>
				<td colspan="2"><c:if test="${!empty department.dep_name}">
						<input type="submit"
							value="<spring:message text="Edit Department"/>" />
					</c:if> <c:if test="${empty department.dep_name}">
						<input type="submit"
							value="<spring:message text="Add Departmrent"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<c:if test="${!empty department.dep_name}">
		<h3>Employees List</h3>
		<c:if test="${!empty department.depEmployees}">
			<table class="tg">
				<tr>
					<th width="80">Employee ID</th>
					<th width="120">Employee Name</th>
					<th width="120">Employee Email</th>
					<th width="120">Employee Position</th>
					<th width="120">Employee Phone</th>
					<th width="120">Employee Salary</th>
					<th width="120">Employee Dep.</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				<c:forEach items="${department.depEmployees}" var="employee">
					<tr>
						<td>${employee.emp_id}</td>
						<td>${employee.emp_name}</td>
						<td>${employee.emp_email}</td>
						<td>${employee.emp_pos}</td>
						<td>${employee.emp_phone}</td>
						<td>${employee.emp_salary}</td>
						<td>${employee.dep.dep_name}</td>
						<td><a
							href="<c:url value='employee/edit/${employee.emp_id}' />">Edit</a></td>
						<td><a
							href="<c:url value='employee/remove/${employee.emp_id}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</c:if>
	<br>
	<c:if test="${!empty listDepartments}">
		<table class="tg">
			<tr>
				<th width="80">Department ID</th>
				<th width="120">Department Name</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listDepartments}" var="department">
				<tr>
					<td>${department.dep_id}</td>
					<td>${department.dep_name}</td>
					<td><a
						href="<c:url value='department/edit/${department.dep_id}' />">Edit</a></td>
					<td><a
						href="<c:url value='department/remove/${department.dep_id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>