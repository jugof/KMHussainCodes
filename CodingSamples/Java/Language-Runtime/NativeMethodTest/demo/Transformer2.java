class Transformer {

    public final static char SALT = '#';
    
    public native static String transform(String text);

    //code in 'static initializer' is executed once when
    //the class is loaded into the JVM
    static {
        //load the native library (libjnitfm.so) from the locations
        //specified by -Djava.library.path
        System.loadLibrary("jnitfm");
    }
}
