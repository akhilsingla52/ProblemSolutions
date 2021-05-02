package recursion;
public class TreeExpression {
	
	public static void main(String[] args) {
		ExprNode expr = new TimesNode(
		        new ValueNode(2),
		        new PlusNode(new ValueNode(3), new ValueNode(4)));
		System.out.println(expr.asInfixString() + " = " + expr.evaluate());
	}

}

interface ExprNode {
    int evaluate();
    String asInfixString();
}

final class ValueNode implements ExprNode {

    private final int value;

    public ValueNode(final int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return this.value;
    }

    @Override
    public String asInfixString() {
        return String.valueOf(this.value);
    }
}

final class PlusNode implements ExprNode {

    private final ExprNode lhs;
    private final ExprNode rhs;

    public PlusNode(final ExprNode lhs, final ExprNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public int evaluate() {
        return this.lhs.evaluate() + this.rhs.evaluate();
    }

    @Override
    public String asInfixString() {
        return String.format("(%s) + (%s)",
                             this.lhs.asInfixString(),
                             this.rhs.asInfixString());
    }
}

final class TimesNode implements ExprNode {

    private final ExprNode lhs;
    private final ExprNode rhs;

    public TimesNode(final ExprNode lhs, final ExprNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public int evaluate() {
        return this.lhs.evaluate() * this.rhs.evaluate();
    }

    @Override
    public String asInfixString() {
        return String.format("(%s) * (%s)",
                             this.lhs.asInfixString(),
                             this.rhs.asInfixString());
    }
}