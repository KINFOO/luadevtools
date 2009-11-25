package com.anwrt.ldt.parser.ast.statements;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.ast.expressions.Expression;

public class ElseIf extends If {

	/** Logical conditions of `ElseIf node */
	private List<Expression> expression;

	/** Chunk with `ElseIf condition */
	private List<Chunk> chunk;

	/**
	 * Define the structure of a traditional `If statement.
	 * 
	 * @param start
	 *            Position of first character of statement in source
	 * @param end
	 *            Position of last character of statement in source
	 * @param condition
	 *            Logical {@link Expression} of `If nodes
	 * @param nominal
	 *            Executed {@link Expression} associated with condition
	 * */
	public ElseIf(int start, int end, Expression condition, Chunk nominal) {
		super(start, end, condition, nominal);
		this.expression = new ArrayList<Expression>();
		this.chunk = new ArrayList<Chunk>();

	}

	public ElseIf(int start, int end, Expression condition, Chunk nominal,
			Chunk alternative) {
		this(start, end, condition, nominal);
		this.setAlternative(alternative);
	}

	/**
	 * Append a new { Expression, Chunk } to current statement
	 * 
	 * @param e
	 *            {@link Expression} of the current block
	 * @param c
	 *            {@link Chunk} of the current block
	 */
	public void addExpressionAndRelatedChunk(Expression e, Chunk c) {
		expression.add(e);
		chunk.add(c);
	}

	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {

			// Iterate over each { Expression, Chunk } pair
			super.traverse(visitor);
			for (int k = 0; k < expression.size(); k++) {
				Expression condition = (Expression) expression.get(k);
				Chunk bloc = (Chunk) chunk.get(k);

				// Traverse each of them
				condition.traverse(visitor);
				bloc.traverse(visitor);
			}
			visitor.endvisit(this);
		}
	}
}
