%{
int comments = 0;
%}

%%

"**".*      {}
\".*\"      {printf("%s", yytext);}
"{"         {comments = 1;}
"}"         {if(comments == 0){ printf("syntax error\n"); return 0;} comments = 0;}
.           {if(comments == 0){ printf("%s", yytext);}}
\n          {if(comments == 0){ printf("%s", yytext);}}

%%

int main()
{
    yylex();
    if(comments == 1){printf("syntax error\n");}
    return 0;
}

{
    hello
}