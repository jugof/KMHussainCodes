using DemoApp.Data;
using DemoApp.Models;
using Microsoft.AspNetCore.Mvc;

namespace DemoApp.Controllers;

public class HomeController(HotelModel hotel) : Controller
{
    //GET /Home/Index, /Home, /
    public IActionResult Index()
    {
        var visitors = hotel.ReadVisitors();
        return View(visitors);//render ~/Views/[controller-name]/[action-name].cshtml
    }

    [HttpPost] //POST /Home/Register
    public IActionResult Register(string visitorId, int visitorRating)
    {
        var guest = new Guest { Id = visitorId, Rating = visitorRating };
        hotel.WriteVisitor(guest);
        return RedirectToAction("Index");
    }
}