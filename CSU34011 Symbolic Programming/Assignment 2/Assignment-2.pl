%Question 1
s --> [2].
s --> l(1), s, r(1).
s --> l(0), s, r(0).

l(Num) --> [Num].
r(Num) --> [Num].


%Question 2
%Defines the neighbourhood, and the conditions to be met

nbd --> h(Col1, Nat1, Pet1), h(Col2, Nat2, Pet2), h(Col3, Nat3, Pet3), 
    {Col1\=Col2, Col1\=Col3, Col2\=Col3, 
    Nat1\=Nat2, Nat1\=Nat3, Nat2\=Nat3, 
    Pet1\=Pet2, Pet1\=Pet3, Pet2\=Pet3}.
%Defines a house
h(Col, Nat, Pet) --> [h(Col, Nat, Pet)],
    {
        (Col = red; Col = blue; Col = green),
      	(Nat = english; Nat = japanese; Nat = spanish),
      	(Pet = snail; Pet = jaguar; Pet = zebra)
    }.


%Question 3
%Part 1
accept(L) :- steps(q0,L,F), final(F).
steps(Q,[],Q).
steps(Q,[H|T],Q2) :- tran(Q,H,Qn), steps(Qn,T,Q2).

tran(q0, 0, q0).
tran(q0, 1, q0).
tran(q0, 0, q1).
tran(q0, 1, q1).

tran(q1, 1, q2).
tran(q2, 0, q3).
tran(q2, 1, q3).
tran(q3, 0, q4).
tran(q3, 1, q4).
final(q4).

%Part 2

q0 --> [0], q0.
q0 --> [1], q0.
q0 --> [0], q1.
q0 --> [1], q1.
    
  
q1 --> [1], q2.
q2 --> [0], q3.
q2 --> [1], q3.
q3 --> [0], q4.
q3 --> [1], q4.
q4 --> [].

%Part 3

numeral(0).
numeral(succ(X)) :- numeral(X).

string_length([], 0).
string_length([_|T], succ(X)) :- string_length(T, X), numeral(X).

l3([1,0,0], succ(succ(succ(0)))).
l3([1,0,1], succ(succ(succ(0)))).
l3([1,1,0], succ(succ(succ(0)))).
l3([1,1,1], succ(succ(succ(0)))).


l3([0|T], succ(X)) :- string_length(T, X), X\=0, X\=succ(0), l3(T,X).
l3([1|T], succ(X)) :- string_length(T, X), X\=0, X\=succ(0), l3(T,X).
    
    

