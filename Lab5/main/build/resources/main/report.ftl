<!DOCTYPE html>
<html>

<head>
    <title>Catalog Report</title>
</head>

<body>
    <h1> ${name} </h1>
</body>
<#list items as item>
    ${item.id} se afla la ${item.location} <br>
</#list>

</html>