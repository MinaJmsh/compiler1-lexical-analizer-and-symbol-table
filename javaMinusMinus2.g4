grammar javaMinusMinus2;

/*
  Parser Rules
*/

program
  : importDecl* mainClass classDecl* interfaceDecl* EOF
  ;

importDecl
  : 'import' Identifier ('.' Identifier)* ('.' '*')? ';'
  ;

mainClass
  : 'class' Identifier '{'
        'public' 'static' 'void' 'main' '(' 'String' '[' ']' Identifier ')' '{'
            statement*
        '}'
    '}'
  ;

classDecl
  : 'abstract'? 'class' Identifier
      ( 'extends' Identifier | 'implements' Identifier (',' Identifier)* )?
      '{'
         fieldDecl*
         ctorDecl?
         methodDecl*
         abstractMethodDecl*
      '}'
  ;

interfaceDecl
  : 'interface' Identifier '{'
        interfaceFieldDecl*
        interfaceMethodDecl*
    '}'
  ;

interfaceMethodDecl
  : (type | 'void') Identifier '(' parameterList? ')' ';'
  ;

interfaceFieldDecl
  : type Identifier EQ expression ';'
  ;

fieldDecl
  : varDecl
  ;

localDecl
  : type Identifier (EQ expression)? ';'
  ;

varDecl
  : accessModifier? type Identifier ';'
  ;

methodDecl
  : '@Override'? accessModifier? (type | 'void') Identifier '(' parameterList? ')' '{' methodBody '}'
  ;

ctorDecl
  : '@Override'? accessModifier? Identifier '(' parameterList? ')' '{' methodBody '}'
  ;

abstractMethodDecl
  : '@Override'? accessModifier? 'abstract' (type | 'void') Identifier '(' parameterList? ')' ';'
  ;

parameterList
  : parameter (',' parameter)*
  ;

parameter
  : type Identifier
  ;

methodBody
  : (localDecl | statement)* (RETURN expression? ';')?
  ;

type
  : (javaType | Identifier) (LSB RSB)?
  ;

javaType
  : 'boolean'
  | 'int'
  | 'char'
  | 'String'
  ;

accessModifier
  : 'private'
  | 'public'
  | 'protected'
  | 'internal'
  ;

/* -------------------- Statements -------------------- */

statement
  : '{' statement* '}'                                         #blockStmt
  | 'if' LP expression RP statement ('else' statement)?         #ifElseStmt
  | 'while' LP expression RP statement                          #whileStmt
  | forStmt                                                     #forStatement
  | printStmt                                                   #printStatement
  | 'read' LP designator RP ';'                                 #readStmt
  | exprStmt                                                    #exprOnlyStmt
  | localDecl                                                   #localDeclStmt
  | 'break' ';'                                                 #breakStmt
  | 'continue' ';'                                              #continueStmt
  ;

forStmt
  : 'for' LP forInit? ';' expression? ';' forUpdate? RP statement
  ;

forInit
  : localDeclNoSemi
  | assignment (',' assignment)*
  ;

forUpdate
  : assignment (',' assignment)*
  ;


localDeclNoSemi
  : type Identifier (EQ expression)?
  ;

printStmt
  : 'print' LP expressionOrString RP ';'
  ;

exprStmt
  : assignment ';'
  ;

/* -------------------- Assignments & Designators -------------------- */

assignment
  : designator EQ expression
  ;

designator
  : primaryDesignator designatorPrime
  ;

primaryDesignator
  : Identifier
  ;

designatorPrime
  : ( '.' Identifier
    | LSB expression RSB
    )*
  ;

expressionOrString
  : expression
  | StringLiteral
  ;

/* -------------------- Expressions -------------------- */

expression
  : primaryExpression expressionPrime
  ;

