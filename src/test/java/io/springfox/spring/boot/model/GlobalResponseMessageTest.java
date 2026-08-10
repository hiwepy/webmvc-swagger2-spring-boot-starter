package io.springfox.spring.boot.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link GlobalResponseMessage}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@DisplayName("GlobalResponseMessage Tests")
class GlobalResponseMessageTest {

    private GlobalResponseMessage msg;

    @BeforeEach
    void setUp() {
        msg = new GlobalResponseMessage();
    }

    @Test void defaultPost() { assertThat(msg.getPost()).isEmpty(); }
    @Test void defaultGet() { assertThat(msg.getGet()).isEmpty(); }
    @Test void defaultPut() { assertThat(msg.getPut()).isEmpty(); }
    @Test void defaultPatch() { assertThat(msg.getPatch()).isEmpty(); }
    @Test void defaultDelete() { assertThat(msg.getDelete()).isEmpty(); }
    @Test void defaultHead() { assertThat(msg.getHead()).isEmpty(); }
    @Test void defaultOptions() { assertThat(msg.getOptions()).isEmpty(); }
    @Test void defaultTrace() { assertThat(msg.getTrace()).isEmpty(); }

    @Test void setPost() { List<GlobalResponseMessageBody> l = new ArrayList<>(); msg.setPost(l); assertThat(msg.getPost()).isSameAs(l); }
    @Test void setGet() { List<GlobalResponseMessageBody> l = new ArrayList<>(); msg.setGet(l); assertThat(msg.getGet()).isSameAs(l); }
    @Test void setPut() { List<GlobalResponseMessageBody> l = new ArrayList<>(); msg.setPut(l); assertThat(msg.getPut()).isSameAs(l); }
    @Test void setPatch() { List<GlobalResponseMessageBody> l = new ArrayList<>(); msg.setPatch(l); assertThat(msg.getPatch()).isSameAs(l); }
    @Test void setDelete() { List<GlobalResponseMessageBody> l = new ArrayList<>(); msg.setDelete(l); assertThat(msg.getDelete()).isSameAs(l); }
    @Test void setHead() { List<GlobalResponseMessageBody> l = new ArrayList<>(); msg.setHead(l); assertThat(msg.getHead()).isSameAs(l); }
    @Test void setOptions() { List<GlobalResponseMessageBody> l = new ArrayList<>(); msg.setOptions(l); assertThat(msg.getOptions()).isSameAs(l); }
    @Test void setTrace() { List<GlobalResponseMessageBody> l = new ArrayList<>(); msg.setTrace(l); assertThat(msg.getTrace()).isSameAs(l); }

    @Test
    void toStringContainsFields() {
        assertThat(msg.toString()).contains("post").contains("get");
    }

}
