%Question 1
s --> [2].
s --> l(1), s, r(1).
s --> l(0), s, r(0).

l(Num) --> [Num].
r(Num) --> [Num].


%Question 2
%Defines the neighbourhood, and the conditions to be met
nbd --> h(Col1,Nat1,Pet1), h(Col2,Nat2,Pet2), h(Col3,Nat3,Pet3), 
    {Col1\=Col2, Col1\=Col3, Col2\=Col3, 
    Nat1\=Nat2, Nat1\=Nat3, Nat2\=Nat3, 
    Pet1\=Pet2, Pet1\=Pet3, Pet2\=Pet3}.
%Defines a house
h(Col, Nat, Pet) --> col(Col), nat(Nat), pet(Pet).

%Conditions
col(red) --> [red].
col(blue) --> [blue].
col(green) --> [green].

nat(english) --> [english].
nat(japanese) --> [japanese].
nat(spanish) --> [spanish].

pet(snail) --> [snail].
pet(jaguar) --> [jaguar].
pet(zebra) --> [zebra].


%Question 3

