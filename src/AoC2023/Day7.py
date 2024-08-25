class Types_Of_Hands:
    five_of_a_kind = []
    four_of_a_kind = []
    full_house = []
    three_of_a_kind = []
    two_pair = []
    one_pair = []
    high_card = []


class Hand:

    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __repr__(self):
        return f"<{self.x}-{self.y}>"

    def get_hand(self):
        return self.x

    def get_bet(self):
        return self.y


def read_hands_from_file(file_name):
    with open(file_name, 'r') as file:
        return file.read()


def sort_into_arrays(hand):
    cards_in_play = hand.get_hand()
    joker_count = cards_in_play.count('J')
    count_of_hand = (cards_in_play.count(cards_in_play[0]) +
                     cards_in_play.count(cards_in_play[1]) +
                     cards_in_play.count(cards_in_play[2]) +
                     cards_in_play.count(cards_in_play[3]) +
                     cards_in_play.count(cards_in_play[4]))
    if count_of_hand == 25:
        Types_Of_Hands.five_of_a_kind.append(hand)

    elif count_of_hand == 17:
        if joker_count > 0:
            Types_Of_Hands.five_of_a_kind.append(hand)
        else:
            Types_Of_Hands.four_of_a_kind.append(hand)

    elif count_of_hand == 13:
        if joker_count > 0:
            Types_Of_Hands.five_of_a_kind.append(hand)
        else:
            Types_Of_Hands.full_house.append(hand)

    elif count_of_hand == 11:
        if joker_count > 0:
            Types_Of_Hands.four_of_a_kind.append(hand)
        else:
            Types_Of_Hands.three_of_a_kind.append(hand)

    elif count_of_hand == 9:
        if joker_count == 1:
            Types_Of_Hands.full_house.append(hand)
        elif joker_count == 2:
            Types_Of_Hands.four_of_a_kind.append(hand)
        else:
            Types_Of_Hands.two_pair.append(hand)

    elif count_of_hand == 7:
        if joker_count > 0:
            Types_Of_Hands.three_of_a_kind.append(hand)
        else:
            Types_Of_Hands.one_pair.append(hand)

    elif joker_count == 1:
        Types_Of_Hands.one_pair.append(hand)

    else:
        Types_Of_Hands.high_card.append(hand)


def sort_arrays_internally(hands):
    # Mapping for card values including 'T', 'J', 'Q', 'K', 'A'
    card_values = {"J": 1, "2": 2, "3": 3, "4": 4, "5": 5, "6": 6, "7": 7, "8": 8, "9": 9,
                   "T": 10, "Q": 12, "K": 13, "A": 14}

    def keyf(hand):
        card_hand = hand.get_hand()
        sort_key = tuple(card_values[card] for card in card_hand)
        print(f"Hand: {card_hand}, Sort Key: {sort_key}")
        return sort_key

    hands.sort(key=keyf)
    return hands


def final_scoring(sorted_hands):
    total_winnings = 0
    for i, hand in enumerate(sorted_hands):
        winnings = int(hand.get_bet()) * (i + 1)  # Convert bet to int and calculate winnings
        total_winnings += winnings
    return total_winnings


def main():
    file_name = "../../2023day7input.txt"
    bets = read_hands_from_file(file_name)
    hand_array = []
    for word in bets.splitlines():
        hand_array.append(Hand(word.split(' ')[0], word.split(' ')[1]))

    for cards in hand_array:
        sort_into_arrays(cards)

    final_rank = sort_arrays_internally(Types_Of_Hands.high_card) + \
                 sort_arrays_internally(Types_Of_Hands.one_pair) + \
                 sort_arrays_internally(Types_Of_Hands.two_pair) + \
                 sort_arrays_internally(Types_Of_Hands.three_of_a_kind) + \
                 sort_arrays_internally(Types_Of_Hands.full_house) + \
                 sort_arrays_internally(Types_Of_Hands.four_of_a_kind) + \
                 sort_arrays_internally(Types_Of_Hands.five_of_a_kind)

    print(final_rank)

    print(final_scoring(final_rank))


if __name__ == "__main__":
    main()
