from re import A
# evals the cards and adds the amount of points its worth to the total
def cardEval(card):
	global cardPoints
	card = card.lower()
	if card[1] in "akqj":
		if card[1]=="a":
			cardPoints += 4
		elif card[1]=="k":
			cardPoints += 3
		elif card[1]=="q":
			cardPoints += 2
		elif card[1]=="j":
			cardPoints += 1
	else:
		cardPoints += 0
# evals suits and keeps track of how many card of each suit there are
def suitEval(card):
	global s, h , d, c
	card = card.lower()
	if card[0] in "shdc":
		if card[0] == "s":
			s+=1
		elif card[0] == "h":
			h+=1
		elif card[0] == "d":
			d+=1
		elif card[0] == "c":
			c+=1
#checks if there is a certain amount of card in a suit
def suitBool(num, suit):
	global s, h , d, c
	return bool(suit==num)
#calculates how many distro points should be awarded
def suitNum():
	global s, h, d, c,  suitPoints
	for var in range(0,3):
		if suitBool(var, s):
			suitPoints += 3-var
		if suitBool(var, h):
			suitPoints += 3-var
		if suitBool(var, d):
			suitPoints += 3-var
		if suitBool(var, c):
			suitPoints += 3-var
# the final eval function
def endEval():
	global s, h, d, c, cardPoints, suitPoints, inputList
	totalPoints=0
	#prints the input just to check
	print(inputList, sep = ", ")
	#calculates how many points each of the cards are worth, then adds it to the total
	for var in inputList:
		print(var)
		cardEval(var)
		print("cardpoints:", cardPoints)
		suitEval(var)
		print("number of each suit", s, h, d, c)
		totalPoints=+ cardPoints
		print("total", totalPoints)
	#evals how many distro points should be given, then adds it to the total
	suitNum()
	print ("distro points", suitPoints)
	totalPoints += suitPoints
	#return the total amount of points
	return totalPoints
#init'ing a lot of variables, the single letter ones are for counting how many cards in a suit, and the other ones are as described.
s=0
h=0
d=0
c=0
cardPoints = 0
suitPoints = 0
# change this if u want
input = input("Input:\n")
#test sequence
if input=="test":
	input = "sa s1 s7 s6 s2 hq hj h9 ck c4 dk d9 d3"
inputList = input.split()
output = endEval()
print("The total point value of deck:", input)
print("is", output, "points.")