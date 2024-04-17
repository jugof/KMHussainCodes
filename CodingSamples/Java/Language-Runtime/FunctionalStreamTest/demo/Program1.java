class Program {

    public static void main(String[] args) {
        if(args[0].equalsIgnoreCase("items")){
            Item[] items = Shop.items();
            for(Item i : items){
                if(i.brand().equals(args[1]))
                    System.out.println(i.name());
            }
        }
    }
}