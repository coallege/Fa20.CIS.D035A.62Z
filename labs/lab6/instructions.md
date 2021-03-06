# lab6 instructions

This assignment is build using your code from Assignment 5.

Req 1 - Create a custom exception handler class called StudentGradingException
that can (add this functionality in a package called exception)

- Centralize capture of all exceptions
- Logs exceptions in a text file.
- Fix at least one exception.

Demonstrate the usage of exception handler in a driver, throwing, logging and
fixing the exception. Put this in a separate driver called Driver1. java.
(Put this in driver package)

Req 2 - Deliver the grade for each student in a serialized file.
((add this functionality in a package called util and place the FileIO class in util package)
HINT: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
(Links to an external site.)

Imagine you are getting your grade report in a serialized file. This will
contain your id, lab scores and high, low and avg for each quiz.

You should create a new class called StudentGrade
(that contains Student and Statistics), then write a method to serialize
StudentGrade in FileIO class.

Demonstrate serializing StudentGrade object in a separate driver called Driver2.
java.  (Put this in driver package)

Req 3 - Implement abstract class and Interface (add this functionality in a
package called adapter)

Create an API (A programming interface) to

- Print student statistics
- Print score for a given student id

You should create an Interface called StudentAPI in which two methods are
declared for functionality (Req 3 - 1 and 2) stated above.

You should create a class StudentAPIImpl that would implement StudentAPI. Using
methods from other classes,
(Student.java, Statistics.java, StudentGrade.java, FileIO.java) implement the
two methods in StudentAPI.

Create a driver demonstrating the usage of the API. Put this in a separate
driver called Driver3. java.  (Put this in driver package)
