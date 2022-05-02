import org.logicng.formulas.Formula;
import org.logicng.formulas.FormulaFactory;
import org.logicng.formulas.Literal;

import java.util.ArrayList;
import java.util.Set;

/**
 Class for checking logical entailment using Resolution-based algorithm
 */
public class Entailment {

    private final FormulaFactory formulaFactory;

    public Entailment(FormulaFactory formulaFactory) {
        this.formulaFactory = formulaFactory;
    }

    /**
     * Check if base |- formula
     */
    public void entails(BeliefBase base, Formula formula) {

        // 1 - formalisation of base as CNF
        //To show that base |= formula, we show that base ∧ ¬formula is unsatisfiable.
        //We do this by proving a contradiction
        // 2 - add contradiction to start resolution
        Formula contradiction = formula.negate();
        Set<Formula> formulasToConvert = base.getFormulas();
        formulasToConvert.add(contradiction);
        Formula cnf = formulaFactory.cnf(formulasToConvert);
        //Check if one of the clauses is False, which means the sentence is unsatisfiable
        while(true) {
            int len = formulasToConvert.size();

        }

        }

    }




