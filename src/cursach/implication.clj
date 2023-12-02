(ns cursach.implication
  (:require [cursach.configs.implication-config :refer [getExprValue getDnf]])
  (:import (cursach.expressions ExprClass)))


;Генератор импликаций.
;@params expr1:(Constant||Variable||Expr) - первое значение импликаций.
;@params expr2:(Constant||Variable||Expr) - второе значение импликаций.
;@return объект, поражденный классом ExprClass.
(defn create_implication [expr1 expr2]
  (ExprClass. :implication getExprValue getDnf expr1 expr2)
)