(ns for-clojure.problem43)

(defn partition-seq-with-n-element 
  [v n]
  (apply map (fn [& x] (remove nil? x))
   (let [cnt (count v)
         size (int (Math/ceil (/ cnt n)))] 
     (partition-all n
                    (concat v (repeat (- (* n size) cnt) nil))))))
(partition-seq-with-n-element [1 2 3 4 5 6 7] 2)



