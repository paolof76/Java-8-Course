package io.atlassian.fugue;

import org.junit.Test;

import java.io.IOException;
import java.io.NotSerializableException;

import static io.atlassian.fugue.Serializer.toBytes;
import static io.atlassian.fugue.Serializer.toObject;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class OptionSerializationTest {

    @Test
    public void serializeSome() throws IOException {
        final Option<Integer> opt = Option.some(1);
        assertThat(Serializer.<Option<Integer>>toObject(toBytes(opt)), equalTo(opt));
    }

    @Test
    public void serializeNone() throws IOException {
        final Option<Integer> opt = Option.none();
        assertThat(Serializer.<Option<Integer>>toObject(toBytes(opt)), equalTo(opt));
    }

    @Test(expected = NotSerializableException.class)
    public void serializeSomeNonSerializable() throws IOException {
        toObject(toBytes(Option.some(Serializer.Unserializable.instance())));
    }
}