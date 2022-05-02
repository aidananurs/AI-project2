import org.logicng.formulas.Formula;

public class Belief {

    public Belief(Formula formula, float order) {
        this.formula = formula;
        this.order = order;
    }

    public Formula formula;
    public float order;


}
