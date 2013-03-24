(ns for-clojure.problem54)

(defn partition-a-sequence-1
  "拆分序列，把一个序列拆分成每部分x个元素，最后不足x元素的丢弃"
  [x v]
  (loop [r [];最终结果 
         m [];中间结果保存 
         v v]
    (if (= (count m) x)
      (if (empty? v) 
        (conj r m)
        (recur (conj r m) [(first v)] (rest v)))
      (if (empty? v)
        r
        (recur r (conj m (first v)) (rest v))))))

(partition-a-sequence-1 3 (range 9))

(defn partition-a-sequence-2 
  "使用take来实现"
  [x v]
  (loop [v v r []]
    (if (< (count v) x)
      r
      (recur (nthrest v x) (conj r (take x v))))))

(partition-a-sequence-2 3 (range 9))
