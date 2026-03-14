// AppendingObjectOutputStream (Part of [3.3 Serializable Program], Repurposed for [snek game v2])
// Made by: Henry Smith
// Created: 11/11/2025

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendingObjectOutputStream extends ObjectOutputStream {
    public AppendingObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
    @Override
    protected void writeStreamHeader() throws IOException {

    }
}
