public class _02CompareLength {
    public static void main(String[] args) {
        // - Create an array variable named `p1`
        //   with the following content: `[1, 2, 3]`
        int[] p1 = {1, 2, 3};
        // - Create an array variable named `p2`
        //   with the following content: `[4, 5]`
        int[] p2 = {4, 5};
        // - Print "p2 is longer" if `p2` has more elements than `p1`
        if (p2.length > p1.length) {
            System.out.println("p2 is longer");
        }   //else if (p1.length > p2.length) {
            //  System.out.println("p1 is longer");
            //}
    }
}
