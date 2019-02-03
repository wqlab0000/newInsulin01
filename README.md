# newInsulin01

srcbdd a is bdd version java source code file and 

srckey a is Java+JML KeY tool source code file.

The project is still ongoing...

For learning about BDD used in srcbdd file, visit https://dannorth.net/introducing-bdd/
or learning from the book called BDD in Action. https://www.manning.com/books/bdd-in-action

For using the srckey file, you need to download KeY tool first from https://www.key-project.org/.
For further learning of KeY tool and JML, visit https://www.key-project.org/.

For understanding this, you need you learn cucumber tutorial https://docs.cucumber.io/guides/10-minute-tutorial/

InsulinPump.java describes, 
if the precondition of insulin pump is off, when turn on the insulin pump, 
then the postcodition is delivering basal does insulin.
If the precondition of insulin pump is empty, when turn on the insulin pump, 
then the postcodition is delivering basal does insulin.

For using the the KeY tool to verify the code, 
we need to use InsulinPump.java in srckey file.




