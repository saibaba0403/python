
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> <title>profile</title>
</head>

<SCRIPT type="text/javascript"> window.history.forward();

function noBack() { window.history.forward(); } </SCRIPT>
<body background="G:\Classroom1.jpg" bgcolor="red" >


<form action="main.jsp"  method="post" >

<table width="960" border="0" cellpadding="0" cellspacing="4" bgcolor="grey">
<tr>

<td>

<center><img src="D:\New folder\Web Page Header.gif" width="960"height="100" ></center>
</td>
</tr>

<tr>

<td align="left" style="word-spacing:6px;font-size:120%;padding-right:30px;color:#888888;white-space:nowrap;">

<a href="studlogin.jsp" title="student">Student login </a> | <a href="faclogin.jsp" title="faculty"> Faculty login </a> |


</td></tr>

</table>


<table>

<tr><td> <tr><td>Admin Login

<tr><td><input type="password" value="" name="pass" > <tr><td><input type="submit" value="Login" onclick="fu(this.form)"

>
</td></tr>
</table>

<%

String pass1=request.getParameter("pass"); try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

Connection c= DriverManager.getConnection("jdbc:odbc:akb", "root", "root");

Statement s= c.createStatement(); String sql="select pass from admin"; ResultSet rs= s.executeQuery(sql); rs.next();
if( pass1.equalsIgnoreCase(rs.getString(1)) )
{
%>

<jsp:forward page="admin.jsp"></jsp:forward>
 
<%

}

rs.close();

s.close();

c.close();

}

catch(Exception e) {}

%>

</form>

</body>

</html>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> <title>MAIN</title>
</head>

<SCRIPT type="text/javascript"> window.history.forward();

function noBack() { window.history.forward(); } </SCRIPT>


<body background="G:\Classroom1.jpg" bgcolor="red" > <SCRIPT type="text/javascript">
window.history.forward();

function noBack() { window.history.forward(); } </SCRIPT>
<form action="studlogin.jsp"  method="post" >

<marquee ONMOUSEOVER="this.stop();" ONMOUSEOUT="this.start();" scrollamount="20" bgcolor="white" >

<H3> Virtual Class room </H3> </MARQUEE>




<TABLE border=0 cellspacing=2 cellpadding=2 width="100%"> <TR>
<TD width="34%">

<TABLE border=0 cellspacing=2 cellpadding=2 width="100%"> <TR>
<TD>

<marquee bgcolor="red" style="position: relative;" behavior="scroll" " direction="up" scrollamount="8" scrolldelay="2" onmouseover="this.stop()" onmouseout="this.start()"width="350" height="200"><br>

<img src="D:\New folder\3d_virtual_classroom.jpg" width=250 height=250 title="ad " style="position: relative;" border="0"><br>

<img src="D:\New folder\education1.jpg" width=250 height=250 title="ad " style="position: relative;" border="0"><br>

<img src="D:\New folder\virtual.jpg" width=250 height=250 title="ad " style="position: relative;" border="0"><br>
 

<img src="D:\New folder\virtual_class_room.jpg" width=250 height=250 title="ad " style="position: relative;" border="0"><br>

</marquee>

</TD>

</TR>

</TABLE>

</TD>

<TD>

<table cellpadding=2 cellspacing=0 border=0>

<tr>	<td bgcolor="red"><table cellpadding=0 cellspacing=0 border=1
width=100%>	<tr>	<td bgcolor="green" align=center
style="padding:2;padding-bottom:4">   <b><font size=-1 color="white"
face="verdana,arial"> LOG IN</font></b></tr>
<tr><td bgcolor="white" style="padding:5"><br>
	<TABLE border=0 cellspacing=5 cellpadding=2 width="60%"
bgcolor="white">	
	<TR>	
	<TD>	
	<tr><td>	<font face="verdana,arial" size=-1>
Login_Type:</font></td>   <td><select name="type"><option
value="Student">Student</option></select></td></tr>
	<tr><td>	<font face="verdana,arial" size=-1>
Login:</font></td>	<td><input type="text" name="login"
value=""></td></tr>	
	<tr><td>	<font face="verdana,arial" size=-1>
Password:</font></td>	<td><input type="password"
name="password1"></td></tr>
	<tr><td>	<font face="verdana,arial" size=-
