package com.citec.Compiler.Html;

import com.citec.Compiler.Html.ECMAScriptParser.AdditiveExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.ArgumentListContext;
import com.citec.Compiler.Html.ECMAScriptParser.ArgumentsContext;
import com.citec.Compiler.Html.ECMAScriptParser.ArgumentsExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.ArrayLiteralContext;
import com.citec.Compiler.Html.ECMAScriptParser.ArrayLiteralExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.AssignmentExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.AssignmentOperatorContext;
import com.citec.Compiler.Html.ECMAScriptParser.AssignmentOperatorExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.BitAndExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.BitNotExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.BitOrExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.BitShiftExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.BitXOrExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.BlockContext;
import com.citec.Compiler.Html.ECMAScriptParser.BreakStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.CaseBlockContext;
import com.citec.Compiler.Html.ECMAScriptParser.CaseClauseContext;
import com.citec.Compiler.Html.ECMAScriptParser.CaseClausesContext;
import com.citec.Compiler.Html.ECMAScriptParser.CatchProductionContext;
import com.citec.Compiler.Html.ECMAScriptParser.ContinueStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.DebuggerStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.DefaultClauseContext;
import com.citec.Compiler.Html.ECMAScriptParser.DeleteExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.DoStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.ElementListContext;
import com.citec.Compiler.Html.ECMAScriptParser.ElisionContext;
import com.citec.Compiler.Html.ECMAScriptParser.EmptyStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.EofContext;
import com.citec.Compiler.Html.ECMAScriptParser.EosContext;
import com.citec.Compiler.Html.ECMAScriptParser.EqualityExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.ExpressionSequenceContext;
import com.citec.Compiler.Html.ECMAScriptParser.ExpressionStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.FinallyProductionContext;
import com.citec.Compiler.Html.ECMAScriptParser.ForInStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.ForStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.ForVarInStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.ForVarStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.FormalParameterListContext;
import com.citec.Compiler.Html.ECMAScriptParser.FunctionBodyContext;
import com.citec.Compiler.Html.ECMAScriptParser.FunctionDeclarationContext;
import com.citec.Compiler.Html.ECMAScriptParser.FunctionExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.FutureReservedWordContext;
import com.citec.Compiler.Html.ECMAScriptParser.GetterContext;
import com.citec.Compiler.Html.ECMAScriptParser.IdentifierExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.IdentifierNameContext;
import com.citec.Compiler.Html.ECMAScriptParser.IfStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.InExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.InitialiserContext;
import com.citec.Compiler.Html.ECMAScriptParser.InstanceofExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.KeywordContext;
import com.citec.Compiler.Html.ECMAScriptParser.LabelledStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.LiteralContext;
import com.citec.Compiler.Html.ECMAScriptParser.LiteralExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.LogicalAndExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.LogicalOrExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.MemberDotExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.MemberIndexExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.MultiplicativeExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.NewExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.NotExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.NumericLiteralContext;
import com.citec.Compiler.Html.ECMAScriptParser.ObjectLiteralContext;
import com.citec.Compiler.Html.ECMAScriptParser.ObjectLiteralExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.ParenthesizedExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.PostDecreaseExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.PostIncrementExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.PreDecreaseExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.PreIncrementExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.ProgramContext;
import com.citec.Compiler.Html.ECMAScriptParser.PropertyExpressionAssignmentContext;
import com.citec.Compiler.Html.ECMAScriptParser.PropertyGetterContext;
import com.citec.Compiler.Html.ECMAScriptParser.PropertyNameAndValueListContext;
import com.citec.Compiler.Html.ECMAScriptParser.PropertyNameContext;
import com.citec.Compiler.Html.ECMAScriptParser.PropertySetParameterListContext;
import com.citec.Compiler.Html.ECMAScriptParser.PropertySetterContext;
import com.citec.Compiler.Html.ECMAScriptParser.RelationalExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.ReservedWordContext;
import com.citec.Compiler.Html.ECMAScriptParser.ReturnStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.SetterContext;
import com.citec.Compiler.Html.ECMAScriptParser.SourceElementContext;
import com.citec.Compiler.Html.ECMAScriptParser.SourceElementsContext;
import com.citec.Compiler.Html.ECMAScriptParser.StatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.StatementListContext;
import com.citec.Compiler.Html.ECMAScriptParser.SwitchStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.TernaryExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.ThisExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.ThrowStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.TryStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.TypeofExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.UnaryMinusExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.UnaryPlusExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.VariableDeclarationContext;
import com.citec.Compiler.Html.ECMAScriptParser.VariableDeclarationListContext;
import com.citec.Compiler.Html.ECMAScriptParser.VariableStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.VoidExpressionContext;
import com.citec.Compiler.Html.ECMAScriptParser.WhileStatementContext;
import com.citec.Compiler.Html.ECMAScriptParser.WithStatementContext;

public class EvalVisitorJavaScript extends ECMAScriptBaseVisitor<String>{

	@Override
	public String visitArrayLiteral(ArrayLiteralContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArrayLiteral(ctx);
	}

	@Override
	public String visitBitOrExpression(BitOrExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBitOrExpression(ctx);
	}

