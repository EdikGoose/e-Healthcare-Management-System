package innopolisuniversity.system.data;


public final class MedicineController  {

    private static MedicineController instance;

    private MedicineController() { }

    public int getMedicinesNumber() {
        return Database.getInstance().getMedicinesNumber();
    }

    public void reduceMedicines() {
        if (getMedicinesNumber() == 0)
            throw new IllegalStateException("there are no medicines");
        Database.getInstance().reduceMedicines();
    }

    public void addMedicine() {
        Database.getInstance().addMedicine();
    }

    public static MedicineController getInstance() {
        if (instance == null) {
            synchronized (MedicineController.class) {
                if (instance == null) {
                    instance = new MedicineController();
                }
            }
        }
        return instance;
    }
}
