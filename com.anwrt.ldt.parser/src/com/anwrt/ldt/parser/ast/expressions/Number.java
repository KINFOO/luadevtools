/**
 * @author	Kevin KIN-FOO <kkinfoo@anyware-tech.com>
 * @date $Date: 2009-06-18 16:46:07 +0200 (jeu., 18 juin 2009) $
 * $Author: kkinfoo $
 * $Id: Number.java 1887 2009-06-18 14:46:07Z kkinfoo $
 */
package com.anwrt.ldt.parser.ast.expressions;

import org.eclipse.dltk.ast.expressions.FloatNumericLiteral;

import com.anwrt.ldt.parser.LuaExpressionConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class Number.
 */
public class Number extends FloatNumericLiteral implements
		LuaExpressionConstants {

	/**
	 * Instantiates a new number.
	 * 
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 * @param value
	 *            the value
	 */
	public Number(int start, int end, double value) {
		super(start, end, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.dltk.ast.statements.Statement#getKind()
	 */
	@Override
	public int getKind() {
		return NUMBER_LITERAL;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.dltk.ast.expressions.Literal#getValue()
	 */
	public java.lang.String getValue() {
		return this.toString();
	}
}
