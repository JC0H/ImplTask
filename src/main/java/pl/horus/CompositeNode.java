package pl.horus;

import java.util.*;

public class CompositeNode extends Node implements ICompositeNode{
    private LinkedList<INode> nodes = new LinkedList<>();

    public CompositeNode(String code, String renderer) {
        super(code, renderer);
    }

    @Override
    public List<INode> getNodes() {
        if(nodes.isEmpty()){
            throw new NoSuchElementException();
        }

        INode node = nodes.getFirst();
        if (node != null) {
            if (node instanceof ICompositeNode) {
                ICompositeNode compositeNode = (ICompositeNode) node;
                nodes.add(compositeNode);
            }
        }
        return nodes;
    }

    public void addNode(INode node) {
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
        if (!super.equals(o)) {
            return false;
        }
        CompositeNode that = (CompositeNode) o;
        return Objects.equals(nodes, that.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nodes);
    }
}