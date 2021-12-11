# RS-Strategy

An implementation of the RS proof using decomposition Tree

## How to run

Use the Strategy class under com.uncc.IntelligentSystem spot the main class and add the express to be tested.

```java
boolean result = new Strategy("<Your expression goes here>")
                .cleanExp() //  This will clean the expression like trimming spaces, replacing operantor
                .normalize(false) // this will normalize the express to postfix
                .runStrategy(); // runs the strategy
```

if the polish expression is added please notify the algorithm via **normalize** method, set the parameter to true, else to false

or

Spot the test case file. Use the global variables to append expression

```java
List<String> positive = Arrays.asList("a->a","(!(a|b)->(!a&!b))", "~(a -> c) -> [~(c v d)-> (a ^ ~c)]", "(!(a&b)->(!a|!b))", "((a|b)->!a)|(!a->!c)", "((a->b)->(!b->!a))");
List<String> negative = Arrays.asList("a", "!a", "a->!a", "(((a->b)&!c)|(a->c))", "!(a->c)->(!(c|d)->(a&c))");

// add polish notation here
List<String> positivePolish = Arrays.asList("->->ab->!b!a");
```

## Explanation

The algorithm will only understand the postfix expression and then builds an expression tree, which is then evaluated via decomposition rules.
So we need to normalize the expression (Infix or prefix expression) to postfix tree.

While building the tree, nodes are classified by type, And, Or, Implies, Not, DataNode holding the logic to decompose the tree if non-fundamental 
formula is encountered algorithm fails by returns "Not a Not Tautology",
otherwise null is returned at every iteration. If algo doesn't terminate the given expression is tautology.


## Valid input

AND: &, ^  
OR: |,v  
NOT: !,~  
IMPLIES: ->, >  
Precedence brackets: (,),{,},[,]  

### Group members 

Harshitha Govid  
Akhil Reddy Gangula  
Karthik Singh  
Satyadev Tummala  