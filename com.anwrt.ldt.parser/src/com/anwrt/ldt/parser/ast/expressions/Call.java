/**
 * @author	Kevin KIN-FOO <kkinfoo@anyware-tech.com>
 * @date $Date: 2009-06-18 16:46:07 +0200 (jeu., 18 juin 2009) $
 * $Author: kkinfoo $
 * $Id: Call.java 1887 2009-06-18 14:46:07Z kkinfoo $
 */
package com.anwrt.ldt.parser.ast.expressions;

import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.ast.expressions.CallArgumentsList;
import org.eclipse.dltk.ast.expressions.CallExpression;
import org.eclipse.dltk.ast.expressions.Expression;

import com.anwrt.ldt.parser.LuaExpressionConstants;

/**
 * The Class Call.
 */
public class Call extends CallExpression implements LuaExpressionConstants {
	/**
	 * Instantiates a new call.
	 * 
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 * @param name
	 *            the name
	 * @param params
	 *            the params
	 */
	public Call(int start, int end, Identifier name, CallArgumentsList args) {
		super(start, end, name, name.getValue(), args);
	}

	public Call(int start, int end, Identifier name) {
		super(start, end, name, name.getValue(), new CallArgumentsList(start,
				end));
	}

	public Call(int start, int end, Index name) {
		super(start, end, name, extractNameFromIndex(name),
				new CallArgumentsList(start, end));
	}

	public Call(int start, int end, Index name, CallArgumentsList args) {
		super(start, end, name, extractNameFromIndex(name), args);
	}

	public Call(int start, int end, Expression name) {
		super(start, end, name, extractNameFromIndex(name),
				new CallArgumentsList(start, end));
	}

	public Call(int start, int end, Expression name, CallArgumentsList args) {
		super(start, end, name, extractNameFromIndex(name), args);
	}

	/**
	 * extracting Key of index
	 */
	private static java.lang.String extractNameFromIndex(Expression expr) {

		java.lang.String name;
		Index index;
		if (expr instanceof Index) {
			index = (Index) expr;
			Identifier id;
			if (index.getKey() instanceof Identifier) {
				id = (Identifier) index.getKey();
				name = id.getValue() + ".";
			} else {
				name = index.getKey() + ".";
			}
			if (index.getValue() instanceof Identifier) {
				id = (Identifier) index.getValue();
				name += id.getValue();
			} else {
				name += index.getValue();
			}
		} else {
			name = expr.toString();
		}
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.dltk.ast.statements.Statement#getKind()
	 */
	@Override
	public int getKind() {
		return E_CALL;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.dltk.ast.statements.Statement#traverse(org.eclipse.dltk.ast
	 * .ASTVisitor)
	 */
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			super.traverse(visitor);
			visitor.endvisit(this);
		}
	}

}
