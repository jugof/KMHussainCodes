<%@taglib prefix="d" uri="demo.app.tags" %>
<html>
    <head>
        <title>demo-web-app</title>
    </head>
    <body>
        <h1>Welcome Gambler</h1>
        <p>
            <b>WINNER: </b>
            <d:lotto digitVar="dig" digitCount="${param.size}">
                <i>${dig}</i>
            </d:lotto>
        </p>
        <b>Set Lotto Size</b>
        <p>
            <form>
                <input type="radio" name="size" value="8"/>Small<br/>
                <input type="radio" name="size" value="9"/>Big<br/>
                <input type="radio" name="size" value="10"/>Large<br/><br/>
                <input type="submit" value="Apply"/>
            </form>
        </p>
    </body>
</html>