(ns for-clojure.problem50)

(defn my-frequencies-1 
  "β�ݹ�����ͳ��Ƶ��"
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
  "ʹ��group-by����Ԫ�صı�ʶ���飬Ȼ����reduceͳ����ط���Ĵ�С"
  [v]
  (reduce #(assoc %1 (key %2) (count (val %2)))  {} (group-by identity v) ))



(my-frequencies-2 [:b :a :b :a :b]) ;{:a 2, :b 3}

(defn my-frequencies-3 
  "β�ݹ�ͳ��Ƶ�ʣ�����get�����������ڵ�ʱ�򣬿���ָ������ֵ�����������ǾͲ���Ҫ�ж��ǲ���key�Ѿ������ڽ��hash-map����"
  [v]
  (loop [v v r {}]
    (if (empty? v)
      r
      (let [ele (first v)
            rest-v (rest v)]
        (recur rest-v (assoc r ele (inc (get r ele 0))))))))

(my-frequencies-3 [:b :a :c :b :a :b])

(defn my-frequencies-4 
  "��β�ݹ�汾,������򵥵İ汾"
  [v]
  (reduce #(assoc %1 %2 (inc (get %1 %2 0))) {} v))

(my-frequencies-4 [:b :a :c :a :b :b])















