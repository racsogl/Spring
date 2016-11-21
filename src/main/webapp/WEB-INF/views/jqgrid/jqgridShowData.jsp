<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>JQGRID</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/themes/redmond/jquery-ui.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.13.5/css/ui.jqgrid.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.13.5/js/jquery.jqgrid.min.js"></script>
    <script>
    //<![CDATA[

    "use strict";
    /*
    $(function () {
        "use strict";
        $("#grid").jqGrid({
            colModel: [
                { name: "firstName" },
                { name: "lastName" }
            ],
            data: [
                { id: 10, firstName: "Angela", lastName: "Merkel" },
                { id: 20, firstName: "Vladimir", lastName: "Putin" },
                { id: 30, firstName: "David", lastName: "Cameron" },
                { id: 40, firstName: "Barack", lastName: "Obama" },
                { id: 50, firstName: "François", lastName: "Hollande" }
            ]
        });
    });

    */
    $()

    $(function(){
      $("#list").jqGrid({
                    url : "${pageContext.request.contextPath}/jqgrid/loadata",
                    datatype : "json",
                    mtype : 'GET',
                    colNames : [ 'Name','Alias','Super Power'],
                    colModel : [ {
                            name : 'name',
                            index : 'name',
                            width : 150
                    }, {
                            name : 'alias',
                            index : 'alias',
                            width : 150,
                            editable : false
                    }, {
                            name : 'power',
                            index : 'power',
                            width : 550,
                            editable : false
                    }],
                    pager : '#pager',
                    rowNum : 10,
                    height: 'auto',
                    rowList : [ 10 ],
                    sortname : 'invid',
                    sortorder : 'desc',
                    viewrecords : true,
                    gridview : true,
                    multiselect: true,
                multiboxonly: false,
                    caption : 'Super Heroes',
                    jsonReader : {
                            repeatitems : false,
                    }
            });
    //]]>
    </script>
</head>
<body>
<table id="grid"></table>
</body>
</html>