	@Override
	public String visitGetter(GetterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitGetter(ctx);
	}

	@Override
	public String visitExpressionStatement(ExpressionStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExpressionStatement(ctx);
	}

	@Override
	public String visitInstanceofExpression(InstanceofExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitInstanceofExpression(ctx);
	}

	@Override
	public String visitObjectLiteralExpression(
			ObjectLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitObjectLiteralExpression(ctx);
	}

	@Override
	public String visitWhileStatement(WhileStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitWhileStatement(ctx);
	}

	@Override
	public String visitArrayLiteralExpression(ArrayLiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArrayLiteralExpression(ctx);
	}

	@Override
	public String visitArgumentsExpression(ArgumentsExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArgumentsExpression(ctx);
	}

	@Override
	public String visitExpressionSequence(ExpressionSequenceContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExpressionSequence(ctx);
	}

	@Override
	public String visitForStatement(ForStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitForStatement(ctx);
	}

	@Override
	public String visitWithStatement(WithStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitWithStatement(ctx);
	}

	@Override
	public String visitFunctionExpression(FunctionExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFunctionExpression(ctx);
	}

	@Override
	public String visitReservedWord(ReservedWordContext ctx) {
		// TODO Auto-generated method stub
		return super.visitReservedWord(ctx);
	}

	@Override
	public String visitParenthesizedExpression(
			ParenthesizedExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParenthesizedExpression(ctx);
	}

	@Override
	public String visitPropertyExpressionAssignment(
			PropertyExpressionAssignmentContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPropertyExpressionAssignment(ctx);
	}

	@Override
	public String visitDefaultClause(DefaultClauseContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDefaultClause(ctx);
	}

	@Override
	public String visitNewExpression(NewExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNewExpression(ctx);
	}

	@Override
	public String visitForVarInStatement(ForVarInStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitForVarInStatement(ctx);
	}

	@Override
	public String visitPostDecreaseExpression(PostDecreaseExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPostDecreaseExpression(ctx);
	}

	@Override
	public String visitCaseBlock(CaseBlockContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCaseBlock(ctx);
	}

	@Override
	public String visitRelationalExpression(RelationalExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRelationalExpression(ctx);
	}

	@Override
	public String visitBreakStatement(BreakStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBreakStatement(ctx);
	}

	@Override
	public String visitAdditiveExpression(AdditiveExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAdditiveExpression(ctx);
	}

	@Override
	public String visitMultiplicativeExpression(
			MultiplicativeExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultiplicativeExpression(ctx);
	}

	@Override
	public String visitForInStatement(ForInStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitForInStatement(ctx);
	}

	@Override
	public String visitObjectLiteral(ObjectLiteralContext ctx) {
		// TODO Auto-generated method stub
		return super.visitObjectLiteral(ctx);
	}

	@Override
	public String visitDoStatement(DoStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDoStatement(ctx);
	}

	@Override
	public String visitAssignmentExpression(AssignmentExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssignmentExpression(ctx);
	}

	@Override
	public String visitVariableStatement(VariableStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVariableStatement(ctx);
	}

	@Override
	public String visitPropertyNameAndValueList(
			PropertyNameAndValueListContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPropertyNameAndValueList(ctx);
	}

	@Override
	public String visitBlock(BlockContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBlock(ctx);
	}

	@Override
	public String visitNotExpression(NotExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNotExpression(ctx);
	}

	@Override
	public String visitSetter(SetterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSetter(ctx);
	}

	@Override
	public String visitUnaryMinusExpression(UnaryMinusExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitUnaryMinusExpression(ctx);
	}

	@Override
	public String visitNumericLiteral(NumericLiteralContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNumericLiteral(ctx);
	}

	@Override
	public String visitFormalParameterList(FormalParameterListContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFormalParameterList(ctx);
	}

	@Override
	public String visitVoidExpression(VoidExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVoidExpression(ctx);
	}

	@Override
	public String visitLiteralExpression(LiteralExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLiteralExpression(ctx);
	}

	@Override
	public String visitBitNotExpression(BitNotExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBitNotExpression(ctx);
	}

	@Override
	public String visitTypeofExpression(TypeofExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTypeofExpression(ctx);
	}

	@Override
	public String visitAssignmentOperatorExpression(
			AssignmentOperatorExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssignmentOperatorExpression(ctx);
	}

	@Override
	public String visitSwitchStatement(SwitchStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSwitchStatement(ctx);
	}

	@Override
	public String visitArguments(ArgumentsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArguments(ctx);
	}

	@Override
	public String visitVariableDeclarationList(
			VariableDeclarationListContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVariableDeclarationList(ctx);
	}

	@Override
	public String visitEqualityExpression(EqualityExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEqualityExpression(ctx);
	}

	@Override
	public String visitBitXOrExpression(BitXOrExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBitXOrExpression(ctx);
	}

	@Override
	public String visitEof(EofContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEof(ctx);
	}

	@Override
	public String visitFunctionDeclaration(FunctionDeclarationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFunctionDeclaration(ctx);
	}

	@Override
	public String visitThrowStatement(ThrowStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitThrowStatement(ctx);
	}

