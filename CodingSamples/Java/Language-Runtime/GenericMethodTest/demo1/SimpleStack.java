class SimpleStack<V> {

    private Node top;

    //inner member class
    class Node {

        V value;
        Node below;

        Node(V item) {
            value = item;
            below = top;
        }
    }

    public void push(V item) {
        top = new Node(item);
    }

    public V pop() {
        V item = top.value;
        top = top.below;
        return item;
    }

    public boolean empty() {
        return top == null;
    }

}
