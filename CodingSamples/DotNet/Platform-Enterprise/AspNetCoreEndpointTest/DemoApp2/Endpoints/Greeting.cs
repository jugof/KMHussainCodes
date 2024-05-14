using DemoApp.Services;

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

    public static async Task Hello(HttpResponse response, HttpRequest request, ICounter ctr)
    {
        string visitor = request.Form["guest"];
        if(visitor.Length == 0)
            visitor = "Visitor";
        int count = ctr.CountNext(visitor);
        await response.WriteAsync($"""
        <html>
            <head>
                <title>DemoApp</title>
            </head>
            <body>
                <h1>Hello {visitor}</h1>
                <b>Number of Greetings: </b>{count}
            </body>
        </html>
        """);
    }

}
