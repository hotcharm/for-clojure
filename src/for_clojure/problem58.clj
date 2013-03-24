(ns for-clojure.problem58)
(defn fn-comp-1
  "����һ����������Ϻ������˺��������κθ����ĺ��������ҵ���ִ�к���"
  [& fns]
  (fn [& init-paramters]
    (let [fns (reverse fns)
          result (apply (first fns) init-paramters)]
      (loop [fns (rest fns) result result]
        (if (empty? fns) 
          result
          (recur (rest fns) ((first fns) result)))))))

((fn-comp-1 rest reverse) [1 2 3 4]) ;= [3 2 1]
((fn-comp-1 (partial + 3) second) [1 2 3 4]) ;= 5
((fn-comp-1 zero? #(mod % 8) +) 3 5 7 9) ;= true
((fn-comp-1 #(.toUpperCase %) #(apply str %) take) 5 "hello world") ;= "HELLO"

(defn fn-comp-2
  "��β�ݹ�汾"
  [& fns]
  (fn [& xs]
    (let [fns (reverse fns)
          result (apply (first fns) xs)]
      (reduce #(%2 %1) result (rest fns)))))

((fn-comp-2 rest reverse) [1 2 3 4]) ;= [3 2 1]
((fn-comp-2 (partial + 3) second) [1 2 3 4]) ;= 5
((fn-comp-2 zero? #(mod % 8) +) 3 5 7 9) ;= true
((fn-comp-2 #(.toUpperCase %) #(apply str %) take) 5 "hello world")  ;= "HELLO"


