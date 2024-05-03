var a = new SimpleStack<string>();
a.Push("Monday");
a.Push("Tuesday");
a.Push("Wednesday");
a.Push("Thursday");
a.Push("Friday");
while(!a.Empty())
    Console.WriteLine(a.Pop());
Console.WriteLine("---------------------");
while(!a.Empty())
    Console.WriteLine(a.Pop());
    