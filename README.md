Name the two patterns you wish to implement and explain what advantages you hope to achieve with them.:
  Decorator Pattern: I hope to achieve to add new a function to the program (converting dollars to pennies, quarters, nickels, or dimes).
Describe how you implement the patterns, including additional interfaces, classes, and how these will integrate with the classes that you already have.
Implement the changes.
  Decorator Pattern:
    I created a abstract class (Conversion) to define the functions and variables I wanted to use, then created a Change class as a template for the decorators. Then I created a ConDecorator abstract class that extends the Conversion class
    to work as a "middle man" for the base class and decorator classes. Then I created the decorator classes (toPennies, toNickel, toDimes, toQuarters) that extends to the ConDecorator class so that they would have access to the Conversion and Change class. 
    Each conversion made in convert() in the decorator class overrides the convert() in the Change class. 
    For the GUI, I created another textbox and label for the conversion. I inserted a base Change object into RegisterPanel and inserted the object into the decorator patterns in to do the conversion based on user choice (drop down menu). 
  
