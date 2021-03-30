public class FilledArray {
    static int[] getFilledArray(final int size, final int modifier, final Process p) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = p.process(i, modifier);
        }
        return arr;
    }
}
