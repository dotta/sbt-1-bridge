/*
 * Zinc - The incremental compiler for Scala.
 * Copyright 2011 - 2017, Lightbend, Inc.
 * Copyright 2008 - 2010, Mark Harrah
 * This software is released under the terms written in LICENSE.
 */

package xsbti;

public interface InteractiveConsoleInterface {
  void reset();
  InteractiveConsoleResponse interpret(String line, boolean synthetic);
}
