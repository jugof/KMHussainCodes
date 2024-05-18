using DemoApp.Data;
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace DemoApp.Pages;

[Authorize]
[ResponseCache(NoStore = true)]
public class DetailsModel(ShopDbContext shop) : PageModel
{
    public Customer Output { get; set; }

    public async Task OnGet()
    {
        Output = await shop.Customers.FindAsync(User.Identity.Name);
        await shop.Entry(Output).Collection(p => p.Orders).LoadAsync();
    }

    public async Task<IActionResult> OnGetLogout()
    {
        await HttpContext.SignOutAsync();
        return RedirectToPage("Index");
    }
}