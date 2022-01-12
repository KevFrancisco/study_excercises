fn main() {
    // In general, the '{}' will be automatically replaced
    // with arguments, stringified.
    println!("{} days", 31 );

    // Without a suffix, an int automatically becomes an i32. You can change
    // what type by adding a suffix. For example: 31i64 will become int 64 type.

    // There are various optional patterns this works with. Positional
    // arguments can be used. Zero indexed.
    println!("{0}, this is {1}. {1}, this is {0}", "Alice", "Bob");

    // Also named arguments.
    println!("{subject} {verb} {object}",
            object="the lazy dog",
            subject="the quick brown fox",
            verb="jumps over");
}
