import org.logicng.formulas.Formula;
import org.logicng.formulas.FormulaFactory;
import org.logicng.formulas.Literal;

import java.util.HashSet;
import java.util.Set;

public class Entry {

    public static void main(String[] args) {
        final FormulaFactory f=new FormulaFactory();
        final Literal a=f.literal("A", false);
        final Literal b=f.literal("B", true);
        final Literal notC=f.literal("C",true);

        //we expect that each clause will be represented as a disjunction of literals
        final Formula formula=f.or(a,f.not(f.or(b,notC)));
        final Formula formula1=f.or(a,f.not(f.or(b,notC)));

        final Formula formula2 = b.negate();
        Set<Formula> formulasToConvert = new HashSet<>();

        formulasToConvert.add(formula);
        formulasToConvert.add(formula2);
        formulasToConvert.add(formula1);

        Formula cnf = f.cnf(formulasToConvert);

        System.out.println(formulasToConvert);




    }
}
