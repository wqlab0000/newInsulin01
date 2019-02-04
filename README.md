# newInsulin01
srckey a is Java+JML KeY tool source code file.

The project is still ongoing...

BDD is a Behavior Driven Development Agile method for software development.
The advantages of BDD is, in a project, developers, testers, product managers are working together to
write the requirment document. Then use this document to translate to gherkin syntax.
For learning about BDD used in srcbdd file, visit https://dannorth.net/introducing-bdd/
or learning from the book called BDD in Action. https://www.manning.com/books/bdd-in-action

The KeY tool is used in formal verification of Java+JML (Java Modeling Language to Java source files) programs. 
These are transformed into theorems of dynamic logic and then compared against program semantics that are likewise defined in terms of dynamic logic. 
KeY generates a fully automated correctness proof, the failed proof attempts can be used for a more efficient debugging or verification-based testing. 
For using the srckey file, you need to download KeY tool first from https://www.key-project.org/.
For further learning of KeY tool and JML, visit https://www.key-project.org/.

For understanding this, you need you learn cucumber tutorial https://docs.cucumber.io/guides/10-minute-tutorial/

InsulinPump.java describes, 
if the precondition of insulin pump is off, when turn on the insulin pump, 
then the postcodition is delivering basal does insulin.
If the precondition of insulin pump is empty, when turn on the insulin pump, 
then the postcodition is delivering basal does insulin.

For assigning basalDose or noDose a value,
we can use String methods below. 
 
 private String basalDose=String.valueOf(0.5);
 
 private String noDose=String.valueOf(0);


For using the the KeY tool to verify the code, 
we need to use InsulinPump.java in srckey file.




