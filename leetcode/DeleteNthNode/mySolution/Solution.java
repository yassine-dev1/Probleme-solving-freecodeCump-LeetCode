package DeleteNthNode.mySolution;

class ListNode {
    int val;
    ListNode next;
    ListNode() { this.next = null; }
    ListNode(int val) { this.val = val; this.next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    private int length;

    private ListNode deleteNthNode(ListNode head, int n, int pos) {
        // Cas de base : fin de la liste atteinte, on stocke la longueur totale
        if (head == null) {
            this.length = pos;
            return null;
        }

        // 1. Descente récursive
        head.next = deleteNthNode(head.next, n, pos + 1); 
        
        int stopPosition = this.length - n;

        // 2. Si on est juste avant le nœud à supprimer, on le saute
        if (pos == stopPosition) {
            return head.next;
        }

        // 3. Si on doit supprimer la tête de liste elle-même
        if (stopPosition == 0 && pos == 0) {
            return head.next;
        }

        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;

        return deleteNthNode(head, n, 0);
    }

    public static void main(String[] args) {
        ListNode racine = new ListNode(2);
        ListNode l = new ListNode(8);
        ListNode r = new ListNode(10);
        racine.next = l;
        l.next = r;

        Solution sol = new Solution();

        racine = sol.removeNthFromEnd(racine, 1);
        
        // Vérification propre
        System.out.println("Nouveau 1er element : " + racine.val); // Doit être 2
        System.out.println("Nouveau 2ème element : " + racine.next.val); // Doit être 10 (8 a bien été supprimé)
    }
}