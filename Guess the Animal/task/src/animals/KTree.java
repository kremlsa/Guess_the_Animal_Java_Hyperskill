package animals;

import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class KTree {
    Node root;
    Node find;
    ArrayList<String> res = new ArrayList<>();
    ArrayList<String> facts = new ArrayList<>();
    int height;
    int totalNodes;

    public void addRoot(String value) {
        this.root = new Node();
        this.root.setValue(value);
    }

    public String getRoot() {
        return root.value;
    }

    public void setParents(Node node) {
        if (node.left == null && node.right == null) {
        } else {
            if (node.left != null) {
                node.left.parent = node;
            }
            if (node.right != null) {
                node.right.parent = node;
            }
            setParents(node.left);
            setParents(node.right);
        }
    }

    public void listAnimals() {
        res = new ArrayList<>();
        recList(this.root);
        Collections.sort(res);
        res.forEach(x -> System.out.println(" - " + x));
    }

    public void recList(Node node) {
        if (node.left == null && node.right == null) {
            res.add(new Animal(node.value).getName());
            return;
        } else {
            recList(node.left);
            recList(node.right);
        }

    }

    public void recFind(Node node, String name) {
        if (node.left == null && node.right == null) {
            if (new Animal(node.value).getName().equals(name)) {
                find = node;
            }
            return;
        } else {
            recFind(node.left, name);
            recFind(node.right, name);
        }
    }

    public void recFacts(Node node) {
        Facts f = new Facts();
        if (node.parent == null) {
            //facts.add(node.value);
            return;
        } else {
            if (node.parent.left == node) {
                facts.add(f.negativeFacts(node.parent.value));
            } else {
                facts.add(f.positiveFacts(node.parent.value));
            }
            recFacts(node.parent);
        }
    }

    public void find(String name) {
        setParents(this.root);
        facts = new ArrayList<>();
        find = null;
        recFind(this.root, name);
        if (find == null) {
            //System.out.println("No facts about the " + name + ".");
            System.out.println(L10in.searchNF());
        } else {
            recFacts(find);
            Collections.reverse(facts);
//            System.out.println("Facts about the " + name + ":");
            System.out.println(MessageFormat.format(L10in.searchFact(), name));
            if (facts.size() == 0 ) System.out.println("oops");
            for (String f : facts) {

                System.out.println(" - " + L10in.searchIt() + " " + f);
            }
        }
    }


    public void countNodes(Node node) {
        if (node.left == null && node.right == null) {
            totalNodes++;
        } else {
            totalNodes++;
            countNodes(node.left);
            countNodes(node.right);
        }
    }

    public void stats() {
        totalNodes = 0;
        countNodes(this.root);
        ArrayList<Integer> heights = new ArrayList<>();
        setParents(this.root);
        listAnimals();
        int size = res.size();
        for (String name : res) {
            find(name);
            heights.add(facts.size());
        }
        int min = Collections.min(heights);
        int max = Collections.max(heights);
        int sum = 0;
        for (Integer i : heights) {
            sum += i;
        }
        Double average = (double) sum / (double) heights.size();

        /*System.out.println("The Knowledge Tree stats\n" +
                "\n" +
                "- root node                    " + root.value + "\n" +
                "- total number of nodes        " + totalNodes + "\n" +
                "- total number of animals      " + size + "\n" +
                "- total number of statements   " + (totalNodes - size) + "\n" +
                "- height of the tree           " + max + "\n" +
                "- minimum depth                " + min + "\n" +
                "- average depth                " + Math.ceil(average*10)/10 + "\n");*/
        System.out.printf(L10in.statT());
        System.out.printf(L10in.statRoot(), root.value);
        System.out.printf(L10in.statNodes(), totalNodes);
        System.out.printf(L10in.statAn(), size);
        System.out.printf(L10in.statS(), (totalNodes - size));
        System.out.printf(L10in.statH(), max);
        System.out.printf(L10in.statM(), min);
        System.out.printf(L10in.statA(), Math.ceil(average*10)/10);


    }

    public void printTree() {
        System.out.println("└ " + root.value);
        //System.out.println(printRec(this.root));
        printRec(this.root);
    }

    public void printRec(Node node) {
        String r = "";
        String prefix = "|";
        String prefixL = "└ ";
        String prefixR = "├ ";
        if (node.left == null && node.right == null) {
            return;
        } else {
            r += node.right.value;
            System.out.println(r);
            printRec(node.right);
            printRec(node.left);
        }
        //return r;
    }
/*
    public void traverseNodes(StringBuilder sb, String padding, String pointer, Node node,
                              boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└ ";
            String pointerLeft = (node.getRight() != null) ? "├ " : "└ ";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
        }
    }

    public String traversePreOrder(Node root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getValue());

        String pointerRight = "└ ";
        String pointerLeft = (root.getRight() != null) ? "├ " : "└ ";

        traverseNodes(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
        traverseNodes(sb, "", pointerRight, root.getRight(), false);

        return sb.toString();
    }

    public void print() {
        PrintStream os = new PrintStream(System.out);
        os.print(traversePreOrder(root));
        System.out.println();
    }*/





}
