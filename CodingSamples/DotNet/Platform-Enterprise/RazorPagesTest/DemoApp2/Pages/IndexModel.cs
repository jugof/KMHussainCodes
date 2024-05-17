using System.Security.Claims;
using DemoApp.Data;
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace DemoApp.Pages;

public class IndexModel(ShopDbContext shop) : PageModel
{
    [BindProperty]
    public Customer Input { get; set; }

    public void OnGet()
    {
        Input = new Customer { Id = "CU" };
    }

    public async Task<IActionResult> OnPost()
    {
        var customer = await shop.Customers.FindAsync(Input.Id);
        if(customer?.Password == Input.Password)
        {
            var identity = new ClaimsIdentity("Customer");
            identity.AddClaim(new Claim(ClaimTypes.Name, customer.Id));
            await HttpContext.SignInAsync(new ClaimsPrincipal(identity));
            return RedirectToPage("Details");
        }
        ModelState.AddModelError("Login", "Invalid Customer Id or Password");
        return Page();
    }
}