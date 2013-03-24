(ns for-clojure.problem60)
(defn seq-reduce
  [f coll]
  (let [new-ele (f (first coll) (second coll))
        nth2-rest (nthrest coll 2)]
    (if (empty? nth2-rest)
      [new-ele]
      (cons  new-ele (lazy-seq (seq-reduce f 
                                           (cons new-ele (nthrest coll 2))))))))

(defn sequence-reductions 
  ([f coll]
     (cons (first coll) (seq-reduce f coll)))
  ([f init coll]
     (sequence-reductions f (cons init coll))))