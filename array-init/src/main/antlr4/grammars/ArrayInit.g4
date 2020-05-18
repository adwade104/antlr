grammar ArrayInit;
import CommonLexerRules;

init : '{' value (',' value)* '}' ;

value : init
      | INT
      ;
