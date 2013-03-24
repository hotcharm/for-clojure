(ns for-clojure.problem135)

(defn infix-calculator
  "前缀计算机，从左到右执行，不论优先级"
  [& xs]
  (loop [r (first xs)
         xs (rest xs)]
    (if (empty? xs)
      r
      (recur ((first xs) r (second xs)) (nthrest xs 2)))))

(= 72 (infix-calculator 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))

 