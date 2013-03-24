;Split by Type
 
;Difficulty:	Medium
;Topics:	seqs

;Write a function which takes a sequence consisting of items with different types and splits them up into a set of homogeneous sub-sequences. The internal order of each sub-sequence should be maintained, but the sub-sequences themselves can be returned in any order (this is why 'set' is used in the test cases).
	
;(= (set (__ [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
	
;(= (set (__ [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})
	
;(= (set (__ [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})
;(vals (group-by type %))
(ns for-clojure.problem50)


(defn split-by-type [v]
  (loop [r {} 
         v v]
    (if (empty? v) 
      (map val r)
      (let [ele (first v)
            ele-type (type ele)]
        (if (get r ele-type)
          (recur (update-in r [ele-type] conj ele) (rest v))
          (recur (assoc r ele-type [ele]) (rest v)))))))

(split-by-type [1 :a 2 :b 3 :c])