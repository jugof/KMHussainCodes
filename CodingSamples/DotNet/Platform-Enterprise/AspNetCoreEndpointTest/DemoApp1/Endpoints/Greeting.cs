namespace DemoApp.Endpoints;

public static class Greeting
{
    public static async Task Welcome(HttpResponse response)
    {
        await response.WriteAsync($"""
        <html>
            <head>
                <title>DemoApp</title>
            </head>
            <body>
                <h1>Welcome Visitor</h1>
                <b>Current Time: </b>{DateTime.Now}
                <p>
                    <form method="post" action="/Greet">
                        <b>Name: </b>
                        <input type="text" name="guest"/>
                        <input type="submit" value="Greet"/>
                    </form>
                </p>
            </body>
        </html>
        """);
    }

    public static async Task Hello(HttpResponse response, HttpRequest request)
    {
        string visitor = request.Form["guest"];
        if(visitor.Length == 0)
            visitor = "Visitor";
        await response.WriteAsync($"""
        <html>
            <head>
                <title>DemoApp</title>
            </head>
            <body>
                <h1>Hello {visitor}</h1>
            </body>
        </html>
        """);
    }

}
