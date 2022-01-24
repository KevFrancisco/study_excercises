// Pardon the code, I'm only beginning to dipinto java syntax
// it might be prone to being... inelegant.

public class Day3b {
  public static void main(String[] args) {
    String[] rawinput = { "00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000",
        "11001", "00010", "01010" };

    // Get the width of the array
    int rawinput_rowlen = rawinput[0].length;

    // Get the length of the array
    int rawinput_collen = rawinput.length;

    // Loop over all the elements of the array
    for (int i = 0; i < rawinput_rowlen; i++) {
      // Initialize this inside i, everytime we move columns the counter resets
      int count_i = 0;
      int count_j = 0;

      for (int j = 0; j < rawinput_collen; j++) {
        char charAtI = rawinput[j].charAt(i);
        if (charAtI == "1") {
          count_i++;
        } else {
          count_j++;
        }
      }
      // Done counting for the first column... tally

    }

  }
}
