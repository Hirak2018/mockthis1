# mockthis1

Steps with a sample program
This is a javaagent based framework , so you have to add the downloaded mockthis.jar to the program argument. (either in program argument of IDE or in command line)

-javaagent:path\to\jar\mockthis.jar
Code
Lets say we have a source class named Example. And we want to mock the greetings() method.

public class Example {
  public String greetings(){
   return "Merry Christmas!";
 }
}


In our test class we need to annotate an instance(could remain as unused instance in the test) of Example class with @Mockthis. And the annotation parameter "method" holds the method to be mocked. The returned object is defined within the static block with AhamockHolder.obj. We can pass any object that is in compliance the the return type of the method to be mocked.

public class ExampleTest {
  @Mockthis(method = "greetings")
  Example example;

  static {
   AhamockHolder.obj = "Hello Coder!";
  }

  @Test
  public void test_my_framework() {
   Example example = new Example();
   System.out.println(example.greetings());
   Assert.assertEquals("Hello Coder!", example.greetings());
  }
 }

Test passes and outputs to

Hello Coder!