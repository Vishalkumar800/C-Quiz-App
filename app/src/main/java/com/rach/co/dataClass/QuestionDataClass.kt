package com.rach.co.dataClass

data class QuestionDataClass(
    val id: Long = 0L,
    val title: String = "",
    val numberOfQuestion: String = "",
    val questionList: List<QuestionModel> = emptyList()
)

data class QuestionModel(
    val question: String = "",
    val correct: String = "",
    val option: List<String> = emptyList()
)

object DummyQuestionData {
    val itemList = listOf(
        QuestionDataClass(
            id = 1L,
            title = "Basics of C++",
            numberOfQuestion = "15",
            questionList = listOf(
                QuestionModel(
                    question = "Who is the father of C++?",
                    correct = "Bjarne Stroustrup",
                    option = listOf("James Gosling", "Bjarne Stroustrup", "Dennis Ritchie", "Guido van Rossum")
                ),
                QuestionModel(
                    question = "What is the extension of a C++ source file?",
                    correct = ".cpp",
                    option = listOf(".cpp", ".c", ".h", ".java")
                ),
                QuestionModel(
                    question = "What is the purpose of 'namespace' in C++?",
                    correct = "Avoiding name conflicts",
                    option = listOf("For inheritance", "Avoiding name conflicts", "Defining functions", "Encapsulation")
                ),
                QuestionModel(
                    question = "What does 'cin' represent in C++?",
                    correct = "Input stream",
                    option = listOf("Output stream", "Input stream", "Variable", "Keyword")
                ),
                QuestionModel(
                    question = "Which operator is used for accessing members in a class?",
                    correct = ".",
                    option = listOf(".", "::", "->", ".*")
                ),
                QuestionModel(
                    question = "What is the default access modifier in a C++ class?",
                    correct = "Private",
                    option = listOf("Public", "Private", "Protected", "None")
                ),
                QuestionModel(
                    question = "What is the correct syntax for a single-line comment in C++?",
                    correct = "//",
                    option = listOf("//", "/* */", "#", "--")
                ),
                QuestionModel(
                    question = "Which header file is used for standard input/output operations?",
                    correct = "<iostream>",
                    option = listOf("<iostream>", "<stdio.h>", "<fstream>", "<sstream>")
                ),
                QuestionModel(
                    question = "What is the purpose of the 'return' statement in C++?",
                    correct = "To exit a function and optionally return a value",
                    option = listOf("To exit the program", "To define a function", "To exit a function and optionally return a value", "To create an object")
                ),
                QuestionModel(
                    question = "What is the purpose of the 'main()' function in C++?",
                    correct = "Entry point of the program",
                    option = listOf("Define variables", "Entry point of the program", "Initialize classes", "Define loops")
                ),
                QuestionModel(
                    question = "What is the output of 'cout << 2 + 3;'?",
                    correct = "5",
                    option = listOf("23", "5", "Error", "Undefined")
                ),
                QuestionModel(
                    question = "Which keyword is used to declare a constant in C++?",
                    correct = "const",
                    option = listOf("static", "final", "const", "constexpr")
                ),
                QuestionModel(
                    question = "What is the role of 'using namespace std;'?",
                    correct = "To avoid prefixing std::",
                    option = listOf("To include libraries", "To avoid prefixing std::", "To define namespaces", "To create templates")
                ),
                QuestionModel(
                    question = "What is the size of a 'char' data type in C++?",
                    correct = "1 byte",
                    option = listOf("1 byte", "2 bytes", "4 bytes", "Depends on the system")
                ),
                QuestionModel(
                    question = "What is the purpose of a semicolon ';' in C++?",
                    correct = "To terminate a statement",
                    option = listOf("To separate arguments", "To terminate a statement", "To define variables", "To create loops")
                )
            )
        ),
        QuestionDataClass(
            id = 2L,
            title = "Data Types and Variables in C++",
            numberOfQuestion = "15",
            questionList = listOf(
                QuestionModel(
                    question = "Which of these is a primitive data type in C++?",
                    correct = "int",
                    option = listOf("set", "int", "list", "map")
                ),
                QuestionModel(
                    question = "What is the default value of an uninitialized 'int' variable?",
                    correct = "Garbage value",
                    option = listOf("0", "Garbage value", "NULL", "Undefined")
                ),
                QuestionModel(
                    question = "Which of these is a valid declaration of a variable in C++?",
                    correct = "int a;",
                    option = listOf("int a;", "variable int a;", "int : a", "var int a;")
                ),
                QuestionModel(
                    question = "What is the size of 'float' on a 32-bit system?",
                    correct = "4 bytes",
                    option = listOf("2 bytes", "4 bytes", "8 bytes", "Depends on the system")
                ),
                QuestionModel(
                    question = "Which keyword is used to define a variable that cannot be modified?",
                    correct = "const",
                    option = listOf("static", "final", "const", "immutable")
                ),
                QuestionModel(
                    question = "Which of these is a user-defined data type?",
                    correct = "struct",
                    option = listOf("struct", "int", "double", "char")
                ),
                QuestionModel(
                    question = "What is the range of 'int' on a 16-bit system?",
                    correct = "-32,768 to 32,767",
                    option = listOf("-32,768 to 32,767", "-65,536 to 65,535", "-128 to 127", "0 to 65,535")
                ),
                QuestionModel(
                    question = "What does 'sizeof' operator return?",
                    correct = "Size of a variable or data type in bytes",
                    option = listOf("Memory address", "Data type", "Size of a variable or data type in bytes", "None")
                ),
                QuestionModel(
                    question = "Which data type would you use for a variable storing a single character?",
                    correct = "char",
                    option = listOf("int", "char", "string", "float")
                ),
                QuestionModel(
                    question = "Which of these is a floating-point literal?",
                    correct = "3.14",
                    option = listOf("3", "3.14", "'a'", "\"string\"")
                ),
                QuestionModel(
                    question = "What is the value of 'true' in a boolean data type?",
                    correct = "1",
                    option = listOf("0", "1", "-1", "true")
                ),
                QuestionModel(
                    question = "Which keyword is used to define a global constant?",
                    correct = "constexpr",
                    option = listOf("const", "static", "constexpr", "global")
                ),
                QuestionModel(
                    question = "What is the purpose of the 'auto' keyword in C++?",
                    correct = "To deduce the data type automatically",
                    option = listOf("Define variables globally", "Create templates", "To deduce the data type automatically", "Allocate memory dynamically")
                ),
                QuestionModel(
                    question = "What is the size of 'bool' on most systems?",
                    correct = "1 byte",
                    option = listOf("1 byte", "2 bytes", "4 bytes", "System dependent")
                ),
                QuestionModel(
                    question = "Which of these is not a valid variable name?",
                    correct = "2value",
                    option = listOf("value_2", "_value", "2value", "value2")
                )
            )
        ),

        QuestionDataClass(
            id = 3L,
            title = "Control Structures in C++",
            numberOfQuestion = "15",
            questionList = listOf(
                QuestionModel(
                    question = "What is the purpose of an 'if' statement in C++?",
                    correct = "To execute code conditionally",
                    option = listOf("To create loops", "To execute code conditionally", "To declare variables", "To define functions")
                ),
                QuestionModel(
                    question = "Which of the following is the correct syntax for a 'for' loop?",
                    correct = "for(int i = 0; i < 10; i++)",
                    option = listOf("for(i=0; i<10; i++)", "for(int i = 0; i < 10; i++)", "for(int i = 10 to 0)", "for(int i; i++)")
                ),
                QuestionModel(
                    question = "What will happen if the condition in a 'while' loop is always true?",
                    correct = "Infinite loop",
                    option = listOf("No iteration", "Infinite loop", "Compile-time error", "None of these")
                ),
                QuestionModel(
                    question = "Which keyword is used to exit a loop prematurely in C++?",
                    correct = "break",
                    option = listOf("break", "exit", "stop", "return")
                ),
                QuestionModel(
                    question = "What does the 'continue' keyword do in a loop?",
                    correct = "Skips the rest of the current iteration and continues with the next iteration",
                    option = listOf("Exits the loop", "Restarts the loop", "Skips the rest of the current iteration", "Skips the loop entirely")
                ),
                QuestionModel(
                    question = "Which of these loops always executes at least once?",
                    correct = "do-while",
                    option = listOf("for", "while", "do-while", "None of these")
                ),
                QuestionModel(
                    question = "Which operator is used in a switch case to separate the case value from the statements?",
                    correct = ":",
                    option = listOf(";", ":", "::", "=")
                ),
                QuestionModel(
                    question = "What is the default value of a 'switch' case if no match is found?",
                    correct = "default case is executed if provided",
                    option = listOf("Program crashes", "default case is executed if provided", "Compiler error", "None of these")
                ),
                QuestionModel(
                    question = "What is the output of the following code? \n\nint x = 5; \nif(x > 3) cout << 'Yes'; else cout << 'No';",
                    correct = "Yes",
                    option = listOf("Yes", "No", "Compiler error", "Undefined")
                ),
                QuestionModel(
                    question = "Which of these is not a valid loop structure in C++?",
                    correct = "repeat-until",
                    option = listOf("for", "while", "do-while", "repeat-until")
                ),
                QuestionModel(
                    question = "Which statement is used to skip the current iteration in a loop?",
                    correct = "continue",
                    option = listOf("break", "skip", "continue", "return")
                ),
                QuestionModel(
                    question = "Which loop is most suitable for traversing arrays?",
                    correct = "for",
                    option = listOf("while", "do-while", "for", "switch")
                ),
                QuestionModel(
                    question = "What will be the output of the following code?\n\nfor(int i=0; i<5; i++) {\n  if(i == 3) break;\n  cout << i;\n}",
                    correct = "012",
                    option = listOf("0123", "012", "123", "None of these")
                ),
                QuestionModel(
                    question = "Which of these allows you to execute multiple conditions in sequence?",
                    correct = "if-else ladder",
                    option = listOf("if-else ladder", "do-while", "break-continue", "for")
                ),
                QuestionModel(
                    question = "Which of these is the correct syntax for a ternary operator in C++?",
                    correct = "condition ? expr1 : expr2",
                    option = listOf("condition ? expr1 : expr2", "expr1 ? expr2 : condition", "expr1 : expr2 ? condition", "expr1 ? condition : expr2")
                )
            )
        ),
        QuestionDataClass(
            id = 4L,
            title = "Functions in C++",
            numberOfQuestion = "15",
            questionList = listOf(
                QuestionModel(
                    question = "What is the correct syntax to define a function in C++?",
                    correct = "returnType functionName(parameters) { body }",
                    option = listOf("returnType functionName(parameters) { body }", "function returnType(parameters) { body }", "function(parameters) returnType { body }", "returnType { body } functionName(parameters)")
                ),
                QuestionModel(
                    question = "What is the purpose of a function prototype?",
                    correct = "To declare the function before its definition",
                    option = listOf("To define the function", "To call the function", "To declare the function before its definition", "None of these")
                ),
                QuestionModel(
                    question = "What is the correct way to return multiple values from a function in C++?",
                    correct = "Using a struct, class, or pair",
                    option = listOf("Return them directly", "Using a struct, class, or pair", "Using multiple return statements", "C++ does not support this")
                ),
                QuestionModel(
                    question = "What does 'void' return type signify in a function?",
                    correct = "The function does not return any value",
                    option = listOf("The function does not return any value", "The function returns void", "The function is optional", "None of these")
                ),
                QuestionModel(
                    question = "Which keyword is used to pass a variable by reference?",
                    correct = "&",
                    option = listOf("*", "&", "@", "^")
                ),
                QuestionModel(
                    question = "Which of these is a valid function call for the function int add(int a, int b)?",
                    correct = "add(5, 10);",
                    option = listOf("add(5, 10);", "add();", "add(int a, int b);", "int add(5, 10);")
                ),
                QuestionModel(
                    question = "What is the output of the following code?\n\nint sum(int a, int b) { return a+b; } \ncout << sum(3, 4);",
                    correct = "7",
                    option = listOf("34", "7", "Error", "Undefined")
                ),
                QuestionModel(
                    question = "What is a recursive function?",
                    correct = "A function that calls itself",
                    option = listOf("A function that calls another function", "A function that calls itself", "A function that runs continuously", "None of these")
                ),
                QuestionModel(
                    question = "What is the default return type of a function in C++ if not specified?",
                    correct = "int",
                    option = listOf("void", "int", "float", "None")
                ),
                QuestionModel(
                    question = "What is function overloading in C++?",
                    correct = "Defining multiple functions with the same name but different parameters",
                    option = listOf("Defining multiple functions with the same name", "Defining multiple functions with the same name but different parameters", "Using a function as a class", "Calling a function multiple times")
                ),
                QuestionModel(
                    question = "Which keyword is used to prevent a function from being overridden?",
                    correct = "final",
                    option = listOf("final", "override", "static", "constant")
                ),
                QuestionModel(
                    question = "What is the purpose of a default argument in a function?",
                    correct = "To provide a default value if no argument is passed",
                    option = listOf("To provide a default value if no argument is passed", "To handle errors", "To initialize a function", "None of these")
                ),
                QuestionModel(
                    question = "What is an inline function in C++?",
                    correct = "A function that is expanded in place at the call site",
                    option = listOf("A function that is private", "A function that is defined inline in the main()", "A function that is expanded in place at the call site", "A function that calls itself")
                ),
                QuestionModel(
                    question = "What is the scope of a local variable in a function?",
                    correct = "Inside the function only",
                    option = listOf("Inside the function only", "Inside the program", "Inside the class", "None of these")
                ),
                QuestionModel(
                    question = "Which keyword is used to declare a function without implementation?",
                    correct = "virtual or pure virtual",
                    option = listOf("abstract", "pure", "virtual or pure virtual", "inline")
                )
            )
        ),
        QuestionDataClass(
            id = 5L,
            title = "Inheritance and Polymorphism in C++",
            numberOfQuestion = "15",
            questionList = listOf(
                QuestionModel(
                    question = "What is inheritance in C++?",
                    correct = "A mechanism to derive a class from another class",
                    option = listOf(
                        "A mechanism to access private members of a class",
                        "A mechanism to derive a class from another class",
                        "A mechanism for memory allocation",
                        "A mechanism to overload operators"
                    )
                ),
                QuestionModel(
                    question = "Which keyword is used to create a derived class?",
                    correct = ": (colon)",
                    option = listOf("inherit", "class", ": (colon)", "extends")
                ),
                QuestionModel(
                    question = "What is the base class in inheritance?",
                    correct = "The class from which properties are inherited",
                    option = listOf(
                        "The class which cannot be inherited",
                        "The class from which properties are inherited",
                        "A private class",
                        "A class with no constructors"
                    )
                ),
                QuestionModel(
                    question = "Which type of inheritance allows a class to inherit from multiple classes?",
                    correct = "Multiple inheritance",
                    option = listOf(
                        "Single inheritance",
                        "Multiple inheritance",
                        "Hierarchical inheritance",
                        "Multilevel inheritance"
                    )
                ),
                QuestionModel(
                    question = "What is a virtual function in C++?",
                    correct = "A function that can be overridden in derived classes",
                    option = listOf(
                        "A function that is defined in all classes",
                        "A function that can be overridden in derived classes",
                        "A function that is private",
                        "None of these"
                    )
                ),
                QuestionModel(
                    question = "What does the keyword 'override' signify in C++?",
                    correct = "It indicates that a function is overriding a base class function",
                    option = listOf(
                        "It creates a new function",
                        "It is used for constructors",
                        "It indicates that a function is overriding a base class function",
                        "None of these"
                    )
                ),
                QuestionModel(
                    question = "What is the purpose of the 'protected' access modifier?",
                    correct = "Allows access to members within the class and its derived classes",
                    option = listOf(
                        "Allows access only within the class",
                        "Allows global access",
                        "Allows access to members within the class and its derived classes",
                        "Allows access only to static members"
                    )
                ),
                QuestionModel(
                    question = "What is a pure virtual function in C++?",
                    correct = "A virtual function with no implementation in the base class",
                    option = listOf(
                        "A function that is not inherited",
                        "A function with a private implementation",
                        "A virtual function with no implementation in the base class",
                        "A static function"
                    )
                ),
                QuestionModel(
                    question = "What is an abstract class?",
                    correct = "A class that has at least one pure virtual function",
                    option = listOf(
                        "A class with no members",
                        "A class that is always private",
                        "A class that has at least one pure virtual function",
                        "A class with only static members"
                    )
                ),
                QuestionModel(
                    question = "What is function overriding?",
                    correct = "Redefining a base class function in the derived class",
                    option = listOf(
                        "Creating multiple constructors",
                        "Redefining a base class function in the derived class",
                        "Defining multiple functions in one class",
                        "None of these"
                    )
                ),
                QuestionModel(
                    question = "What is the purpose of the 'virtual' keyword?",
                    correct = "Allows a function to be overridden in derived classes",
                    option = listOf(
                        "Allows a function to be overridden in derived classes",
                        "Defines a private function",
                        "Allows global access",
                        "None of these"
                    )
                ),
                QuestionModel(
                    question = "What is a vtable in C++?",
                    correct = "A table of pointers to virtual functions",
                    option = listOf(
                        "A memory table for objects",
                        "A table of constructors",
                        "A table of pointers to virtual functions",
                        "A static table for classes"
                    )
                ),
                QuestionModel(
                    question = "Which type of inheritance can lead to the diamond problem?",
                    correct = "Multiple inheritance",
                    option = listOf(
                        "Single inheritance",
                        "Multilevel inheritance",
                        "Multiple inheritance",
                        "Hierarchical inheritance"
                    )
                ),
                QuestionModel(
                    question = "What is runtime polymorphism?",
                    correct = "Achieved through virtual functions",
                    option = listOf(
                        "Achieved using static functions",
                        "Achieved through function overloading",
                        "Achieved through virtual functions",
                        "None of these"
                    )
                ),
                QuestionModel(
                    question = "What is the difference between function overloading and overriding?",
                    correct = "Overloading is in the same class; overriding involves base and derived classes",
                    option = listOf(
                        "Overloading requires inheritance",
                        "Overloading occurs in derived classes",
                        "Overloading is in the same class; overriding involves base and derived classes",
                        "None of these"
                    )
                )
            )
        ),
        QuestionDataClass(
            id = 5L,
            title = "Object-Oriented Programming in C++",
            numberOfQuestion = "15",
            questionList = listOf(
                QuestionModel(
                    question = "What is the key principle of object-oriented programming?",
                    correct = "Encapsulation, Inheritance, and Polymorphism",
                    option = listOf(
                        "Encapsulation, Abstraction, and Structs",
                        "Inheritance, Functions, and Loops",
                        "Encapsulation, Inheritance, and Polymorphism",
                        "Pointers, Classes, and Loops"
                    )
                ),
                QuestionModel(
                    question = "Which keyword is used to create a class in C++?",
                    correct = "class",
                    option = listOf("struct", "class", "object", "new")
                ),
                QuestionModel(
                    question = "What is an object in C++?",
                    correct = "An instance of a class",
                    option = listOf("A variable", "An instance of a class", "A function", "A block of code")
                ),
                QuestionModel(
                    question = "What is the purpose of the 'private' access modifier in a class?",
                    correct = "Restricts access to class members from outside the class",
                    option = listOf(
                        "Allows global access to class members",
                        "Restricts access to class members from outside the class",
                        "Specifies the members can be inherited only",
                        "None of these"
                    )
                ),
                QuestionModel(
                    question = "What is a constructor in C++?",
                    correct = "A special function called automatically when an object is created",
                    option = listOf(
                        "A function used to initialize a program",
                        "A special function called automatically when an object is created",
                        "A destructor for a class",
                        "A function for allocating memory"
                    )
                ),
                QuestionModel(
                    question = "Which operator is used to access members of a class using an object?",
                    correct = ". (dot operator)",
                    option = listOf(":: (scope resolution)", ". (dot operator)", "-> (arrow operator)", "* (pointer operator)")
                ),
                QuestionModel(
                    question = "What is a destructor in C++?",
                    correct = "A function called automatically when an object is destroyed",
                    option = listOf(
                        "A function to deallocate memory manually",
                        "A function to initialize objects",
                        "A function called automatically when an object is destroyed",
                        "None of these"
                    )
                ),
                QuestionModel(
                    question = "Which of these is an example of encapsulation?",
                    correct = "Wrapping data and methods into a single unit",
                    option = listOf(
                        "Creating multiple objects",
                        "Wrapping data and methods into a single unit",
                        "Inheriting a class",
                        "Using multiple functions"
                    )
                ),
                QuestionModel(
                    question = "What is the difference between a struct and a class in C++?",
                    correct = "By default, struct members are public, and class members are private",
                    option = listOf(
                        "Structs are for smaller programs",
                        "Structs can only store data; classes have functions",
                        "By default, struct members are public, and class members are private",
                        "Classes cannot be inherited; structs can"
                    )
                ),
                QuestionModel(
                    question = "What is an inline member function in a class?",
                    correct = "A function whose definition is directly written inside the class",
                    option = listOf(
                        "A function that can only be accessed inside the class",
                        "A function defined using the keyword 'inline'",
                        "A function whose definition is directly written inside the class",
                        "A global function"
                    )
                ),
                QuestionModel(
                    question = "What does 'this' pointer represent in C++?",
                    correct = "The current object of the class",
                    option = listOf(
                        "A pointer to the base class",
                        "The current object of the class",
                        "The memory location of a class",
                        "A pointer to all objects of a class"
                    )
                ),
                QuestionModel(
                    question = "What is the purpose of the 'friend' keyword in C++?",
                    correct = "To allow a function or another class to access private members of a class",
                    option = listOf(
                        "To make a class global",
                        "To define a public class",
                        "To allow a function or another class to access private members of a class",
                        "To inherit private members"
                    )
                ),
                QuestionModel(
                    question = "Which of these is an example of dynamic memory allocation in a class?",
                    correct = "Using 'new' keyword inside the class",
                    option = listOf(
                        "Using 'malloc' function",
                        "Using 'delete' keyword",
                        "Using 'new' keyword inside the class",
                        "Using global variables"
                    )
                ),
                QuestionModel(
                    question = "What is the difference between shallow copy and deep copy?",
                    correct = "Shallow copy copies references; deep copy duplicates the actual data",
                    option = listOf(
                        "Shallow copy is slower",
                        "Shallow copy copies references; deep copy duplicates the actual data",
                        "Deep copy is a default behavior",
                        "None of these"
                    )
                ),
                QuestionModel(
                    question = "What is the purpose of static members in a class?",
                    correct = "They are shared among all objects of the class",
                    option = listOf(
                        "They are private to a specific object",
                        "They are shared among all objects of the class",
                        "They are destroyed with each object",
                        "None of these"
                    )
                )
            )
        )




    )
}

