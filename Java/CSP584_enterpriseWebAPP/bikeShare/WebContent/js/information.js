$(document).ready(function(){
    var oldPswflag=0;
    var newPswflag=0;
    $("#name").val($("#nameVal").text());
    $("#email").val($("#emailVal").text());
    $("#telephone").val($("#telephoneVal").text());
    $("#changeInfo").click(function(){
        $("#update-info").modal({
            backdrop:'static'
        });
    });


    $("#saveInfo").click(function (){
        var saveInfo={};
        saveInfo.name=$("#name").val();
        saveInfo.email=$("#email").val();
        
        saveInfo.telephone=$("#telephone").val();
        
        saveInfo.flag=$("#flag").val();
        
        $.ajax({
            type: "POST",
            url: "UserManageServlet",
            contentType:"application/x-www-form-urlencoded; charset=utf-8",
            data:saveInfo,
            dateType:"json",
            
            success: function(result){
                if (result.msg=="更新失败")
                {
                    swal("Update failed", "", "error");
                }
                else {
                    $("#update-info").modal('hide');
                    swal("Update Success", "", "success");
                    $("button").click(function (){
                        location.reload();
                    });
                }
            },
            error:function (){
                alert("Update failed");
            }
        });
    });

    $("#changePsw").click(function (){
        $("#update-Psw").modal({
            backdrop:'static'
        });
    });

    $("#oldPsw").blur(function (){
        if ($("#oldPsw").val()!=$("#Psw").attr("Psw"))
        {
            $("#oldPswError").show();
        }
        else
        {
            $("#oldPswError").hide();
            oldPswflag=1;
        }
    })

   /* $("#newPsw").focus(function (){
        if ($("#oldPsw").val()==$("#Psw").attr("Psw"))
        {
            $("#oldPswError").hide();
            oldPswflag=1;
        }
    });*/

    $("#newPsw").blur(function (){
        if($("#newPsw").val().length<6)
        {
            $("#newPswError").show();
        }
        else {
            $("#newPswError").hide();
            newPswflag=1;
        }
    });

    $("#savePsw").click(function (){
        if (oldPswflag==1&&newPswflag==1)
        {
            var Psw={};
            Psw.Psw=$("#newPsw").val();
            Psw.flag=$("#flag_savePsw").val();
            
            $.ajax({
                type: "POST",
                url: "UserManageServlet",
                contentType:"application/x-www-form-urlencoded; charset=utf-8",
                data:Psw,
                dateType:"json",
                success: function(result){
                    if (result.msg=="更新失败")
                    {
                        swal("Update failed", "", "error");
                    }
                    else {
                        $("#update-info").modal('hide');
                        swal("Update Success", "", "success");
                        $("button").click(function (){
                            location.reload();
                        });
                    }
                },
                error:function (){
                    alert("Update failed");
                }
            });
        }
    })

});
