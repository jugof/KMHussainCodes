using DemoApp;

if (args.Length > 1)
{
    var input = new FileStream(args[0], FileMode.Open);
    var output = new FileStream(args[1], FileMode.CreateNew);
    byte[] buffer = new byte[80];
    while(input.Position < input.Length)
    {
        int n = input.Read(buffer, 0, buffer.Length);
        Transformer.Transform(buffer, n);
        output.Write(buffer, 0, n);
    }
    output.Close();
    input.Close();
}
else if(args.Length == 1)
{
    using var file = new FileStream(args[0], FileMode.Open, FileAccess.ReadWrite);
    int n = (int) file.Length;
    Span<byte> buffer = new byte[n];
    file.Read(buffer);
    buffer.Reverse();
    file.Position = 0;
    file.Write(buffer);
}
