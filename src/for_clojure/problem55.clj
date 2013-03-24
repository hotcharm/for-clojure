(ns for-clojure.problem50)

(defn my-frequencies-1 
  "尾递归序列统计频率"
  [v] 
  (loop [v v r {}]
    (if (empty? v)
      r
      (let [ele (first v)
            rest-v (rest v)]
        (if (get r ele)
          (recur rest-v (update-in r [ele] inc))
          (recur rest-v (assoc r ele 1)))))))

(my-frequencies-1 [1 1 2 3 2 1 1]) ;{1 4, 2 2, 3 1}


(defn my-frequencies-2 
  "使用group-by根据元素的标识分组，然后用reduce统计相关分组的大小"
  [v]
  (reduce #(assoc %1 (key %2) (count (val %2)))  {} (group-by identity v) ))



(my-frequencies-2 [:b :a :b :a :b]) ;{:a 2, :b 3}

(defn my-frequencies-3 
  "尾递归统计频率，运用get函数当不存在的时候，可以指定返回值，这样子我们就不需要判断是不是key已经包含在结果hash-map中了"
  [v]
  (loop [v v r {}]
    (if (empty? v)
      r
      (let [ele (first v)
            rest-v (rest v)]
        (recur rest-v (assoc r ele (inc (get r ele 0))))))))

(my-frequencies-3 [:b :a :c :b :a :b])

(defn my-frequencies-4 
  "非尾递归版本,最终最简单的版本"
  [v]
  (reduce #(assoc %1 %2 (inc (get %1 %2 0))) {} v))

(my-frequencies-4 [:b :a :c :a :b :b])















