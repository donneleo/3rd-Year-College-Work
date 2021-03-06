%{
    int current_year = 19;
    int oldStart = 87;
    int oldEnd = 12;
    int newStart = 13;
%}

NUMBER [0-9]{1,6}[ \t\n]+

OLDCOUNTY C|CE|CN|CW|D|DL|G|KE|KK|KY|KK|L|LK|LD|LH|LM|LS|MH|MN|MO|OY|RN|SO|TN|TS|W|WD|WH|WX|WW
NEWCOUNTY C|CE|CN|CW|D|DL|G|KE|KK|KY|L|LD|LH|LM|LS|MH|MN|MO|OY|RN|SO|T|W|WH|WX|WW

OLDYEAR ([0-9]{2})
NEWYEAR ([0-9]{2}[12])


%%
{OLDYEAR}(-){OLDCOUNTY}(-){NUMBER} {
                                	char yearStr[] = {yytext[0], yytext[1], '\0'}; 
                                    int year = atoi(yearStr);
                                    if(year >= 87)
                                        printf("%d\n", (100-year)+current_year);
                                    else if(year < 13)
                                        printf("%d\n", (current_year - year));
                                    else
                                        printf("INVALID\n");
                                    
                                   }

{NEWYEAR}(-){NEWCOUNTY}(-){NUMBER} {
                                char yearStr[] = { yytext[0], yytext[1], '\0' };
                                int year = atoi(yearStr);
                                if(year >= newStart && year <= current_year)
                                    printf("%d\n", current_year-year);
                                else
                                    printf("INVALID\n");
                               }

.+[\n]                           {printf("INVALID\n");}
\n                               {}

%%


int main()
{
    yylex();
    return 0;
}