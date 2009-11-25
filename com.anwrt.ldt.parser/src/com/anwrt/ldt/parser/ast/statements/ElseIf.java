package com.anwrt.ldt.parser.ast.statements;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.ast.expressions.Expression;

public class ElseIf extends If {

	private List<Expression> expression;
	private List<Chunk> chunk;

	private void allocateLists() {
		this.expression = new ArrayList<Expression>();
		this.chunk = new ArrayList<Chunk>();

	}

	public ElseIf(int start, int end, Expression condition, Chunk nominal) {
		super(start, end, condition, nominal);
		allocateLists();
	}

	public ElseIf(int start, int end, Expression condition, Chunk nominal,
			Chunk alternative) {
		super(start, end, condition, nominal, alternative);
		allocateLists();
	}

	public void addExpressionAndRelatedChunk(Expression e, Chunk c) {
		expression.add(e);
		chunk.add(c);
	}

	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			super.traverse(visitor);
			for (int k = 0; k < expression.size(); k++) {
				Expression condition = (Expression) expression.get(k);
				Chunk bloc = (Chunk) chunk.get(k);
				condition.traverse(visitor);
				bloc.traverse(visitor);
			}
			visitor.endvisit(this);
		}
	}
}
