class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        int[] firstRow = twoDimArray[0];
        int firstElementOfFirstRow = firstRow[0];
        int lastElementOfFirstRow = firstRow[firstRow.length - 1];

        int[] lastRow = twoDimArray[twoDimArray.length - 1];
        int firstElementOfLastRow = lastRow[0];
        int lastElementOfLastRow = lastRow[lastRow.length - 1];

        System.out.println(firstElementOfFirstRow + " " + lastElementOfFirstRow);
        System.out.println(firstElementOfLastRow + " " + lastElementOfLastRow);

    }
}