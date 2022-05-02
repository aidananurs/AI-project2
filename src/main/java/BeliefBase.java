import org.logicng.formulas.Formula;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 Belief base that implements epistemic entrenchment
 with finite partial entrenchment ranking.
 Each belief has an epistemic value which determines its entrenchment, i.e. the level of commitment
 to maintain it when applying a change function (contraction,
 revision, etc).
 */
public class BeliefBase {
    private final Set<Belief> beliefs = new HashSet<>();

    public Set<Formula> getFormulas() {
        return beliefs.stream().map(b -> b.formula).collect(Collectors.toSet());
    }

    public void printBeliefBase() {
        beliefs.forEach(b -> {
            String s = String.format("formula: 1%s, order: 2%f", b.formula.toString(), b.order);
            System.out.println(s);
        });
    }

    public void add(Formula formula, float order) {
        checkForDuplicates(formula);
        beliefs.add(new Belief(formula, order));
    }

    public void removeByFormula(Formula formula) {
        final Set<Belief> beliefsToRemove = new HashSet<>();
        for(Belief b: beliefs) {
            if(b.formula.toString().equals(formula.toString())) {
                beliefsToRemove.add(b);
            }
        }
        beliefs.removeAll(beliefsToRemove);
    }

    public void reorderBeliefs(Set<Belief> beliefs) {
        final Set<Belief> beliefsToReorder = new HashSet<>();
        beliefs.forEach(b -> {
            removeByFormula(b.formula);
            beliefsToReorder.add(b);
        });
        beliefs.addAll(beliefsToReorder);
    }

    public void checkForDuplicates(Formula formula) {
        for(Belief b: beliefs) {
            if(b.formula.toString().equals(formula.toString())) {
                throw new IllegalArgumentException("Belief with such a formula already exists!");
            }
        }
    }



}