expressionPrime
  : LSB expression RSB expressionPrime                         #arrayAccessExpr
  | DOTLENGTH expressionPrime                                  #arrayLengthExpr
  | '.' Identifier LP (expression (',' expression)*)? RP expressionPrime  #methodCallExpr
  | POWER primaryExpression expressionPrime                    #powExpr
  | TIMES primaryExpression expressionPrime                    #mulExpr
  | DIV   primaryExpression expressionPrime                    #divExpr
  | MOD   primaryExpression expressionPrime                    #modExpr
  | PLUS  primaryExpression expressionPrime                    #addExpr
  | MINUS primaryExpression expressionPrime                    #subExpr
  | LT    primaryExpression expressionPrime                    #ltExpr
  | LE    primaryExpression expressionPrime                    #leExpr
  | GT    primaryExpression expressionPrime                    #gtExpr
  | GE    primaryExpression expressionPrime                    #geExpr
  | EQEQ  primaryExpression expressionPrime                    #eqExpr
  | NEQ   primaryExpression expressionPrime                    #neqExpr
  | AND   primaryExpression expressionPrime                    #andExpr
  | OR    primaryExpression expressionPrime                    #orExpr
  | /* ε */                                                    #emptyExprTail
  ;

primaryExpression
  : NOT primaryExpression                                      #notExpr
  | MINUS primaryExpression                                    #unaryMinusExpr
  | 'new' type LP (expression (',' expression)*)? RP           #newObjectExpr
  | 'new' type LSB expression RSB                              #newArrayExpr
  | '{' IntegerLiteral (',' IntegerLiteral)* '}'               #intArrayLiteralExpr
  | IntegerLiteral                                             #intLitExpr
  | CharLiteral                                                #charLitExpr
  | BooleanLiteral                                             #boolLitExpr
  | NullLiteral                                                #nullLitExpr
  | StringLiteral                                              #stringLitExpr
  | 'this'                                                     #thisExpr
  | LP expression RP                                           #parenExpr
  | primaryDesignator                                          #identExpr
  ;

/*
  Lexer Rules
*/

AND      : '&&';
OR       : '||';
LT       : '<';
LE       : '<=';
GT       : '>';
GE       : '>=';
EQEQ     : '==';
NEQ      : '!=';
PLUS     : '+';
MINUS    : '-';
TIMES    : '*';
DIV      : '/';
MOD      : '%';
POWER    : '**';
NOT      : '!';
LSB      : '[';
RSB      : ']';
DOTLENGTH: '.length';
LP       : '(';
RP       : ')';
RETURN   : 'return';
EQ       : '=';

BooleanLiteral
  : 'true'
  | 'false'
  ;

NullLiteral
  : 'null'
  ;

StringLiteral
  : '"' ( ~["\\] | '\\' . )* '"'
  ;

CharLiteral
  : '\'' ( ~['\\\r\n] | '\\' . ) '\''
  ;

Identifier
  : JavaLetter JavaLetterOrDigit*
  ;

fragment JavaLetter
  : [a-zA-Z$_]
  ;

fragment JavaLetterOrDigit
  : [a-zA-Z0-9$_]
  ;

IntegerLiteral
  : DecimalIntegerLiteral
  ;

fragment DecimalIntegerLiteral
  : DecimalNumeral IntegerTypeSuffix?
  ;

fragment IntegerTypeSuffix
  : [lL]
  ;

fragment DecimalNumeral
  : '0'
  | NonZeroDigit (Digits? | Underscores Digits)
  ;

fragment Digits
  : Digit (DigitsAndUnderscores? Digit)?
  ;

fragment Digit
  : '0' | NonZeroDigit
  ;

fragment NonZeroDigit
  : [1-9]
  ;

fragment DigitsAndUnderscores
  : DigitOrUnderscore+
  ;

fragment DigitOrUnderscore
  : Digit | '_'
  ;

fragment Underscores
  : '_'+
  ;

/* Whitespace & Comments */
WS  : [ \t\r\n\u000C]+ -> skip ;
MULTILINE_COMMENT : '/*' .*? '*/' -> skip ;
LINE_COMMENT      : '//' ~[\r\n]* -> skip ;
