(ns cursach.constant
  (:require [cursach.di-container :refer [di_container]])
)

;Генератор констант.
;@params class_type:Keyword - тип константы.
;@params value: - значение константы.
;@return объект, поражденный классом ConstantClass. Если параметры не валидны, то вернет исключение.
(defn create_constant [config_name]
  (.createObject di_container config_name nil)
)

