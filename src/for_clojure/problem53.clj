(ns for-clojure.problem53)

(defn longest-increasing-sub-seq
  [v]
  (loop [result []
         cur-inc-seq []
         v v]
    (if (empty? v)
      (if (= 1 (count result))
        []
        result)
      (let [max-cnt (count result)
            cur-cnt (count cur-inc-seq)
            cur-ele (first v)
            last-ele (last cur-inc-seq)
            rest-eles (rest v)]
        (if (or (nil? last-ele) (< last-ele cur-ele))
          (if (= max-cnt cur-cnt)
            (recur (conj cur-inc-seq cur-ele) (conj cur-inc-seq cur-ele) rest-eles)
            (recur result (conj cur-inc-seq cur-ele) rest-eles))
          (recur result [cur-ele] rest-eles))))))

(longest-increasing-sub-seq [1 0 1 2 3 0 4 5])
(= (longest-increasing-sub-seq [5 6 1 3 2 7]) [5 6])
(= (longest-increasing-sub-seq [7 6 5 4]) [])
