import random

# Create a list of words to choose from
words = open("Unit_4/hangman/thing.txt", "r").read().split()
# Choose a random word from the list
word = random.choice(words)
print(word)
# Create a list to store the letters that have been guessed
guesses = []
# Set the number of wrong guesses to 6
guesses_left = 6
# Loop until win or lose
while True:
    # Print the word, with unguessed letters replaced by underscores
    for letter in word:
        if letter in guesses:
            print(letter, end="")
        else:
            print("_", end="")
    # Prompt the player to guess a letter
    guess = input("\nGuess a letter: ")
    # Add the letter to the list of guesses
    guesses.append(guess)
    # If letter is not in the word, subtract a guess
    if guess not in word:
        guesses_left -= 1
        if guesses_left == 0:
            print("The word was", word)
            print("You lose!")
            break
    if set(word) <= set(guesses):
        print("The word was", word)
        print("You win!")
        break
    print("You have", guesses_left, "guesses left")
