import java.util.*;

public class MinimizeDFA {
    public static void main(String[] args) {
        // Define the DFA
        Set<String> states = new HashSet<>(Arrays.asList("A", "B", "C", "D"));
        Set<String> alphabet = new HashSet<>(Arrays.asList("0", "1"));
        Map<String, Map<String, String>> transitionFunction = new HashMap<>();
        transitionFunction.put("A", new HashMap<>());
        transitionFunction.get("A").put("0", "B");
        transitionFunction.get("A").put("1", "C");
        transitionFunction.put("B", new HashMap<>());
        transitionFunction.get("B").put("0", "A");
        transitionFunction.get("B").put("1", "D");
        transitionFunction.put("C", new HashMap<>());
        transitionFunction.get("C").put("0", "D");
        transitionFunction.get("C").put("1", "A");
        transitionFunction.put("D", new HashMap<>());
        transitionFunction.get("D").put("0", "D");
        transitionFunction.get("D").put("1", "D");
        String startState = "A";
        Set<String> acceptStates = new HashSet<>(Arrays.asList("C"));

        // Minimize the DFA
        Set<Set<String>> minimizedStates = minimizeDFA(states, alphabet, transitionFunction, startState, acceptStates);

        // Print the minimized DFA
        System.out.println(minimizedStates);
    }

    public static Set<Set<String>> minimizeDFA(Set<String> states, Set<String> alphabet, Map<String, Map<String, String>> transitionFunction, String startState, Set<String> acceptStates) {
        // Initialize the partition with the accept states and non-accept states
        Set<Set<String>> partition = new HashSet<>();
        Set<String> nonAcceptStates = new HashSet<>(states);
        nonAcceptStates.removeAll(acceptStates);
        partition.add(acceptStates);
        partition.add(nonAcceptStates);

        // Refine the partition until it cannot be refined further
        boolean done;
        do {
            done = true;
            for (Set<String> part : partition) {
                for (String symbol : alphabet) {
                    // Check if the part can be split by the symbol
                    Map<Set<String>, Set<String>> split = new HashMap<>();
                    for (String state : part) {
                        String nextState = transitionFunction.get(state).get(symbol);
                        Set<String> nextPart = findPartContainingState(partition, nextState);
                        if (!split.containsKey(nextPart)) {
                            split.put(nextPart, new HashSet<>());
                        }
                        split.get(nextPart).add(state);
                    }
                    if (split.size() > 1) {
                        // The part can be split by the symbol
                        done = false;
                        partition.remove(part);
                        partition.addAll(split.values());
                        break;
                    }
                }
                if (!done) {
                    break;
                }
            }
        } while (!done);

        return partition;
    }

    public static Set<String> findPartContainingState(Set<Set<String>> partition, String state) {
        for (Set<String> part : partition) {
            if (part.contains(state)) {
                return part;
            }
        }
        return null;
    }
}