1>&nbsp;</font></td>	<td><font face="verdana,arial" size=-1><input
type="submit" value="Enter"></font></td></tr>
	<tr><td colspan=2><font face="verdana,arial" size=-
1>&nbsp;</font></td>	</tr>
	<tr><td colspan=2><font face="verdana,arial" size=-1>Lost your

username or password? Find it <a href="G:\study\seminar\ppt\ppt_for_05].ppt">here</a>!</font></td></tr>

<tr><td colspan=2><font face="verdana,arial" size=-1>Not member yet? Click <button style="width:160;height:24; background-color:#97cfc3" onclick= " location.href='signup.jsp'" >here</button> to register.</font></td></tr>


</TABLE>

</TD>

<TD>

</table>


</TD>

</TR>

</TABLE>
</TD>
</TR>
</TABLE>
 




<%
 

String str1=request.getParameter("login"); String str2=request.getParameter("password1"); if(str1!=null && str2!= null)

{

int flag=0;

try{

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

Connection c= DriverManager.getConnection("jdbc:odbc:akb", "root", "root");

Statement s= c.createStatement(); out.println("user="+str1+" and pass= "+str2);

String sql="select user from student where user='"+str1+"' and pass='"+str2+"'";

ResultSet rs= s.executeQuery(sql); if(rs.next())

flag=1;

else

flag=0;

if(flag==1)

{
session.setAttribute("user",str1);
%>

<jsp:forward page="profile.jsp" /> <%

}
else
out.println("UserName/Password Not Valid");
rs.close();

s.close();
c.close();
}catch(Exception e) {  out.println(e);}

}







%>

</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<SCRIPT type="text/javascript"> window.history.forward();

function noBack() { window.history.forward(); } </SCRIPT>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> <title>student</title>
</head>

<body background="G:\Classroom1.jpg" bgcolor="red" >
 

<form action="studentsignup.jsp"  method="post" >

<table width="960" border="0" cellpadding="0" cellspacing="4" bgcolor="black">
<tr>

<td>

<center><img src="D:\New folder\Web Page Header.gif" width="1150" height="100" ></center>

</td>

</tr>

<tr>

<td align="left" style="word-spacing:6px;font-size:120%;padding-right:30px;color:#888888;white-space:nowrap;">
<a href="student.jsp" title="student">Student </a>  |

<a href="studentsignup.jsp" title="studensignupt">Student req </a> | <a href="faculty.jsp" title="faculty"> Faculty </a> |

<a href="facultysignup.jsp" title="faculty signup requests">Faculty req

</a>	|		
<a href="pptup.jsp" title="faculty"> PPT(upload) </a>	|
<a href="pptdel.jsp" title="faculty"> PPT(del) </a>	|	
<a href="videoup.jsp" title="faculty"> Video(up) </a>	|
<a href="videodel.jsp" title="faculty"> Video(del) </a>	|
<a href="que1.jsp" title="faculty"> Question </a>	|	
<a href="ans1.jsp" title="faculty"> Ans </a>  |		
<td>	<a href="main.jsp" title="faculty"> Logout </a>	

</td></tr>
</table>
<br>
<br>

<b>User Name : </b><input type="text" value="" name="user"> &emsp; &emsp; <input type="submit" value="DELETE" >
<br>

<br>

<table width="960" border="0" cellpadding="0" cellspacing="4" border=2 background="G:\Classroom1.jpg">
<tr>
<td>

<%
try{

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

Connection c= DriverManager.getConnection("jdbc:odbc:akb", "root", "root");
Statement s= c.createStatement();

String sql="select * from studentsignup "; ResultSet rs= s.executeQuery(sql);
%>
<tr><td><b>USERNAME</b><td><b>PASSWORD</b><td><b>NAME</b><td><b>PHONE
NO</b><td><b>YEAR</b><td><b>BRANCH</b>

<%
while( rs.next() )
{
%>
<tr><td>
<%
out.println(rs.getString(1));
%>

<td>
 
<%

out.println(rs.getString(2));

%>

<td>

<%

out.println(rs.getString(3));

%>

<td>

<%

out.println(rs.getString(4));

%>

<td>

<%

out.println(rs.getString(5));

%>

<td>

<%

out.println(rs.getString(6));


}
rs.close();

String user=request.getParameter("user"); String sql1;
if(user!=null)
{

sql1="select * from studentsignup where user='"+user+"'
";

ResultSet rs1= s.executeQuery(sql1); rs1.next();

out.println("user : "+user); sql1="insert into student
values('"+rs1.getString(1)+"','"+rs1.getString(2)+"','"+rs1.getString(3)+
"','"+rs1.getString(4)+"','"+rs1.getString(5)+"','"+rs1.getString(6)+"'
)";
s.execute(sql1);

sql="delete from studentsignup where user='"+user+"'"; s.execute(sql);
rs1.close();

}


s.close();
c.close();
}catch(Exception e) {  out.println(e);}

