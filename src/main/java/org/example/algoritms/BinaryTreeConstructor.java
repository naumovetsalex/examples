package org.example.algoritms;

import lombok.Data;

import java.util.*;

public class BinaryTreeConstructor {

    public static void main(String[] args) {
        System.err.println(checkIfConstructBiTree(new String[] {"(1,2)", "(3,2)", "(2,12)", "(5,2)"}));
    }

    private static Boolean checkIfConstructBiTree(String[] sequence) {
        var resultSet = new ArrayList<Boolean>();
        var biTreeStringNodes = Arrays.stream(sequence).toList().stream().map(node -> {
            node = node.replaceAll("[)(]", "");
            return node;
        }).toList();
        var biTreeNodes = biTreeStringNodes
                .stream()
                .map(node -> new Node(node.split(",")))
                .toList();
        for (Node node : biTreeNodes) {
            var resultSetTmp = new ArrayList<Boolean>();
            var leafsForNode = new ArrayList<Node>();
            var leafsForNodeTmp = new ArrayList<Node>();
            for (Node nodeTmp: biTreeNodes) {
                if (node.getCurrent() == nodeTmp.getParent() && !node.equals(nodeTmp)) {
                    leafsForNode.add(nodeTmp);
                } else if (node.getParent() == nodeTmp.getCurrent() && !node.equals(nodeTmp)) {
                    leafsForNodeTmp.add(node);
                } else if ((leafsForNodeTmp.size() > 2) || (leafsForNode.size() > 2)) {
                    return false;
                }
                resultSetTmp.add(definingLeafs(node, leafsForNode)
                                || definingLeafs(nodeTmp, leafsForNodeTmp));
            }
            boolean result = false;
            for (boolean bool: resultSetTmp) {
                result = result || bool;
            }
            resultSet.add(result);
        }
        return resultSet
                .stream()
                .filter(leafValueAccessory -> !leafValueAccessory)
                .findFirst()
                .orElse(Boolean.TRUE);
    }

    private static boolean definingLeafs(Node parent, ArrayList<Node> leafs) {
        boolean result = false;
        if (leafs.size() == 2) {
            var currentValue = parent.getCurrent();
            var leafFirst = leafs.get(0).getCurrent();
            var leafSecond = leafs.get(1).getCurrent();
            if ((leafFirst < currentValue && currentValue < leafSecond)
                    || (leafFirst > currentValue && currentValue > leafSecond)) {
                result = true;
            }
        } else if (leafs.size() == 1) {
            var currentValue = parent.getCurrent();
            var leafFirst = leafs.get(0).getCurrent();
            if ((leafFirst < currentValue)
                    || (leafFirst > currentValue)) {
                result = true;
            }
        } else if (leafs.size() > 2) {
            result = false;
        }
        return result;
    }
}

@Data
class Node {
    private int current;
    private int parent;

    public Node(String[] nodes){
        this.current = Integer.parseInt(nodes[0]);
        this.parent = Integer.parseInt(nodes[1]);
    }
}

@Data
class BiTree<T> {

    private Node<T> head;
    private Set<Node<T>> nodes;

    private Comparator<? super T> comparator;

    public BiTree() {
        this.nodes = new HashSet<>();
    }

    @Data
    static class Node<T> {
        private T value;
        private Node<T> parent;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node<?> node = (Node<?>) o;
            return value.equals(node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    public void add(T value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            var iterator = nodes.iterator();
            while(iterator.hasNext()) {
                var tmp = iterator.next();
                if (!tmp.getValue().equals(value)) {

                }
            }
        }
    }

}


