import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

// Pardon the code, I'm only beginning to dipinto java syntax
// it might be prone to being... inelegant.

public class Day3b {

  static void increment_count(Map<String, Integer> map, String key) {
    Integer count = map.get(key);
    map.put(key, count + 1);
  }

  static int get_next_array_length(ArrayList<String> current_dataset, int char_position, String get_me) {
    int next_array_length = 0;
    for (int i = 0; i < current_dataset.size(); i++) {
      if (current_dataset.get(i).charAt(char_position) == get_me.charAt(0)) {
        next_array_length++;
      }
    }
    return next_array_length;
  };

  static void populateNextArrayOfStrings(List<ArrayList<String>> dataset, int array_position, int char_position,
      String get_me) {
    ArrayList<String> current_dataset = dataset.get(array_position);
    int next_array_length = get_next_array_length(current_dataset, char_position, get_me);
    ArrayList<String> new_current_dataset = new ArrayList<String>(next_array_length);
    // System.out.println("current_dataset: " + current_dataset + ".");
    // System.out.println("get_me: " + get_me + ".");

    for (int i = 0; i < current_dataset.size(); i++) {
      String tmp_str = Character.toString(current_dataset.get(i).charAt(char_position));
      if (tmp_str.equals(get_me)) {
        new_current_dataset.add(current_dataset.get(i));
      }
    }
    System.out.println("new_current_dataset: " + new_current_dataset + ".");

    dataset.add(new_current_dataset);
  };

  static String loopOverCollection(List<ArrayList<String>> dataset, ArrayList<String> current_dataset,
      int array_position,
      int char_position) {

    if (current_dataset.size() <= 1) {
      return current_dataset.get(0);
    }

    // if (current_dataset.size() == 2) {
    // for (int i = 0; i < current_dataset.size(); i++) {
    // String tmp_str =
    // Character.toString(current_dataset.get(i).charAt(char_position));
    // String get_me = "1";
    // if (tmp_str.equals(get_me)) {
    // populateNextArrayOfStrings(dataset, array_position, char_position, get_me);
    // array_position++;
    // char_position++;
    // return loopOverCollection(dataset, dataset.get(array_position),
    // array_position, char_position);
    // }
    // }
    // }

    HashMap<String, Integer> counts = new HashMap<String, Integer>();
    counts.put("1", 0);
    counts.put("0", 0);

    for (int i = 0; i < current_dataset.size(); i++) {
      char tmp_char = current_dataset.get(i).charAt(char_position);
      String tmp_str = Character.toString(tmp_char);
      // Regarding string comparison... == will check if both operands
      // point to the same object, it WILL be false even if the values are the same
      // So instead use the .equals method.
      if (tmp_str.equals("1")) {
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

    System.out.println("full dataset is : " + dataset);
    System.out.println("current_dataset is : " + current_dataset);
    System.out.println("arr_pos is : " + array_position);
    System.out.println("char_pos is : " + char_position);
    System.out.println("next current_dataset is : " + dataset.get(array_position));

    // return "Ha!";
    return loopOverCollection(dataset, dataset.get(array_position), array_position, char_position);

  };

  public static void main(String[] args) {
    String[] rawinput = { "00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000",
        "11001", "00010", "01010" };

    // The idea is to use a recursive function, to traverse through
    // an array of array of strings (?!).
    int char_position = 0;
    int array_position = 0;
    List<ArrayList<String>> arrayOfArrayOfStrings = new ArrayList<>();
    ArrayList<String> current_dataset = new ArrayList<>();
    for (int i = 0; i < rawinput.length; i++) {
      current_dataset.add(rawinput[i]);
    }
    arrayOfArrayOfStrings.add(current_dataset);

    // // DEBUG
    // for (int i = 0; i < arrayOfArrayOfStrings.size(); i++) {
    // System.out.println(arrayOfArrayOfStrings.get(i));
    // for (int j = 0; j < arrayOfArrayOfStrings.get(i).size(); j++) {
    // System.out.println(arrayOfArrayOfStrings.get(i).get(j));
    // }
    // }
    // System.out.println("Debug over");

    String answer;
    answer = loopOverCollection(arrayOfArrayOfStrings, current_dataset, array_position, char_position);

    System.out.println(answer);
  };
}
