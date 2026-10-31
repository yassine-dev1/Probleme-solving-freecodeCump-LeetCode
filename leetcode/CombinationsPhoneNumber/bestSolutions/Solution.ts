function letterCombinations(digits: string): string[] {
    // Si la chaîne est vide, on retourne un tableau vide
    if (!digits || digits.length === 0) {
        return [];
    }

    // Correspondance des chiffres vers les lettres
    const phoneMap: Record<string, string> = {
        "2": "abc",
        "3": "def",
        "4": "ghi",
        "5": "jkl",
        "6": "mno",
        "7": "pqrs",
        "8": "tuv",
        "9": "wxyz"
    };

    const result: string[] = [];

    // Fonction récursive de backtracking
    function backtrack(index: number, currentPath: string) {
        // Si la longueur du chemin actuel est égale à celle des chiffres, 
        // on a trouvé une combinaison complète qu'on ajoute au résultat.
        if (index === digits.length) {
            result.push(currentPath);
            return;
        }

        // Récupérer les lettres associées au chiffre actuel
        const currentDigit = digits[index];
        const letters = phoneMap[currentDigit];

        if (letters) {
            for (let i = 0; i < letters.length; i++) {
                // On ajoute la lettre au chemin et on passe au chiffre suivant
                backtrack(index + 1, currentPath + letters[i]);
            }
        }
    }

    // Lancer la récursion à partir de l'indice 0 avec une chaîne vide
    backtrack(0, "");

    return result;
}