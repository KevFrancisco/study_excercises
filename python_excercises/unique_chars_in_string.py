""" 
Given a string, are all characters unique?
return True or False
"""


def unique_string(str):
    # Using python builtins
    str = str.replace(" ", "").lower()
    # return if len(str) == len(set(str)) else False
    unq_chars = set()

    for letter in str:
        if letter in unq_chars:
            return False
        else:
            unq_chars.add(letter)
    return True


str3 = "ab c de"
str4 = "a abc de"

ans3 = unique_string(str3)
ans4 = unique_string(str4)

print(ans3)
print(ans4)
