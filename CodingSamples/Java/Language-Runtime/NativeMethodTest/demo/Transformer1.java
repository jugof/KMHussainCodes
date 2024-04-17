class Transformer {

    public static String transform(String text) {
        System.out.println("Slow transformation...");
        int n = text.length();
        var buffer = new StringBuilder(n);
        for(int i = 0; i < n; ++i) {
            char ch = text.charAt(i);
            ch = (char)(ch ^ '#');
            buffer.append(ch);
        }
        return buffer.toString();
    }
    
}
