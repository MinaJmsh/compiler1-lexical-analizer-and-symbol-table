// Generated from javaMinusMinus2.g4 by ANTLR 4.13.1
package com.example.jmmparser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link javaMinusMinus2Parser}.
 */
public interface javaMinusMinus2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(javaMinusMinus2Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(javaMinusMinus2Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#importDecl}.
	 * @param ctx the parse tree
	 */
	void enterImportDecl(javaMinusMinus2Parser.ImportDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#importDecl}.
	 * @param ctx the parse tree
	 */
	void exitImportDecl(javaMinusMinus2Parser.ImportDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMainClass(javaMinusMinus2Parser.MainClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMainClass(javaMinusMinus2Parser.MainClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(javaMinusMinus2Parser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(javaMinusMinus2Parser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#interfaceDecl}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDecl(javaMinusMinus2Parser.InterfaceDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#interfaceDecl}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDecl(javaMinusMinus2Parser.InterfaceDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#interfaceMethodDecl}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDecl(javaMinusMinus2Parser.InterfaceMethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#interfaceMethodDecl}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDecl(javaMinusMinus2Parser.InterfaceMethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#interfaceFieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceFieldDecl(javaMinusMinus2Parser.InterfaceFieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#interfaceFieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceFieldDecl(javaMinusMinus2Parser.InterfaceFieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(javaMinusMinus2Parser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(javaMinusMinus2Parser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#localDecl}.
	 * @param ctx the parse tree
	 */
	void enterLocalDecl(javaMinusMinus2Parser.LocalDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#localDecl}.
	 * @param ctx the parse tree
	 */
	void exitLocalDecl(javaMinusMinus2Parser.LocalDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(javaMinusMinus2Parser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(javaMinusMinus2Parser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(javaMinusMinus2Parser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(javaMinusMinus2Parser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#ctorDecl}.
	 * @param ctx the parse tree
	 */
	void enterCtorDecl(javaMinusMinus2Parser.CtorDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#ctorDecl}.
	 * @param ctx the parse tree
	 */
	void exitCtorDecl(javaMinusMinus2Parser.CtorDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#abstractMethodDecl}.
	 * @param ctx the parse tree
	 */
	void enterAbstractMethodDecl(javaMinusMinus2Parser.AbstractMethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#abstractMethodDecl}.
	 * @param ctx the parse tree
	 */
	void exitAbstractMethodDecl(javaMinusMinus2Parser.AbstractMethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(javaMinusMinus2Parser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(javaMinusMinus2Parser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(javaMinusMinus2Parser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(javaMinusMinus2Parser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(javaMinusMinus2Parser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(javaMinusMinus2Parser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(javaMinusMinus2Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(javaMinusMinus2Parser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#javaType}.
	 * @param ctx the parse tree
	 */
	void enterJavaType(javaMinusMinus2Parser.JavaTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#javaType}.
	 * @param ctx the parse tree
	 */
	void exitJavaType(javaMinusMinus2Parser.JavaTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void enterAccessModifier(javaMinusMinus2Parser.AccessModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void exitAccessModifier(javaMinusMinus2Parser.AccessModifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStmt}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(javaMinusMinus2Parser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStmt}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(javaMinusMinus2Parser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifElseStmt}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStmt(javaMinusMinus2Parser.IfElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifElseStmt}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStmt(javaMinusMinus2Parser.IfElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(javaMinusMinus2Parser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(javaMinusMinus2Parser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(javaMinusMinus2Parser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(javaMinusMinus2Parser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStatement}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(javaMinusMinus2Parser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStatement}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(javaMinusMinus2Parser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code readStmt}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReadStmt(javaMinusMinus2Parser.ReadStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code readStmt}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReadStmt(javaMinusMinus2Parser.ReadStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOnlyStmt}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprOnlyStmt(javaMinusMinus2Parser.ExprOnlyStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOnlyStmt}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprOnlyStmt(javaMinusMinus2Parser.ExprOnlyStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code localDeclStmt}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLocalDeclStmt(javaMinusMinus2Parser.LocalDeclStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code localDeclStmt}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLocalDeclStmt(javaMinusMinus2Parser.LocalDeclStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStmt}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(javaMinusMinus2Parser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStmt}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(javaMinusMinus2Parser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continueStmt}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(javaMinusMinus2Parser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continueStmt}
	 * labeled alternative in {@link javaMinusMinus2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(javaMinusMinus2Parser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(javaMinusMinus2Parser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(javaMinusMinus2Parser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(javaMinusMinus2Parser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(javaMinusMinus2Parser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(javaMinusMinus2Parser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(javaMinusMinus2Parser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#localDeclNoSemi}.
	 * @param ctx the parse tree
	 */
	void enterLocalDeclNoSemi(javaMinusMinus2Parser.LocalDeclNoSemiContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#localDeclNoSemi}.
	 * @param ctx the parse tree
	 */
	void exitLocalDeclNoSemi(javaMinusMinus2Parser.LocalDeclNoSemiContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#printStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(javaMinusMinus2Parser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#printStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(javaMinusMinus2Parser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(javaMinusMinus2Parser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(javaMinusMinus2Parser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(javaMinusMinus2Parser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(javaMinusMinus2Parser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#designator}.
	 * @param ctx the parse tree
	 */
	void enterDesignator(javaMinusMinus2Parser.DesignatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#designator}.
	 * @param ctx the parse tree
	 */
	void exitDesignator(javaMinusMinus2Parser.DesignatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#primaryDesignator}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryDesignator(javaMinusMinus2Parser.PrimaryDesignatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#primaryDesignator}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryDesignator(javaMinusMinus2Parser.PrimaryDesignatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#designatorPrime}.
	 * @param ctx the parse tree
	 */
	void enterDesignatorPrime(javaMinusMinus2Parser.DesignatorPrimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#designatorPrime}.
	 * @param ctx the parse tree
	 */
	void exitDesignatorPrime(javaMinusMinus2Parser.DesignatorPrimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#expressionOrString}.
	 * @param ctx the parse tree
	 */
	void enterExpressionOrString(javaMinusMinus2Parser.ExpressionOrStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#expressionOrString}.
	 * @param ctx the parse tree
	 */
	void exitExpressionOrString(javaMinusMinus2Parser.ExpressionOrStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link javaMinusMinus2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(javaMinusMinus2Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link javaMinusMinus2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(javaMinusMinus2Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAccessExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessExpr(javaMinusMinus2Parser.ArrayAccessExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAccessExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessExpr(javaMinusMinus2Parser.ArrayAccessExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayLengthExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterArrayLengthExpr(javaMinusMinus2Parser.ArrayLengthExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayLengthExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitArrayLengthExpr(javaMinusMinus2Parser.ArrayLengthExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodCallExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallExpr(javaMinusMinus2Parser.MethodCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodCallExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallExpr(javaMinusMinus2Parser.MethodCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(javaMinusMinus2Parser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(javaMinusMinus2Parser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(javaMinusMinus2Parser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(javaMinusMinus2Parser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterDivExpr(javaMinusMinus2Parser.DivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitDivExpr(javaMinusMinus2Parser.DivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterModExpr(javaMinusMinus2Parser.ModExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitModExpr(javaMinusMinus2Parser.ModExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(javaMinusMinus2Parser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(javaMinusMinus2Parser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterSubExpr(javaMinusMinus2Parser.SubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitSubExpr(javaMinusMinus2Parser.SubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterLtExpr(javaMinusMinus2Parser.LtExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitLtExpr(javaMinusMinus2Parser.LtExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code leExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterLeExpr(javaMinusMinus2Parser.LeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code leExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitLeExpr(javaMinusMinus2Parser.LeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gtExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterGtExpr(javaMinusMinus2Parser.GtExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gtExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitGtExpr(javaMinusMinus2Parser.GtExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code geExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterGeExpr(javaMinusMinus2Parser.GeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code geExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitGeExpr(javaMinusMinus2Parser.GeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(javaMinusMinus2Parser.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(javaMinusMinus2Parser.EqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code neqExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterNeqExpr(javaMinusMinus2Parser.NeqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code neqExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitNeqExpr(javaMinusMinus2Parser.NeqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(javaMinusMinus2Parser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(javaMinusMinus2Parser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(javaMinusMinus2Parser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(javaMinusMinus2Parser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyExprTail}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void enterEmptyExprTail(javaMinusMinus2Parser.EmptyExprTailContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyExprTail}
	 * labeled alternative in {@link javaMinusMinus2Parser#expressionPrime}.
	 * @param ctx the parse tree
	 */
	void exitEmptyExprTail(javaMinusMinus2Parser.EmptyExprTailContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(javaMinusMinus2Parser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(javaMinusMinus2Parser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpr(javaMinusMinus2Parser.UnaryMinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpr(javaMinusMinus2Parser.UnaryMinusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newObjectExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewObjectExpr(javaMinusMinus2Parser.NewObjectExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newObjectExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewObjectExpr(javaMinusMinus2Parser.NewObjectExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newArrayExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayExpr(javaMinusMinus2Parser.NewArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newArrayExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayExpr(javaMinusMinus2Parser.NewArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intArrayLiteralExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterIntArrayLiteralExpr(javaMinusMinus2Parser.IntArrayLiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intArrayLiteralExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitIntArrayLiteralExpr(javaMinusMinus2Parser.IntArrayLiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intLitExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterIntLitExpr(javaMinusMinus2Parser.IntLitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intLitExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitIntLitExpr(javaMinusMinus2Parser.IntLitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charLitExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterCharLitExpr(javaMinusMinus2Parser.CharLitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charLitExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitCharLitExpr(javaMinusMinus2Parser.CharLitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolLitExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterBoolLitExpr(javaMinusMinus2Parser.BoolLitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolLitExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitBoolLitExpr(javaMinusMinus2Parser.BoolLitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullLitExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterNullLitExpr(javaMinusMinus2Parser.NullLitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullLitExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitNullLitExpr(javaMinusMinus2Parser.NullLitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLitExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringLitExpr(javaMinusMinus2Parser.StringLitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLitExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringLitExpr(javaMinusMinus2Parser.StringLitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterThisExpr(javaMinusMinus2Parser.ThisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitThisExpr(javaMinusMinus2Parser.ThisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(javaMinusMinus2Parser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(javaMinusMinus2Parser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterIdentExpr(javaMinusMinus2Parser.IdentExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identExpr}
	 * labeled alternative in {@link javaMinusMinus2Parser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitIdentExpr(javaMinusMinus2Parser.IdentExprContext ctx);
}