record Customer(String id, double purchase, int rating) implements Comparable<Customer> {
    
    public int compareTo(Customer that) {
        return id.compareTo(that.id);
    }
}
