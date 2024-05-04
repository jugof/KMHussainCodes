var a = new SimpleStack<string>();
a.Push("Monday");
a.Push("Tuesday");
a.Push("Wednesday");
a.Push("Thursday");
a.Push("Friday");
for(var i = a.GetEnumerator(); i.MoveNext();)
    Console.WriteLine(i.Current);
Console.WriteLine("---------------------");
while(!a.Empty())
    Console.WriteLine(a.Pop());
Console.WriteLine("---------------------");
SimpleStack<decimal> b = new ();
b.Push(43.51m);
b.Push(27.42m);
b.Push(64.73m);
b.Push(36.14m);
b.Push(18.95m);
b.Push(52.36m);
b[3] += 2.1m; //using indexer
foreach(decimal d in b)
    Console.WriteLine(d);