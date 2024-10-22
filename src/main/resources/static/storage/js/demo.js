function postdata(params,service,action) {
    $.ajax({
        type:"post",
        url:service,
        contentType:"application/json;charset=utf-8",
        dataType:"json",
        data:JSON.stringify(params),
        success:function(result){
            if(result.msg=="success"){
                action(result.data);
            }else{
                alert("操作失败！");
            }
        }
    });
}