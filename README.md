# twitterFeeds
Twitter users and their twitter feeds

The projec is done on pure java with no frame work , I thought about using spring REST however based on the requirement that 
stipulated that I should print on the console then I decided against that idea of implementing spring REST.

Even though no frame work has been used the design structure conform to standard design practice.

The design strucuture of the project looks like below,

Resource  : Presentation layer only display tweets and users. 
Service   : Here is there business logic,here I have service classes to help implemnt the business logic  
Model     : Here I am modelling the data in this cas  modelling user.txt and tweet.txt to Java Object files(User and Tweet) 
Config    : Here we manage everything that could possible change without changing the actual code

The code like variables,methods are well documented with some code comments.
Where there is no comment you can read the code and understand what it does.
