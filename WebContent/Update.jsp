<%@page import="com.student.record.controller.StudentManager"%>
<%@page import="com.student.record.model.Student"%>
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

<s:form action="adddone" method="post">
     <s:textfield name="student.roll"  value="%{studentit.roll}" label="Roll"/>
	<s:textfield name="student.name"  value="%{studentit.name}" label="Name" />
	<s:textfield name="student.batch" value="%{studentit.batch}" label="Batch"/>
	<s:textfield name="student.contact_no" value="%{studentit.contact_no}" label="Contact"/>
	<s:submit value="Update Contact" align="center"/>
</s:form>

</body>
</html>