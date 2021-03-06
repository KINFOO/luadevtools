/**
 * @author	Kevin KIN-FOO <kkinfoo@anyware-tech.com>
 * @date $Date: 2009-07-23 12:07:30 +0200 (jeu., 23 juil. 2009) $
 * $Author: kkinfoo $
 * $Id: String.java 2161 2009-07-23 10:07:30Z kkinfoo $
 */
package com.anwrt.ldt.parser.ast.expressions;

import org.eclipse.dltk.ast.expressions.StringLiteral;

/**
 * The Class String.
 */
public class String extends StringLiteral {

	/**
	 * Instantiates a new string.
	 * 
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 */
	public String(int start, int end, java.lang.String value) {
		super(start, end, value);
	}
}
