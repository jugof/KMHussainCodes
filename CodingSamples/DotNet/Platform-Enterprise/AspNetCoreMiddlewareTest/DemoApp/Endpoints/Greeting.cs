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
            </body>
        </html>
        """);
    }

    public static async Task Hello(HttpContext context)
    {
        string visitor = context.Request.Form["guest"];
        if(visitor.Length == 0)
            visitor = "Visitor";
        int count = context.Session.GetInt32(visitor) ?? 1;
        context.Session.SetInt32(visitor, count + 1);
        await context.Response.WriteAsync($"""
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
