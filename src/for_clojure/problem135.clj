(ns for-clojure.problem135)

(defn infix-calculator
  "ǰ׺�������������ִ�У��������ȼ�"
  [& xs]
  (loop [r (first xs)
         xs (rest xs)]
    (if (empty? xs)
      r
      (recur ((first xs) r (second xs)) (nthrest xs 2)))))

(= 72 (infix-calculator 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))

 