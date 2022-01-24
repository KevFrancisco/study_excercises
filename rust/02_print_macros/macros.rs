fn main() {
    // In general, the '{}' will be automatically replaced
    // with arguments, stringified.
    println!("{} days", 31);

    // Without a suffix, an int automatically becomes an i32. You can change
    // what type by adding a suffix. For example: 31i64 will become int 64 type.

    // There are various optional patterns this works with. Positional
    // arguments can be used. Zero indexed.
    println!("{0}, this is {1}. {1}, this is {0}", "Alice", "Bob");

    // Also named arguments.
    println!(
        "{subject} {verb} {object}",
        object = "the lazy dog",
        subject = "the quick brown fox",
        verb = "jumps over"
    );

    // Special Formatting
    println!(
        "{} of {:b} people know binary, the other half doesn't",
        1, 2
    );

    // You can right-align text with a specified width. This will output
    // "      1". 5 white spaces and a "1".
    println!("{number:-^width$}", number = 1, width = 6);

    // Rust even checks to make sure the correct number of arguments are used.
    println!("My name is {0}, {1} {0}", "Bond", "James");

    // Create a structure named 'Structure' which contains an 'i32'.
    #[allow(dead_code)]
    #[derive(Debug)]
    struct Structure(i32);
    // However, custom types such as this structure require more compilcated handling.
    // This will NOT work.
    println!("This struct '{:?}' won't print...", Structure(3));

    // Add a println macro that prints Pi is roughly 3.142 by controlling the number
    // of decimal places shown.
    let pi = 3.141592;
    println!("Pi is roughly {:.3}", pi);
}
