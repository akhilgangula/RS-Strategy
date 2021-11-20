import com.charlotte.IntelligentSystems.Strategy;
import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class RSTest {

List<String> positive = Arrays.asList("a->a","(!(a|b)->(!a&!b))", "(!(a->c)->(!(c|d)->(a&!c)))", "(!(a&b)->(!a|!b))", "((a|b)->!a)|(!a->!c)", "((a->b)->(!b->!a))");
List<String> negative = Arrays.asList("a", "!a", "a->!a", "(((a->b)&!c)|(a->c))", "!(a->c)->(!(c|d)->(a&c))");

List<String> positivePolish = Arrays.asList("->->ab->!b!a");

    @Test
    public void tautology() {
        positive.forEach(exp -> Assert.assertTrue("Failed while evaluating exp: " + exp, new Strategy(exp)
                .cleanExp()
                .transform(false)
                .runStrategy()));
    }

    @Test
    public void nonTautology() {
        negative.forEach(exp -> Assert.assertFalse("Failed while evaluating exp: " + exp, new Strategy(exp)
                .cleanExp()
                .transform(false)
                .runStrategy()));
    }

    @Test
    public void tautologyPolish() {
        positivePolish.forEach(exp -> Assert.assertTrue("Failed while evaluating exp: " + exp, new Strategy(exp)
                .cleanExp()
                .transform(true)
                .runStrategy()));
    }
}
