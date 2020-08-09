package Java_Level3.Lesson6;

public class ArrayCheck2 {

    public boolean arrayContains(int[] arraySource) {
        for (int value : arraySource) {
            if (value == 1 | value == 4) return true;
        }
        return false;
    }
}
