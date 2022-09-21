package assignmentcode;
public enum Sport{
    ARCHERY(1), BADMINTON(2), CRICKET(3), FOOTBALL(4), GYMNASTICS(5), SWIMMING(6), TENNIS(7), TABLE_TENNIS(8), VOLLEYBALL(9);
    private int value;
    private Sport (int x){
        value = x;
    }
    public int getValue(){
        return value;
    }
}
