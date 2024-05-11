using System.Text.Json.Serialization;

namespace Tourism;

public class Visitor
{
    public required string Name { get; set; }

    public int VisitCount { get; set; }

    public DateTime LastVisit { get; set; }

    [JsonIgnore]
    public int Ticket { get; set; }

    public void Visit()
    {
        VisitCount += 1;
        LastVisit = DateTime.Now;
        Ticket = Environment.TickCount % 1000000;
    }
}