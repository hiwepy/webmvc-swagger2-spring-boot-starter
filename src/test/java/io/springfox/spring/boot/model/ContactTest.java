package io.springfox.spring.boot.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link Contact}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@DisplayName("Contact Tests")
class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact();
    }

    @Test void defaultName() { assertThat(contact.getName()).isEmpty(); }
    @Test void defaultUrl() { assertThat(contact.getUrl()).isEmpty(); }
    @Test void defaultEmail() { assertThat(contact.getEmail()).isEmpty(); }

    @Test void setName() { contact.setName("John"); assertThat(contact.getName()).isEqualTo("John"); }
    @Test void setUrl() { contact.setUrl("http://example.com"); assertThat(contact.getUrl()).isEqualTo("http://example.com"); }
    @Test void setEmail() { contact.setEmail("a@b.com"); assertThat(contact.getEmail()).isEqualTo("a@b.com"); }

    @Test
    void toStringContainsFields() {
        contact.setName("Test");
        assertThat(contact.toString()).contains("Test");
    }

}
