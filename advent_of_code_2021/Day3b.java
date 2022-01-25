import java.util.Map;

// Pardon the code, I'm only beginning to dipinto java syntax
// it might be prone to being... inelegant.

public class Day3b {

  static void increment_count(Map<String, Integer> map, String key) {
    Integer count = map.getOrDefault(key, 0);
    map.put(key, count + 1);
  }

  static int get_next_array_length(String[] current_dataset, int char_position, String get_me) {
    int next_array_length = 0;
    for (int i = 0; i < current_dataset.length; i++) {
      if (current_dataset[i].charAt(char_position) == get_me.charAt(0)) {
        next_array_length++;
      }
    }
    return next_array_length;
  };

  static void populateNextArrayOfStrings(String[][] dataset, int array_position, int char_position, String get_me) {
    String[] current_dataset = dataset[array_position];
    int next_array_length = get_next_array_length(current_dataset, char_position, get_me);
    String[] new_strings_array = new String[next_array_length];
    dataset[array_position + 1] = new_strings_array;
  };

  static String loopOverCollection(String[][] dataset, String[] current_dataset, int array_position,
      int char_position) {
    if (current_dataset.length == 1) {
      return current_dataset[0];
    }

    if (dataset.length == 2) {
      for (int i = 0; i < current_dataset.length; i++) {
        if (dataset[array_position][i].charAt(char_position) == 1) {
          array_position++;
          char_position++;
          return loopOverCollection(dataset, dataset[array_position], array_position, char_position);
        }
      }
    }

    Map<String, Integer> counts = Map.of("1", 0, "2", 0);

    for (int i = 0; i < current_dataset.length; i++) {
      if (current_dataset[i].charAt(char_position) == "1".charAt(0)) {
        increment_count(counts, "1");
      } else {
        increment_count(counts, "0");
      }
      ;
    }
    ;

    String get_me = (counts.get("1") > counts.get("0")) ? "1" : "0";

    populateNextArrayOfStrings(dataset, array_position, char_position, get_me);
    array_position++;
    char_position++;

    return loopOverCollection(dataset, dataset[array_position], array_position, char_position);

  };

  public static void main(String[] args) {
    String[] rawinput = { "00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000",
        "11001", "00010", "01010" };

    // The idea is to use a recursive function, to traverse through
    // an array of array of strings (?!).
    int char_position = 0;
    int array_position = 0;
    int rawinput_rows = rawinput.length;
    int rawinput_cols = rawinput[0].length();
    String[][] arrayOfArrayOfStrings = new String[rawinput_rows][rawinput_cols];
    arrayOfArrayOfStrings[array_position] = rawinput;
    String[] current_dataset = rawinput;

    String answer;
    answer = loopOverCollection(arrayOfArrayOfStrings, current_dataset, array_position, char_position);

    System.out.println(answer);
  };
}
