$(document).ready(function() {
    $.ajax({
        url: 'http://localhost:8085/api/books/by-tag',
        type: 'GET',
        dataType: 'json',
        success: function(data) {

            let arr = [];
            const set = new Set();
            let setElements = 0;
            let avg = 0;

            jQuery.each(data, function (key, value) {
                arr[value.id - 1] = parseInt(value.tagId);

            });

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

            const n = 1
            const results = new Array(Math.ceil(grouped.length / n))
                .fill()
                .map(_ => grouped.splice(0, n))

            results.forEach(function (value) {
                if(value[0].length !== undefined){
                    set.add(value[0].length)
                }
            });

            set.forEach(function (value) {
                setElements += value;
            });

            avg = setElements / set.size;



            results.forEach(function (value) {

                if( value[0].length === undefined ){
                    $("#" + (value[0])).attr("class", "Tag Tag_xs");
                    console.log(value);
                }

                if( value[0].length < (avg / 2) && value[0].length !== undefined ){
                    $("#" + (value[0][0])).attr("class", "Tag Tag_xs");
                }

                if( avg / 2 < value[0].length < avg && value[0].length !== undefined ){
                    $("#" + (value[0][0])).attr("class", "Tag Tag_sm");
                }

                if ( avg < value[0].length < (avg * 1.5) && value[0].length !== undefined ){
                    $("#" + (value[0][0])).attr("class", "Tag Tag_md");
                }

                if ( (avg * 1.5) < value[0].length && value[0].length !== undefined ){
                    $("#" + (value[0][0])).attr("class", "Tag Tag_lg");
                }

            });

        }})
    });