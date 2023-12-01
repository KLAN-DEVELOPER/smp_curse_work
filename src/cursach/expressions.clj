(ns cursach.expressions)

;Протокол, содержащий геттеры для выражений
;getValue - метод, который возвращает результат выражения
;getType  - метод, который возвращает тип выражения.
;getDNF   - метод, который возвращает ДНФ выражения.
(defprotocol ExprGetters
  (getValue [this])
  (getType [this])
  (getDNF [this])
)
;Протокол, содержащий сеттеры для выражений
;setValue - метод, который устанавливает новое значение выражения.
(defprotocol ExprSetters
  (setValue [this new_value])
)


;Класс, содержащий интерфейс выражений.
;@params class_type:Keyword - тип выражения.
;@params expr1:(Constant||Variable||Expr) - первое передаваемое выражение.
;@params expr2:(Constant||Variable||Expr) - второе передаваемое выражение.
;@params getValueFn:Fn - функция для получения результата выражения.
;@params getDnfFn:Fn - функция для получения ДНФ выражения.
(deftype ExprClass [class_type getValueFn getDnfFn expr1 expr2]
  ExprGetters
  (getValue [this] (getValueFn expr1 expr2))
  (getType [this] class_type)
  (getDNF [this]
    (getDnfFn expr1 expr2)
    )
  )

;Проверяет тип переданного параметра.
;@params expr:Any - данные, который нужно проверить на выражение.
;@return Возвращает true, если переданный параметр является выражением. False в противном случае.
(defn isExpr
  [expr]
  (def class_type (.getType expr))
  (or
    (= class_type :constant)
    (= class_type :variable)
    (= class_type :conjunction)
    (= class_type :disjunction)
    (= class_type :implication)
    (= class_type :no)
  )
)

;Генератор обертки для ДНФ.
;@param dnf:String - ДНФ выражения.
;@return Днф без изменений, если его длина равна 1. В противном случае вернет dnf обернутый в круглые скобки.
(defn dnfScopeWrapper
  [dnf]
  (if (> (count dnf) 1)
    (str "(" dnf ")")
    dnf)
)