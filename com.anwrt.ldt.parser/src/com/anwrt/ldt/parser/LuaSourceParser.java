/**
 * @author	Kevin KIN-FOO <kkinfoo@anyware-tech.com>
 * @date $Date: 2009-07-29 17:56:04 +0200 (mer., 29 juil. 2009) $
 * $Author: kkinfoo $
 * $Id: LuaSourceParser.java 2190 2009-07-29 15:56:04Z kkinfoo $
 */
package com.anwrt.ldt.parser;

import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.ast.parser.AbstractSourceParser;
import org.eclipse.dltk.compiler.problem.IProblemReporter;

import com.anwrt.ldt.internal.parser.NodeFactory;

/**
 * The Class LuaSourceParser provides a DLTK AST, when an error occur during
 * parsing it provide the previous version of AST.
 */
public class LuaSourceParser extends AbstractSourceParser {

    /**
     * AST cache, allow to keep previous AST in mind when syntax errors occurs
     */
    private ModuleDeclaration _cache = null;

    /**
     * Provide DLTK compliant AST
     * 
     * @return {@link ModuleDeclaration}, in case of syntax errors, the previous
     *         valid AST is given
     * @see org.eclipse.dltk.ast.parser.ISourceParser#parse(char[], char[],
     *      org.eclipse.dltk.compiler.problem.IProblemReporter)
     */
    @Override
    public ModuleDeclaration parse(char[] fileName, char[] source,
	    IProblemReporter reporter) {

	// Analyze code
	NodeFactory factory = new NodeFactory(new String(source));

	/*
	 * Keep older version of AST in case of syntax errors, when cache is
	 * defined.
	 */
	if ((_cache == null) || (!factory.errorDetected())) {
	    _cache = factory.getRoot();
	}
	return _cache;
    }

}
