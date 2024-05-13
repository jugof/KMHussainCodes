using DemoApp.Data;
using DemoApp.Models;

var model = new HotelModel();
if(args.Length > 0)
{
    var guest = new Guest { Id = args[0] };
    model.WriteVisitor(guest);
    Console.WriteLine("Welcome {0}", guest.Id);
}
else
{
    foreach(var visitor in model.ReadVisitors())
    {
        Console.WriteLine("{0}\t{1}\t{2}", visitor.GivenName, visitor.VisitCount, visitor.LastVisit);
    }
}