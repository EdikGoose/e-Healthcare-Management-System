package innopolisuniversity.system;

public class Ward {
    private static int numberOfCreatedWard = 0;

    private final int number;
    private boolean free;
    private final int id;

    public Ward(int number) {
        this.number = number;
        this.id = ++numberOfCreatedWard;
    }

    public int getNumber() {
        return number;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public boolean isFree() {
        return free;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("{Ward number=%d, free=%d}", number, free);
    }
}
