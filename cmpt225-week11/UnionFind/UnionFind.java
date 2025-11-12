
public class UnionFind {


    private static class Node implements UnionFindTicket {
        private Object data;
        private Node parent;
        private int rank;


        public Node(Object data) {
            this.data = data;
            this.parent = null;
            this.rank = 0;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(UnionFindTicket parent) {
            this.parent = (Node) parent;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

    }


    /**
     *
     * @param data
     * @return a Node (a ticket) that can be used to run find and union
     */
    public static UnionFindTicket makeSet(Object data) {
        return new UnionFind.Node(data);
    }

    /**
     *
     * @param node
     * @return returns the root of the tree containing node
     */
    public static UnionFindTicket find(UnionFindTicket node) {
        Node current = (Node) node;
        while (current.getParent() != null)
            current = current.getParent();

        // path compression: moving the node closer to the root
        if (current.getParent() != null)
            current.setParent(current); // optimizing for future calls

        return current;
    }


    public static void union(UnionFindTicket u, UnionFindTicket v) {
        Node ru = (Node) find(u);
        Node rv = (Node) find(v);
        if (ru.getRank() > rv.getRank())
            rv.setParent(ru);    // ru will be the common root
        else if (ru.getRank() < rv.getRank())
            ru.setParent(rv);    // rv will be the common root
        else {    // ru.getRank() == rv.getRank()
            ru.setParent(rv);
            rv.setRank(rv.getRank() + 1);
        }
    }
}
