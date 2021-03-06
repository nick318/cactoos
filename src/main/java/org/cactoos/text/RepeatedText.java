/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2017-2018 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.cactoos.text;

import java.io.IOException;
import org.cactoos.Text;

/**
 * Repeat an text count times.
 *
 * <p>There is no thread-safety guarantee.
 *
 * @author Fabricio Cabral (fabriciofx@gmail.com)
 * @version $Id$
 * @since 0.9
 */
public final class RepeatedText implements Text {

    /**
     * The text.
     */
    private final Text origin;

    /**
     * How many times repeat the Text.
     */
    private final int count;

    /**
     * Ctor.
     * @param text A String
     * @param count How many times repeat the Text
     */
    public RepeatedText(final String text, final int count) {
        this(new TextOf(text), count);
    }

    /**
     * Ctor.
     * @param text The Text
     * @param count How many times repeat the Text
     */
    public RepeatedText(final Text text, final int count) {
        this.origin = text;
        this.count = count;
    }

    @Override
    public String asString() throws IOException {
        final StringBuilder out = new StringBuilder();
        for (int cnt = 0; cnt < this.count; ++cnt) {
            out.append(this.origin.asString());
        }
        return out.toString();
    }

}
