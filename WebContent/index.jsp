<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<style>
		body, input{
			font-family: Calibri, Arial;
		}
		table#contact {
			border-collapse: collapse;
			width:550px;
		}
		th {
			height: 40px;
			background-color: #ffee55;
		}
	</style>
	<title>Student Manager - Struts2 Hibernate Example</title>
</head>
<body>
<h1>Student Manager</h1>

<s:actionerror/>
<s:form  method="post" action="add">
 <s:textfield name="student.roll"  value="%{studentit.roll}" label="Roll"/>
	<s:textfield name="student.name" value="%{studentit.name}"  label="Name"/>
	<s:textfield name="student.batch" value="%{studentit.batch}"  label="Batch"/>
	<s:textfield name="student.contact_no" value="%{studentit.conact_no}" label="Contact"/>
	
	<s:submit value="Add Student" align="center"/>
	<s:submit value="Search Student" action="search" align="center"/>
</s:form>
<a href="view">View Student List</a>

<h2>Students</h2>
<table id="student" border="1">
<tr>
    <th>Roll</th>
	<th>Name</th>
	<th>Batch</th>
	<th>Contact</th>
	<th>Delete</th>
	<th>Edit</th>
</tr>
<s:iterator value="studentList" var="student">
	<tr>
	    <td><s:property value="roll"/></td>
		<td><s:property value="name"/></td>
		<td><s:property value="batch"/></td>
		<td><s:property value="Contact_No"/></td>
		
		<td><a href="delete?roll=<s:property value="roll"/>">delete</a></td>
		<td><a href="update?roll=<s:property value="roll"/>">edit</a></td>
	</tr>	
</s:iterator>
</table>
</body>
</html>