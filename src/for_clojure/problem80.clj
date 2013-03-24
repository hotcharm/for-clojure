(ns for-clojure.problem80)

(defn perfect-number 
  "某个数的所有的因数之和刚好等于这个数，那么这个数就是perfect number，如 6 = 1 + 2 + 3"
  [n]
  (loop [s 0
         c 1]
    (if (= c n)
      (= s n)
      (if (zero? (rem n c))
        (recur (+ s c) (inc c))
        (recur s (inc c))))))