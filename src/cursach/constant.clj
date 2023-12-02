(ns cursach.constant
  (:require [cursach.project-configs])
  (:import (cursach.project_configs ConstantClass)))

;Генератор констант.
;@params value: - значение константы.
;@return объект, поражденный классом ConstantClass. Если параметры не валидны, то вернет исключение.
(defn create_constant [value]
  (ConstantClass. :constant value)
)

