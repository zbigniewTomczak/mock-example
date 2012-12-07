mock-example
============

Maven example project for testing using mocks.
It presents very simple example taken from Roy Osherove video "Understanding Mock Objects".
The example is ported to Java and is presented using:
- manual mocking
- EasyMock and
- Mockito frameworks

The interaction being tested is that LoginManager calls to log during login.
There are 3 tests that shoud pass after running simple
    mvn test
