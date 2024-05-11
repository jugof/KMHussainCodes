using Tourism;

var mysite = SiteStore.Load("CitiZoo");
if(args.Length > 0)
{
    var guest = mysite.GetVisitor(args[0]);
    guest.Visit();
    mysite.Save();
    Console.WriteLine("Welcome {0}, your ticket number is {1}", guest.Name, guest.Ticket);
}
else
{
    foreach(var visitor in mysite.Visitors)
        Console.WriteLine("{0}\t{1}\t{2}", visitor.Name, visitor.VisitCount, visitor.LastVisit);
}
