package com.anwrt.ldt.parser.ast.expressions;

import org.eclipse.dltk.ast.expressions.BooleanLiteral;

import com.anwrt.ldt.parser.LuaExpressionConstants;

public class Boolean extends BooleanLiteral implements LuaExpressionConstants {

	public Boolean(int start, int end, boolean b) {
		super(start, end, b);
	}

	public int getKind() {
		return boolValue() ? BOOL_TRUE : BOOL_FALSE;
	}

}
