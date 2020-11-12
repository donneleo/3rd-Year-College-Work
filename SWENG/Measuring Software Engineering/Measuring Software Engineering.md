# CSU33012 – Software Engineering
## Assignment 3 – Measuring Software Engineering

“From a more abstract point of view, the goal of software measurement is to build and validate hypotheses and increase the body of knowledge about software engineering” (Morasca, n.d.). There isn’t a company in the world who do not evaluate the performance and production of their workers. The use of metrics can allow for management to clearly see how effective a worker has been over a period of time. In some cases, this may be the number of units produced or the number of tables served. However, measuring software engineering is complex also in that there may not be a uniform standard for what needs to be measured. The use of normal metric such as these are not applicable to the world of software engineering, where projects can vary between taking place over a number of weeks or months to create large scale applications, to taking place over a single day in order to fix small bugs and errors.

In this paper, we will explore some of the new technologies and methodologies which are being used to measure software engineering, the platforms being used to measure and the ethical aspects of using some of these technologies.

## Method of yesteryear

Counting the number of lines of code is a method that has been employed for many years but carries with it many flaws. “Source Lines of Code (SLOC or LOC) is one of the most widely used sizing metric in industry and literature” (Nguyen, et.al, 2007). However, there is often confusion regarding what constitutes a “source line of code”.  Measuring engineers on the number of lines od code they write can lead to serious issues of inefficiency. For example:

    if(num%2 == 0)
    {
      print(“Number is Even.”)
    }

is correct and is equivalent to four physical SLOC. However, this simple statement can be simplified down to one physical SLOC:

    if(num%2 ==0) print(“Number is Even.”);

While the two functions perform the same task, the physical number of lines makes the first piece of code less efficient. By measuring software engineers on the number of SLOC in their systems, it promotes the use of inefficient, unnecessarily long code, which, when applied to systems of a massive size, can lead to complications when trying to debug.  Another issue with counting SLOC, especially in the present day with new languages, such as Python, which can perform operations in fewer lines of code, is that programmers will be swayed away from using these more efficient languages. 

There are of course tools that exist that aid in the counting of these SLOC. In 2004, there were “at least 75 commercial software cost-estimating tools” (Jones, 2004). Again, however, these tools count the lines, and not the importance of the lines written for the programmes. Think for example, of writing the code for accepting payment on an e-commerce site. The code written for this function will most likely be less than that the of the whole site. So, by having the tool say that a particular engineer has written a proportionally small X% of code for the whole store, the code written is an integral piece to the system. 


## Bibliography

Morasca, S., n.d. Software Measurement. [pdf] Como: Università dell'Insubria Dipartimento di Scienze Chimiche, Fisiche e Matematiche. Available at: <https://www.uio.no/studier/emner/matnat/ifi/INF5181/h11/undervisningsmateriale/reading-materials/Lecture-06/morasca-handbook.pdf> [Accessed 11 November 2020].

Nguyen, V., Deeds-Rubin, S., Tan, T., Boehm, B., 2007, A SLOC Counting Standard, Center for Systems and Software Engineering University of Southern California, Available at: http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.550.8181&rep=rep1&type=pdf [Accessed 12 November 2020]

C. Jones. Software Project Management Practices: Failure Versus Success©, CrossTalk, The Journal of Defense Software Engineering, October, 2004.