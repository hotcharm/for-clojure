(ns for-clojure.problem74)

(defn filter-perfect-squares
   "从字符串中找出用逗号分隔的完全平方数，然后把这些完全平方数用逗号分隔组成字符串"
   [s]
   (letfn [(perfect-square? [n]
             (let [sq (Math/sqrt n)]
               (== (int sq) sq)))]
    (apply str (interpose "," (filter perfect-square? (map #(Integer/parseInt %) (re-seq #"\d+" s)))))))

 (filter-perfect-squares "15,16,25,36,37")