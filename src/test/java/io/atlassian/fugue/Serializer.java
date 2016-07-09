package io.atlassian.fugue;

import java.io.*;

class Serializer {

    static <A> byte[] toBytes(final A a) throws IOException {
        final ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        new ObjectOutputStream(bytes).writeObject(a);
        return bytes.toByteArray();
    }

    static <A> A toObject(final byte[] bs) throws IOException {
        final ByteArrayInputStream bytes = new ByteArrayInputStream(bs);
        try {
            @SuppressWarnings("unchecked")
            final A result = (A) new ObjectInputStream(bytes).readObject();
            return result;
        } catch (final ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static class Unserializable {
        static Unserializable instance() {
            return new Unserializable();
        }
    }
}