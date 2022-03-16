<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <script src="js/jquery-3.6.0.js"></script>
</head>
<body>
<script>
    $(function (){
      $("#bianhao").click(function (){
        var proid=$("#proid").val();
        $.ajax({
          url:"/queryInfo/queryProvince",
          data:{
            "proid":proid
          },
          dataType:"json",
          success:function (data){
            window.alert(data);
          }
        })
      })
    })

  // function search(){
  //   var xhr=new XMLHttpRequest();
  //   xhr.onreadystatechange=function (){
  //     if(xhr.readyState==4&&xhr.status==200){
  //       var date=xhr.responseText;
  //       window.alert(date);
  //       // document.getElementById("proname").value=date;
  //       var json=eval("("+date+")");
  //       // var json = eval("("+date+")");
  //       document.getElementById("proname").value=json.name;
  //       document.getElementById("jiancheng").value=json.jiancheng;
  //       document.getElementById("shenghui").value=json.shenghui;
  //
  //     }
  //   }
  //   var id=document.getElementById("proid").value;
  //   var str="?id="+id;
  //   xhr.open("get","queryProvince"+str,true);
  //   xhr.send();
  // }
</script>
<center>
  <table>
    <tr>
      <td>省份编号</td>
      <td>
        <input type="text" name="id" id="proid">
        <input type="button" value="搜素" id="bianhao">
      </td>
    </tr>
    <tr>
      <td>省份名称</td>
      <td><input type="text" id="proname"></td>
    </tr>
    <tr>
      <td>省份简称</td>
      <td><input type="text" id="jiancheng"></td>
    </tr>
    <tr>
      <td>省   会</td>
      <td><input type="text" id="shenghui"></td>
    </tr>


  </table>
</center>
</body>
</html>