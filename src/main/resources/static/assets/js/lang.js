

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

    $(document).ready(function() {
        $.ajax({
            url: 'http://localhost:8085/api/books/allbooks',

        type: 'GET',
        dataType: 'json',
        success: function(result) {

                let index;
                let arr = [];
                let index_counter = 0;

                for (let q = 0; q < 2; q++){
                jQuery.each(result, function (key, value) {
                        var index = index_counter++;
                        var result = parseInt(value.tags[q]);
                        arr[index] = result;
                });}

                arr.sort();

                let grouped = arr.reduce((r, v, i, a) => {
                    if (v === a[i - 1]) {
                        r[r.length - 1].push(v);
                    } else {
                        r.push(v === a[i + 1] ? [v] : v);
                    }
                    return r;
                }, []);

                grouped.sort(function (a, b) {
                    return b.length - a.length;
                });

                 const n = 12
                 const resulty = new Array(Math.ceil(grouped.length / n))
                    .fill()
                    .map(_ => grouped.splice(0, n))

                console.log(resulty);

                resulty.forEach(function (value, i) {
                    if (i === 0) {
                        for (j of value) {
                            $("#" + j[0]).attr("class", "Tag Tag_lg");
                        }
                    }
                    if (i === 1) {
                        for (j of value) {
                            $("#" + j[0]).attr("class", "Tag Tag_md");
                        }
                    }
                    if (i === 2) {
                        for (j of value) {
                            $("#" + j[0]).attr("class", "Tag Tag_sm");
                        }
                    }
                    if (i === 3) {
                        for (j of value) {
                            $("#" + j[0]).attr("class", "Tag Tag_xs");
                        }
                    }
                    if (i === 4) {
                        for (j of value) {
                            $("#" + j[0]).attr("class", "Tag Tag_xs");
                        }
                    }
            });
        }})
    });