incr(null, f1(null)).
incr(f0(P1), f1(P1)).
incr(f1(P1), f0(P2)) :- incr(P1,P2).


legal(f0(null)).
legal(P1) :- legal(P2), incr(P2,P1).

incrR(X,Y) :- legal(X), incr(X,Y).

add(f0(null), A, A).
add(A, B, C) :- incr(P1, A), add(P1, B, P2), incr(P2, C).

mult(f1(null), A, A).
mult(A, B, C) :- incr(P1, A), mult(P1, B, P2), add(B, P2, C).

revers(P, RevP) :- reverse(P, null, RevP).
reverse(null, P, P).
reverse(f0(P), A, RevP) :- reverse(P, f0(A), RevP).
reverse(f1(P), B, RevP) :- reverse(P, f1(B), RevP).
