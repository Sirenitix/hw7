
    $(document).ready(function (){
    $("#locales").change(function(){
        var selectedOption = $("#locales").val();
        if (selectedOption == "ru") {
            window.location.replace('?lang=' +selectedOption);
        }else  if (selectedOption == "en"){
            window.location.replace('?lang=' +selectedOption);
    }
    })
})

    $(document).ready ( function(){
        var str = window.location + " ";
        if(str.includes("?lang=ru")){
            errmessage = "ru";
        }else {
            errmessage = "en";
        }
    });
