using System.ComponentModel.DataAnnotations;
using DemoApp.Services;
using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Mvc;

namespace DemoApp.Controllers;

[ApiController] //enable automatic data validation, service binding, etc
public class BackController : ControllerBase
{
    //Browser only allows client-side script to render/submit data from/to
    //the endpoint of its origin or an endpoint from which it has received
    //headers required for enabling cross origin resource sharing (CORS)
    [EnableCors("forPreview")] //see Program.cs 
    [HttpPut("/greet")]
    public ActionResult<GreetOutput> Greet(GreetInput guest, ICounter counter)
    {
        return new GreetOutput 
        {
            Message = guest.Age < 20 ? $"Hi {guest.Name}" : $"Hello {guest.Name}",
            Count = counter.CountNext(guest.Name)
        };
    }

    public class GreetInput
    {
        [StringLength(32, MinimumLength = 4)]
        public string Name { get; set; }

        [Range(16, 66)]
        public int Age { get; set; }
    }

    public class GreetOutput
    {
        public string Message { get; set; }

        public int Count { get; set; }
    }
}