	@Override
	public String visitThisExpression(ThisExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitThisExpression(ctx);
	}

	@Override
	public String visitSourceElements(SourceElementsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSourceElements(ctx);
	}

	@Override
	public String visitReturnStatement(ReturnStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitReturnStatement(ctx);
	}

	@Override
	public String visitPreDecreaseExpression(PreDecreaseExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPreDecreaseExpression(ctx);
	}

	@Override
	public String visitInExpression(InExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitInExpression(ctx);
	}

	@Override
	public String visitVariableDeclaration(VariableDeclarationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVariableDeclaration(ctx);
	}

	@Override
	public String visitEos(EosContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEos(ctx);
	}

	@Override
	public String visitMemberDotExpression(MemberDotExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMemberDotExpression(ctx);
	}

	@Override
	public String visitDeleteExpression(DeleteExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDeleteExpression(ctx);
	}

	@Override
	public String visitCaseClauses(CaseClausesContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCaseClauses(ctx);
	}

	@Override
	public String visitPreIncrementExpression(PreIncrementExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPreIncrementExpression(ctx);
	}

	@Override
	public String visitLabelledStatement(LabelledStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLabelledStatement(ctx);
	}

	@Override
	public String visitPropertyName(PropertyNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPropertyName(ctx);
	}

	@Override
	public String visitBitShiftExpression(BitShiftExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBitShiftExpression(ctx);
	}

	@Override
	public String visitLogicalOrExpression(LogicalOrExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLogicalOrExpression(ctx);
	}

	@Override
	public String visitDebuggerStatement(DebuggerStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDebuggerStatement(ctx);
	}

	@Override
	public String visitPostIncrementExpression(
			PostIncrementExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPostIncrementExpression(ctx);
	}

	@Override
	public String visitEmptyStatement(EmptyStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEmptyStatement(ctx);
	}

	@Override
	public String visitStatementList(StatementListContext ctx) {
		// TODO Auto-generated method stub
		return super.visitStatementList(ctx);
	}

	@Override
	public String visitStatement(StatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitStatement(ctx);
	}

	@Override
	public String visitPropertyGetter(PropertyGetterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPropertyGetter(ctx);
	}

	@Override
	public String visitProgram(ProgramContext ctx) {
		// TODO Auto-generated method stub
		return super.visitProgram(ctx);
	}

	@Override
	public String visitElision(ElisionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitElision(ctx);
	}

	@Override
	public String visitCaseClause(CaseClauseContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCaseClause(ctx);
	}

	@Override
	public String visitForVarStatement(ForVarStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitForVarStatement(ctx);
	}

	@Override
	public String visitAssignmentOperator(AssignmentOperatorContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssignmentOperator(ctx);
	}

	@Override
	public String visitTernaryExpression(TernaryExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTernaryExpression(ctx);
	}

	@Override
	public String visitLogicalAndExpression(LogicalAndExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLogicalAndExpression(ctx);
	}

	@Override
	public String visitPropertySetParameterList(
			PropertySetParameterListContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPropertySetParameterList(ctx);
	}

	@Override
	public String visitPropertySetter(PropertySetterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPropertySetter(ctx);
	}

	@Override
	public String visitElementList(ElementListContext ctx) {
		// TODO Auto-generated method stub
		return super.visitElementList(ctx);
	}

	@Override
	public String visitTryStatement(TryStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTryStatement(ctx);
	}

	@Override
	public String visitIdentifierExpression(IdentifierExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIdentifierExpression(ctx);
	}

	@Override
	public String visitBitAndExpression(BitAndExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBitAndExpression(ctx);
	}

	@Override
	public String visitIdentifierName(IdentifierNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIdentifierName(ctx);
	}

	@Override
	public String visitFinallyProduction(FinallyProductionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFinallyProduction(ctx);
	}

	@Override
	public String visitFutureReservedWord(FutureReservedWordContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFutureReservedWord(ctx);
	}

	@Override
	public String visitKeyword(KeywordContext ctx) {
		// TODO Auto-generated method stub
		return super.visitKeyword(ctx);
	}

	@Override
	public String visitUnaryPlusExpression(UnaryPlusExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitUnaryPlusExpression(ctx);
	}

	@Override
	public String visitFunctionBody(FunctionBodyContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFunctionBody(ctx);
	}

	@Override
	public String visitContinueStatement(ContinueStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitContinueStatement(ctx);
	}

	@Override
	public String visitArgumentList(ArgumentListContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArgumentList(ctx);
	}

	@Override
	public String visitIfStatement(IfStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIfStatement(ctx);
	}

	@Override
	public String visitInitialiser(InitialiserContext ctx) {
		// TODO Auto-generated method stub
		return super.visitInitialiser(ctx);
	}

	@Override
	public String visitSourceElement(SourceElementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSourceElement(ctx);
	}

	@Override
	public String visitCatchProduction(CatchProductionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCatchProduction(ctx);
	}

	@Override
	public String visitMemberIndexExpression(MemberIndexExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMemberIndexExpression(ctx);
	}

	@Override
	public String visitLiteral(LiteralContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLiteral(ctx);
	}

}
