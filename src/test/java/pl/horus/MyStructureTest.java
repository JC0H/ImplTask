package pl.horus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class MyStructureTest {
    private Node firstNode = new Node("firstCode", "firstRender");
    private Node secondNode = new Node("secondCode", "secondRender");
    private CompositeNode compositeNode = new CompositeNode("compositeCode", "compositeRender");

    private MyStructure emptyList;
    private MyStructure fullList;

    @BeforeEach
    void setUp() {
        emptyList = new MyStructure();

        fullList = new MyStructure();
        fullList.addNode(firstNode);
        fullList.addNode(secondNode);
        fullList.addNode(compositeNode);
    }


    @Test
    void shouldReturnEmptyListWhenListIsEmpty() {
        assertThat(emptyList.count(), is(equalTo(0)));
    }

    @Test
    void shouldReturnNullWhenCodeListIsEmpty() {
        assertThat(emptyList.findByCode("asd"), is(nullValue()));
    }

    @Test
    void shouldReturnNullWhenRenderListIsEmpty() {
        assertThat(emptyList.findByRenderer("asd"), is(nullValue()));
    }

    @Test
    void shouldReturnNullWhenNotFoundByCode() {
        assertThat(fullList.findByCode("missingCode"), is(nullValue()));
    }

    @Test
    void shouldReturnNullWhenNotFoundByRenderer() {
        assertThat(fullList.findByRenderer("missingRenderer"), is(nullValue()));
    }

    @Test
    void shouldReturnNodeWhenCodeEquals() {
        assertThat(fullList.findByCode("secondCode"), is(secondNode));
    }

    @Test
    void shouldReturnNodeWhenRendererEquals() {
        assertThat(fullList.findByRenderer("secondRender"), is(secondNode));
    }

    @Test
    void shouldFindCompositeNodeByCode() {
        assertThat(fullList.findByCode("compositeCode"), is(compositeNode));
    }

    @Test
    void shouldFindCompositeNodeByReferer() {
        assertThat(fullList.findByRenderer("compositeRender"), is(compositeNode));
    }
}