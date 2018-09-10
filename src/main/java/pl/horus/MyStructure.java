package pl.horus;

import java.util.LinkedList;
import java.util.Objects;
import java.util.function.Predicate;

public class MyStructure implements IMyStructure {

    private LinkedList<INode> nodes = new LinkedList<>();

    @Override
    public INode findByCode(String code) {
        return findByPredicate(node -> code.equals(node.getCode()));
    }

    @Override
    public INode findByRenderer(String renderer) {
        return findByPredicate(node -> renderer.equals(node.getRenderer()));
    }

    @Override
    public int count() {
        return (int) nodes.stream().count();
    }

    private INode findByPredicate(Predicate<INode> predicate) {
        return nodes.stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyStructure that = (MyStructure) o;
        return Objects.equals(nodes, that.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes);
    }
}
