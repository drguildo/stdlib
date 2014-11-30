/*
 * Copyright (c) 2014, Simon Morgan <sjm@sjm.io>
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.drguildo.stdlib;

import java.io.IOException;
import java.io.InputStream;

public class IO {
  public static <T> void prn(T msg) {
    System.out.print(msg.toString());
  }

  public static <T> void prnl(T msg) {
    System.out.println(msg.toString());
  }

  public static void prnl() {
    System.out.println();
  }

  @SafeVarargs
  public static <T> void prnf(T msg, T... args) {
    System.out.println(String.format(msg.toString(), args));
  }

  public static <T> void dbg(T msg) {
    System.out.println("DEBUG: " + msg);
  }

  @SafeVarargs
  public static <T> void dbg(T msg, T... args) {
    System.out.println("DEBUG: " + String.format(msg.toString(), args));
  }

  public static <T> void err(T msg) {
    System.err.println(msg);
  }

  @SafeVarargs
  public static <T> void err(T msg, T... args) {
    System.err.println(String.format(msg.toString(), args));
  }

  // Read a little-endian integer from an input stream.
  public static int readInteger(InputStream in) throws IOException {
    int n;
    byte[] b = new byte[4];

    in.read(b);

    n = b[3] << 24;
    n = n | b[2] << 16;
    n = n | b[1] << 8;
    n = n | b[0];

    return n;
  }
}
