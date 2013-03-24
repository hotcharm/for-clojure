(ns for-clojure.problem65)

(defn black-box-testing
  "�ںв��ԣ��������е��ص��ж����е����ͣ�����ʹ�������жϵȺ���"
  [v]
  (cond
          (:a (conj v [:a 1])) :map
          (< (- (count (conj v 1 1)) (count v)) 2) :set
          (= (conj v 1 2) (cons 2 (cons 1 v))) :list
          :else :vector))

(= :map (black-box-testing {:a 1, :b 2}))
(= :vector (black-box-testing [1 2 3 4 5 6]))
(= :set (black-box-testing #{10 (rand-int 5)}))
(= :list (black-box-testing (range (rand-int 20))))
(= [:map :set :vector :list] (map black-box-testing [{} #{} [] ()]))