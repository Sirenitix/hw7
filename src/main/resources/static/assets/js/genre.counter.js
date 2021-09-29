$(document).ready(function() {
    $.ajax({
        url: 'http://localhost:8085/api/books/allbooks',

        type: 'GET',
        dataType: 'json',
        success: function(data) {

            let index;
            let arr = [];
            let parentChilds = 0;
            let midParent = 0;
            let defaultIndex = 201;
            let parentIndex = 201;
            let index_counter = 0;
            const map = new Map();


            jQuery.each(data, function (key, value) {
                const index = index_counter++;
                arr[index] = parseInt(value.genre);
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


            // console.log(grouped);

            grouped.forEach(function (value, i){
                $("#" + grouped[i][0]).html($("#" + grouped[i][0]).text() + "("+grouped[i].length+")");
                map.set(grouped[i][0], grouped[i].length)
            });

            var mapAsc = new Map([...map.entries()].sort());



            $.ajax({
                url: 'http://localhost:8085/api/books/parent-genres',

                type: 'GET',
                dataType: 'json',
                success: function(parent) {

                    for (let i = 1; i < 6; i ++) {

                        jQuery.each(parent, function (keyP, valueP) {
                            for (const [keyM, valueM] of mapAsc) {
                                if (valueP.id === keyM && parentIndex === valueP.parentId) {
                                    parentChilds += valueM;
                                    if(i === 1){
                                        midParent += valueM;
                                        console.log(valueM);
                                    }

                                }
                            }

                        });

                        if (i === 2){
                            midParent = midParent - 25;
                            $("#" + defaultIndex).html($("#" + defaultIndex).text() + "(" + parentChilds + ")");
                            $("#" + parentIndex).html($("#" + parentIndex).text() + "(" + midParent + ")");
                        }
                        if (parentIndex > 202) {
                            $("#" + parentIndex).html($("#" + parentIndex).text() + "(" + parentChilds + ")");
                        }
                        ++parentIndex;

                        if(i === 2 || i > 2){
                            parentChilds = 0;
                        }

                    }

                }})
        }})
});

