(ns for-clojure.problem95)

(defn is-tree?
  "判断是否是树结构，树结构包含三部分，值，左子树，右子树"
  [xs]
  (if (= 3 (count xs)) 
    (let [value (first xs)
          left (second xs)
          right (last xs)]
      (cond 
       (and (not (nil? value)) (not (coll? value)) (nil? left) (nil? right)) true
       (and (not (nil? value)) (not (coll? value)) (coll? left) (nil? right)) (is-tree? left)
       (and (not (nil? value)) (not (coll? value)) (coll? right) (nil? left)) (is-tree? right)
       (and (not (nil? value)) (not (coll? value)) (coll? left) (coll? right)) (and (is-tree? left) (is-tree? right))
       :else false))
    false))

(= (is-tree? '(:a (:b nil nil) nil)))

(= (is-tree? '(:a (:b nil nil))) false)

