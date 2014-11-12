<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
<h1>Test</h1>
<h2>${message}</h2>
<form:form action="/rest/get">
    <form:label path="url">Ссылка на циан:</form:label> <form:input path="url" type="text"/>
    <input id="btn" type="submit" value="Click">
    <br />
    <h3>Результат поиска: </h3>
    <br />
    <table>
        <tr>
            <td>
                <div style="height: 100px; width: 300px" id="desc1">

                </div>
            </td>
            <td>
                <div style="height: 100px; width: 600px" id="ph1">

                </div>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
