# lab6 instructions that actually make sense

For this lab, you're going to be building off of the previous lab.
Some of these things seem pointless (because they are) but they're there to make
you ~~suffer~~ demonstrate your understanding of several key concepts:

- try-catch
- exception handling
- file io
- packages
- serialization
- APIs

## Requirement 1

Create a class `exception.StudentGradingException`.

- Somehow it's supposed to "centralize" the capture of all exceptions haha
- Log all of the exceptions into a text file
- The exception itself is supposed to fix... an exception

Good fucking luck, kiddo.

Also, it's apparently supposed to go in a `driver.Driver1.java`

## Requirement 2

Remember that `Student` class you made last lab?
Well yeah, serialize it.
I think you probably wanna `implement Serializable` in the `Student` and use
another class that you're supposed to make called `util.FileIO` to write it out.
The serialized thing should contain:

- student id
- scores array
- high score
- avg score
- low score

We just want to waste disk space with those last three because it's funny.
RIP third normal form.

### Requirement 2, part 2

Hahaha! You thought it was over?
Nope! Make *another* `driver.Driver2` class and serialize the student.

## Requirement 3

- Implement an abstract class
- Implement an interface

For what? HahahahahahAHAHAHA! Do we look like we have *any* fucking idea?
You're the programmer! You demonstrate making an "API".

Ok JK just separate the Interface from the impl with the above items for no reason.

## layout

- Driver
	- Driver1.java
- Adapter
	- StudentAPI.java
