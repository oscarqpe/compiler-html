// Generated from ECMAScript.g4 by ANTLR 4.0
package com.citec.Compiler.Html;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface ECMAScriptVisitor<T> extends ParseTreeVisitor<T> {
	T visitArrayLiteral(ECMAScriptParser.ArrayLiteralContext ctx);

	T visitBitOrExpression(ECMAScriptParser.BitOrExpressionContext ctx);

	T visitGetter(ECMAScriptParser.GetterContext ctx);

	T visitExpressionStatement(ECMAScriptParser.ExpressionStatementContext ctx);

	T visitInstanceofExpression(ECMAScriptParser.InstanceofExpressionContext ctx);

	T visitObjectLiteralExpression(ECMAScriptParser.ObjectLiteralExpressionContext ctx);

	T visitWhileStatement(ECMAScriptParser.WhileStatementContext ctx);

	T visitArrayLiteralExpression(ECMAScriptParser.ArrayLiteralExpressionContext ctx);

	T visitArgumentsExpression(ECMAScriptParser.ArgumentsExpressionContext ctx);

	T visitExpressionSequence(ECMAScriptParser.ExpressionSequenceContext ctx);

	T visitForStatement(ECMAScriptParser.ForStatementContext ctx);

	T visitWithStatement(ECMAScriptParser.WithStatementContext ctx);

	T visitFunctionExpression(ECMAScriptParser.FunctionExpressionContext ctx);

	T visitReservedWord(ECMAScriptParser.ReservedWordContext ctx);

	T visitParenthesizedExpression(ECMAScriptParser.ParenthesizedExpressionContext ctx);

	T visitPropertyExpressionAssignment(ECMAScriptParser.PropertyExpressionAssignmentContext ctx);

	T visitDefaultClause(ECMAScriptParser.DefaultClauseContext ctx);

	T visitNewExpression(ECMAScriptParser.NewExpressionContext ctx);

	T visitForVarInStatement(ECMAScriptParser.ForVarInStatementContext ctx);

	T visitPostDecreaseExpression(ECMAScriptParser.PostDecreaseExpressionContext ctx);

	T visitCaseBlock(ECMAScriptParser.CaseBlockContext ctx);

	T visitRelationalExpression(ECMAScriptParser.RelationalExpressionContext ctx);

	T visitBreakStatement(ECMAScriptParser.BreakStatementContext ctx);

	T visitAdditiveExpression(ECMAScriptParser.AdditiveExpressionContext ctx);

	T visitMultiplicativeExpression(ECMAScriptParser.MultiplicativeExpressionContext ctx);

	T visitForInStatement(ECMAScriptParser.ForInStatementContext ctx);

	T visitObjectLiteral(ECMAScriptParser.ObjectLiteralContext ctx);

	T visitDoStatement(ECMAScriptParser.DoStatementContext ctx);

	T visitAssignmentExpression(ECMAScriptParser.AssignmentExpressionContext ctx);

	T visitVariableStatement(ECMAScriptParser.VariableStatementContext ctx);

	T visitPropertyNameAndValueList(ECMAScriptParser.PropertyNameAndValueListContext ctx);

	T visitBlock(ECMAScriptParser.BlockContext ctx);

	T visitNotExpression(ECMAScriptParser.NotExpressionContext ctx);

	T visitSetter(ECMAScriptParser.SetterContext ctx);

	T visitUnaryMinusExpression(ECMAScriptParser.UnaryMinusExpressionContext ctx);

	T visitNumericLiteral(ECMAScriptParser.NumericLiteralContext ctx);

	T visitFormalParameterList(ECMAScriptParser.FormalParameterListContext ctx);

	T visitVoidExpression(ECMAScriptParser.VoidExpressionContext ctx);

	T visitLiteralExpression(ECMAScriptParser.LiteralExpressionContext ctx);

	T visitBitNotExpression(ECMAScriptParser.BitNotExpressionContext ctx);

	T visitTypeofExpression(ECMAScriptParser.TypeofExpressionContext ctx);

	T visitAssignmentOperatorExpression(ECMAScriptParser.AssignmentOperatorExpressionContext ctx);

	T visitSwitchStatement(ECMAScriptParser.SwitchStatementContext ctx);

	T visitArguments(ECMAScriptParser.ArgumentsContext ctx);

	T visitVariableDeclarationList(ECMAScriptParser.VariableDeclarationListContext ctx);

	T visitEqualityExpression(ECMAScriptParser.EqualityExpressionContext ctx);

	T visitBitXOrExpression(ECMAScriptParser.BitXOrExpressionContext ctx);

	T visitEof(ECMAScriptParser.EofContext ctx);

	T visitFunctionDeclaration(ECMAScriptParser.FunctionDeclarationContext ctx);

	T visitThrowStatement(ECMAScriptParser.ThrowStatementContext ctx);

	T visitThisExpression(ECMAScriptParser.ThisExpressionContext ctx);

	T visitSourceElements(ECMAScriptParser.SourceElementsContext ctx);

	T visitReturnStatement(ECMAScriptParser.ReturnStatementContext ctx);

	T visitPreDecreaseExpression(ECMAScriptParser.PreDecreaseExpressionContext ctx);

	T visitInExpression(ECMAScriptParser.InExpressionContext ctx);

	T visitVariableDeclaration(ECMAScriptParser.VariableDeclarationContext ctx);

	T visitEos(ECMAScriptParser.EosContext ctx);

	T visitMemberDotExpression(ECMAScriptParser.MemberDotExpressionContext ctx);

	T visitDeleteExpression(ECMAScriptParser.DeleteExpressionContext ctx);

	T visitCaseClauses(ECMAScriptParser.CaseClausesContext ctx);

	T visitPreIncrementExpression(ECMAScriptParser.PreIncrementExpressionContext ctx);

	T visitLabelledStatement(ECMAScriptParser.LabelledStatementContext ctx);

	T visitPropertyName(ECMAScriptParser.PropertyNameContext ctx);

	T visitBitShiftExpression(ECMAScriptParser.BitShiftExpressionContext ctx);

	T visitLogicalOrExpression(ECMAScriptParser.LogicalOrExpressionContext ctx);

	T visitDebuggerStatement(ECMAScriptParser.DebuggerStatementContext ctx);

	T visitPostIncrementExpression(ECMAScriptParser.PostIncrementExpressionContext ctx);

	T visitEmptyStatement(ECMAScriptParser.EmptyStatementContext ctx);

	T visitStatementList(ECMAScriptParser.StatementListContext ctx);

	T visitStatement(ECMAScriptParser.StatementContext ctx);

	T visitPropertyGetter(ECMAScriptParser.PropertyGetterContext ctx);

	T visitProgram(ECMAScriptParser.ProgramContext ctx);

	T visitElision(ECMAScriptParser.ElisionContext ctx);

	T visitCaseClause(ECMAScriptParser.CaseClauseContext ctx);

	T visitForVarStatement(ECMAScriptParser.ForVarStatementContext ctx);

	T visitAssignmentOperator(ECMAScriptParser.AssignmentOperatorContext ctx);

	T visitTernaryExpression(ECMAScriptParser.TernaryExpressionContext ctx);

	T visitLogicalAndExpression(ECMAScriptParser.LogicalAndExpressionContext ctx);

	T visitPropertySetParameterList(ECMAScriptParser.PropertySetParameterListContext ctx);

	T visitPropertySetter(ECMAScriptParser.PropertySetterContext ctx);

	T visitElementList(ECMAScriptParser.ElementListContext ctx);

	T visitTryStatement(ECMAScriptParser.TryStatementContext ctx);

	T visitIdentifierExpression(ECMAScriptParser.IdentifierExpressionContext ctx);

	T visitBitAndExpression(ECMAScriptParser.BitAndExpressionContext ctx);

	T visitIdentifierName(ECMAScriptParser.IdentifierNameContext ctx);

	T visitFinallyProduction(ECMAScriptParser.FinallyProductionContext ctx);

	T visitFutureReservedWord(ECMAScriptParser.FutureReservedWordContext ctx);

	T visitKeyword(ECMAScriptParser.KeywordContext ctx);

	T visitUnaryPlusExpression(ECMAScriptParser.UnaryPlusExpressionContext ctx);

	T visitFunctionBody(ECMAScriptParser.FunctionBodyContext ctx);

	T visitContinueStatement(ECMAScriptParser.ContinueStatementContext ctx);

	T visitArgumentList(ECMAScriptParser.ArgumentListContext ctx);

	T visitIfStatement(ECMAScriptParser.IfStatementContext ctx);

	T visitInitialiser(ECMAScriptParser.InitialiserContext ctx);

	T visitSourceElement(ECMAScriptParser.SourceElementContext ctx);

	T visitCatchProduction(ECMAScriptParser.CatchProductionContext ctx);

	T visitMemberIndexExpression(ECMAScriptParser.MemberIndexExpressionContext ctx);

	T visitLiteral(ECMAScriptParser.LiteralContext ctx);
}