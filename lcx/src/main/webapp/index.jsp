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
    // $("#btnload").click(
    //         function (){
      $.ajax({
        url:"queryProvince",
        dataType:"json",
        success:function (resp){
          // alert(resp);
          $("#province").empty();
          $.each(resp,function (i,n){
            $("#province").append("<option value='"+n.id+"'>"+n.name+"</option>");
          })
        }
      })
    // }
    // )
    $("#province").change(function (){
      // alert("12313123")
      var obj=$("#province>option:checked");
      // alert(obj.val()+"======="+obj.text());
      var proviceId=obj.val();
      $.get("queryCity",{provinceId:proviceId},function (resp){
        // window.alert(resp);
        $("#city").empty();
        $.each(resp,function (i,n){
          // $("#province").empty();
          $("#city").append("<option value='"+n.id+"'>"+n.name+"</option>")
        })
      },"json");
    })
  })
</script>
<p>省市级联查询，使用ajax</p>
<div>
  <table>
    <tr>
      <td>省份名称</td>
      <td>
        <select id="province">
          <option value="0">请选择。。。。。</option>
        </select>
        <input type="button" value="加载数据" id="btnload">
      </td>

    </tr>
    <tr>
      <td>城市：</td>
      <td>
        <select id="city">
          <option value="0">请选择。。。</option>
        </select>
      </td>
    </tr>
  </table>
</div>
</body>
</html>