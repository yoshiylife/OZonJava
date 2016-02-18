/*
 Copyright(c) 1996-1998
 IPA, ETL, AT21, FSIABC, FXIS, InArc, MRI, NUL, SBC, Sharp, TEC, TIS

 All rights reserved.  No guarantee.
 This technology is a result of the Advanced Software  Enrichment 
 Project of Information-technology Promotion Agency, Japan (IPA).

 Permissions  to  use,  copy, modify and distribute this software
 are governed by the terms and conditions set forth in  the  file 
 COPYRIGHT, located on the top directory of this software.
 */

/*
 * $Id: version.java,v 0.131 1998/03/22 23:42:16 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 199.1.27
 */

package JP.go.ipa.oz.compiler;

/**
  * A class for embbeded version string 
  */

class version {
  /**
    * version string
    */
  static final String version_string = "ozc version 1.1.1";

/* 
AlreadyDefined.java:
     AlreadyDefined.java,v 0.3 1997-06-04 16:49:06+09 otokawa Exp $

AssignBoolExp.java:
     AssignBoolExp.java,v 0.6 1997-07-02 16:35:34+09 otokawa Exp $

AssignExp.java:
     AssignExp.java,v 0.17 1998-01-22 08:45:35+09 otokawa Exp $

AssignNumericExp.java:
     AssignNumericExp.java,v 0.8 1997-07-11 18:25:28+09 otokawa Exp $

AttributeAccessExp.java:
     AttributeAccessExp.java,v 0.17 1998-03-19 14:22:10+09 otokawa Exp $

AttributeTable.java:
     AttributeTable.java,v 0.5 1997-06-17 17:56:13+09 otokawa Exp $

BinaryBoolExp.java:
     BinaryBoolExp.java,v 0.12 1998-01-30 11:04:41+09 otokawa Exp $

BinaryExp.java:
     BinaryExp.java,v 0.15 1998-01-22 08:45:36+09 otokawa Exp $

CatchSt.java:
     CatchSt.java,v 0.21 1998-02-02 08:31:21+09 otokawa Exp $

CatchStList.java:
     CatchStList.java,v 0.13 1998-02-02 08:31:22+09 otokawa Exp $

ClassImplementation.java:
     ClassImplementation.java,v 0.37 1998-01-30 11:04:43+09 otokawa Exp $

ClassInfoWriter.java:
     ClassInfoWriter.java,v 0.1 1997-07-09 10:57:30+09 otokawa Exp $

ClassInterface.java:
     ClassInterface.java,v 0.20 1998-01-30 11:04:44+09 otokawa Exp $

ClassList.java:
     ClassList.java,v 0.7 1997-07-04 11:15:18+09 otokawa Exp $

ClassMember.java:
     ClassMember.java,v 0.21 1997-10-22 17:00:09+09 otokawa Exp $

ClassSymbol.java:
     ClassSymbol.java,v 0.4 1997-07-10 15:46:09+09 otokawa Exp $

ClassType.java:
     ClassType.java,v 0.35 1998-03-19 14:22:12+09 otokawa Exp $

CompoundSt.java:
     CompoundSt.java,v 0.12 1998-02-02 08:31:24+09 otokawa Exp $

ConditionalExp.java:
     ConditionalExp.java,v 0.13 1997-10-09 18:38:26+09 otokawa Exp $

Constants.java:
     Constants.java,v 0.8 1997-06-27 15:00:18+09 otokawa Exp $

DeclarationSt.java:
     DeclarationSt.java,v 0.9 1998-02-02 08:31:25+09 otokawa Exp $

DoSt.java:
     DoSt.java,v 0.7 1998-02-02 08:31:26+09 otokawa Exp $

Emitter.java:
     Emitter.java,v 0.22 1997-11-19 16:11:28+09 otokawa Exp $

Expression.java:
     Expression.java,v 0.13 1998-03-19 14:22:14+09 otokawa Exp $

ExpressionList.java:
     ExpressionList.java,v 0.6 1997-09-17 16:48:24+09 otokawa Exp $

ExpressionSt.java:
     ExpressionSt.java,v 0.13 1998-02-02 08:31:27+09 otokawa Exp $

ExpressionSym.java:
     ExpressionSym.java,v 0.4 1997-06-04 16:49:23+09 otokawa Exp $

ForSt.java:
     ForSt.java,v 0.16 1998-02-02 08:31:28+09 otokawa Exp $

GlobalProxy.java:
     GlobalProxy.java,v 0.16 1997-10-30 15:03:35+09 otokawa Exp $

Identifier.java:
     Identifier.java,v 0.16 1998-03-19 14:22:18+09 otokawa Exp $

IdentifierList.java:
     IdentifierList.java,v 0.9 1997-07-11 18:25:48+09 otokawa Exp $

IdentifierSym.java:
     IdentifierSym.java,v 0.4 1997-06-04 16:49:26+09 otokawa Exp $

IfBodySym.java:
     IfBodySym.java,v 0.4 1997-06-04 16:49:26+09 otokawa Exp $

IfSt.java:
     IfSt.java,v 0.18 1998-02-02 08:31:30+09 otokawa Exp $

InstantiationExp.java:
     InstantiationExp.java,v 0.21 1998-01-30 11:04:55+09 otokawa Exp $

JumpSt.java:
     JumpSt.java,v 0.16 1998-02-02 09:14:18+09 otokawa Exp $

LabelSt.java:
     LabelSt.java,v 0.12 1998-02-02 08:31:32+09 otokawa Exp $

ListSym.java:
     ListSym.java,v 0.4 1997-06-04 16:49:29+09 otokawa Exp $

Literal.java:
     Literal.java,v 0.11 1998-03-19 14:22:19+09 otokawa Exp $

LoopSt.java:
     LoopSt.java,v 0.19 1998-02-02 09:14:21+09 otokawa Exp $

MethodInvocationExp.java:
     MethodInvocationExp.java,v 0.30 1998-03-20 08:43:49+09 otokawa Exp $

MethodTable.java:
     MethodTable.java,v 0.19 1997-07-11 18:25:56+09 otokawa Exp $

MethodType.java:
     MethodType.java,v 0.29 1998-02-02 08:31:34+09 otokawa Exp $

NullSt.java:
     NullSt.java,v 0.4 1997-07-10 15:46:22+09 otokawa Exp $

OverloadingAmbiguous.java:
     OverloadingAmbiguous.java,v 0.3 1997-06-04 16:49:36+09 otokawa Exp $

OzStrToken.java:
     OzStrToken.java,v 0.4 1997-06-17 17:56:30+09 otokawa Exp $

OzToken.java:
     OzToken.java,v 0.6 1997-07-04 11:15:30+09 otokawa Exp $

OzcClassLoader.java:
     OzcClassLoader.java,v 0.20 1998-01-30 11:05:01+09 otokawa Exp $

OzcError.java:
     OzcError.java,v 0.18 1998-03-19 14:22:26+09 otokawa Exp $

OzcProperty.java:
     OzcProperty.java,v 0.12 1998-03-19 14:22:27+09 otokawa Exp $

ParenthesisExp.java:
     ParenthesisExp.java,v 0.8 1997-07-11 18:26:01+09 otokawa Exp $

ParserAction.java:
     ParserAction.java,v 0.38 1998-02-02 08:31:37+09 otokawa Exp $

PrimitiveType.java:
     PrimitiveType.java,v 0.11 1998-03-19 14:22:29+09 otokawa Exp $

ReturnSt.java:
     ReturnSt.java,v 0.14 1998-02-02 08:31:39+09 otokawa Exp $

School.java:
     School.java,v 0.15 1997-07-07 10:25:57+09 otokawa Exp $

ThisExp.java:
     ThisExp.java,v 0.2 1997-06-04 16:49:44+09 otokawa Exp $

Statement.java:
     Statement.java,v 0.9 1998-02-02 08:31:40+09 otokawa Exp $

StatementExpressionList.java:
     StatementExpressionList.java,v 0.2 1997-06-04 16:49:45+09 otokawa Exp $

StatementSym.java:
     StatementSym.java,v 0.4 1997-06-04 16:49:46+09 otokawa Exp $

StopCompilation.java:
     StopCompilation.java,v 0.1 1997-06-26 14:51:45+09 otokawa Exp $

SwitchLabel.java:
     SwitchLabel.java,v 0.9 1998-02-02 08:31:42+09 otokawa Exp $

SwitchSt.java:
     SwitchSt.java,v 0.21 1998-02-02 08:31:42+09 otokawa Exp $

SymbolTable.java:
     SymbolTable.java,v 0.6 1998-01-30 11:05:10+09 otokawa Exp $

ThrowSt.java:
     ThrowSt.java,v 0.21 1998-02-02 08:31:43+09 otokawa Exp $

TryBodySym.java:
     TryBodySym.java,v 0.4 1997-06-04 16:49:50+09 otokawa Exp $

TrySt.java:
     TrySt.java,v 0.15 1998-02-02 08:31:44+09 otokawa Exp $

Type.java:
     Type.java,v 0.17 1998-03-19 14:22:32+09 otokawa Exp $

TypeMismatch.java:
     TypeMismatch.java,v 0.3 1997-06-04 16:49:52+09 otokawa Exp $

TypeSym.java:
     TypeSym.java,v 0.4 1997-06-04 16:49:52+09 otokawa Exp $

UnaryExp.java:
     UnaryExp.java,v 0.14 1998-01-30 11:05:13+09 otokawa Exp $

Unreachable.java:
     Unreachable.java,v 0.5 1997-08-19 13:50:33+09 otokawa Exp $

Variable.java:
     Variable.java,v 0.1 1997-07-15 18:50:38+09 otokawa Exp $

WhileSt.java:
     WhileSt.java,v 0.10 1998-02-02 08:31:46+09 otokawa Exp $

ozc.java:
     ozc.java,v 0.47 1998-02-02 08:31:46+09 otokawa Exp $

scanner.java:
     scanner.java,v 0.14 1998-01-13 18:29:36+09 otokawa Exp $

parser.cup:
     parser.cup,v 0.33 1998-02-02 08:31:47+09 otokawa Exp $

Output.java:
     Output.java,v 0.4 1997-07-09 09:47:03+09 otokawa Exp $

OzOzc_if.java:
     OzOzc_if.java,v 0.9 1998-01-22 09:01:41+09 otokawa Exp $

OzOzc_cl.java:
     OzOzc_cl.java,v 0.20 1997-11-13 16:44:05+09 otokawa Exp $

OzSchool_if.java:
     OzSchool_if.java,v 0.3 1997-11-13 09:52:23+09 otokawa Exp $

OzSchool.java:
     OzSchool.java,v 0.7 1997-08-20 17:20:46+09 otokawa Exp $

OzOutput.java:
     OzOutput.java,v 0.5 1997-07-09 09:47:17+09 otokawa Exp $

OzcUtility.java:
     OzcUtility.java,v 0.1 1998-03-19 14:22:36+09 otokawa Exp $
*/
}

/* EOF */
