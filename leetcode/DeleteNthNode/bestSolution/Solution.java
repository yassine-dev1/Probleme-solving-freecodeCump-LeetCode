package DeleteNthNode.bestSolution;

class ListNode {
    int val;
    ListNode next;
    ListNode() { this.next = null; }
    ListNode(int val) { this.val = val; this.next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Nœud factice pour simplifier le cas où l'on supprime la tête de liste
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Avancer le pointeur 'fast' de n + 1 étapes pour créer un écart de n nœuds
        for (int i = 0; i <= n; i++) {
            if (fast == null) return head; // Sécurité au cas où n est supérieur à la taille de la liste
            fast = fast.next;
        }

        // Déplacer les deux pointeurs en parallèle jusqu'à ce que 'fast' atteigne la fin
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 'slow' pointe maintenant juste avant le nœud à supprimer
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode racine = new ListNode(2);
        Solution sol = new Solution();

        racine = sol.removeNthFromEnd(racine, 1);
        System.out.println("racine est null : " + (racine == null));
    }
}
