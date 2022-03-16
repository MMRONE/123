<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
    <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous">
    </script>
</head>
<body>
<script>

  $(function (){
    $("#bianhao").click(function (){
      var proid=$("#proid").val();
      window.alert(proid);
      $.ajax({
        url:"queryProvince",
        data:{
          "proid":proid
        },
        dataType:"json",
        success:function (data){
          // window.alert(data);
            $("#proname").val(data.name);
            $("#jiancheng").val(data.jiancheng);
            $("#shenghui").val(data.shenghui);
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
<%--        <input type="button" value="搜素" onclick="search()">--%>
        <input type="button" value="搜素" id="bianhao" >
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