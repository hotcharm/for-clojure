(ns for-clojure.problem97)
(defn pascals-triangle-1
  "杨辉三角"
  [n]
  (if (= n 1)
    [1]
  (loop [m 2 
         r [1]]
    (let [next-r (into [] (map #(apply + %) (partition 2 1(concat [0] r [0]))))] 
      (if (= m n)
        next-r
        (recur (inc m) next-r))))))

(pascals-triangle-1 11)

(defn pascals-triangle-2
  "杨辉三角下一行的结果由上一行的结果产生，因此可以使用iterate函数"
  [n]
  (nth (iterate 
          (fn [r] 
            (into [] 
                  (map #(apply + %) (partition 2 1 (concat [0] r [0]))))) 
          [1])
       n))

(pascals-triangle-2 11)