(ns for-clojure.problem74)

(defn filter-perfect-squares
   "���ַ������ҳ��ö��ŷָ�����ȫƽ������Ȼ�����Щ��ȫƽ�����ö��ŷָ�����ַ���"
   [s]
   (letfn [(perfect-square? [n]
             (let [sq (Math/sqrt n)]
               (== (int sq) sq)))]
    (apply str (interpose "," (filter perfect-square? (map #(Integer/parseInt %) (re-seq #"\d+" s)))))))

 (filter-perfect-squares "15,16,25,36,37")