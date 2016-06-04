# Enter your code here. Read input from STDIN. Print output to STDOUT


shapes = set(["Rock", "Paper", "Scissors", "Lizard", "Spock"])

beat_by = {"Paper": ["Scissors", "Lizard"], "Rock": ["Paper", "Spock"], "Lizard": ["Rock", "Scissors"], "Spock": ["Lizard", "Paper"], "Scissors": ["Spock", "Rock"]}


t = input("")

for i in range(t):
    line = raw_input("")
    arr = line.split(" ")
    state1 = arr[0]
    state2 = arr[1]
    n = int(arr[2])

    alice_win = 0
    bob_win = 0
    tie_games = 0

    for j in range(n):
        if state2 in beat_by[state1]:
            choices = beat_by[state2]
            c1, c2 = choices[0], choices[1]
            # Alice's next choice:
            if c1 in beat_by[c2]:
                state1 = c1
            else:
                state1 = c2

            # Bob's next choice:
            if state2 == "Spock":
                state2 = "Rock"
            else:
                state2 = "Spock"


            bob_win += 1
        elif state1 in beat_by[state2]:
            # Alice's next choice: keeps unchanged!

            # Bob's next choice:
            if state2 == "Spock":
                state2 = "Paper"
            else:
                state2 = "Spock"

            alice_win += 1
        else:
            # Alice's next choice:
            choices = beat_by[state1]
            c1, c2 = choices[0], choices[1]
            if c1 in beat_by[c2]:
                state1 = c1
            else:
                state1 = c2

            # Bob's next choice:
            if state2 == "Spock":
                state2 = "Lizard"
            else:
                state2 = "Spock"

            tie_games += 1

    if alice_win > bob_win:
        print "Alice wins, by winning", alice_win, "game(s) and tying", tie_games, "game(s)"
    elif alice_win == bob_win:
        print "Alice and Bob tie, each winning", alice_win, "game(s) and tying", tie_games, "game(s)"
    else:
        print "Bob wins, by winning", bob_win, "game(s) and tying", tie_games, "game(s)"

    # print alice_win, bob_win, tie_games






