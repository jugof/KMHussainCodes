namespace Tourism;

public class Site(string title)
{
    public string Title { get; set; } = title;

    public List<Visitor> Visitors { get; set; } = [];

    public Visitor GetVisitor(string id)
    {
        var visitor = Visitors.Find(v => v.Name == id);
        if(visitor is null)
        {
            visitor = new Visitor { Name = id };
            Visitors.Add(visitor);
        }
        return visitor;
    }
}