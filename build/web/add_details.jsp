<%@include file="header_admin.jsp" %>
<%@include file="flash.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>JSP Page</title>
    </head>
    <style>
               
                  body {
    background-image: url("img/add.png");
    background-repeat: no-repeat;
    background-size:  1367px 800px;
}

  #headpro_info_pro{
                  position:fixed;
                left: 40%; 
                 padding-top: -80px;
                font-family: "Lucida Calligraphy";
                color:white;
                font-size: 200%;
            }
           #pos1_info_pro{
                 position:fixed;
                 left : 30%;
                 margin: 65px;
                 padding-top: -30px;
            }
            
             #use11{
                width: 300px;
                height:32px;
                background: white; 
                color: black; 
                outline: none;
                font-size: 12px;
                padding: 5px;

            }
            
                #sub_pro{
                background-color: black;
                color: white;
                border-radius: 4px;
                width:400px;
                height:32px;
                position: fixed;
              
                right:36%;
                font-size: 20px;
            }
</style>

 
    <body>
         <h1 id="headpro_info_pro">Add Details </h1>
         <div id="pos1_info_pro" align="left">
        
      <form action="adddetails"  method="post" name="f1">
      
               <select name="cat"  id="use">
                        <option>Select Option</option>
                        <option value="principle">Add Principle</option>
                        <option value="HOD">Add HOD</option>
                        <option value="teacher">Add Teacher</option>
                       
                        
                    </select><br><br>
                    
                     <select name="dep"  id="use">
                        <option>Select Department</option>
                        <option value="all">All</option>
                        <option value="Computer Technology">Computer Technology</option>
                        <option value="Computer Engineering">Computer Engineering</option>
                        <option value="Electronics & Telecommunication">Electronics & Telecommunication</option>
                        <option value="Electrical Engineering">Electrical Engineering</option>
                       
                        
                    </select><br><br>
             
            <input type="text" name="fullname" placeholder="Full Name" id="use" ><br><br>
            <input type="text" name="mob" placeholder="Mobile Number" id="use" ><br><br>
              <input type="text" name="email" placeholder="Email ID" id="use" ><br><br>
            <input type="text" name="add" placeholder="Address" id="use" ><br><br>
            
              <select name="gender"  id="use_gender">
                        <option>Gender</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
               
                    </select>
            
                    <input type="text" name="cl" placeholder="Casual Leave" id="use_le" >
                    <input type="text" name="sl" placeholder="Sick Leave" id="use_le" > 
                    <input type="text" name="el" placeholder="Earn Leave" id="use_le" > <br><br>
                    Birthday : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="month"  id="use1_combo">
                        <option>Month</option>
                        <option value="January">January</option>
                        <option value="February">February</option>
                        <option value="March">March</option>
                        <option value="April">April</option>
                        <option value="May">May</option>
                        <option value="June">June</option>
                         <option value="July">July</option>
                        <option value="August">August</option>
                        <option value="September">September</option>
                        <option value="October">October</option>
                        <option value="November">November</option>
                        <option value="December">December</option>
                        
                    </select>
            
            <input type="text" name="day" placeholder="Day" id="use1_combo" >
            <input type="text" name="year" placeholder="Year" id="use1_combo" ><br><br>
              
             Joining Date : <select name="j_month"  id="use1_combo">
                        <option>Month</option>
                        <option value="January">January</option>
                        <option value="February">February</option>
                        <option value="March">March</option>
                        <option value="April">April</option>
                        <option value="May">May</option>
                        <option value="June">June</option>
                         <option value="July">July</option>
                        <option value="August">August</option>
                        <option value="September">September</option>
                        <option value="October">October</option>
                        <option value="November">November</option>
                        <option value="December">December</option>
                        
                    </select>
            <input type="text" name="j_day" placeholder=date" id="use1_combo" >
            <input type="text" name="j_year" placeholder="Year" id="use1_combo" ><br><br>
                        
            <input type="submit" value="Submit" id="sub_pro"/>
          </form><br><br><br>
             
             
         </div>
         
  
    </body>
</html>
<%@include file="footer.jsp" %>