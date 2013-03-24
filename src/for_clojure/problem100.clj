(ns for-clojure.problem100)

(defn gcd
  ([n1 n2] 
     (if (zero? n2)
       n1
       (recur n2 (rem n1 n2))))
  ([n1 n2 & more]
     (reduce gcd (gcd n1 n2) more)))

(defn least-common-multiple 
  ([n1 n2]
     (/ (* n1 n2) (gcd n1 n2)))
  ([n1 n2 & more]
     (reduce least-common-multiple (least-common-multiple n1 n2) more)))