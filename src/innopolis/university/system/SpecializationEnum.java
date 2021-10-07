package innopolis.university.system;

public enum SpecializationEnum {
    ADULT, CHILD;

    @Override
    public String toString() {
        switch (this){
            case ADULT -> {
                return "Adult";
            }
            case CHILD -> {
                return "Child";
            }
            default -> throw new IllegalArgumentException();
        }
    }
}
