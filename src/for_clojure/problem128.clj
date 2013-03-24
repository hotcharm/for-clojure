(ns for-clojure.problem128)

(defn recognize-playing-cards
  "ʶ������˿ˣ������˿������ֻ�ɫ�����ҡ����ҡ���Ƭ��÷����ÿ�ֻ�ɫ13���ƣ�2��С��A���"
  [card-string]
  (let [suit-map {\D :diamond \H :heart \C :club \S :spade}
        rank-map {\2 0, \3 1, \4 2, \5 3, \6 4, \7 5, \8 6, \9 7, \T 8, \J 9, \Q 10, \K 11, \A 12}]
    {:suit (get suit-map (first card-string)) 
     :rank (get rank-map (second card-string))}))

(= {:suit :diamond :rank 10} (recognize-playing-cards "DQ"))