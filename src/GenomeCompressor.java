/******************************************************************************
 *  Compilation:  javac GenomeCompressor.java
 *  Execution:    java GenomeCompressor - < input.txt   (compress)
 *  Execution:    java GenomeCompressor + < input.txt   (expand)
 *  Dependencies: BinaryIn.java BinaryOut.java
 *  Data files:   genomeTest.txt
 *                virus.txt
 *
 *  Compress or expand a genomic sequence using a 2-bit code.
 ******************************************************************************/

/**
 *  The {@code GenomeCompressor} class provides static methods for compressing
 *  and expanding a genomic sequence using a 2-bit code.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *  @author Zach Blick
 */
public class GenomeCompressor {

    /**
     * Reads a sequence of 8-bit extended ASCII characters over the alphabet
     * { A, C, T, G } from standard input; compresses and writes the results to standard output.
     */
    public static void compress() {

        String s = BinaryStdIn.readString();
        int n = s.length();

        BinaryStdOut.write(n);

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'A'){
                BinaryStdOut.write(0, 2);
            }
            else if (s.charAt(i) == 'C') {
                BinaryStdOut.write(1, 2);
            }
            else if (s.charAt(i) == 'T') {
                BinaryStdOut.write(2, 2);
            }
            else if (s.charAt(i) == 'G') {
                BinaryStdOut.write(3, 2);
            }
        }

        BinaryStdOut.close();
    }

    /**
     * Reads a binary sequence from standard input; expands and writes the results to standard output.
     */
    public static void expand() {

        int n = BinaryStdIn.readInt();

        for (int i = 0; i < n; i++) {
            char c = BinaryStdIn.readChar(2);
            if (c == 0) {
                BinaryStdOut.write("A");
            }
            else if (c == 1) {
                BinaryStdOut.write("C");
            }
            else if (c == 2) {
                BinaryStdOut.write("T");
            }
            else if (c == 3) {
                BinaryStdOut.write("G");
            }
            else {
                BinaryStdOut.write(c);
            }
        }
        BinaryStdOut.close();
    }


    /**
     * Main, when invoked at the command line, calls {@code compress()} if the command-line
     * argument is "-" an {@code expand()} if it is "+".
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        if      (args[0].equals("-")) compress();
        else if (args[0].equals("+")) expand();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}