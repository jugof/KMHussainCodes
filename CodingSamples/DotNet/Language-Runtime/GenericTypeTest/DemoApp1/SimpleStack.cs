interface IStackReader<out E>
{
    E Pop();
    bool Empty();
}

interface IStackWriter<in E>
{
    void Push(E item);
}

class SimpleStack<E> : IStackReader<E>, IStackWriter<E>
{
    class Node
    {
        internal E Value;
        internal Node Below;
    }

    private Node top;

    public void Push(E item)
    {
        top = new Node { Value = item, Below = top };
    }

    public E Pop()
    {
        Node n = top;
        top = top.Below;
        return n.Value;
    }

    public bool Empty()
    {
        return top is null;
    }
}