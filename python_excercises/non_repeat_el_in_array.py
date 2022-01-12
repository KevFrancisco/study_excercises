""" 
Non repeat element
take a string and return char that never repeats
if multiple unique return only the first unique
"""


def non_repeat(str):
    str = str.replace(" ", "").lower()
    char_count = {}
    uniques = []

    for letter in str:
        if letter not in char_count:
            char_count[letter] = 1
        else:
            char_count[letter] += 1

    for c in str:
        if char_count[c] == 1:
            uniques.append(c)

    return uniques if len(uniques) > 0 else None


str = "aaaabbbcccdddeeefghi"
str2 = "I Apple Ape Peels"
ans = non_repeat(str2)
print(ans)