%>
</td>
</tr>
</table>

</form>

</body>

</html>
 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> <title>profile</title>

</head>

<SCRIPT type="text/javascript"> window.history.forward();

function noBack() { window.history.forward(); } </SCRIPT>
<body background="G:\Classroom1.jpg" bgcolor="red" >

<form action="profile.jsp"  method="post" >

<table width="960" border="0" cellpadding="0" cellspacing="4" bgcolor="grey">
<tr>

<td>

<center><img src="D:\New folder\Web Page Header.gif" width="960"height="100" ></center>
</td>
</tr>

<tr>

<td align="left" style="word-spacing:6px;font-size:120%;padding-right:30px;color:#888888;white-space:nowrap;">
<a href="profile.jsp" title="Home">Home </a>  |

<a href="update.jsp" title="update"> Edit Profile </a> | <a href="study.jsp" title="study">Study material</a> | <a href="video.jsp" title="video">Video Lectures</a> | <a href="question.jsp" title="ask">Ask doubts</a> |

<a href="ans.jsp" title="tell">Answers</a>

</td>

<td align="right" style="word-spacing:6px;font-size:120%;padding-right:10px;color:#888888;white-space:nowrap;">

|<a href="main.jsp" title="tell">Logout</a> </td>

</tr>
</table>







<%

String user =(String)session.getAttribute("user");



try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

Connection c= DriverManager.getConnection("jdbc:odbc:akb", "root", "root");

Statement s= c.createStatement();
 
String sql="select * from student where user='"+user+"'";


ResultSet rs= s.executeQuery(sql); rs.next();


%>



<br>

<br>

<br>

<table border=0 cellspacing=2 cellpadding=2 width="100%">

<tr> <td bgcolor="red"><table cellpadding=0 cellspacing=0 border=1 width=100%> <tr> <td bgcolor="green" align=center style="padding:2;padding-bottom:4"> <font size=-1 color="white" face="verdana,arial"> <b>Profile</b></font></tr>

<TR>

<TD width="50%">

<TABLE cellspacing=2 cellpadding=2 width="100%"> <TR>
<td>

<center> <img src="G:\Classroom1.jpg" width=100 height=

100 > </center> </td> </TR>

<tr><td>Logged in as <input type="text" name="user" value="<% out.println(rs.getString(1)); %>"></td></tr>


</TABLE>

</TD>
<TD>

<TABLE border=0 cellspacing=2 cellpadding=2 width="100%"> <TR>
<TD>

<tr><td> <font face="verdana,arial" size=-1> Name: </font></td> <td> <input type="text" name="name" value="<% out.println(rs.getString(3)); %>"> </td> </tr>


	<tr><td>	<font face="verdana,arial" size=-1>	Branch:</font></td>
<td>	<input type="text" name="branch" value="<%	
out.println(rs.getString(6)); %>">	</td>	</tr>	
	<tr><td>	<font face="verdana,arial" size=-1>	Year.:</font></td>
<td>	<input type="text" name="year" value="<%	
out.println(rs.getString(5)); %>">	</td>	</tr>	
	<tr><td>	<font face="verdana,arial" size=-1>	Contact
No..:</font></td>  <td>   <input type="text" name="phno" value="<%
out.println(rs.getString(4)); %>">	</td>	</tr>	

</TABLE>
</TD>
<TD>
 
</TABLE>

</td>

</tr>

</table>

<%

String branch=rs.getString(6); String year=rs.getString(5);

session.setAttribute("branch",branch);

session.setAttribute("year",year); out.println("branch = "+branch+" and year = "+year); rs.close();

s.close();

c.close();

}

catch(Exception e) { out.println(e);  }








%>


</form>
</body>
</html>
