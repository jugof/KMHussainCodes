namespace DemoApp;

class Transformer
{
    public static void Transform(byte[] data, int count)
    {
        for(int i = 0; i < count; ++i)
            data[i] = (byte)(data[i] ^ '#');
    }
}
