package animals;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Node {
    String value;
    Node left;
    Node right;
    Node parent;

    Node() {
    }

    public String getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
        this.left.parent = this;
    }

    public void setRight(Node right) {
        this.right = right;
        this.right.parent = this;
    }
}
