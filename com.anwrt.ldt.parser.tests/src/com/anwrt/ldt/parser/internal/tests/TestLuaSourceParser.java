/**
 * @author	Kevin KIN-FOO <kkinfoo@anyware-tech.com>
 * @date $Date: 2009-07-23 12:07:30 +0200 (jeu., 23 juil. 2009) $
 * $Author: kkinfoo $
 * $Id: TestLuaSourceParser.java 2161 2009-07-23 10:07:30Z kkinfoo $
 */
package com.anwrt.ldt.parser.internal.tests;

import junit.framework.TestCase;

import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.compiler.problem.IProblemReporter;

import com.anwrt.ldt.parser.LuaSourceParser;
import com.anwrt.ldt.parser.internal.tests.utils.DummyReporter;

/**
 * The Class TestLuaSourceParser. Is the privileged entrance of the package.
 * Allows to generate AST from source from a file or even straight from source
 * code.
 */
public class TestLuaSourceParser extends TestCase {

	/** The reporter. */
	private IProblemReporter reporter;

	/** The file name. */
	private char[] fileName;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	public void setUp() {
		// No tests on about file name
		fileName = "none".toCharArray();

		// Dummy problem reporter
		this.reporter = new DummyReporter();
	}

	/**
	 * Test empty chunk.
	 */
	public void testEmptyChunk() {
		char[] source = "".toCharArray();
		ModuleDeclaration module = new LuaSourceParser().parse(fileName,
				source, this.reporter);
		assertFalse("AST should contain at least an empty chunk", module
				.isEmpty());
	}

	/**
	 * Test single assignment.
	 */
	public void testSingleAssignment() {

		// Single assignment
		char[] source = "var = 1 + 2 * 3".toCharArray();
		ModuleDeclaration module = new LuaSourceParser().parse(fileName,
				source, this.reporter);
		assertFalse("Valid code provides empty AST", module.isEmpty());
	}
}
