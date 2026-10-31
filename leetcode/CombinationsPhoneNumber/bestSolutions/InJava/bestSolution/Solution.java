package bestSolution;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Solution {
    // La map peut être initialisée une seule fois
    private final HashMap<Character, String> mapPhone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    private void backtrack(String digits, int index, String currentPath, List<String> result) {
        // Condition d'arrêt : si on a parcouru tous les chiffres
        if (index == digits.length()) {
            result.add(currentPath);
            return;
        }

        char digit = digits.charAt(index);
        String letters = mapPhone.get(digit);

        if (letters != null) {
            for (int idx = 0; idx < letters.length(); idx++) {
                backtrack(digits, index + 1, currentPath + letters.charAt(idx), result);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Gestion du cas où l'entrée est vide ou nulle
        if (digits == null || digits.trim().isEmpty()) {
            return result; 
        }

        backtrack(digits, 0, "", result);
        return result;
    }
}