(ns for-clojure.problem54)

(defn partition-a-sequence-1
  "������У���һ�����в�ֳ�ÿ����x��Ԫ�أ������xԪ�صĶ���"
  [x v]
  (loop [r [];���ս�� 
         m [];�м������� 
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
  "ʹ��take��ʵ��"
  [x v]
  (loop [v v r []]
    (if (< (count v) x)
      r
      (recur (nthrest v x) (conj r (take x v))))))

(partition-a-sequence-2 3 (range 9))
