import java.util.*;

class Solution {
    
    public class Node {
        private Node parent;
        private int level;
        
        public Node() {
            this.parent = this;
            this.level = 0;
        }
        
        public Node find() {
            if(this.parent != this) {
                this.parent = this.parent.find();
            }
            return this.parent;
        }
        
        public void union(Node compareNode) {
            Node rootThis = this.find();
            Node rootCompare = compareNode.find();
            
            if(rootThis == rootCompare) {
                return;
            }
            
            if(rootThis.level < rootCompare.level) {
                rootThis.parent = rootCompare;
            } else if(rootCompare.level < rootThis.level) {
                rootCompare.parent = rootThis;
            } else {
                rootThis.parent = rootCompare;
                rootCompare.level += 1;
            }
            
        }
        
        public boolean isConnected(Node compareNode) {
            return this.find() == compareNode.find();
        }
    }
    
    public int solution(int n, int[][] costs) {
        
        Node[] nodes = new Node[n];
        
        for(int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        
        int sum = 0;
        
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        
        for(int[] arr : costs) {
            
            if(!(nodes[arr[0]].isConnected(nodes[arr[1]]))) {
                nodes[arr[0]].union(nodes[arr[1]]);
                sum += arr[2];
            }
        }
        
        return sum;
    }
}