# RS-Strategy

An implementation of the RS proof using decomposition Tree

Please note: Please open the project with IDEA Intellij for best setup experience. View the project in the Github for better readMe experience.  

https://github.com/akhilgangula/RS-Strategy

## How to run


Run via Jar. Download the Jar file from <project_dir>/out/artifacts/RS_Strategy_Jar and run below cmd.

```shell
java -jar RS_Strategy.jar
```
Follow the instructions on the screen.
This way we can enter the expression on the cmd line, instead of opening project.

or

Spot the test case file. Use the global variables to append expression


```java
List<String> positive=Arrays.asList("a->a","(!(a|b)->(!a&!b))","~(a -> c) -> [~(c v d)-> (a ^ ~c)]","(!(a&b)->(!a|!b))","((a|b)->!a)|(!a->!c)","((a->b)->(!b->!a))");
        List<String> negative=Arrays.asList("a","!a","a->!a","(((a->b)&!c)|(a->c))","!(a->c)->(!(c|d)->(a&c))");

// add polish notation here
        List<String> positivePolish=Arrays.asList("->->ab->!b!a");
```


## Explanation

The algorithm will only understand the postfix expression and then builds an expression tree, which is then evaluated via decomposition rules.
So we need to normalize the expression (Infix or prefix expression) to postfix tree.

While resolving the tree, nodes are classified by type, And, Or, Implies, Not, DataNode holding the logic to decompose the tree. Each ExpNode will define a logic to break the node rule by tree decomposition rules.

Rules are as below:

![Screen Shot 2021-12-11 at 1 38 48 PM](https://user-images.githubusercontent.com/58249928/145687854-51fc984f-36dd-427c-ba87-aa334a725070.png)


![Screen Shot 2021-12-11 at 1 39 00 PM](https://user-images.githubusercontent.com/58249928/145687862-6e290c45-466b-4e94-9997-01eb3e30aa09.png)


If non-fundamental formula is encountered algorithm fails by returns "Not a Not Tautology",
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
