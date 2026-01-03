(ns algs.heap
  (:refer-clojure :exclude [remove]))

(defn- sift-up
  [heap i]
  (if-not (zero? i)
    (let [p (quot (dec i) 2)
          v (heap p)]
      (if (> (heap i) (heap p))
        (recur (-> heap
                   (assoc i v)
                   (assoc p (heap i))) p)
        heap))
    heap))

(defn- sift-down
  [heap from to]
  (loop [heap heap
         i from]
    (let [li (inc (* 2 i))]
      (if (>= li to)
        heap
        (let [ri (inc li)
              ci (if (and (< ri to)
                          (> (heap ri) (heap li)))
                   ri
                   li)]
          (if (> (heap ci) (heap i))
            (recur (-> heap
                       (assoc i (heap ci))
                       (assoc ci (heap i)))
                   ci)
            heap))))))

(defn top
  [heap]
  (get heap 0))

(defn add [heap k]
  (let [i (count heap)
        new-heap (conj heap k)]
    (sift-up new-heap i)))

(defn remove
  [heap]
  (if-not (empty? heap)
    (let [v (last heap)
          new-heap (vec
                    (butlast
                     (assoc heap 0 v)))]
      (sift-down new-heap 0 (count new-heap)))
    heap))

(defn heap-sort
  [heap]
  (if-not (empty? heap)
    (loop [end (count heap)
           heap heap]
      (let [i (dec end)
            vlast (heap i)
            vfirst (first heap)]
        (if (> end 1)
          (recur i (-> heap
                       (assoc i vfirst)
                       (assoc 0 vlast)
                       (sift-down 0 i)))
          heap)))
    heap))

(heap-sort
 (remove
  (add
   (add
    (add
     (add
      (add [] 1) 4) 2) 10) 5)))
