using DemoApp.Services;
using Microsoft.AspNetCore.Mvc;

namespace DemoApp.Controllers;

public class FrontController : ControllerBase
{
    [HttpGet("/meet/{id=Friend}")]
    public IActionResult Index(string id, [FromServices] ICounter counter)
    {
        int count = counter.CountNext(id);
        string ua = Request.Headers.UserAgent;
        string page = ua.Contains("Mobile") ? "./Templates/Hello.html" : "./Templates/Welcome.html";
        string markup = System.IO.File.ReadAllText(page)
                            .Replace("@Model.VisitorName", id)
                            .Replace("@Model.VisitCount", count.ToString());
        return Content(markup, "text/html");
    }
}