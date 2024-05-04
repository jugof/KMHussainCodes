#nullable disable

class SimpleStack<E> 
{
    class Node
    {
        internal E Value;
        internal Node Below;

        internal Node Skip(int count)
        {
            Node n = this;
            for(int i = 0; i < count; ++i)
                n = n.Below;
            return n;
        }
    }

    internal struct Navigator(SimpleStack<E> outer)
    {
        Node next = outer.top;

        public bool MoveNext()
        {
            if(next != null)
            {
                Current = next.Value;
                next = next.Below;
                return true;
            }
            return false;
        }

        public E Current { get; private set; }

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

    //In order to enable standard iteration, a type must support 
    //an accessible GetEnumerator() method whose return type
    //must expose MoveNext() method and Current property
    public Navigator GetEnumerator()
    {
        return new Navigator(this);
    }

    //an indexer is a parameterized property that provides access to
    //elements inside of 'this' object through an array-style syntax
    public E this[int index]
    {
        get { return top.Skip(index).Value; }
        set { top.Skip(index).Value = value; }
    }
}