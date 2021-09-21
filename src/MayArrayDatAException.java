public class MayArrayDatAException extends Exception{
    public MayArrayDatAException(String message) {
        super(message);
        System.err.println(message);
    }
}
