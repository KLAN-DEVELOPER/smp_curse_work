(ns cursach.no
  (:require [cursach.di-container :refer [di_container]])
  )

;Генератор булевого не.
;@params expr:(Constant||Variable||Expr) -  значение булевого не.
;@return объект, поражденный классом ExprClass.
(defn create_no [expr]
  (.createObject di_container "no" (list expr ""))
  )