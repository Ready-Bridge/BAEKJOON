import java.util.*;

class Solution {
    
    static class Node {
        int idx, x, y;
        Node left, right;
        
        public Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
    
    // 트리에 노드 삽입
    public void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) parent.left = child;
            else insert(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
    
    // 전위 순회
    public void preorder(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.idx);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    // 후위 순회
    public void postorder(Node node, List<Integer> result) {
        if (node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.idx);
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];
        
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }
        
        // y 내림차순, x 오름차순
        Arrays.sort(nodes, (a, b) -> {
            if (a.y != b.y) return b.y - a.y;
            return a.x - b.x;
        });
        
        // 트리 구성
        Node root = nodes[0];
        for (int i = 1; i < n; i++) {
            insert(root, nodes[i]);
        }
        
        // 순회 결과
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        
        preorder(root, pre);
        postorder(root, post);
        
        int[][] answer = new int[2][n];
        for (int i = 0; i < n; i++) {
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }
        return answer;
    }
}