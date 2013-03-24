(ns for-clojure.problem56)

(defn find-distinct-items 
  "找出序列中不同的元素，并且要保持原来的次序不变"
  [v]
  (reduce #(if (some #{%2} %1) %1 (conj %1 %2)) [] v))

(find-distinct-items [:a :a :b :b :c :c])