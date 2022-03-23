public class NoMeanException extends java.lang.Exception {
    public NoMeanException() {
        super("Nebyl zadán žádný průměr");
    }
    public NoMeanException(String a) {
        super(a);
    }
}
