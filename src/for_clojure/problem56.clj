(ns for-clojure.problem56)

(defn find-distinct-items 
  "�ҳ������в�ͬ��Ԫ�أ�����Ҫ����ԭ���Ĵ��򲻱�"
  [v]
  (reduce #(if (some #{%2} %1) %1 (conj %1 %2)) [] v))

(find-distinct-items [:a :a :b :b :c :c])