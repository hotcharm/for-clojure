(ns for-clojure.problem77)

(defn anagram-finder-1 
  [v]
 (into #{} 
       (filter #(> (count %) 1) (map #(into #{} (val %)) (group-by sort v)))))

(defn anagram-finder-2
  [v]
  (->> v
       (group-by sort)
       (vals)
       (filter #(> (count %) 1))
       (map set)
       (set)))