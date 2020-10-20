%take the query and return the succesor
%base clauses
incr(null, f1(null)).
incr(f0(P1), f1(P1)).
%recursive clause
incr(f1(P1), f0(P2)) :- incr(P1,P2).

%take in the query, continue checking the legality while incrementing for the output
legal(f0(null)).
legal(P1) :- legal(P2), incr(P2,P1).

%take the query and reutrn the next succesor every time, checking legality
incrR(X,Y) :- legal(X), incr(X,Y).

%take the query and return the sum
%base clause
add(f0(null), A, A).
%recursive clause
add(A, B, C) :- incr(P1, A), add(P1, B, P2), incr(P2, C).

%take the query and return the multiple
mult(f1(null), A, A).
mult(A, B, C) :- incr(P1, A), mult(P1, B, P2), add(B, P2, C).

%reverse the query string to find the answer
revers(P, RevP) :- reverser(P, null, RevP).
reverser(null, P, P).
reverser(f0(P), A, RevP) :- reverser(P, f0(A), RevP).
reverser(f1(P), B, RevP) :- reverser(P, f1(B), RevP).

%take the query and normalize it
normalize(null, f0(null)).
normalize(f0(null), f0(null)).
normalize(P1, P2) :- revers(P1, P3), remove(P3, X), revers(X, P2).

%remove the f0's from the query 
remove(f1(A), f1(A)).
remove(f0(A), X) :- remove(A, X).


%test functions copied from assignment sheet
% test add inputting numbers N1 and N2
testAdd(N1,N2,T1,T2,Sum,SumT) :- numb2pterm(N1,T1), numb2pterm(N2,T2),
add(T1,T2,SumT), pterm2numb(SumT,Sum).
3
% test mult inputting numbers N1 and N2
testMult(N1,N2,T1,T2,N1N2,T1T2) :- numb2pterm(N1,T1), numb2pterm(N2,T2),
mult(T1,T2,T1T2), pterm2numb(T1T2,N1N2).
% test revers inputting list L
testRev(L,Lr,T,Tr) :- ptermlist(T,L), revers(T,Tr), ptermlist(Tr,Lr).
% test normalize inputting list L
testNorm(L,T,Tn,Ln) :- ptermlist(T,L), normalize(T,Tn), ptermlist(Tn,Ln).
% make a pterm T from a number N numb2term(+N,?T)
numb2pterm(0,f0(null)).
numb2pterm(N,T) :- N>0, M is N-1, numb2pterm(M,Temp), incr(Temp,T).
% make a number N from a pterm T pterm2numb(+T,?N)
pterm2numb(null,0).
pterm2numb(f0(X),N) :- pterm2numb(X,M), N is 2*M.
pterm2numb(f1(X),N) :- pterm2numb(X,M), N is 2*M +1.
% reversible ptermlist(T,L)
ptermlist(null,[]).
ptermlist(f0(X),[0|L]) :- ptermlist(X,L).
ptermlist(f1(X),[1|L]) :- ptermlist(X,L).
