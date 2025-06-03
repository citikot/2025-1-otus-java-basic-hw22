package service;

public class ArrayService {

    public int[] modifyArray(int[] array) {

        if (isOneNotExist(array)) {
            throw new RuntimeException("Массив должен содержать хотя бы одну единицу!");
        }

        int lastOneIndex = findLastOneIndex(array);

        int size = array.length - lastOneIndex - 1;
        int[] result = new int[size];
        System.arraycopy(array, lastOneIndex + 1, result, 0, size);

        return result;
    }

    private int findLastOneIndex(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    private boolean isOneNotExist(int[] array) {

        if (array.length == 0) {
            return true;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                return false;
            }
        }

        return true;
    }

    public boolean isFilledByOneTwoArray(int[] array) {

        int oneCount = 0;
        int twoCount = 0;

        if (array.length == 0) {
            return false;
        }

        for (int i = 0; i < array.length; i++) {

            if (!(array[i] == 1 || array[i] == 2)) {
                return false;
            }
            if (array[i] == 1) {
                oneCount++;
                continue;
            }
            if (array[i] == 2) {
                twoCount++;
            }
        }

        if (oneCount == array.length || twoCount == array.length) {
            return false;
        }

        return true;
    }
}
